import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Storage {
    // Создать и заполнить Map для хранения минимум 25 Клиентов
    public Map<Client, Double> getStorage(int countClients) {
        if (countClients < 25) {
            countClients = 25;
        }
        Map<Client, Double> clientMap = new HashMap<>();
        for (int i = 0; i < countClients; i++) {
            Client client = new Client(getName(),
                    new CardDataGenerator().generateBankCard(), getBalance());
            clientMap.putIfAbsent(client, client.getBalance());
        }
        return clientMap;
    }
    // Вывести в консоль все значения Map
    public void printClientsStorage(Map<Client, Double> clients) {
        for (Map.Entry<Client, Double> entry : clients.entrySet()) {
            Client client = entry.getKey();
            Double balance = entry.getValue();
            System.out.println(client + " : balance[" + balance + "]");
        }
    }
    // Вывести в консоль, всех клиентов у которых определенный статус карты
    public void getClientsCardStatus(Map<Client, Double> clients, Statuses status) {
        for (Map.Entry<Client, Double> entry : clients.entrySet()) {
            if (entry.getKey().getBankCard().getStatus() == status) {
                System.out.println(entry.getKey());
            }

        }
    }
    // Сгруппировать по балансу клиентов у которых больше какой-то суммы
    public void groupedBalanceMoreSum(Map<Client, Double> clients, Integer sum) {
        for (Map.Entry<Client, Double> entry : clients.entrySet()) {
            if (entry.getKey().getBalance() >= sum) {
                System.out.println(entry.getKey());
            }
        }
    }
    // Сгруппировать по балансу клиентов у которых меньше какой-то суммы
    public void groupedBalanceLessSum(Map<Client, Double> clients, Integer sum) {
        for (Map.Entry<Client, Double> entry : clients.entrySet()) {
            if (entry.getKey().getBalance() <= sum) {
                System.out.println(entry.getKey());
            }
        }
    }
    // Средний баланс по всем клиентам
    public Double getAVG(Map<Client, Double> clients) {
        return clients.values().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }
    // Вывести в консоль номера карт всех клиентов в формате имя номер
    public void getCardNumbers(Map<Client, Double> clients) {
        for (Map.Entry<Client, Double> entry: clients.entrySet()) {
            System.out.println("Name: "+ entry.getKey().getName()+", number Card: "+
                    entry.getKey().getBankCard().getCardData());
        }
    }
    // Вывести в консоль всех клиентов у кого закончился срок действия карт
    public void getEndedValidity(Map<Client, Double> clients) {
       List<Client> expiredClients = groupedStatuses(clients).get(Status.EXPIRED);
       if(expiredClients == null || expiredClients.isEmpty()) {
           System.out.println("Нет клиентов с истекшим сроком действия карты");
       } else {
           System.out.println("Клиенты с истекшим сроком действия карты:");
           int count = 0;
           for (Client client : expiredClients) {
               count++;
               System.out.println("Client name: " + client.getName() +
                       ", срок действия карты истек: " + generateDate(client.getBankCard().getCardData()));
           }
           System.out.println("C истекшим сроком действия карты " + count + " клиентов");
       }
    }
    // Отсортировать по балансу на карте клиентов без учета типа валют
    public void sortBalance(Map<Client, Double> clients) {
        clients.entrySet()
                .stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .forEach(entry -> {
                    Client client = entry.getKey();
                    double balance = entry.getValue();
                    System.out.println("Клиент: " + client.getName() + ", Баланс по карте : " + balance);
                });
    }
    // Отсортировать по балансу на карте клиентов учитывая тип валюты
    public Map<Currencies, List<Client>> sortBalanceCurrencies(Map<Client, Double> clients) {
        return clients.entrySet().stream()
                .collect(Collectors.groupingBy(el -> el.getKey().getBankCard().getCurrency(),
                        Collectors.mapping(Map.Entry::getKey,
                                Collectors.collectingAndThen(Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.comparingDouble(clients::get))
                                                .collect(Collectors.toList())))));
    }
    // Напечатать Map<?, List<Client>> в консоль
    public void printSortMap(Map<?, List<Client>> sortMap) {
        sortMap.forEach((key, clientsList) -> {
            String str = null;
            if(key instanceof Currencies){
                str = "Валюта: ";
            } else if(key instanceof Status) {
                str = "Статус: ";
            }
            System.out.println(str + key);
            clientsList.forEach(client -> System.out.println("\t" + client));
            System.out.println();
        });
    }
    // Сгруппировать по сроку действия карт - у кого закончился срок карт, а у кого ещё действует
    public Map<Status, List<Client>> groupedStatuses(Map<Client, Double> clients) {
        Map<Status, List<Client>> groupedMap = new HashMap<>();
        LocalDate currentDate = LocalDate.now();
        for (Map.Entry<Client, Double> entry : clients.entrySet()) {
            Client client = entry.getKey();
            if(generateDate(entry.getKey().getBankCard().getCardData()).isBefore(currentDate)) {
                groupedMap.computeIfAbsent(Status.EXPIRED, k -> new ArrayList<>()).add(client);
            } else {
                groupedMap.computeIfAbsent(Status.ACTIVE, k -> new ArrayList<>()).add(client);
            }
        }
        return groupedMap;
    }

    private LocalDate generateDate(String cardData) {
        int month = Integer.parseInt(cardData.substring(16, 18));
        int year = Integer.parseInt(cardData.substring(18,20));
        LocalDate expirationDateCard = LocalDate.of(2000 + year, month, 1);
        expirationDateCard = expirationDateCard.withDayOfMonth(expirationDateCard.lengthOfMonth());
        return expirationDateCard;
    }
    private String getName() {
        Names[] allNames = Names.values();
        int randomIndex = new Random().nextInt(allNames.length);
        return allNames[randomIndex].toString();
    }
    private Double getBalance() {
        Random random = new Random();
        double min = 0.99;
        double max = 100000.99;
        double value = min+(max-min)*random.nextDouble();
        BigDecimal roundedNumber = BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
        return roundedNumber.doubleValue();
    }

}
