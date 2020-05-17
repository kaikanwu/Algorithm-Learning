package structure;

/**
 * Queue
 * FIFO
 * LILO
 * (implement by an array)
 *
 * @author kaikanwu
 * created on 5/17/2020
 */
public class ArrayQueue {

    // array's capacity: n
    private String[] items;
    private int n = 0;

    // the current index of head and tail
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }


    /**
     * add a new item
     * @param item the new element
     * @return true or false
     */
    public boolean enqueue(String item) {
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        tail++;
        return true;
    }

    /**
     * pop an element
     * @return the first element of the queue
     */
    public String dequeue() {
        if (head == tail) {
            return null;
        }

        String ret = items[head];
        head++;
        return ret;
    }

}
