package tree

class KTree {
    private var root: KtreeNode? = null;
    private var length = 0;
    private fun hasRoot(): Boolean {
        return root != null
    }
    fun push(node: KtreeNode) {
        if (root == null) {
            root = node
            length++
            return
        }
        root!!.push(node)
        length++
        return
    }
    fun printInorder(): String {
        val sb = StringBuilder("")
        if (!hasRoot()) {
            return sb.toString();
        }
        return root!!.printInOrder(sb).toString();
    }
    fun contains(value: Int): Boolean {
        if (root == null)  {
            return false
        }
        return false;
    }
    override fun toString(): String {
        return printInorder();
    }
}