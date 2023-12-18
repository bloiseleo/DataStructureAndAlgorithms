package LinkedList

class DoubleLinkedList<T> {
    private var head: Node<T>? = null;
    private var tail: Node<T>? = null;
    private var length = 0;
    fun append(node: Node<T>) {
        if(head == null) {
            head = node;
            tail = node;
            length++;
            return;
        }
        tail?.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
        length++;
        return;
    }
    fun unshift(node: Node<T>) {
        if (head == null) {
            append(node);
            return;
        }
        node.next = head
        head!!.prev = node
        head = node
        length++;
        return
    }
    fun insert(node: Node<T>, position: Int): Unit {
        if (position == length) {
            append(node);
            return;
        }
        if (position == 0) {
            unshift(node);
            return;
        }
        if (position < 0) {
            throw IndexOutOfBoundsException("Index $position out of $length")
        }
        if (position > length) {
            throw IndexOutOfBoundsException("Index $position out of $length")
        }
        var transNode = head!!;
        for (i in 0..<position) {
            transNode = transNode.next!!;
        }
        node.next = transNode;
        node.prev = transNode.prev;
        node.prev?.next = node
        transNode.prev = node;
        length++;
        return;
    }
    private fun shift() {
        if (head == null) {
            return;
        }
        val newHead = head!!.next
        newHead!!.prev = null
        head = newHead
        length--;
    }
    fun remove(position: Int): Unit {
        if (position < 0 || position > length) {
            throw IndexOutOfBoundsException("Index $position out of $length")
        }
        if (position == 0) {
            shift();
            return;
        }
        if (position == length) {
            pop();
            return;
        }
        var transNode = head;
        for (i in 0..<position) {
            transNode = transNode?.next;
        }
        transNode?.next?.prev = transNode?.prev
        transNode?.prev?.next = transNode?.next
        length--;
        return;
    }
    private fun pop() {
        if (tail == null) {
            return;
        }
        val newTail = tail!!.prev;
        newTail?.next = null;
        tail = newTail;
        length--;
    }
    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("[");
        var node = head;
        if (node == null) {
            sb.append(" ]")
            return sb.toString();
        }
        while (node?.hasNext() == true) {
            sb.append(" $node ")
            node = node.next
        }
        sb.append(" $node ")
        sb.append("]")
        return sb.toString()
    }
    fun size(): Int {
        return length;
    }
}