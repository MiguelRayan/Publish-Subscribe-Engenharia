package Broker;

import Utils.SimulationReport;
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
        System.out.println("\u001B[33m[Broker] Novo inscrito no tópico: " + topic + "\u001B[0m");
        SimulationReport.getInstance().log("Subscriber inscrito no tópico '" + topic + "'");
    }

    public void publish(Event event) {
        System.out.println("\u001B[36m[Broker] Publicando evento '" + event.getTopic() + "'\u001B[0m");
        SimulationReport.getInstance().log("Evento publicado: '" + event.getTopic() + "'");

        List<Subscriber> list = subscribers.get(event.getTopic());
        if (list != null) {
            for (Subscriber s : list) {
                System.out.println("  -> Enviando para subscriber: " + s.getClass().getSimpleName());
                SimulationReport.getInstance().log("Evento '" + event.getTopic() + "' entregue para " + s.getClass().getSimpleName());
                s.onEvent(event);
            }
        } else {
            System.out.println("  Nenhum subscriber para este tópico.");
        }
    }
}