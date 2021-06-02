package org.example.employee_performance_review_api.infrastructure.repository.hibernate.helpers;

import java.util.List;
import java.util.ListIterator;
import java.util.function.Predicate;

public class GenericListHelper {
  public static <T> int indexOf(List<T> list, Predicate<? super T> predicate) {
    for (ListIterator<T> iter = list.listIterator(); iter.hasNext(); )
      if (predicate.test(iter.next())) return iter.previousIndex();
    return -1;
  }
}
