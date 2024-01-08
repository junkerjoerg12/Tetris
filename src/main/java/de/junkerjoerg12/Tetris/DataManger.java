package de.junkerjoerg12.Tetris;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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

  public void writeNutzerHighscore(String user, String modus, int highscore) {

  }

  public int getUserHighscore(String username, String modus) {
    JSONObject user;
    String userdata = "";
    try {
      BufferedReader reader = new BufferedReader(new FileReader(getFilePath(username)));
      String line;
      while ((line = reader.readLine()) != null) {
        userdata += line;
      }
      user = new JSONObject(userdata);
      user.getString(modus);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (JSONException e) {
      user = new JSONObject(userdata);
      user.put(modus, 0);
      try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(getFilePath(username)));
        writer.write(user.toString());
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }
    return 0;
  }

  public boolean nutzerAnlegen(String username, String passwort) { // gibt true zurück, wenn ein neuer nutzer erstellt
                                                                   // wurde und false, falls der nutzer bereits
                                                                   // existiert
    Path filePath = Paths.get(getFilePath(username));
    System.err.println(filePath + " ist der Pfad");
    if (Files.exists(filePath)) {
      System.out.println("Ein nutzer mit dem gleichen nutzernamen exiustiert bereits");
      return false;
    } else {
      System.out.println("Nutzer kann erstellt werden");
      try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(getFilePath(username)));
        JSONObject user = new JSONObject();
        user.append("username", encrypt(username));
        user.append("passwort", encrypt(passwort));
        writer.write(user.toString());
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return true;
    }
  }

  public JSONObject getUserdata(String username) throws FileNotFoundException {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(getFilePath(username)));
      String line;
      String file = "";
      try {
        while ((line = reader.readLine()) != null) {
          file += line;
        }
      } catch (IOException e) {
        e.printStackTrace();
      }

      return new JSONObject(file);

    } catch (JSONException e) {
      return new JSONObject("{}");
    }
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

  private String encrypt(String plainText) {
    return plainText.hashCode() + "";
  }

  private String getFilePath(String username) {
    return USERDATA + "/" + encrypt(username) + ".json";
  }

  public static void main(String[] args) {

    try {
      System.out.println(DataManger.getDataManger().getUserdata("junkerjoerg12"));
    } catch (FileNotFoundException e) {
      System.out.println(
          "Der NUtzer ist noch nicht erstellt, überprüfen sie auf rechtschreibung oder erstellen sie einen neuen Nutzer");
    }
    DataManger.getDataManger().nutzerAnlegen("junkerjoerg12", "passwort");

    System.err.println(DataManger.getDataManger().getUserHighscore("junkerjoerg12", "normal"));
    // DataManger.getDataManger().checkFolders();

    // Test zum saven
    // try {
    // getDataManger().saveHighscore("normal", 0);
    // } catch (Exception e) {
    // e.printStackTrace();
    // }

    // Test zum auslesen
    // try {
    // System.out.println(getDataManger().getHighscore("normal") +
    // "Absoluterhighscore");
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
  }
}
