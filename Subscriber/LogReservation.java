package Subscriber;

import Broker.Broker;
import Broker.Event;
import Broker.Subscriber;
import Domain.Reservation;

public class LogReservation implements Subscriber {

    public LogReservation() {
        Broker.getInstance().subscribe("reserva_confirmada", this);
        Broker.getInstance().subscribe("reserva_cancelada", this);
    }

    @Override
    public void onEvent(Event event) {
        if (event.getData() instanceof Reservation) {
            Reservation r = (Reservation) event.getData();
            System.out.println("[LOG] Evento: " + event.getTopic() + " -> " + r);
        }
    }
}