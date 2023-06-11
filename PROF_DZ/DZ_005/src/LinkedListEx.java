public class LinkedListEx<T> {
    private Node<T> head;
    private int size = 0;

    public LinkedListEx() {
        this.head = null;
    }

    public int getSize() {
        return size;
    }

    public void add(T data) {                   // добавление в конец списка
        Node<T> newNode = new Node(data);
        if (head == null) {                     // Если список пустой, значит добавляется первый узел
            head = newNode;
            size++;
        } else {
            Node<T> current = head;             // указатель на первый узел списка
            while (current.getNext() != null) {
                current = current.getNext();    // После цикла current указывает на последний узел в списке
            }
            current.setNext(newNode);           // Присоединяем новый узел к концу списка
            size++;
        }
    }

    public void remove(T data) {                // удаление элемента из списка по значению
        if (head == null) {                     // Если список пустой, значит ничего не делаем
            return;
        }
        if (head.getData().equals(data)) {      // Если удаляемый элемент первый в списке
            head = head.getNext();
            size--;
            return;
        }
        Node<T> previous = head;
        Node<T> current = head.getNext();       // Ищем элемент, который следует за удаляемым элементом
        while (current != null) {               // Устанавливаем ссылку на следующий элемент, пропуская удаляемый элемент
            if (current.getData().equals(data)) {
                previous.setNext(current.getNext());
                size--;
                return;
            }
            previous = current;                 // Условие не выполнилось значит двигаемся дальше по списку
            current = current.getNext();        // продолжаем перебор
        }
    }

    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void removeAll(T data) {
        if (head == null) {
            return;
        }
        // Проверяем начальные элементы списка
        while (head != null && head.getData().equals(data)) {
            head = head.getNext();
            size--;
        }
        // Ищем и удаляем остальные вхождения элемента
        Node<T> previous = head;
        Node<T> current = head != null ? head.getNext() : null;
        while (current != null) {
            if (current.getData().equals(data)) {
                previous.setNext(current.getNext());
                size--;
            } else {
                previous = current;
            }
            current = current.getNext();
        }
    }

    public void display() {
        Node<T> current = head;
        System.out.print("LinkedListEx ==> (");
        while (current != null) {
            if (current.getNext() == null) {
                System.out.print(current.getData());
            } else {
                System.out.print(current.getData() + ", ");
            }
            current = current.getNext();
        }
        System.out.println(") size = " + size);
    }
}

