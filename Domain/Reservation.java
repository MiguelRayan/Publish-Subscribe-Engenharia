package Domain;

import java.time.LocalDateTime;

public class Reservation {
    private int id;
    private String clientName;
    private int people;
    private LocalDateTime dateTime;
    private String status;

    public Reservation(int id, String clientName, int people, LocalDateTime dateTime) {
        this.id = id;
        this.clientName = clientName;
        this.people = people;
        this.dateTime = dateTime;
        this.status = "PENDING";
    }

    public int getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public int getPeople() {
        return people;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reserva #" + id + " - " + clientName + " (" + people + " pessoas) em " + dateTime + " [" + status + "]";
    }
}