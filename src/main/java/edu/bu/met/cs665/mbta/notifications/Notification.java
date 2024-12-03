/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: Notification.java
 * Description: This interface is responsible for the Notification.
 */
package edu.bu.met.cs665.mbta.notifications;

/**
 * This is the Notification interface.
 * This interface is responsible for representing a generic Notification
 * blueprint.
 */
public interface Notification {
    void send(String message);
}
