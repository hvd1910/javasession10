package session09;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;
public class AtomicOperationClassDemo {
    private final LongAdder longAdder;
    private final DoubleAdder doubleAdder;

    public AtomicOperationClassDemo(LongAdder longAdder, DoubleAdder doubleAdder) {
        this.longAdder = longAdder;
        this.doubleAdder = doubleAdder;
    }

    public void incrementLong() {
        longAdder.increment();
    }

    public long getLongCounter() {
        return longAdder.longValue();
    }

    public void addDouble(int doubleValue) {
        doubleAdder.add(doubleValue);
    }

    public double getSumAsDouble() {
        return doubleAdder.doubleValue();
    }

    public static void main(String[] args) {
        AtomicOperationClassDemo atomicOperationClassDemol = new AtomicOperationClassDemo(new LongAdder(), new DoubleAdder());
        System.out.println(" Long Counter ");
        for (int i = 0; i < 10; i++) {
            atomicOperationClassDemol.incrementLong();
            System.out.println("Long Counter " + atomicOperationClassDemol.getLongCounter());
        }
        System.out.println(" Double Sum ");
        for (int j = 0; j < 10; j++) {
            atomicOperationClassDemol.addDouble(j);
            System.out.println("Double Sum" + atomicOperationClassDemol.getSumAsDouble());
        }
    }
}