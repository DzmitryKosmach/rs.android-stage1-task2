package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        var indexA = 0
        for (charB in b) {
            while (a[indexA].toUpperCase() != charB) {
                if (a.length != indexA.inc()) {
                    indexA++
                } else {
                    return "NO"
                }
            }
        }
        return "YES"
    }
}
