package subtask2

class TimeConverter {

    fun toTextFormat(hour: String, minute: String): String {
        val thirstyInt = 30
        val sixtyInt = 60
        val elevenInt = 11
        val twenty = 20
        val half = "half"
        var result = ""
        val numbers = arrayOf(
            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "quarter",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen",
            "twenty"
        )
        val hourInt = hour.toInt()
        var minuteInt = minute.toInt()
        if (hourInt > elevenInt || minuteInt > sixtyInt) {
            return result
        }
        var zeroOrOne = 0
        val pastOrTo = if ((minuteInt - thirstyInt) > 0) {
            minuteInt = sixtyInt - minuteInt
            zeroOrOne = 1
            "to"
        } else {
            "past"
        }
        when (minuteInt) {
            0 -> {
                result = "${numbers[hourInt]} o' clock"
            }
            1 -> {
                result = "one minute $pastOrTo ${numbers[hourInt + zeroOrOne]}"
            }
            in 2..14, in 16..20 -> {
                result = "${numbers[minuteInt]} minutes $pastOrTo ${numbers[hourInt + zeroOrOne]}"
            }
            15 -> {
                result = "${numbers[minuteInt]} $pastOrTo ${numbers[hourInt + zeroOrOne]}"
            }
            in 21..29 -> {
                result =
                    "${numbers[twenty]} ${numbers[minuteInt - twenty]} minutes $pastOrTo ${numbers[hourInt + zeroOrOne]}"
            }
            30 -> {
                result = "$half past ${numbers[hourInt + zeroOrOne]}"
            }
        }
        return result
    }
}
