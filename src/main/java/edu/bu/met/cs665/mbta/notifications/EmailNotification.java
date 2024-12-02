package edu.bu.met.cs665.mbta.notifications;

import edu.bu.met.cs665.utils.ThreadManager;

public class EmailNotification extends NotificationManager implements Notification {

    public EmailNotification(ThreadManager threadManager) {
        super(threadManager);
    }

    @Override
    public void send(String message) {
        try {
            Thread.sleep(10);
            System.out.print("\n" +
                    "----------------------------------------\n" +
                    "[EMAIL NOTIFICATION]: " + message +
                    "\n----------------------------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
