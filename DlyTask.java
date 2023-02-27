package session09;

import java.security.PublicKey;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public abstract class DlyTask implements Delayed {
    private String name;
    private long dlyTime;

    public DlyTask(String name, long dlyTime) {
        this.name = name;
        this.dlyTime = System.currentTimeMillis() + dlyTime;
    }
    public long getDly(TimeUnit timeUnit){
        long difference = dlyTime - System.currentTimeMillis();
        return timeUnit.convert(dlyTime, TimeUnit.MILLISECONDS);
    }
    public int compareTo(Delayed tdetla){
        DlyTask tdetlaTask = (DlyTask) tdetla;
        if(this.dlyTime < tdetlaTask.dlyTime){
            return -1;
        } if(this.dlyTime > tdetlaTask.dlyTime){
            return 1;
        } else {
            return 0;
        }
    }
}
