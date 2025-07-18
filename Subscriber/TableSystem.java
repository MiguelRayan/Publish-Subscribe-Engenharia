package Subscriber;

import Broker.Broker;
import Broker.Event;
import Broker.Subscriber;
import Domain.Table;

public class TableSystem implements Subscriber {

    public TableSystem() {
        Broker.getInstance().subscribe("table_released", this);
    }

    @Override
    public void onEvent(Event event) {
        if (event.getData() instanceof Table) {
            Table table = (Table) event.getData();
            table.free();  // Marca como disponível
            System.out.println("[TableSystem] Mesa liberada: " + table);
        }
    }

    public void tableClear(Table table) {
        if (!table.free()) {
            table.free(); // Liberar localmente
            Event evento = new Event("table_released", table);
            Broker.getInstance().publish(evento); // Notifica sistema
        } else {
            System.out.println("[TableSystem] Mesa já está liberada: " + table);
        }
    }
}