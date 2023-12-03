package lessAlg_2023_11_29.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class AlgorithmStack {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        Deque<Integer> deque = new ArrayDeque<>();

        CustomArrayStack stack1 = new CustomArrayStack(5);
        stack1.push(1);
        stack1.push(3);
        stack1.push(2);
        stack1.push(5);
        stack1.push(7);
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        System.out.println(stack1.isEmpty());
        SpecialStack specialStack = new SpecialStack(5);
        specialStack.push(18);
        specialStack.push(19);
        System.out.println(specialStack.getMin());
        specialStack.push(29);
        specialStack.pop();
        specialStack.push(15);
        specialStack.push(5);
        System.out.println(specialStack.getMin());
        specialStack.push(16);
        System.out.println(specialStack.getMin());
        specialStack.pop();
        specialStack.pop();
        System.out.println(specialStack.getMin());
        specialStack.push(5);
        System.out.println(specialStack.getMin());


    }
}
