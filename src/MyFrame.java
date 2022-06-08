import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class MyFrame extends JFrame {
    MyPanel panel;
    public static int panelSizeX = 800;
    public static int  panelSizeY = 800;
    MyFrame(){
        this.setSize(panelSizeX+100, panelSizeY+100);
        panel = new MyPanel(panelSizeX, panelSizeY);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.ORANGE);
        this.add(panel, BorderLayout.CENTER);
        this.pack();
        this.setTitle("Balls");
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
    public void setBallPositions(ArrayList<double[]> pos){
        panel.ballsPositions = pos;
    }
    public void setBallsRadiuses(ArrayList<Integer> radiuses){
        panel.ballsRadiuses = radiuses;
    }

    public void setBallsColors(ArrayList<Color> col){
        panel.ballsColors = col;
    }
}
