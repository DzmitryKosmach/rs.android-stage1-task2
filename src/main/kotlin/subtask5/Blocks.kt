package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        var resultInt = 0
        var resultString = ""
        var resultLocalDate = LocalDate.MIN

        for (block in blockA) {
            when (blockB) {
                Int::class -> {
                    if (block is Int)
                        resultInt += block
                }
                String::class -> {
                    if (block is String)
                        resultString += block
                }
                LocalDate::class -> {
                    if (block is LocalDate) {
                        if (resultLocalDate.isBefore(block)) {
                            resultLocalDate = block
                        }
                    }
                }
            }
        }
        when (blockB) {
            Int::class -> return resultInt
            String::class -> return resultString
            LocalDate::class -> return resultLocalDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
        return Any()
    }
}
