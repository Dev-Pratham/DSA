
public class QueueJ2 {
    // circular queue implementation using array

    static class CircularQueue {
        int arr[];
        int capacity;
        int front;
        int rear;

        CircularQueue(int size) {
            arr = new int[size];
            capacity = size;
            front = -1;
            rear = -1;
        }

        boolean isEmpty() {
            return (front == -1 && rear == -1);
        }

        boolean isFull() {
            // +1 because rear starts with 0 index so
            return (rear + 1) % capacity == front;
        }

        void add(int data) {
            if (isFull()) {
                System.out.print("Queue is full");
                return;
            }
            // add first element
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % capacity;
            arr[rear] = data;
            return;
        }

        int remove() {
            if (isFull()) {
                System.out.print("Queue is full");
                return -1;
            }
            int removed = arr[front];
            // edge case one one element exists in queue
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % capacity;
            }
            return removed;
        }

        int peek() {
            if (isEmpty()) {
                System.out.print("Circular queue is empty");
                return -1;
            }

            return arr[front];
        }

        void printQueue() {

            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            for (int i = front; i <= rear; i++) {
                System.out.print(arr[i]);
                if (i != rear) {
                    System.out.print(" <- ");
                } else {
                    System.out.print(":");
                }
            }
        }
    }

    public static void main(String args[]) {

        CircularQueue q = new CircularQueue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        q.printQueue();

        System.out.println("0" + "1");
    }
}
