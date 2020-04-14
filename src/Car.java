import javax.tools.Diagnostic;
import java.util.Random;

public class Car implements Runnable {
    private static final int DISTANCE = 10;
    private static final int STEP = 2;
    private String name;
    public Car(String name){
        this.name = name;
    }
    @Override
    public void run(){
        long startTime = System.currentTimeMillis();
        int rungDistance = 0;
        int speed;
        String log = "|";
        int percentTravel;
        while (rungDistance < DISTANCE){
            try {
                speed = (new Random()).nextInt(5);
                rungDistance = rungDistance + speed;
                percentTravel =(rungDistance * 10) / DISTANCE;
                for (int i = 0;i < DISTANCE;i++){
                    if (percentTravel >= i + STEP){
                        log += "=";
                    } else if (percentTravel >= i && percentTravel < i + STEP){
                        log +="o";
                    }else {
                        log+="-";
                    }
                }
                log+="|";
                System.out.println("Car " + this.name+": "+ log+ " " + Math.min(DISTANCE,rungDistance)+ " KM\n");
                Thread.sleep(1000);
            }catch (InterruptedException ex){
                System.out.println("car " + this.name+" broken...");
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car " + this.name+"Finish in "+ (endTime - startTime)/1000 + " s");
    }
}
