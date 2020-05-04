import controller.MessageController
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MessageControllerTest {

    @Test
    fun `When give a list of messages containing punctuation, Expect a map the count of each word in all messages ignoring case and punctuation`() {
        val controller = MessageController()
        val messages = listOf("I love summer.", "My family loves to hike in the summer.", "Should I love to hike too?")

        val result = controller.countWords(messages)
        val expected = mapOf(
            "i" to 2,
            "love" to 2,
            "summer" to 2,
            "my" to 1,
            "family" to 1,
            "loves" to 1,
            "to" to 2,
            "hike" to 2,
            "in" to 1,
            "the" to 1,
            "should" to 1,
            "too" to 1
        )

        assertThat(result, notNullValue())
        assertThat(result, equalTo(expected))
    }

    @Test
    fun `When give a list of messages containing numbers, Expect a map the count of each word in all messages`() {
        val controller = MessageController()
        val messages = listOf("I love summer.", "My family loves to hike in the summer when is above 18 degrees.", "I think 18 degrees is too hot")

        val result = controller.countWords(messages)
        val expected = mapOf(
            "i" to 2,
            "love" to 1,
            "summer" to 2,
            "my" to 1,
            "family" to 1,
            "loves" to 1,
            "to" to 1,
            "hike" to 1,
            "in" to 1,
            "the" to 1,
            "when" to 1,
            "is" to 2,
            "above" to 1,
            "18" to 2,
            "degrees" to 2,
            "think" to 1,
            "too" to 1,
            "hot" to 1
        )

        assertThat(result, notNullValue())
        assertThat(result, equalTo(expected))
    }

    @Test
    fun `When give an empty list of messages, Expect an empty map as result`() {
        val controller = MessageController()
        val messages = emptyList<String>()

        val result = controller.countWords(messages)

        assertThat(result, nullValue())
    }
}