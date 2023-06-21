package TaskBank;
// - класс Клиент
//      - имя name
//      - возраст клиента age
//      - номер паспорта passportID
//      - все банковские карты клиента bankcardsList

import java.util.List;

public class Client {
    private String name;
    private Integer age;
    private String passportID;

    public List<Bankcards> getBankcardsList() {
        return bankcardsList;
    }

    private List<Bankcards> bankcardsList;

    public Client(String name, Integer age, String passportID, List<Bankcards> bankcardsList) {
        this.name = name;
        this.age = age;
        this.passportID = passportID;
        this.bankcardsList = bankcardsList;
    }
    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", passportID='" + passportID + '\'' +
                ", bankcardsList=" + bankcardsList +
                '}';
    }
}
