import java.util.Queue;
import java.util.LinkedList;

public class QueueJ4 {
    // Queue using java collection framework

    public static String nonRepeatingLetter(String w) {

        StringBuilder sb = new StringBuilder();
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < w.length(); i++) {

            // add in the queue
            char ch = w.charAt(i);
            q.add(ch);

            // increase frequency
            freq[ch - 97]++;

            // check in queue whether the frequency is <1 for non repeating letters
            // if less than one we simply append
            if (freq[q.peek() - 97] <= 1) {
                sb.append(q.peek());
            } else {
                // if greater than 1 we remove until we found element <1
                while ((!q.isEmpty() && freq[q.peek() - 97] > 1)) {
                    q.remove();
                }
                // similarly when removing if queue becomes empty append -1
                if (q.isEmpty()) {
                    sb.append(-1);
                    // if not then append q.peek as it contains letter of non repeating
                } else {
                    sb.append(q.peek());
                }
            }

        }

        return sb.toString();
    }

    // interleave 2 half of queue

    public static void interleave(Queue<Integer> q) {

        Queue<Integer> q1st = new LinkedList<>();
        int size = q.size();
        int i = 1;
        // removing half element from the original queue and addint to new queue
        while (i <= size / 2) {
            int res = q.peek();
            q1st.add(res);
            q.remove();
            i++;
        }

        // add the first element from q1st and remove from original and add to original
        while (!q1st.isEmpty()) {
            int res = q1st.remove();
            q.add(res);
            int res2 = q.remove();
            q.add(res2);
        }

    }

    public static void main(String args[]) {
        // there are 2 classes which are used to implement queue in java
        // -linkedlist
        // arrayDeque

        // because queue can not has object because its an interface
        // Queue<Integer> q = new LinkedList<>();
        // q.add(1);
        // q.add(2);
        // q.add(3);

        // First non repeating letter problem
        // String w = "aabccxb";
        // String res = nonRepeatingLetter(w);
        // System.out.println(res);

        // interleave queue
        Queue<Integer> q1 = new LinkedList<>();

        for (int i = 1; i <= 10; i++) {
            q1.add(i);
        }

        interleave(q1);
        System.out.println(q1);

    }
}

/*
 * Totally fair — this is one of those things that sounds simple but gets fuzzy
 * over time. Let’s reset it cleanly with a real, relatable example and then tie
 * it back to Queue so it sticks.
 * 
 * 1️⃣ Big idea first (one line)
 * 
 * Interface = what you can do
 * Class = how you do it
 * 
 * Keep this in your head while reading everything below.
 * 
 * 2️⃣ Real-world analogy (very important)
 * 🧾 Interface = Contract
 * 
 * Imagine a job contract:
 * 
 * “You must be able to:
 * 
 * take payments
 * 
 * refund money”
 * 
 * That contract does not say HOW you do it.
 * 
 * 🏭 Class = Actual Worker
 * 
 * Now:
 * 
 * A Cashier
 * 
 * A UPI Machine
 * 
 * A Card Terminal
 * 
 * All follow the same contract, but work differently.
 * 
 * 3️⃣ Code example (simple & clear)
 * ✅ Interface (contract)
 * interface Payment {
 * void pay(int amount);
 * }
 * 
 * 
 * Notice:
 * 
 * ❌ No constructor
 * 
 * ❌ No implementation
 * 
 * ✔ Only method declaration
 * 
 * ✅ Class implementing interface
 * class CashPayment implements Payment {
 * public void pay(int amount) {
 * System.out.println("Paid " + amount + " using cash");
 * }
 * }
 * 
 * 
 * Another implementation:
 * 
 * class UpiPayment implements Payment {
 * public void pay(int amount) {
 * System.out.println("Paid " + amount + " using UPI");
 * }
 * }
 * 
 * 4️⃣ Why interface exists (this is the WHY)
 * 
 * Now look at this:
 * 
 * Payment p;
 * 
 * p = new CashPayment();
 * p.pay(100);
 * 
 * p = new UpiPayment();
 * p.pay(200);
 * 
 * 
 * Same variable
 * Same method call
 * Different behavior
 * 
 * 🔥 THIS is the power of interfaces.
 * 
 * 5️⃣ Why you cannot create interface object
 * Payment p = new Payment(); // ❌ illegal
 * 
 * 
 * Why?
 * 
 * Interface has no implementation
 * 
 * Java doesn’t know what code to run
 * 
 * It’s like trying to hire a contract instead of a worker.
 * 
 * 6️⃣ Now connect this to Queue (aha moment)
 * Queue is an interface:
 * Queue<Integer> q;
 * 
 * 
 * Queue says:
 * 
 * enqueue
 * 
 * dequeue
 * 
 * peek
 * 
 * But not HOW.
 * 
 * LinkedList & ArrayDeque are classes:
 * Queue<Integer> q1 = new LinkedList<>();
 * Queue<Integer> q2 = new ArrayDeque<>();
 * 
 * 
 * Both follow the Queue contract, but internally:
 * 
 * LinkedList → nodes
 * 
 * ArrayDeque → circular array
 * 
 * 7️⃣ Key differences table (easy to revise)
 * Feature Interface Class
 * Object creation ❌ No ✔ Yes
 * Method body ❌ (mostly) ✔
 * Constructor ❌ ✔
 * Multiple inheritance ✔ Yes ❌ No
 * Purpose What to do How to do
 * 8️⃣ One-line interview answers (memorize)
 * 
 * Q: Difference between class and interface?
 * 
 * “A class provides implementation, while an interface provides abstraction.”
 * 
 * Q: Why use interface?
 * 
 * “To achieve loose coupling and multiple implementations.”
 * 
 * 9️⃣ Final mental image (lock this in)
 * 
 * Interface = remote control
 * 
 * Class = TV
 * 
 * You press the same button, different TVs respond differently.
 */
