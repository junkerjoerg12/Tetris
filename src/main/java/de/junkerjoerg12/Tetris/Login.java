package de.junkerjoerg12.Tetris;

import java.awt.Color;

import javax.swing.JPanel;

public class Login extends JPanel {
  private int width = 400;
  private int height = 200;

  public Login(Background hintergrund) {
    this.setBounds(hintergrund.getWidth() / 2 - width / 2, hintergrund.getHeight() / 2 - height / 2, width, height);
    // this.setBounds(0, 0, 500, 500);
    this.setBackground(Color.GRAY);
    this.requestFocus();
    // this.setVisible(true);
    // System.out.println("Ich bin wirklich erstellt");
    // System.out.println("width, height, x, y, " + this.getwi);

  }
}