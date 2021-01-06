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

    // положить элемент (по очереди) FIFO
    public void push(long element) {

        if (tail == head - 1 && nItems > 0 || head == 0 && tail == size - 1 && nItems > 0) { //tail == size - 1 && nItems > 1
            System.out.println("Очередь нельзя дальше заполнять: вытащите элемент или ничего не делайте");
        } else {
            if (tail == size - 1 && head != 0) {
                tail = -1;
            }
            queueArray[++tail] = element;
            nItems++;
        }
    }

    // вытащить (1-й элемент) FIFO
    public long pop() {
        long tmp = 0;
        if (tail == head - 1 && nItems == 0) {
            System.out.println("Нельзя больше вытаскивать элементы: запушите элемент или ничего не делайте");
        }
        else {
            if (head == size) {
                head = 0;
            }
            tmp = queueArray[head];
            queueArray[head++] = 0;
            nItems--;
        }
        return tmp;
    }

    // Показать все элементы
    public void displayAll() {
        System.out.println("All elements:");
        for (int i = 0; i < size; i++) {
            System.out.print(" |" + queueArray[i] + "| ");
        }
        System.out.println();
    }

    // Показать очередь
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
            if (head == 0) {
                for (int i = head; i < getSize(); i++) {
                    System.out.print(" |" + queueArray[i] + "| ");
                }
                System.out.println();
            } else {
                for (int i = head; i <= getSize(); i++) {
                    System.out.print(" |" + queueArray[i] + "| ");
                }
                System.out.println();
            }
        }
    }

    public int getSize() {
//        if (head > tail) {
//            return size - head + tail;
//        } else
        return nItems;
    }

    // Проверяем пустая ли очередь
    public boolean isEmpty() {
        if (nItems == 0) {
            System.out.println("Очередь пустая");
            return true;
        } else {
            System.out.println("Очередь непустая");
            return false;
        }
    }
}

class Main {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(10);

        myQueue.displayAll();
        myQueue.isEmpty();
        myQueue.push(23); // добавить
        myQueue.push(10);
        myQueue.push(11);
        myQueue.push(12);
        myQueue.displayAll(); // показать всё
        myQueue.displayQueue(); // показать только очередь
        myQueue.pop();
        myQueue.pop();
        myQueue.displayAll();
        myQueue.pop();
        myQueue.push(55);
        myQueue.push(666);
        myQueue.displayAll();
        myQueue.isEmpty();
        myQueue.pop();
        myQueue.pop();
        myQueue.displayAll();
        myQueue.isEmpty();
        myQueue.pop();
    }
}
