import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import util.orderDescendingByValue

class ExtensionsTest {

    @Test
    fun `When give a map of Int values and order descending, Expect success`() {

        val map = mapOf("First" to 1, "Third" to 3, "Fifth" to 5, "Second" to 2, "Fourth" to 4)
        val result = map.orderDescendingByValue()

        val expected = mapOf("Fifth" to 5, "Fourth" to 4, "Third" to 3, "Second" to 2, "First" to 1)

        assertThat(result.toList(), equalTo(expected.toList()))
    }

    @Test
    fun `When give a map with duplicated values and order descending, Expect success`() {

        val map = mapOf("First" to 1, "Third" to 3, "Fifth" to 5, "Second" to 1, "Fourth" to 2)
        val result = map.orderDescendingByValue()

        val expected = mapOf("Fifth" to 5, "Third" to 3, "Fourth" to 2, "First" to 1, "Second" to 1)

        assertThat(result.toList(), equalTo(expected.toList()))
    }

    @Test
    fun `When give an empty map and order descending, Expect empty map as result`() {

        val map = emptyMap<String, Int>()
        val result = map.orderDescendingByValue()

        val expected = emptyMap<String, Int>()

        assertThat(result.toList(), equalTo(expected.toList()))
    }
}