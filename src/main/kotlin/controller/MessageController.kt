package controller

class MessageController {

    fun countWords(messages: List<String>): Map<String, Int>? {
        return if (messages.isEmpty()) null else  {
            val allMessages: String = messages.joinToString(" ")
            allMessages.split(" ")
                .groupingBy { getPlainWord(it) }
                .eachCount()
        }
    }

    private fun getPlainWord(word: String): String {
        return word.toLowerCase().filter { it.isLetterOrDigit() }
    }
}