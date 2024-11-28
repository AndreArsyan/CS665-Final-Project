package edu.bu.met.cs665.mbta.notifications;

public class EmailNotification extends NotificationManager implements Notification {

    @Override
    public void send(String message) {
        if (!isSent) {
            System.out.println("[EMAIL NOTIFICATION]: " + message);
            isSent = true;
        }
    }

}
