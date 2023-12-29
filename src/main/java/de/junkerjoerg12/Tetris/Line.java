package de.junkerjoerg12.Tetris;

import javax.swing.*;
import java.awt.*;

public class Line extends JPanel {

    public Line(boolean vertical, int start, int ende) {
        this.setBackground(Color.BLACK);
        if (vertical == true) {
            this.setBounds(start, 0, 1, ende);
        } else {
            this.setBounds(0, start, ende, 1);
        }
    }
}
