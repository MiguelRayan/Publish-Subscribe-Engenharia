package Subscriber;

import Broker.Broker;
import Broker.Event;
import Broker.Subscriber;
import Domain.Reservation;

public class Panel implements Subscriber {

    public Panel() {
        Broker.getInstance().subscribe("nova_reserva", this);
    }

    @Override
    public void onEvent(Event event) {
        if (event.getData() instanceof Reservation) {
            Reservation r = (Reservation) event.getData();
            System.out.println("Atendente recebeu nova reserva:");
            System.out.println(r);
            // Simulação: confirmar imediatamente
            r.setStatus("CONFIRMADA");
            Broker.getInstance().publish(new Event("reserva_confirmada", r));
        }
    }
}