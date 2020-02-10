package structure;

/**
 * @author kaikanwu
 * @date 24/10/2018
 */
public class ListNode<T> {
    public int val;
    public ListNode<T> next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (ListNode cur = this; ; cur = cur.next) {
            if (cur == null) {
                stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
                stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
                break;
            }

            stringBuilder.append(cur.val);
            stringBuilder.append(", ");
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
