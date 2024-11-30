package edu.bu.met.cs665.mbta.notifications;

import edu.bu.met.cs665.utils.ThreadManager;

public class EmailNotification extends NotificationManager implements Notification {

    public EmailNotification(ThreadManager threadManager) {
        super(threadManager);
    }

    @Override
    public void send(String message) {
        if (!isSent) {
            System.out.print("\n" +
                    "----------------------------------------\n" +
                    "[EMAIL NOTIFICATION]: " + message +
                    "\n----------------------------------------");
            isSent = true;
        }
    }

}
