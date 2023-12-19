package stack

import java.util.Stack

fun validBracketsClosing(brackets: String): Boolean {
    val symbols = HashMap<String, String>();
    val tracker = Stack<String>();
    symbols.put("]", "[");
    symbols.put("}", "{");
    symbols.put(")", "(");

    for (i in 0..<brackets.length) {
        val character = brackets.get(i);
        if (symbols.containsValue(character.toString())) {
            tracker.push(character.toString());
            continue
        }
        if(tracker.isEmpty()) {
            return false
        }
        val expectedBracket = symbols.get(character.toString());
        if (expectedBracket != tracker.peek()) {
            return false
        }
        tracker.pop()
    }
    if (!tracker.isEmpty()) {
        return false
    }

    return true;
}

fun main() {

    var brackets = "[[]]"
    val validFirstPair = validBracketsClosing(brackets);
    println("$brackets sequence is valid? $validFirstPair")
    brackets = "{{}{}}"
    val secondPir = validBracketsClosing(brackets)
    println("$brackets sequence is valid? $secondPir")
    brackets = "[{({}{})}]"
    val thridPair = validBracketsClosing(brackets)
    println("$brackets sequence is valid? $thridPair")
}
