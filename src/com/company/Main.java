package com.company;

/**
 * Created by invite on 14/02/17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
            MultithreadServ server = new MultithreadServ(6969);
            new Thread(server).start();

            try {
                Thread.sleep(20 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Stopping Server");
            server.stop();
}
}
