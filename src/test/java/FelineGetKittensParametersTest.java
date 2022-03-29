import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class FelineGetKittensParametersTest {

    private final int kittensCount;
    private final int expectedCount;

    public FelineGetKittensParametersTest(int kittensCount, int expectedCount) {
        this.kittensCount = kittensCount;
        this.expectedCount = expectedCount;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} = {1}")
    public static Object[][] getKittens() {
        return new Object[][] {
            {1, 1},
            {0, 1},
            {-1, 1},
            {2, 1}
        };
    }

    @Test
    public void numberKittensTest() {
        Feline feline = new Feline();
        int actualCount = feline.getKittens(kittensCount);
        assertEquals(expectedCount, actualCount);
    }
}
