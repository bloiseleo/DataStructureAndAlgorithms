fun main() {
    val arr = DynamicArray()
    for (i in 0..9) {
        arr.append(i)
    }
    arr.delete(2)
    arr.append(10)
    arr.delete(0)
    arr.append(11)
    println(arr)
    println(arr.size())
    println(arr.get(2));
    println(arr.get(3));
}