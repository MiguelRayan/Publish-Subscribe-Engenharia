package Domain;

public class Table {
    private int id;
    private int capacidade;
    private boolean disponivel;

    public Table(int id, int capacidade) {
        this.id = id;
        this.capacidade = capacidade;
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacidade;
    }

    public boolean free() {
        return disponivel;
    }

    public void clear() {
        this.disponivel = true;
    }

    public void occupy() {
        this.disponivel = false;
    }

    @Override
    public String toString() {
        return "Mesa " + id + " (" + capacidade + " lugares) - " + (disponivel ? "Disponível" : "Ocupada");
    }
}