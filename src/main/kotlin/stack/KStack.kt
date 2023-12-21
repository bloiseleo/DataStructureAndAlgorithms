package stack

import java.lang.StringBuilder

class KStack<T> {
    class KStackNode<T>(val value: T) {
        var next: KStackNode<T>? = null
    }
    private var head: KStackNode<T>? = null
    private var length = 0;
    fun push(value: T): Unit {
        if(head == null) {
            head = KStackNode(value);
            length++
            return
        }
        val newHead = KStackNode(value)
        newHead.next = head
        head = newHead
        length++
        return
    }
    fun pop(): T {
        if (length == 0 || head == null) {
            throw Exception("Stack is empty")
        }
        val oldHead = head!!
        val newHead = head!!.next
        head = newHead
        oldHead.next = null
        length--;
        return oldHead.value
    }
    fun peek(): T? {
        if (length == 0 || head == null) {
            return null
        }
        return head!!.value
    }
    fun size(): Int {
        return length
    }
    override fun toString(): String {
        val sb = StringBuilder()
        var node = head
        sb.append(" [ ")
        if(node == null) {
            sb.append(" ] ")
            return sb.toString()
        }
        while (node!!.next != null) {
            sb.append(" ${node.value} ")
            node = node.next
        }
        sb.append(" ${node.value} ")
        sb.append("] ")
        return sb.toString()
    }
}