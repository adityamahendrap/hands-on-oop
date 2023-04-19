package Mahasiswa;
import java.time.LocalDate;

public class Utils {
  public static int getCurrentYear() {
    LocalDate currentDate = LocalDate.now();
    return currentDate.getYear();
  }

  public static boolean checkNimFormat(String nim) {
    String regex = "-?\\d+(\\.\\d+)?";

    if (!(nim.matches(regex))) {
      System.out.println("NIM tidak valid!");
      return false;
    }
    return true;
  }

  public static boolean checkNameFormat(String nama) {
    String regex = "^[a-zA-Z ,.]+$";

    if (!(nama.matches(regex))) {
      System.out.println("Nama tidak valid!");
      return false;
    }
    return true;
  }

  public static boolean checkJurusanFormat(String jurusan) {
    String regex = "^[a-zA-Z .]+$";
    return jurusan.matches(regex);
  }

  public static boolean checkDuplicateStringInArray(String[] array, String value) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == value)
        return false;
    }
    return true;
  }

  public static String[] pushStringToArray(String[] array, String value) {
    if (checkDuplicateStringInArray(array, value) == false) {
      System.out.println(value + " already exist");
      return array;
    }

    String[] newArray = new String[array.length + 1];

    for (int i = 0; i < array.length; i++) {
      newArray[i] = array[i];
    }

    newArray[newArray.length - 1] = value;
    return newArray;
  }

  public static String[] updateStringInArray(String[] array, String currentString, String newString) {
    if (checkDuplicateStringInArray(array, newString) == false) {
      System.out.println(newString + " already exist");
      return array;
    }

    boolean isCurrentStringExist = false;

    for (int i = 0; i < array.length; i++) {
      if (array[i] == currentString) {
        isCurrentStringExist = true;
        array[i] = newString;
      }
    }

    if (!isCurrentStringExist)
      System.out.println(currentString + " does'nt exist");

    return array;
  }

  public static String[] removeStringFromArray(String[] array, String toRemove) {
    boolean exists = false;
    for (int i = 0; i < array.length; i++) {
      if (array[i].equals(toRemove)) {
        exists = true;
        break;
      }
    }

    if (!exists) {
      System.out.println(toRemove + " does'nt exist");
      return array;
    }

    String[] newArray = new String[array.length - 1];

    int newIndex = 0;
    for (int i = 0; i < array.length; i++) {
      if (!array[i].equals(toRemove)) {
        newArray[newIndex] = array[i];
        newIndex++;
      }
    }

    return newArray;
  }
}
