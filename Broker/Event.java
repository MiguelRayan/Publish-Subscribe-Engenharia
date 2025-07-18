package Broker;

public class Event {
    private String topic;
    private Object data;

    public Event(String topic, Object data) {
        this.topic = topic;
        this.data = data;
    }

    public String getTopic() {
        return topic;
    }

    public Object getData() {
        return data;
    }
}