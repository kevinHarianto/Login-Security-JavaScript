package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AvengerFileIO {
  private static String filePathName;
  private static List<Avenger> list;

  public static String getFilePathName() {
    return filePathName;
  }

  public static void setFilePathName(String filePathName) {
    AvengerFileIO.filePathName = filePathName;
    AvengerFileIO.list = readFromFile(filePathName);
  }

  public static List<Avenger> getList() {
    if (list == null)
      list = readFromFile(filePathName);
    return list;
  }
  
  public static List<Avenger> readFromFile(String filePath) {
    list = new ArrayList<>();
    File file = new File(filePath);
    try (
        Scanner input = new Scanner(file);
    ) {
      input.nextLine();
      while (input.hasNext()) {
        String[] fields = input.nextLine().split(",");
        list.add(new Avenger(
            fields[0], Boolean.parseBoolean(fields[1]),
            Integer.parseInt(fields[2]), Integer.parseInt(fields[3]),
            Integer.parseInt(fields[4]), Integer.parseInt(fields[5]),
            Integer.parseInt(fields[6]), Integer.parseInt(fields[7]),
            Integer.parseInt(fields[8]), Integer.parseInt(fields[9]),
            fields[10], fields[11]
        ));
      }
    } catch (FileNotFoundException ex) {
      Logger.getLogger(AvengerFileIO.class.getName()).log(Level.SEVERE, null, ex);
    } 
    return list;
  } 
  
  public static Avenger searchAvenger(String name) {
    if (list == null) 
      list = readFromFile(filePathName);
    for (Avenger avg : list)
      if (avg.getName().equals(name))
        return avg;
    return null;
  } 
}
