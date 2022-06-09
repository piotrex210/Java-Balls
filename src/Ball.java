import java.awt.*;
import java.util.List;

public class Ball
{
    private int iD;
    private double[] position = new double[2];
    private double[] nextPosition = new double[2];
    private double direction;
    private double velocity;
    private int radius;
    private Color color;

    public boolean collisionWithBall;

    Ball(int id_, double pos[], int r, double dir, double velo, Color c){
        iD = id_;
        position[0] = pos[0];
        position[1] = pos[1];
        nextPosition[0] = pos[0];
        nextPosition[1] = pos[1];
        direction = dir;
        velocity = velo;
        radius = r;
        color = c;
        collisionWithBall = false;
        System.out.println("Hello from Ball class, x= "+position[0]+" y:"+pos[1]+" direction: "+direction+" velocity: "+velocity+"Color: "+color.toString());
    }

    public synchronized double[] getPosition() {
        return position;
    }

    public synchronized double[] getNextPosition() {
        return nextPosition;
    }

    public int getRadius() {
        return radius;
    }

    public double getDirection(){ return direction;}

    public synchronized void setPosition(double[] position) {
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

    public synchronized void calculateNextPosition(){
        double px = velocity*Math.cos(direction);
        double py = velocity*Math.sin(direction);

        nextPosition[0] = position[0] + px;
        nextPosition[1] = position[1] + py;
    }
    public synchronized boolean collisionWithWall(MyFrame frame){

        if (nextPosition[0] + radius >= frame.panelSizeX || nextPosition[0] - radius <= 0 ||
                nextPosition[1] + radius >= frame.panelSizeY || nextPosition[1] - radius <= 0){
            System.out.println("Kolizja!!");
            return  true;
        } else return false;
    }

    public synchronized int collisionWithBalls(List<Ball> ballList){
        Double d; // odległość między środkami piłek

        for (Ball ball :
                ballList) {
            if (iD == ball.iD ) continue;
            d = Math.sqrt(Math.pow(this.nextPosition[0] - ball.nextPosition[0],2) + Math.pow(this.nextPosition[1] - ball.nextPosition[1],2));
            if(d <= radius + ball.radius)  {
                System.out.println("Kolizja z piłką: "+ball.iD);
                collisionWithBall = true;
                ball.collisionWithBall = true;
                return ball.iD;
            }
        }
        return -1;
    }
    public synchronized void changeDirectionAfterCollisionWithBall(MyFrame frame){
        direction = direction + Math.PI/2.0;
    }

    public synchronized void changeDirectionAfterCollisionWithWall(MyFrame frame){
        direction = direction%(2.0*Math.PI);
        double vx = Math.cos(direction);
        double vy = Math.sin(direction);

        double px = nextPosition[0];
        double py = nextPosition[1];

        if(py - radius <= 0 || py + radius >= frame.panelSizeY) vy = -vy;
        if(px + radius >= frame.panelSizeX || px - radius <=0) vx = -vx;
        direction = Math.atan2(vy, vx);
    }
}
