import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class MyFrame extends JFrame {
    int frameSizeX = 800;
    int frameSizeY = 800;
    int[][] ballsPositions;
    int[] ballsRadiuses;
    Color[] ballsColors;
    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(frameSizeX, frameSizeY);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        ballsColors = new Color[2];
    }

    public void paint(Graphics graphics){

        super.paint(graphics);
        Graphics2D g2D = (Graphics2D) graphics;

        //g2D.fillRect(0,0,100,200);
        g2D.setPaint(ballsColors[0]);
        g2D.fillOval(ballsPositions[0][0], ballsPositions[0][1], 2*ballsRadiuses[0],2*ballsRadiuses[0]);
        g2D.setPaint(ballsColors[1]);
        g2D.fillOval(ballsPositions[1][0], ballsPositions[1][1], 2*ballsRadiuses[1],2*ballsRadiuses[1]);

    }

    public void setBallPositions(ArrayList<int[]> pos){
        ballsPositions = pos;
        for(int i = 0; i < ballsRadiuses.size(); i++){
            ballsPositions.get(i)[0] -= ballsRadiuses.get(i);
            ballsPositions.get(i)[1] -= ballsRadiuses.get(i);
            //System.out.println("Hello from MyFrame class, x= "+ballsPositions[i][0] +" y:"+ballsPositions[i][1]);
        }
    }
    public void setBallsRadiuses(ArrayList<Integer> radiuses){
        ballsRadiuses = radiuses;
    }

    public void setBallsColors(ArrayList<Color> col){
            ballsColors = col;
    }
}
