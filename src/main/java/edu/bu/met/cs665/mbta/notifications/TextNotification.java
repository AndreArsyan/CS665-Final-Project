package edu.bu.met.cs665.mbta.notifications;

public class TextNotification extends NotificationManager implements Notification {

    @Override
    public void send(String message) {
        if (!isSent) {
            System.out.println("[TEXT NOTIFICATION]: " + message);
            isSent = true;
        }
    }

}
