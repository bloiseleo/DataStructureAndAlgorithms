package tree

class KTree {
    private var root: KtreeNode? = null;
    private var length = 0;
    fun push(node: KtreeNode) {
        if (root == null) {
            root = node;
            length++;
            return;
        }
    }
}