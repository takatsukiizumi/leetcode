package takatsukiizumi.leetcode.philosopher_eating_problem;

import org.springframework.ui.context.Theme;

public class philosopher extends Thread {

    private String name;
    private chopsticks left;
    private chopsticks right;

    private int index;

    public philosopher(String name, int index ,chopsticks left, chopsticks right) {
        this.name = name;
        this.left = left;
        this.right = right;
        this.index = index;
    }

    public void run () {
        if(index %2 ==0 ){
            synchronized (left) {
                System.out.println(this.name + "拿起了左筷子");
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (right) {
                    try {
                        Thread.sleep(1L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(this.name + "拿起了右筷子");
                    this.eat();
                }
            }
            }else{
                synchronized (right){
                    System.out.println(this.name+"拿起了右筷子");
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (left){
                        try {
                            Thread.sleep(1L);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(this.name+"拿起了左筷子");
                        this.eat();
                    }
                }


        }

        }



    void eat()  {
        System.out.println(name+"吃完了");
        long millsTime = 1000;
        try {
            Thread.sleep(millsTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
