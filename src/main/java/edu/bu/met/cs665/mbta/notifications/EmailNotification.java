/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: EmailNotification.java
 * Description: This class is responsible for the Email Notification.
 */
package edu.bu.met.cs665.mbta.notifications;

import edu.bu.met.cs665.utils.ThreadManager;

/**
 * This is the EmailNotification class.
 * This class is responsible for representing an Email Notification.
 */
public class EmailNotification extends NotificationManager {

    /**
     * Create an EmailNotification object.
     *
     * @param threadManager Thread manager object to enable sending notifications
     *                      using Threads.
     */
    public EmailNotification(ThreadManager threadManager) {
        super(threadManager);
    }

    /**
     * Send a notification message.
     *
     * @param message notification message.
     */
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
