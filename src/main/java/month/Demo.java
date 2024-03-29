package month;

public class Demo {
    ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private String content;
//    public String getContent() {
//        return threadLocal.get();
//    }
//    public void setContent(String content) {
//        threadLocal.set(content);
//    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Demo() {
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                synchronized (demo){
                    demo.setContent(Thread.currentThread().getName() + "的数据");
                    System.out.println("---------------------------");
                    System.out.println(Thread.currentThread().getName() + "---->" + demo.getContent());
                }
            });
            thread.setName("线程" + i);
            thread.start();
        }


    }
}
