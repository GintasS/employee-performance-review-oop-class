package org.example.employee_performance_review_api.infrastructure.repository.hibernate.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {
  public static String ReadFile(String filePath) {
    String content = "";

    try {
      content = new String(Files.readAllBytes(Paths.get(filePath)));
    } catch (IOException ex) {
      ex.printStackTrace();
    }

    return content;
  }

  public static void WriteToFile(String filePath, String data) {
    try {
      Files.writeString(Path.of(filePath), data);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
