/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game_project;

import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Puii
 */
public class MainStart {
    public static void main(String[] args) {
        JFrame mainStart = new Playstate();
        mainStart.setSize(900, 500);
        mainStart.setTitle("Pikachu VS Zombie");
        mainStart.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainStart.setVisible(true);
        mainStart.setLocationRelativeTo(null);
    }
}
