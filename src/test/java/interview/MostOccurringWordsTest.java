package interview;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(VertxUnitRunner.class)
public class MostOccurringWordsTest {

    @Test
    public void mostOccurringWordsTest(TestContext context) throws Exception{
        JsonObject mostOccurringWords = MostOccurringWords.mostOccurringWords("ball is a nice ball to play ball outside");
        context.assertTrue(mostOccurringWords.containsKey("ball"));
        context.assertEquals(mostOccurringWords.getInteger("ball"), 3);
    }

    @Test
    public void firstMostOccurringWordsTest(TestContext context) throws Exception{
        JsonObject mostOccurringWords = MostOccurringWords.mostOccurringWords("ball is a a a nice ball to play ball outside");
        context.assertTrue(mostOccurringWords.containsKey("a"));
        context.assertEquals(mostOccurringWords.getInteger("a"), 3);
    }

    @Test
    public void emptySentenceTest(TestContext context) {
        try {
            MostOccurringWords.mostOccurringWords( null);
        } catch (Exception e){
            context.assertEquals(e.getMessage(), "sentence cannot be empty");
        }
        try {
            MostOccurringWords.mostOccurringWords( "");
        } catch (Exception e){
            context.assertEquals(e.getMessage(), "sentence cannot be empty");
        }
        try {
            MostOccurringWords.mostOccurringWords( " ");
        } catch (Exception e){
            context.assertEquals(e.getMessage(), "sentence cannot be empty");
        }
    }
}