package TaskBank;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StorageInfoClientCards infoClientCards = new StorageInfoClientCards();
        Map<Client, List<Bankcards>> mapClients = new HashMap<>();

        Client id_001 = Generator.clientGeneration();
        Client id_002 = Generator.clientGeneration();
        Client id_003 = Generator.clientGeneration();
        Client id_004 = Generator.clientGeneration();
        Client id_005 = Generator.clientGeneration();
        infoClientCards.addClient(id_001, mapClients);
        infoClientCards.addClient(id_002, mapClients);
        infoClientCards.addClient(id_003, mapClients);
        infoClientCards.addClient(id_004, mapClients);
        infoClientCards.addClient(id_005, mapClients);

        for (Map.Entry<Client, List<Bankcards>> entry : mapClients.entrySet()) {
            System.out.println("[" + entry.getKey() + entry.getValue() + "]");
        }

    }
}
