/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: AppNotification.java
 * Description: This class is responsible for the Notification on the App.
 */
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
