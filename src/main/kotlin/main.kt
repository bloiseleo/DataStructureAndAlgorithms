import Queue.KQueue
import org.w3c.dom.Node
import stack.KStack
import tree.KTree
import tree.KtreeNode

fun main() {
    val tree = KTree()
    tree.push(KtreeNode(12))
    tree.push(KtreeNode(13))
    tree.push(KtreeNode(10))
    tree.push(KtreeNode(11))
    tree.push(KtreeNode(9))
    tree.push(KtreeNode(13))
    tree.push(KtreeNode(14))
    println(tree)
}