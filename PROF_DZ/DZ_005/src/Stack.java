import java.util.LinkedList;
import java.util.List;

public class Stack <T> {
    private LinkedList<T> stack;

    public Stack() {
        stack = new LinkedList<>();
    }
    // добавления элемента в стек
    public void push(T element) {
        stack.push(element);
    }
    // извлечения элемента из стека
    public T pop() {
        return stack.pop();
    }
    // проверка, стек пуст или нет
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return "stack = " + stack;
    }
}
