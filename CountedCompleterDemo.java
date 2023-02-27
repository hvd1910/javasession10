package session09;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
public class CountedCompleterDemo {
    static class NumberComputator extends CountedCompleter<Void>{
        final ConcurrentLinkedQueue<String>concurrentLinkedQueue;
        final int start;
        final int end;
        NumberComputator(ConcurrentLinkedQueue<String>concurrentLinkedQueue, int start, int end){
            this(concurrentLinkedQueue, start, end, null);
        }
        NumberComputator(ConcurrentLinkedQueue<String>concurrentLinkedQueue, int start, int end, NumberComputator parent){
            super(parent);
            this.concurrentLinkedQueue = concurrentLinkedQueue;
            this.start = start;
            this.end = end;
        }
        @Override
        public void compute(){
            if(end - start < 5){
                String s = Thread.currentThread().getName();
                for(int i = start; i < end;i++){
                    concurrentLinkedQueue.add(String.format("Iteration number: {%d} performed by thread{%s}",i,s));
                }
                propagateCompletion();
            }
        } else{
            int mid = (end + start)/2;
            NumberComputator subTaskA = new NumberComputator(concurrentLinkedQueue, start, mid, this);
            NumberComputator subTaskB = new NumberComputator(concurrentLinkedQueue, mid, end,this);
            setPendingCount(1);
            subTaskA.fork();
            subTaskB.compute();
        }

        public static void main(String[] args) throws ExecutionException, InterruptedException{
            ConcurrentLinkedQueue<String>linkedQueue = new ConcurrentLinkedQueue<>();
            NumberComputator numberComputator = new NumberComputator(linkedQueue,10,100);
            ForkJoinPool.commonPool().invoke(numberComputator);
            ArrayList<String>list = new ArrayList<>(linkedQueue);
            for (String listItem : list){
                System.out.println(""+listItem);
            }
        }
    }
}
