package TaskBank;

// - класс Хранилище
//      - мапа которая хранит ---Клиент, ЛистКарт--- TreeMap
//      * Add Read(валюта) Update Delete

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageInfoClientCards {
    private Map<Client, List<Bankcards>> clientsListCards;

    public Map<Client, List<Bankcards>> addClient(Client clientID, Map<Client, List<Bankcards>> map) {
        map.put(clientID, clientID.getBankcardsList());
        return map;
    }

    public void readClient() {

    }

    public void updateClient() {

    }

    public void deleteClient() {

    }


}