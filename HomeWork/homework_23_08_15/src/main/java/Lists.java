import java.util.*;

public class Lists {
    private final List<String> arrayList = new ArrayList<>();
    private final List<String> linkedList = new LinkedList<>();
    private static final Random rd = new Random();

    public void addElemToLists(int quantityElem) {
        for (int i = 0; i < quantityElem; i++) {
            UUID uuid = UUID.randomUUID();
            String generatedString = uuid.toString().substring(0, 6);
            arrayList.add(generatedString);
            linkedList.add(generatedString);
        }
    }

    public void randomSelectionArrayList(int count) {
        for (int i = 0; i < count; i++) {
            arrayList.get(rd.nextInt(arrayList.size()));
        }
    }

    public void randomSelectionLinkedList(int count) {
        for (int i = 0; i < count; i++) {
            linkedList.get(rd.nextInt(linkedList.size()));
        }
    }

    public double average(List<Integer> integerList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите пять целых чисел: ");
        for (int i = 0; i < 5; i++) {
            int number = scanner.nextInt();
            integerList.add(number);
        }
        System.out.println("Введенные числа: " + integerList);
        int sum = 0;
        for (int n : integerList) {
            sum += n;
        }
        return (double) sum / integerList.size();
    }

    public List<Integer> bubbleSort(List<Integer> list) {
        List<Integer> result = new ArrayList<>(list);
        int numElem = 1;
        int count = 0;
        boolean flagStop = false;
        while (count < result.size() - 1) {
            while (numElem < result.size()) {
                int current = result.get(numElem - 1);
                int next = result.get(numElem);
                if (current > next) {
                    result.set(numElem, current);
                    result.set(numElem - 1, next);
                    flagStop = true;
                }
                numElem++;
            }
            if (!flagStop) break;
            flagStop = false;
            numElem = 1;
            count++;
        }
        return result;
    }

    public List<String> removeDuplicates(List<String> products) {
        List<String> result = new ArrayList<>(products);
        String firstProduct = products.get(0);
        result.removeIf(i -> Objects.equals(i, firstProduct));
        result.add(0, firstProduct);
        return result;
    }

    public List<String> removeDuplicates2(List<String> products) {
        List<String> result = new ArrayList<>(products);
        String firstProduct = result.get(0);
        Iterator<String> iterator = result.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str.equals(firstProduct)) {
                iterator.remove();
            }
        }
        result.add(0, firstProduct);
        return result;
    }
}