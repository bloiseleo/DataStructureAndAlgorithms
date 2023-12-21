package Queue

import java.lang.StringBuilder

class KQueue<T>() {
    class KNode<T>(val value: T) {
        var next: KNode<T>? = null
        override fun toString(): String {
            return value.toString()
        }
    }
    private var tail: KNode<T>? = null;
    private var head: KNode<T>? = null;
    private var length: Int = 0;
    fun enqueue(value: T) {
        if(tail == null) {
            tail = KNode(value)
            head = tail
            length++;
            return
        }
        val node = KNode(value)
        tail!!.next = node
        tail = node
        length++;
    }
    fun dequeue(): T {
        if (head == null || length == 0) {
            throw IndexOutOfBoundsException("Empty Queue")
        }
        val newHead = head!!.next
        val currentHead = head
        head = newHead
        length--;
        return currentHead!!.value
    }
    fun peekTop(): T? {
        return head?.value
    }
    fun peekBottom(): T? {
        return tail?.value
    }
    override fun toString(): String {
        val sb = StringBuilder()
        sb.append("[")
        var node = head
        if (node == null) {
            sb.append("]")
            return sb.toString()
        }
        while (node!!.next != null) {
            sb.append(" $node ")
            node = node.next
        }
        sb.append(" $node ]")
        return sb.toString()
    }
}