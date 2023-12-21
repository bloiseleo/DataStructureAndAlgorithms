import Queue.KQueue
import stack.KStack

fun main() {
    val queue = KQueue<Int>()
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    queue.enqueue(4)
    queue.dequeue()
    queue.dequeue()
    queue.enqueue(5)
}