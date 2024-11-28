package edu.bu.met.cs665.mbta.notifications;

public class AppNotification extends NotificationManager implements Notification {

    @Override
    public void send(String message) {
        if (!isSent) {
            System.out.println("[APP NOTIFICATION]: " + message);
            isSent = true;
        }
    }

}
