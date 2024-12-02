/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: EmailNotification.java
 * Description: This class is responsible for the Email Notification.
 */
package edu.bu.met.cs665.mbta.notifications;

import edu.bu.met.cs665.utils.ThreadManager;

public class EmailNotification extends NotificationManager {

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
