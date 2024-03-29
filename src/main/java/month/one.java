package month;

class ticket implements Runnable{
    int ticket_num = 10;
    @Override
    public  void run() {
        synchronized (this){
            try {
                while (true){
                    if (ticket_num<=0) break;
                    buy();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void buy() throws InterruptedException {
        if (ticket_num<=0) return;
        Thread.sleep(300);
        System.out.println(Thread.currentThread().getName()+"抢到了"+ticket_num--);

    }
}
class people{
    public static void main(String[] args) {
        ticket tk = new ticket();
        new Thread(tk,"小明").start();
        new Thread(tk,"小张").start();
        new Thread(tk,"小王").start();
        new Thread(tk,"小邹").start();
    }

}
