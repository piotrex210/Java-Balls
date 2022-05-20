import java.awt.*;

public class Ball
{
    private int iD;
    private int[] position = new int[2];
    private double direction;
    private double velocity;
    private int radius;
    private Color color;

    Ball(int id_, int pos[], int r, double dir, double velo, Color c){
        iD = id_;
        position[0] = pos[0];
        position[1] = pos[1];
        direction = dir;
        velocity = velo;
        radius = r;
        color = c;
        System.out.println("Hello from Ball class, x= "+position[0]+" y:"+pos[1]+" direction: "+direction+" velocity: "+velocity+"Color: "+color.toString());
    }

    public int[] getPosition() {
        return position;
    }

    public int getRadius() {
        return radius;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }
    public int getiD() {
        return iD;
    }

    public Color getColor() {
        return color;
    }

    public void calculateNextPosition(){
        position[0] += (int) velocity*Math.cos(direction);
        position[1] += (int) velocity*Math.sin(direction);


    }
}
