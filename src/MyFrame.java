import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class MyFrame extends JFrame {
    MyPanel panel;
    public static int panelSizeX = 800;
    public static int  panelSizeY = 800;
    ArrayList<int[]> ballsPositions;
    ArrayList<Integer> ballsRadiuses;
    ArrayList<Color> ballsColors;
    MyFrame(){
        panel = new MyPanel(panelSizeX, panelSizeY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(panelSizeX, panelSizeY);
        //this.setLayout(new FlowLayout());
        this.add(panel);
        this.pack();
        this.setTitle("Balls");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //ballsColors = new Color[2];

    }



    public void setBallPositions(ArrayList<int[]> pos){
        ballsPositions = pos;
        panel.ballsPositions = pos;
        for(int i = 0; i < ballsRadiuses.size(); i++){
            ballsPositions.get(i)[0] -= ballsRadiuses.get(i);
            ballsPositions.get(i)[1] -= ballsRadiuses.get(i);
            panel.ballsPositions.get(i)[0] -= panel.ballsRadiuses.get(i);
            panel.ballsPositions.get(i)[1] -= panel.ballsRadiuses.get(i);
            //System.out.println("Hello from MyFrame class, x= "+ballsPositions[i][0] +" y:"+ballsPositions[i][1]);
        }
    }
    public void setBallsRadiuses(ArrayList<Integer> radiuses){
        ballsRadiuses = radiuses;
        panel.ballsRadiuses = radiuses;
    }

    public void setBallsColors(ArrayList<Color> col){
        ballsColors = col;
        panel.ballsColors = col;
    }
}
