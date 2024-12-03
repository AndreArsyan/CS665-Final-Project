/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: NotificationManager.java
 * Description: This class is responsible for the Notification Manager.
 */
package edu.bu.met.cs665.mbta.notifications;

import edu.bu.met.cs665.utils.ThreadManager;

/**
 * This is the NotificationManager class.
 * This class is responsible for representing a Notification Manager.
 */
public abstract class NotificationManager implements Notification {
    ThreadManager threadManager;

    /**
     * Create a NotificationManager object.
     *
     * @param threadManager Thread manager object to enable sending notifications
     *                      using Threads.
     */
    protected NotificationManager(ThreadManager threadManager) {
        this.threadManager = threadManager;
    }

    public void sendMessage(String message) {
        threadManager.addTask(() -> send(message));
    }

}
