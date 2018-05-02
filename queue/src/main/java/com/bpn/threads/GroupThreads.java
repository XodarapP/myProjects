package com.bpn.threads;

import com.bpn.handler.Handler;

public class GroupThreads extends Thread {
    private Handler handler;

    public GroupThreads(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
            try {
                while (!handler.getEmpty()) {
                    Thread.sleep(500);
                    handler.removeItemFromMap();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
    }
}
