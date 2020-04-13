package subtask1

import java.text.SimpleDateFormat
import java.util.*

class DateFormatter {

    fun toTextDay(day: String, month: String, year: String): String {
        val c = Calendar.getInstance()
        c.isLenient = false
        return try {
            c.set(year.toInt(), month.toInt()-1, day.toInt())
            val formatter = SimpleDateFormat("dd MMMM, EEEE", Locale("ru"))
            formatter.format(c.time)
        }catch (e: Exception){
            "Такого дня не существует"
        }
    }
}
