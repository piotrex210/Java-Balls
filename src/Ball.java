import java.awt.*;

public class Ball
{
    private int iD;
    private int[] position = new int[2];
    private int[] nextPosition = new int[2];
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

    public int[] getNextPosition() {
        return nextPosition;
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
        nextPosition[0] += (int) velocity*Math.cos(direction);
        nextPosition[1] += (int) velocity*Math.sin(direction);
    }
    public boolean collisionWithWall(MyFrame frame){

        if (nextPosition[0] + radius >= frame.frameSizeX || nextPosition[0] - radius <= 0 ||
                nextPosition[1] + radius >= frame.frameSizeY || nextPosition[1] - radius <= 0){
            System.out.println("Kolizja!!");
            return  true;
        } else return false;
    }

    public synchronized int collisionWithBalls(List<Ball> ballList){
        Double d;

        for (Ball ball :
             balls) {
            if (iD == ball.iD ) continue;
            d = Math.sqrt(Math.pow(this.nextPosition[0] - ball.nextPosition[0],2) + Math.pow(this.nextPosition[1] - ball.nextPosition[1],2));
            if(d <= radius + ball.radius)  {
                System.out.println("Kolizja z piłką");
                return ball.iD;
            }
        }
        return -1;
    }
    public void changeDirectionAfterCollision(MyFrame frame){
//        if (nextPosition[0] + radius >= frame.frameSizeX && direction >= 0 && direction <= Math.PI/2) // jeśli prawa ściana i kierunek w górę
//        {
//            direction += Math.PI/2;
//        }

        direction = direction + Math.PI;
    }
}
