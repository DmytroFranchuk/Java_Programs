import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * В примере используем два класса: ConcurrentHashMap и HashMap.
 * Метод createMap создает объект типа Map<String, String>. В зависимости от параметра concurrent будет использован либо
 * класс ConcurrentHashMap, либо HashMap. Поскольку ConcurrentHashMap реализует интерфейс ConcurrentMap,
 * который расширяет свойства Map<K,V>, то в методе реализуется один их принципов объектно-ориентированного
 * программирования — полиморфизм (всё по науке). Далее метод наполняет объект некоторыми значениями.
 * В методе addValue сначала выводится содержимое объекта в консоль. После этого с использованием итератора
 * выполняется перебор всего набора данных объекта, и для ключа со значением "2" формируется новый объект, который
 * добавляется в набор. Во время перебора значения набора выводятся в консоль. В заключение повторно выводится
 * содержимое объекта в консоль. Следует отметить, что в этом методе мы проверяем срабатывание исключения
 * ConcurrentModificationException, связанное с работой итератора и модификацией набора во время перебора.
 * После нахождения ключа и добавления объекта в набор, цикл не прерывается.
 * <p>
 * Информационные сообщения при выполнении примера выводятся в консоль.
 * При использовании класса ConcurrentHashMap цикл перебора с использованием итератора завершился нормально;
 * в консоль попал также новый объект с ключом "2", добавленный в набор во время итерации.
 * А вот при использовании класса HashMap цикл был прерван вызовом исключения ConcurrentModificationException,
 * как и ожидалось. Место ошибки : String key = it.next();
 * Т.е. итератор вызывает исключение при обращении к следующему объекту, если набор изменился.
 */
public class ConcurrentHashMapExample {
    Map<String, String> map;

    public ConcurrentHashMapExample() {
        System.out.println("ConcurrentHashMap");
        createMap(true);
        addValue();

        System.out.println("\n\nHashMap");
        createMap(false);
        addValue();
    }

    private void addValue() {
        System.out.println("  before iterator : " + map);
        Iterator<String> it = map.keySet().iterator();

        System.out.print("  cycle : ");
        while (it.hasNext()) {
            String key = it.next();
            if (key.equals("2")) {
                map.put(key + "new", "222");
            } else
                System.out.print("  " + key + "="
                        + map.get(key));
        }
        System.out.println();
        System.out.println("  after iterator : " + map);
    }

    private void createMap(boolean concurrent) {
        if (concurrent)
            map = new ConcurrentHashMap<>();
        else
            map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "1");
        map.put("3", "1");
        map.put("4", "1");
        map.put("5", "1");
        map.put("6", "1");
    }

    public static void main(String[] args) {
        new ConcurrentHashMapExample();
        System.exit(0);
    }
}