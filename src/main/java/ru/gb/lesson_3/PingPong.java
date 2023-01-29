package ru.gb.lesson_3;

public class PingPong {

    private boolean busy;

    public void start() {
        new Thread(this::ping).start();
        new Thread(this::pong).start();
    }

    private synchronized void ping() {
        while (true) {
            try {
                if (busy) {
                    wait();
                }
                busy = true;
                System.out.println("PING");
                Thread.sleep(750);
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void pong() {
        while (true) {
            try {
                if (!busy) {
                    wait();
                }
                busy = false;
                System.out.println("PONG");
                Thread.sleep(750);
                notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
