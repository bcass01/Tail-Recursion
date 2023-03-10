
public class ListNode <T> {

    protected T value; 
    protected ListNode next;

    /**
     * Construct a ListNode.
     *
     * @param value The first element.
     * @param rest The rest of the list.
     */
    public ListNode (T value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    /**
     * Get the first element of the list.
     *
     * @return The first element of the list.
     */
    public T getFirst() {
        return this.value;
    }

    /**
     * Get the rest of the list.
     *
     * @return The rest of the list.
     */
    public ListNode getRest() {
        return this.next;
    }

}