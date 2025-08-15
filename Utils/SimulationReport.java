package Utils;

import java.util.ArrayList;
import java.util.List;

public class SimulationReport {
    private static SimulationReport instance;
    private final List<String> logList = new ArrayList<>();

    private SimulationReport() {}

    public static SimulationReport getInstance() {
        if (instance == null) {
            instance = new SimulationReport();
        }
        return instance;
    }

    public void log(String action) {
        logList.add(action);
    }

    public void printReport() {
        System.out.println("\n===== 📋 RELATÓRIO FINAL DA SIMULAÇÃO =====");
        for (int i = 0; i < logList.size(); i++) {
            System.out.println((i + 1) + ". " + logList.get(i));
        }
        System.out.println("===========================================\n");
    }
}