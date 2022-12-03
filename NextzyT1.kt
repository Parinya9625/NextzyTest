fun fibonacci(N: Int) : IntArray {
    var num1 = 0
    var num2 = 1
    var sum: Int
    var fib = intArrayOf()

    while (num1 <= N) {
        fib += num1

        sum = num1 + num2
        num1 = num2
        num2 = sum
    }

    return fib
}

fun main() {
    println(fibonacci(0).contentToString())
    println(fibonacci(1).contentToString())
    println(fibonacci(9).contentToString())
    println(fibonacci(64).contentToString())
}