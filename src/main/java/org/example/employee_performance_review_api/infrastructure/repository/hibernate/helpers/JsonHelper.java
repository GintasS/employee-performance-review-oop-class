package org.example.employee_performance_review_api.infrastructure.repository.hibernate.helpers;

import org.example.employee_performance_review_api.domain.model.employee.enums.EmployeeType;
import org.example.employee_performance_review_api.domain.model.employee.enums.PerformanceRating;
import org.example.employee_performance_review_api.domain.model.employee.enums.Team;
import org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity.EmployeeEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

public class JsonHelper {

    public static List<EmployeeEntity> DeserializeStringToEmployees(String json) {

        final var employees = new ArrayList<EmployeeEntity>();
        JSONObject obj = new JSONObject(json);
        JSONArray arr = obj.getJSONArray("employees");

        for (int i = 0; i < arr.length(); i++) {
            var id = UUID.fromString(arr.getJSONObject(i).getString("id"));
            var firstName = arr.getJSONObject(i).getString("firstName");
            var lastName = arr.getJSONObject(i).getString("lastName");
            var team = Team.valueOf(arr.getJSONObject(i).getString("team"));
            var rating = PerformanceRating.valueOf(arr.getJSONObject(i).getString("rating"));
            var type = EmployeeType.valueOf(arr.getJSONObject(i).getString("type"));
            var yearlySalary = arr.getJSONObject(i).getDouble("yearlySalary");
            var employmentTime = arr.getJSONObject(i).getInt("employmentTime");

            var yearlyBonusesObjectArray = arr.getJSONObject(i).getJSONArray("yearlyBonuses").toList();
            var yearlyBonuses = yearlyBonusesObjectArray.stream().map(x -> Double.valueOf(x.toString()))
                    .collect(Collectors.toList());

            employees.add(new EmployeeEntity(id, firstName, lastName, team, rating, type, yearlySalary, employmentTime, yearlyBonuses));
        }

        return employees;
    }

    public static String SerializeEmployeeToString(List<EmployeeEntity> employeeEntity) {
        JSONObject obj = new JSONObject();
        obj.put("employees", employeeEntity);

        return obj.toString();
    }
}