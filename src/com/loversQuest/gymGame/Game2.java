package com.loversQuest.gymGame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Game2 extends JPanel {
    Ball ball = new Ball(this);

    private void move() {
        ball.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Agility Training Game");
        Game2 game = new Game2();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
}
