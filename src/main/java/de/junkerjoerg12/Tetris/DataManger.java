package de.junkerjoerg12.Tetris;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataManger {

  private static DataManger mngr;
  private static final String DATA = "userdata.json";

  private DataManger() {
  }

  public static DataManger getDataManger() {
    if (mngr == null) {
      mngr = new DataManger();
    }
    return mngr;
  }

  public int getGeneralHighscore() throws IOException {
    String key = "Highscore";
    String file = "";
    BufferedReader reader = new BufferedReader(new FileReader(DATA));
    String line;
    while ((line = reader.readLine()) != null) {
      file += line;
    }
    System.out.println(new JSONObject(file).getInt(key));
    reader.close();
    return new JSONObject(file).optInt(key);
  }

  public void saveGeneralHighscore(int highscore) throws IOException {
    String file = "";
    BufferedReader reader = new BufferedReader(new FileReader(DATA));
    String line;
    while ((line = reader.readLine()) != null) {
      file += line;
    }
    reader.close();
    JSONObject jsonObj = new JSONObject(file);
    jsonObj.put("Highscore", highscore);
    BufferedWriter writer = new BufferedWriter(new FileWriter(DATA));
    System.out.println(jsonObj);
    writer.write(jsonObj.toString());
    writer.close();
  }

  public static void saveData(String data) throws IOException {
    Path filePath = Paths.get(DATA);
    Files.write(filePath, data.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
  }

  public static String loadData() throws IOException {
    Path filePath = Paths.get(DATA);
    return new String(Files.readAllBytes(filePath));
  }

  public static void main(String[] args) {
    try {
      getDataManger().saveGeneralHighscore(0);
    } catch (Exception e) {
      e.printStackTrace();
    }

    try {
      System.out.println(getDataManger().getGeneralHighscore() + "Absoluter highscore");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // try {
    // saveData("Hello, World!");
    // System.out.println("Data saved successfully.");

    // String loadedData = loadData();
    // System.out.println("Loaded data: " + loadedData);
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // String filePath = "scores.txt";

    // try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
    // String line;
    // while ((line = br.readLine()) != null) {
    // // Process each line as needed
    // System.out.println(line);
    // }
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
  }
}
