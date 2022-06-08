import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyPanel extends JPanel {
    public static int panelSizeX;
    public static int  panelSizeY;

    ArrayList<double[]> ballsPositions;
    ArrayList<Integer> ballsRadiuses;
    ArrayList<Color> ballsColors;

    MyPanel(int x, int y){
        panelSizeX = x;
        panelSizeY = y;
        this.setPreferredSize(new Dimension(panelSizeX,panelSizeY));
        this.setBackground(Color.white);
        setBorder(BorderFactory.createEmptyBorder( 50, 50,  50, 50));
    }

    public void paint(Graphics graphics){

        super.paint(graphics);
        Graphics2D g2D = (Graphics2D) graphics;
        //getContentPane().setBackground(Color.BLACK);
        for (int i = 0; i < ballsRadiuses.size(); i++) {
            g2D.setPaint(ballsColors.get(i));
            g2D.fillOval((int)ballsPositions.get(i)[0], (int)ballsPositions.get(i)[1], 2*ballsRadiuses.get(i),2*ballsRadiuses.get(i));
        }
    }
}
