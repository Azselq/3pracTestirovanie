import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class ClientTest{
    var client = Client()


    @Test
    fun setName() {
        client.name = "adsf"
        assertEquals("adsf", client.name)
    }
    @Test
    fun setAge() {
        client.age = 21
        assertEquals(21, client.age)
    }
    @Test
    fun setSex() {
        client.sex = "М"
        assertEquals("М", client.sex)
    }
    @Test
    fun setType() {
        client.painType = 2
        assertEquals(2, client.painType)
    }


}
