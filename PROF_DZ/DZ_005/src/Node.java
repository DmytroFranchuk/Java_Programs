public class Node<T> {
    private T data;         // данные узла
    private Node<T> next;   // ссылка (указатель) на следующий узел

    public Node(T data) {
        this.data = data;
        next = null;
    }
    // Геттеры и сеттеры для доступа к данным и ссылке
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
