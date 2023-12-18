package LinkedList

class Node<T>(private val value: T) {
    var prev: Node<T>? = null;
    var next: Node<T>? = null;
    fun hasNext(): Boolean {
        return this.next != null;
    }
    fun hasPrevious(): Boolean {
        return this.prev != null;
    }
    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false;
        }
        if (other !is Node<*>) {
            return false;
        }
        if (this.value == null) {
            return other.value == null;
        }
        return this.value.equals(other.value);
    }

    override fun toString(): String {
        return value.toString()
    }
}