import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    public static int panelSizeX;
    public static int  panelSizeY;

    ArrayList<int[]> ballsPositions;
    ArrayList<Integer> ballsRadiuses;
    ArrayList<Color> ballsColors;

    MyPanel(int x, int y){
        panelSizeX = x;
        panelSizeY = y;
        this.setPreferredSize(new Dimension(panelSizeX,panelSizeY));
        this.setBackground(Color.BLACK);
    }

    public void paint(Graphics graphics){

        super.paint(graphics);
        Graphics2D g2D = (Graphics2D) graphics;
        //getContentPane().setBackground(Color.BLACK);
        for (int i = 0; i < ballsRadiuses.size(); i++) {
            g2D.setPaint(ballsColors.get(i));
            g2D.fillOval(ballsPositions.get(i)[0], ballsPositions.get(i)[1], 2*ballsRadiuses.get(i),2*ballsRadiuses.get(i));
        }
    }
}
