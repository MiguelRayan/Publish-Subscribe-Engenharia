package Subscriber;

import Broker.Broker;
import Broker.Event;
import Broker.Subscriber;
import Domain.Reservation;

public class Notificate implements Subscriber {

    public Notificate() {
        Broker.getInstance().subscribe("reserva_confirmada", this);
    }

    @Override
    public void onEvent(Event event) {
        if (event.getData() instanceof Reservation) {
            Reservation r = (Reservation) event.getData();
            System.out.println("Cliente notificado: sua reserva foi " + r.getStatus().toLowerCase() + "!");
        }
    }
}