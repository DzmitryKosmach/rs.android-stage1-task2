package subtask6

class Fibonacci {

    fun productFibonacciSequenceFor(n: Int): IntArray {
        val result = intArrayOf(0,0,0)
        var temp = 1
        var fibAndNext = getFibonacci(temp)
        var currentFib = fibAndNext[0]
        var nextFib = fibAndNext[1]
        while (true) {
            if (currentFib * nextFib < n) {
                temp++
                fibAndNext = getFibonacci(temp)
                currentFib = fibAndNext[0]
                nextFib = fibAndNext[1]
            }
            if (currentFib * nextFib == n) {
                result[0] = currentFib
                result[1] = nextFib
                result[2] = 1
                break
            }
            if (currentFib * nextFib > n) {
                result[0] = currentFib
                result[1] = nextFib
                result[2] = 0
                break
            }
        }
        return result
    }

    private fun getFibonacci(n: Int): IntArray {
        var n1 = 0
        var n2 = 1
        val fibAndNext = intArrayOf(n1, n2)
        if (n == 1) return fibAndNext
        var n3 = 0
        for (i in 2..n) {
            n3 = n1 + n2
            n1 = n2
            n2 = n3
        }
        fibAndNext[0] = n3
        fibAndNext[1] = n3 + n1
        return fibAndNext
    }
}
