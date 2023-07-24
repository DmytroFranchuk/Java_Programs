import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Storage clients = new Storage();
        Map<Client, Double> mapClients = clients.getStorage(10);
        // Вывести в консоль, всех клиентов у которых определенный статус карты
        System.out.println("Клиенты у которых карта GOLD");
        clients.getClientsCardStatus(mapClients, Statuses.GOLD);
        System.out.println("Клиенты у которых карта WORLD");
        clients.getClientsCardStatus(mapClients, Statuses.WORLD);
        System.out.println("Клиенты у которых карта DIAMOND");
        clients.getClientsCardStatus(mapClients, Statuses.DIAMOND);
        System.out.println("Клиенты у которых карта PLATINUM");
        clients.getClientsCardStatus(mapClients, Statuses.PLATINUM);
        System.out.println("Клиенты у которых карта STANDART");
        clients.getClientsCardStatus(mapClients, Statuses.STANDART);
        // Сгруппировать по балансу клиентов у которых больше какой-то суммы
        int sum = 90000;
        System.out.println("Сгруппировать по балансу клиентов у которых больше " + sum);
        clients.groupedBalanceMoreSum(mapClients, sum);
        // Сгруппировать по балансу клиентов у которых меньше какой-то суммы
        sum = 10000;
        System.out.println("Сгруппировать по балансу клиентов у которых меньше " + sum);
        clients.groupedBalanceLessSum(mapClients, sum);
        // Средний баланс по всем клиентам
        System.out.println("Средний баланс по всем клиентам");
        System.out.println(clients.getAVG(mapClients));
        // Вывести в консоль номера карт всех клиентов в формате имя номер
        System.out.println("Вывести в консоль номера карт всех клиентов в формате имя номер");
        clients.getCardNumbers(mapClients);
        // Вывести в консоль всех клиентов у кого закончился срок действия карт
        System.out.println("Вывести в консоль всех клиентов у кого закончился срок действия карт");
        clients.getEndedValidity(mapClients);
        // Отсортировать по балансу на карте клиентов c учетом типа валют
        System.out.println("Отсортировать по балансу на карте клиентов c учетом типа валют");
        Map<Currencies, List<Client>> sortMapCurrencies = clients.sortBalanceCurrencies(mapClients);
        clients.printSortMap(sortMapCurrencies);
        // Сгруппировать по сроку действия карт - у кого закончился срок карт, а у кого ещё действует
        System.out.println("Сгруппировать по сроку действия карт:");
        Map<Status, List<Client>> sortMapStatus = clients.groupedStatuses(mapClients);
        clients.printSortMap(sortMapStatus);
    }

}
