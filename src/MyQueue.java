public class MyQueue {
    private int size;
    private long queueArray[];
    private int head;
    private int tail;
    private int nItems;

    MyQueue(int size) {
        this.size = size;
        this.queueArray = new long[size];
        this.head = 0;
        this.tail = -1;
        this.nItems = 0;
    }

    public void push(long element) {

        if (tail == head - 1 && nItems > 1) {
            System.out.println("Очередь нельзя дальше заполнять: вытащите элемент или ничего не делайте");
        } else {
            if (tail == size - 1 && head != 0) {
                tail = -1;
            }
            queueArray[++tail] = element;
            nItems++;
        }
    }

    public long pop() {
        long tmp = queueArray[head];
        queueArray[head++] = 0;
        return tmp;
    }

    public void displayAll() {
        System.out.println("All elements:");
        for (int i = 0; i < size; i++) {
            System.out.print(" |" + queueArray[i] + "| ");
        }
        System.out.println();
    }

    public void displayQueue() {
        System.out.println("Queue: <-");

        if (tail < head) {
            for (int i = head; i < size; i++) {
                System.out.print(" |" + queueArray[i] + "| ");
            }
            for (int i = 0; i <= tail; i++) {
                System.out.print(" |" + queueArray[i] + "| ");
            }
            System.out.println();
        } else {
            for (int i = head; i < getSize(); i++) {
                System.out.print(" |" + queueArray[i] + "| ");
            }
            System.out.println();
        }
    }

    public int getSize() {
//        if (head > tail) {
//            return size - head + tail;
//        } else
        return nItems;
    }

    public boolean isEmpty() {
        if (head == tail) {
            System.out.println("Очередь пустая:");
            return true;
        } else {
            System.out.println("Очередь непустая:");
            return false;
        }
    }
}

class Main {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(10);
        myQueue.push(1);
        myQueue.push(23);
        myQueue.push(-5);
        myQueue.push(34);
        myQueue.displayAll();
        myQueue.displayQueue();
        myQueue.pop();
        myQueue.displayAll();
        myQueue.displayQueue();
        myQueue.pop();
        myQueue.displayAll();
        myQueue.displayQueue();
        myQueue.push(2);
        myQueue.push(24);
        myQueue.push(-6);
        myQueue.push(35);
        myQueue.push(-7);
        myQueue.push(36);

        myQueue.push(1);
        myQueue.push(2);
        myQueue.displayAll();
        myQueue.displayQueue();


        myQueue.push(3);
        myQueue.push(4);

        myQueue.displayAll();
        myQueue.displayQueue();
        myQueue.isEmpty();
    }
}
