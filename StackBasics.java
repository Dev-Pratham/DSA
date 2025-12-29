import java.util.ArrayList;

public class StackBasics {

    // Stack does
    // not need
    // an instance
    // of StackBasics

    // It is
    // NOT tied
    // to any
    // outer object
    // so its made static

    public static class Stack {

        // we have done private so that you cannot access list
        // inside main simply list will not be accessible but if it`s public list
        // will be accessible
        // s.list.add(10); // ❌
        // s.list.remove(0); // ❌
        // s.list.size(); // ❌

        // Stack s = new Stack();
        // s.push(10); // ✅ allowed
        // s.pop(); // ✅ allowed
        private ArrayList<Integer> list;

        Stack() {
            list = new ArrayList<>();
        }

        boolean isEmpty() {
            return list.size() == 0;
        }

        // we can make it puclic but should not make it static because
        // static methods do not belongs to an object and they cannot access
        // instance variable like list
        void push(int data) {
            list.add(data);
            return;
        }

        int pop() {
            // simply if the list is empty we return as no element to remove
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }

    }

    public static void main(String args[]) {

        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
