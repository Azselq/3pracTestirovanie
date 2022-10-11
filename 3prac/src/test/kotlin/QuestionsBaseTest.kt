import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class QuestionsBaseTest
{
    @Test
    fun Question(){
        val string1 = "Давление повышенное?"
        assert(string1.equals(QuestionsBase.HIGH_PRESSURE.s));
    }
    @Test
    fun Question2(){
        val string1 = "Вы нервничали последние 3 дня?"
        assert(string1.equals(QuestionsBase.HEAD_NERVOUS.s));
    }
}