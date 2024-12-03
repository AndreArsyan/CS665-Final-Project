/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: TextNotification.java
 * Description: This class is responsible for the Text Notification.
 */
package edu.bu.met.cs665.mbta.notifications;

import edu.bu.met.cs665.utils.ThreadManager;

/**
 * This is the TextNotification class.
 * This class is responsible for representing an Text Notification.
 */
public class TextNotification extends NotificationManager {

    /**
     * Create an TextNotification object.
     *
     * @param threadManager Thread manager object to enable sending notifications
     *                      using Threads.
     */
    public TextNotification(ThreadManager threadManager) {
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
                    "[TEXT NOTIFICATION]: " + message +
                    "\n----------------------------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
