package tree

import java.util.Stack

class KTree {
    private var root: KtreeNode? = null
    private var length = 0
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
    fun printInorderRecursive(): String {
        val sb = StringBuilder("")
        if (!hasRoot()) {
            return sb.toString()
        }
        return root!!.printInOrder(sb).toString()
    }
    fun printInOrderWithouRecursion(): String {
        val sb = StringBuilder("");
        if(!hasRoot()) {
            return sb.toString();
        }
        val s = Stack<KtreeNode>();
        var curr = root;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop()
            sb.append(" $curr ");
            curr = curr.right
        }
        return sb.toString();
    }
    fun contains(value: Int): Boolean {
        if (root == null)  {
            return false
        }
        val s = Stack<KtreeNode>()
        var curr = root
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop()
            if (curr.getValue() == value) {
                return true;
            }
            curr = curr.right
        }
        return false;
    }
    override fun toString(): String {
        return printInOrderWithouRecursion();
    }
}