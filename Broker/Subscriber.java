package Broker;

public interface Subscriber {
    void onEvent(Event event);
}