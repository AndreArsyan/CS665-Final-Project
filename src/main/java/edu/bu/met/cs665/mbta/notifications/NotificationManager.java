package edu.bu.met.cs665.mbta.notifications;

import edu.bu.met.cs665.utils.ThreadManager;

public abstract class NotificationManager implements Notification {
    ThreadManager threadManager;

    protected NotificationManager(ThreadManager threadManager) {
        this.threadManager = threadManager;
    }

    public void sendMessage(String message) {
        threadManager.addTask(() -> send(message));
    }

}
