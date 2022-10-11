import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.InputStream


internal class TherapistTest {
    @Mock

    annotation class Mock

    var therapist: Therapist? = null
    @BeforeEach
    fun setUp() {
        therapist = Therapist()
        therapist!!.currentClient = Client()
    }

    @Test
    fun setClientNameTest() {
        val input = "Михаил"
        val `in`: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(`in`)
        therapist!!.setClientName()
        assertEquals("Михаил", therapist!!.currentClient.name)
    }



    @Test
    fun setClientSexTest() {
        val input = "М"
        val `in`: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(`in`)
        therapist!!.setClientSex()
        assertEquals("М", therapist!!.currentClient.sex)
    }





    @Test
    fun setClientAgeTest() {
        val input = "15"
        val `in`: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(`in`)
        therapist!!.setClientAge()
        assertEquals(15, therapist!!.currentClient.age)
    }


    @Test
    fun setClientAgeTestNoLineFound() {
        val input = "asdf"
        val `in`: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(`in`)
        assertThrows(NullPointerException::class.java) {
            therapist!!.setClientAge()
        }
    }

    @Test
    fun setClientPainTypeTest() {
        val input = "3"
        val `in`: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(`in`)
        therapist!!.setClientPainType()
        assertEquals(3, therapist!!.currentClient.painType)
    }


    @Test

    fun setClientPainTypeTestNoLineFound() {
        val input = "6"
        val `in`: InputStream = ByteArrayInputStream(input.toByteArray())
        assertThrows(
            NullPointerException::class.java
        ) { therapist!!.setClientPainType() }
    }

    @Test
    fun setClientNameTestNoLineFound() {
        val input = 123.toString()
        val `in`: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(`in`)
        assertThrows(java.lang.NullPointerException::class.java) { therapist!!.setClientName() }
    }


}