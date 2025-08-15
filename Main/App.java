package Main;

import Publisher.ClientApp;
import Subscriber.Notificate;
import Subscriber.Panel;
import Subscriber.LogReservation;
import Utils.SimulationReport;

import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        // Inicializando Subscribers
        new Panel();
        new Notificate();
        new LogReservation();

        // Criando vários clientes e simulando reservas
        ClientApp c1 = new ClientApp("João da Silva");
        ClientApp c2 = new ClientApp("Maria Oliveira");
        ClientApp c3 = new ClientApp("Carlos Souza");

        c1.MakeReservation(4, LocalDateTime.now().plusHours(2));
        c2.MakeReservation(2, LocalDateTime.now().plusHours(3));
        c3.MakeReservation(6, LocalDateTime.now().plusHours(5));

        // Mostrando relatório final
        SimulationReport.getInstance().printReport();
    }
}