package tepigmc.textadventure.util;

public class Compare {
  public static <T> boolean arrayEquals(T[][] a, T[][] b) {
    if (a.length != b.length || a[0].length != b[0].length) { return false; }
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
        if (!a[i][j].equals(b[i][j])) { return false; }
      }
    }
    return true;
  }
  
  public static <T> boolean arrayEquals(T[] a, T[] b) {
    if (a.length != b.length) { return false; }
    for (int i = 0; i < a.length; i++) {
      if (!a[i].equals(b[i])) { return false; }
    }
    return true;
  }
  
  public static boolean arrayEquals(int[] a, int[] b) {
    if (a.length != b.length) { return false; }
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) { return false; }
    }
    return true;
  }
}