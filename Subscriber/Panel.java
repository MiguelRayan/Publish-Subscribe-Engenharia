package Subscriber;

import Broker.Broker;
import Broker.Event;
import Broker.Subscriber;
import Domain.Reservation;
import Utils.SimulationReport;

public class Panel implements Subscriber {

    public Panel() {
        Broker.getInstance().subscribe("nova_reserva", this);
    }

    @Override
    public void onEvent(Event event) {
        if (event.getData() instanceof Reservation) {
            Reservation r = (Reservation) event.getData();
            System.out.println("\u001B[35m[Panel] Nova reserva recebida: " + r + "\u001B[0m");
            SimulationReport.getInstance().log("Painel recebeu nova reserva: " + r);

            // Simulação: confirmar imediatamente
            r.setStatus("CONFIRMADA");
            Broker.getInstance().publish(new Event("reserva_confirmada", r));
        }
    }
}