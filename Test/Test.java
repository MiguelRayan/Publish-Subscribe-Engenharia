package Test;

import Broker.Broker;
import Domain.Table;
import Domain.Reservation;
import Publisher.ClientApp;
import Subscriber.LogReservation;
import Subscriber.Notificate;
import Subscriber.Panel;
import Subscriber.TableSystem;

import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        // Inicializar subsistemas
        new Panel();
        new Notificate();
        new LogReservation();
        TableSystem TableSystem = new TableSystem();

        ClientApp cliente = new ClientApp();

        // 1. Cliente faz reserva
        cliente.MakeReservation("Maria", 3, LocalDateTime.now().plusHours(1));

        // 2. Simulação de cancelamento
        Reservation r2 = new Reservation(2, "Carlos", 2, LocalDateTime.now().plusHours(3));
        cliente.CancelReservation(r2);

        // 3. Simulação de liberação de Table
        Table Table = new Table(5, 4);
        Table.occupy(); // simula que estava ocupada
        TableSystem.tableClear(Table);
    }
}