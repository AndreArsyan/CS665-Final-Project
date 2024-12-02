package edu.bu.met.cs665.mbta.notifications;

import edu.bu.met.cs665.utils.ThreadManager;

public class AppNotification extends NotificationManager {

    public AppNotification(ThreadManager threadManager) {
        super(threadManager);
    }

    @Override
    public void send(String message) {
        try {
            Thread.sleep(10);
            System.out.print("\n" +
                    "----------------------------------------\n" +
                    "[APP NOTIFICATION]: " + message +
                    "\n----------------------------------------");
        } catch (InterruptedException e) {
            System.out.println("Error sending notification: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
