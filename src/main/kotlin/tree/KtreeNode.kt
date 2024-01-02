package tree

class KtreeNode(
    private var value: Int
) {
    private var right: KtreeNode? = null
        set(value) {
            if (value == null) {
                throw RuntimeException("Null cannot be setted");
            }
            field = value;
        }
    private var left: KtreeNode? = null
        set(value) {
            if (value == null) {
                throw RuntimeException("Null cannot be setted");
            }
            field = value;
        }
    fun hasLeft(): Boolean {
        return left != null
    }
    fun hasRight(): Boolean {
        return right != null
    }
    fun setLeft(node: KtreeNode) {
        left = node
    }
    fun setRight(node: KtreeNode) {
        right = node
    }
    fun getValue(): Int {
        return value;
    }
}