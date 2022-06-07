import java.util.List;
import java.util.concurrent.TimeUnit;

public class computeBall implements Runnable  {
    private int id;
    private List<Ball> balls;
    private MyFrame frame;

    public Object monitor = new Object();

    computeBall(List<Ball> b, MyFrame f, int i){
        balls = b;
        frame = f;
        id = i;
    }

    @Override
    public void run() {


        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Exception sleep in run");
            }
            for(int i = 0; i < balls.size(); i++){
                if(i%3 == id){
                    System.out.println("Obliczam nową pozycję piłki: " + i);
                    balls.get(i).calculateNextPosition();
                    if(balls.get(i).collisionWithWall(frame)) {
                        balls.get(i).changeDirectionAfterCollisionWithBall(frame);
                        balls.get(i).calculateNextPosition();
                    }
                    int id2= balls.get(i).collisionWithBalls(balls);
                    if(id2 != -1){
                        balls.get(i).changeDirectionAfterCollisionWithBall(frame);
                        balls.get(i).calculateNextPosition();
                        balls.get(id2).changeDirectionAfterCollisionWithBall(frame);
                        balls.get(id2).calculateNextPosition();
                    }
                    balls.get(i).setPosition(balls.get(i).getNextPosition());
                }
            }

            synchronized (monitor) {
                try {
                    System.out.println("Uśpiono wątek: " + id);
                    monitor.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Wybudzono wątek: " + id);

                    // zrób coś po wybudzeniu
                }
                //monitor.notifyAll();
            }
            //notifyAll();

        }


    }
}
