/**
 * Name: Andre Arsyan Jordie
 * Course: CS-665 Software Designs & Patterns
 * Date: 11/28/2024
 * File Name: PublisherBase.java
 * Description: This interface is responsible for the Publisher.
 */
package edu.bu.met.cs665.utils;

/**
 * This is the PublisherBase interface.
 * This interface is responsible as blueprint of a Publisher.
 */
public interface PublisherBase {

    void subscribe(SubscriberBase o);

    void unsubscribe(SubscriberBase o);

    void notifySubscribers();

}