import com.sergosoft.sentencessorter.SentenceSorter;
import org.junit.Test;

public class SentenceSorterExceptionTests {

    private final SentenceSorter sentenceSorter = new SentenceSorter();

    @Test(expected = IllegalArgumentException.class)
    public void testInputTextIsNull() {
        sentenceSorter.sortByWordCount(null);
    }
}