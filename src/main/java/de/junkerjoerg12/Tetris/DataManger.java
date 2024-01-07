package de.junkerjoerg12.Tetris;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataManger {

  private static DataManger mngr;
  private final String HIGHSCORES = "savedData/highscores.json";
  private final String USERDATA = "savedData/userdata";

  private DataManger() {
  }

  public static DataManger getDataManger() {
    if (mngr == null) {
      mngr = new DataManger();
    }
    return mngr;
  }

  public int getHighscore(String modus) throws IOException {// muss in den IMplementierung noch angepasst werden
    String key = modus;
    String file = "";
    BufferedReader reader = new BufferedReader(new FileReader(HIGHSCORES));
    String line;
    while ((line = reader.readLine()) != null) {
      file += line;
    }
    int highscore;
    try {
      highscore = (new JSONObject(file).getInt(key));
    } catch (JSONException e) {
      highscore = 0;
      saveHighscore(modus, highscore); // nimmt den Modus direkt in die Datei auf
    }
    reader.close();
    return highscore;
  }

  public void saveHighscore(String modus, int highscore) throws IOException {// muss in den IMplementierung noch
                                                                             // angepasst werden
    String file = "";
    BufferedReader reader = new BufferedReader(new FileReader(HIGHSCORES));
    String line;
    while ((line = reader.readLine()) != null) {
      file += line;
    }
    reader.close();
    JSONObject jsonObj = new JSONObject(file);
    jsonObj.put(modus, highscore);
    BufferedWriter writer = new BufferedWriter(new FileWriter(HIGHSCORES));
    writer.write(jsonObj.toString());
    writer.close();
  }

  public void checkFolders() { // Überprüft die Orderstruktur und vervollständigt sie wenn nötig

    File f = new File(USERDATA); // Überprüft den Order "userdata" und "savedData"
    if (!f.isDirectory()) {
      System.out.println("Userordner erstellt");
      f.mkdirs();
    }

    if (!(new File(HIGHSCORES)).isFile()) { // Überprüft die Datei highscores.json
      try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(HIGHSCORES));
        writer.write("{}");
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {

    DataManger.getDataManger().checkFolders();

    // Test zum saven
    // try {
    // getDataManger().saveHighscore("normal", 0);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }

    // Test zum auslesen
    try {
      System.out.println(getDataManger().getHighscore("normal") + "Absoluterhighscore");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
