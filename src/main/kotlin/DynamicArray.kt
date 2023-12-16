class DynamicArray {
    private var length: Int = 0;
    private var array: IntArray = IntArray(5);
    private var capacity: Int = 5;
    fun get(n: Int): Int {
        if (n < 0 || n >= length) {
            throw IndexOutOfBoundsException("Index $n out of $length");
        }
        return array[n]
    }
    private fun guaranteeCapacity() {
        if (length < array.size) {
            return;
        }
        val newArray = IntArray(length * 2)
        for (i in 0..<length) {
            newArray[i] = array[i];
        }
        array = newArray;
        capacity = newArray.size;
    }
    fun append(n: Int) {
        guaranteeCapacity();
        array[length] = n;
        length++;
    }
    fun insert(n: Int, position: Int): Unit {
        guaranteeCapacity();
        if (position >= capacity) {
            throw IndexOutOfBoundsException("Index $position out of $capacity");
        }
        for (i in (length - 1) downTo position) {
            array[i + 1] = array[i]
        }
        array[position] = n;
        length++;
    }
    fun delete(position: Int): Unit {
        if (position < 0 || position >= length) {
            throw IndexOutOfBoundsException("Index $position out of $length");
        }
        for (i in position..<(length - 1)) {
            array[i] = array[i + 1];
        }
        array[length - 1] = 0;
        length--;
    }
    fun size(): Int {
        return length;
    }
    override fun toString(): String {
        val text = StringBuilder("[")
        for (i in array) {
            text.append(" $i ");
        }
        text.append("]")
        return text.toString()
    }
}