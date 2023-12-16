fun main() {
    val arr = DynamicArray()
    for (i in 0..5) {
        arr.append(i)
    }
    println(arr)
    println(arr.size())
}