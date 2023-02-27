package session09;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
public class ExecutorExample {
    public void main(String[] args) {
        ImplementExecutor obj = new ImplementExecutor();
        try {
            obj.executor(new NewThrd);
        } catch(RejectedExecutionException | NullPointerException exception){
            System.out.println(exception);
        }
    }
    class ImplementExecutor implements Executor{
        @Override
        public void execute(Runnable command){
            new Thread(command).start();
        }

        public void executor(NewThrd newThrd) {
        }
    }
    class NewThrd implements Runnable{
        @Override
        public void run(){
            System.out.println("This thread executed under executor");
        }
    }
}
