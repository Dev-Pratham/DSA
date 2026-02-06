public class QueueJ {
    // implementing queue using array
    public static class Queue {

        int arr[];
        int capacity;
        int front;
        int rear;

        Queue(int size) {
            capacity = size;
            arr = new int[capacity];
            front = 0;
            rear = -1;
        }

        void insert(int data) {

            // check first whether queue is not full
            if (rear == capacity - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear++;
            arr[rear] = data;
            return;
        }

        void remove() {

            // check whether queue is already empty
            if (front > rear) {
                System.out.println("Queue is empty");
                return;
            }

            front = front + 1;
            return;

        }

        int peek() {
            // check whether queue is already empty
            if (front > rear) {
                System.out.println("Queue is empty");
                return -100000000;
            }

            return arr[front];

        }

        void printQueue() {

            if (front > rear) {
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

    // Insert in the queue

    public static void main(String args[]) {

        Queue q = new Queue(5);
        q.insert(1);
        q.insert(2);
        q.insert(3);

        q.printQueue();

    }
}