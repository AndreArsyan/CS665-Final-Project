package edu.bu.met.cs665.utils;

public interface PublisherBase {

    void subscribe(SubscriberBase o);

    void unsubscribe(SubscriberBase o);

    void notifySubscribers();

}