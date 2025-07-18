package Main;

import Publisher.ClientApp;
import Subscriber.Notificate;
import Subscriber.Panel;

import java.time.LocalDateTime;

import Publisher.ClientApp;
import Subscriber.Notificate;
import Subscriber.Panel;

public class App {
    public static void main(String[] args) {
        new Panel();
        new Notificate();

        ClientApp cliente = newClientApp();
        cliente.MakeReservation("João da Silva", 4, LocalDateTime.now().plusHours(2));
    }
}