package Test;

import Domain.Table;
import Domain.Reservation;
import Publisher.ClientApp;
import Subscriber.LogReservation;
import Subscriber.Notificate;
import Subscriber.Panel;
import Subscriber.TableSystem;
import Utils.SimulationReport;

import java.time.LocalDateTime;

public class Test {
    public static void main(String[] args) {
        // Inicializar subsistemas
        new Panel();
        new Notificate();
        new LogReservation();
        TableSystem tableSystem = new TableSystem();

        // Criar clientes
        ClientApp cliente1 = new ClientApp("Maria");
        ClientApp cliente2 = new ClientApp("Carlos");

        // 1. Cliente faz reserva
        cliente1.MakeReservation(3, LocalDateTime.now().plusHours(1));

        // 2. Simulação de cancelamento
        Reservation r2 = new Reservation(2, "Carlos", 2, LocalDateTime.now().plusHours(3));
        cliente2.CancelReservation(r2);

        // 3. Simulação de liberação de mesa
        Table table = new Table(5, 4);
        table.occupy(); // simula que estava ocupada
        tableSystem.tableClear(table);

        // Mostrar relatório final
        SimulationReport.getInstance().printReport();
    }
}