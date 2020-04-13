package subtask4

class Pangram {

    fun getResult(inputString: String): String {
        val vowels = setOf('a','e','i','o','u','y')
        val pangram = isPangram(inputString)
        val words = inputString.split("\\s+".toRegex())
        val wordsMap = sortedMapOf<Int, MutableList<StringBuilder>>()
        for (i in words.indices){
            val temp = StringBuilder(words[i])
            var countLetters = 0
            if (temp.isEmpty()) {
                continue
            }
            for (iTemp in temp.indices){
                if (pangram){
                    if (vowels.contains(temp[iTemp].toLowerCase())){
                        countLetters++
                        temp[iTemp] = temp[iTemp].toUpperCase()
                    }
                }else {
                    if (!vowels.contains(temp[iTemp].toLowerCase()) && temp[iTemp].isLetter()){
                        countLetters++
                        temp[iTemp] = temp[iTemp].toUpperCase()
                    }
                }
            }
            temp.insert(0, countLetters.toString())
            if (wordsMap[countLetters] == null){
                wordsMap[countLetters] = mutableListOf<StringBuilder>(temp)
            }else {
                wordsMap[countLetters]?.add(temp)
            }
        }
        val result = StringBuilder()
        var space = false
        for (wordsList in wordsMap.values){
            for (i in wordsList.indices){
                if (!space){
                    space = true
                }else {
                    result.append(" ")
                }
                result.append(wordsList[i])
            }
        }
        return result.toString()
    }

    private fun isPangram(inputString: String): Boolean {
        val countAlphabet = 26
        val letters = mutableSetOf<Char>()
        inputString.forEach { if (it.isLetter()) letters.add(it.toLowerCase()) }
        return letters.size == countAlphabet
    }
}
