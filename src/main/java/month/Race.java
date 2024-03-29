package month;

public class Race implements Runnable{
    private String winner=null;
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (Thread.currentThread().getName()=="兔子"){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            boolean flag=gameOver(i);
            if (flag) break;
            System.out.println(Thread.currentThread().getName()+"-->跑了"+i+"步");
        }
    }
    private boolean gameOver(int steps){
        if (winner!=null) return true;
        {
            if (steps>=100){
                winner=Thread.currentThread().getName();
                System.out.println("winner is "+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race,"乌龟").start();
        new Thread(race,"兔子").start();

    }

}
