import com.sergosoft.sentencessorter.sorter.impl.StringBuilderTextSorter;
import org.junit.Test;

public class StringBuilderTextSorterExceptionTests {

    private final StringBuilderTextSorter stringBuilderTextSorter = new StringBuilderTextSorter();

    @Test(expected = IllegalArgumentException.class)
    public void testInputTextIsNull() {
        stringBuilderTextSorter.sortByWordCount(null);
    }
}