package tepigmc.textadventure.util;

import java.util.ArrayList;
import java.util.List;

public class Array {
  public static <T> T[] subArray(T[] array, int startIndex, int endIndex) {
    if (startIndex >= endIndex) { return null; }
    @SuppressWarnings("unchecked")
    T[] result = (T[]) new Object[endIndex - startIndex];
    int resultIndex = 0;
    for (int i = startIndex; i < endIndex; i++) {
      result[resultIndex] = array[i];
      resultIndex++;
    }
    return result;
  }
  
  public static <T> T[] subArray(T[] array, int startIndex) {
    return subArray(array, startIndex, array.length);
  }
  
  public static int[] subArray(int[] array, int startIndex, int endIndex) {
    if (startIndex >= endIndex) { return null; }
    int[] result = new int[endIndex - startIndex];
    int resultIndex = 0;
    for (int i = startIndex; i < endIndex; i++) {
      result[resultIndex] = array[i];
      resultIndex++;
    }
    return result;
  }
  
  public static int[] subArray(int[] array, int startIndex) {
    return subArray(array, startIndex, array.length);
  }
  
  public static <T> boolean equals(T[][] a, T[][] b) {
    if (a.length != b.length || a[0].length != b[0].length) { return false; }
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        if (!a[i][j].equals(b[i][j])) {
          System.err.println("Array " + toString(a) + " differs from " + toString(b) + ".");
          return false;
        }
      }
    }
    return true;
  }
  
  public static <T> boolean equals(T[] a, T[] b) {
    if (a.length != b.length) { return false; }
    for (int i = 0; i < a.length; i++) {
      if (!a[i].equals(b[i])) {
        System.err.println("Array " + toString(a) + " differs from " + toString(b) + ".");
        return false;
      }
    }
    return true;
  }
  
  public static boolean equals(int[] a, int[] b) {
    if (a.length != b.length) { return false; }
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) {
        System.err.println("Array " + toString(a) + " differs from " + toString(b) + ".");
        return false;
      }
    }
    return true;
  }  
  
  public static <T> String toString(T[][] array) {
    String arrayString = "[";
    for (int i = 0; i < array.length; i++) {
      arrayString += "[";
      for (int j = 0; j < array[0].length; j++) {
        arrayString += array[i][j] + (j < array[0].length-1 ? "," : "");
      }
      arrayString += "]" + (i < array.length-1 ? "," : "]");
    }
    return arrayString;
  }
  
  public static <T> String toString(T[] array) {
    if (array == null) { return "null"; }
    String arrayString = "[";
    for (int i = 0; i < array.length; i++) {
      arrayString += array[i] + (i < array.length-1 ? "," : "");
    }
    return arrayString + "]";
  }
  
  public static String toString(int[] array) {
    if (array == null) { return "null"; }
    String arrayString = "[";
    for (int i = 0; i < array.length; i++) {
      arrayString += array[i] + (i < array.length-1 ? "," : "");
    }
    return arrayString + "]";
  }
  
  public static <T> List<T> toList(T[] array) {
    List<T> list = new ArrayList<T>();
    for (T item : array) {
      list.add(item);
    }
    return list;
  }
  
  public static <T> T[] toArray(List<T> list) {
    @SuppressWarnings("unchecked")
    T[] array = (T[]) new Object[list.size()];
    for (int i = 0; i < list.size(); i++) {
      array[i] = list.get(i);
    }
    return array;
  }
}