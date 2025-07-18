package Publisher;

import Broker.Broker;
import Broker.Event;
import Domain.Reservation;

import java.time.LocalDateTime;

public class ClientApp {
    private static int counter = 1;

    public void MakeReservation(String nome, int pessoas, LocalDateTime dataHora) {
        Reservation r = new Reservation(counter++, nome, pessoas, dataHora);
        Event evento = new Event("nova_reserva", r);
        Broker.getInstance().publish(evento);
    }

    public void CancelReservation(Reservation reserva) {
    reserva.setStatus("CANCELADA");
    Event evento = new Event("reserva_cancelada", reserva);
    Broker.getInstance().publish(evento);
    }
}