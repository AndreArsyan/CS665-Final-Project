package edu.bu.met.cs665.mbta.notifications;

import edu.bu.met.cs665.utils.ThreadManager;

public class TextNotification extends NotificationManager implements Notification {

    public TextNotification(ThreadManager threadManager) {
        super(threadManager);
    }

    @Override
    public void send(String message) {
        if (!isSent) {
            System.out.print("\n" +
                    "----------------------------------------\n" +
                    "[TEXT NOTIFICATION]: " + message +
                    "\n----------------------------------------");
            isSent = true;
        }
    }

}
