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
     *
     * A problem here: with a serious of enqueue and dequeue, the index of head and tail will move the last place of the queue,
     * at that time, this queue cannot add new items, even the queue is empty.
     *
     * @param item the new element
     * @return true or false
     */
    public boolean enqueue1(String item) {
        if (tail == n) {
            return false;
        }
        items[tail] = item;
        tail++;
        return true;
    }


    /**
     * Try to solve the problem of enqueue1:
     * copy the array, let it  start from the first place of an arry
     */
    public boolean enqueue2(String item) {
        if (tail == n) {
            if (head == 0) {
                return false;
            }
          // manual copy the array
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            // reassign the index
            tail -= head;
            head = 0;

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
