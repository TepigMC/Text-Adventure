package tepigmc.textadventure.util;

import java.util.ArrayList;
import java.util.List;

public class Convert {
  public static <T> List<T> arrayToList(T[] array) {
    List<T> list = new ArrayList<T>();
    for (T item : array) {
      list.add(item);
    }
    return list;
  }
  
  public static <T> T[] listToArray(List<T> list) {
    @SuppressWarnings("unchecked")
    T[] array = (T[]) new Object[list.size()];
    for (int i = 0; i < list.size(); i++) {
      array[i] = list.get(i);
    }
    return array;
  }
}