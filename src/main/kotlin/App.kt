import controller.MessageController
import util.orderDescendingByValue

fun main() {
    val controller = MessageController()

    val input = listOf("I love summer.", "My family loves to hike in the summer.")
    val frequency = controller.countWords(input)
    val frequencyOrdered = frequency?.orderDescendingByValue()

    print(frequencyOrdered?.toList())
}