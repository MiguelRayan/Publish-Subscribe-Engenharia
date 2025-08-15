package Publisher;

import Broker.Broker;
import Broker.Event;
import Domain.Reservation;
import Utils.SimulationReport;

import java.time.LocalDateTime;

public class ClientApp {
    private static int counter = 1;
    private final String clientName;

    public ClientApp(String clientName) {
        this.clientName = clientName;
    }

    public void MakeReservation(int pessoas, LocalDateTime dataHora) {
        Reservation r = new Reservation(counter++, clientName, pessoas, dataHora);
        System.out.println("\u001B[32m[ClientApp] " + clientName + " solicitou nova reserva.\u001B[0m");
        SimulationReport.getInstance().log(clientName + " fez uma reserva para " + pessoas + " pessoas.");
        Event evento = new Event("nova_reserva", r);
        Broker.getInstance().publish(evento);
    }

    public void CancelReservation(Reservation reserva) {
        reserva.setStatus("CANCELADA");
        System.out.println("\u001B[31m[ClientApp] " + clientName + " cancelou a reserva #" + reserva.getId() + ".\u001B[0m");
        SimulationReport.getInstance().log(clientName + " cancelou a reserva #" + reserva.getId());
        Event evento = new Event("reserva_cancelada", reserva);
        Broker.getInstance().publish(evento);
    }
}