package Broker;

import java.util.*;

public class Broker {
    private static Broker instance;
    private Map<String, List<Subscriber>> subscribers;

    private Broker() {
        subscribers = new HashMap<>();
    }

    public static synchronized Broker getInstance() {
        if (instance == null) {
            instance = new Broker();
        }
        return instance;
    }

    public void subscribe(String topic, Subscriber subscriber) {
        subscribers.computeIfAbsent(topic, k -> new ArrayList<>()).add(subscriber);
    }

    public void publish(Event event) {
        List<Subscriber> list = subscribers.get(event.getTopic());
        if (list != null) {
            for (Subscriber s : list) {
                s.onEvent(event);
            }
        }
    }
}