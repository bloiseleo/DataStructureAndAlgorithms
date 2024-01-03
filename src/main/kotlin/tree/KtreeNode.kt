package tree

class KtreeNode(
    private var value: Int
) {
    var root: KtreeNode? = null
    var right: KtreeNode? = null
    var left: KtreeNode? = null
    fun hasLeft(): Boolean {
        return left != null
    }
    fun hasRight(): Boolean {
        return right != null
    }
    fun getValue(): Int {
        return value;
    }
    fun push(node: KtreeNode) {
        if (node.getValue() > value) {
            if(hasRight()) {
                this.right!!.push(node);
                return
            }
            node.root = this
            this.right = node;
            return
        }
        if (hasLeft()) {
            left!!.push(node)
            return
        }
        node.root = this
        left = node
        return
    }
    fun printInOrder(sb: StringBuilder): String {
        val nodeSB = StringBuilder()
        if (hasLeft()) {
            nodeSB.append(this.left!!.printInOrder(sb));
        }
        nodeSB.append(" $this ");
        if(hasRight()) {
            nodeSB.append(right!!.printInOrder(sb))
        }
        return nodeSB.toString();
    }
    override fun toString(): String {
        return value.toString()
    }
}