package ca.ubc.cs.cpsc210.snake.ui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel {
    private static final int LBL_WIDTH = 200;
    private static final int LBL_HEIGHT = 30;
    private static final String LBL_STRING = "Nutrition Consumed: ";
    private JLabel label;

    public ScorePanel() {
        label = new JLabel(LBL_STRING + "0");
        label.setPreferredSize(new Dimension(LBL_WIDTH, LBL_HEIGHT));
        add(label);
    }

    public void update(int nutritionConsumed) {
        label.setText(LBL_STRING + nutritionConsumed);
        repaint();
    }
}
