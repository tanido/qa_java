import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionDoesHaveManeParametersTest {

    @Mock
    private Feline feline;

    private final String sex;
    private final boolean expectedResult;


    public LionDoesHaveManeParametersTest(String sex, boolean expectedResult) {
        this.sex = sex;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} has mane {1}")
    public static Object[][] getLionSex() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"Самка", true}
        };
    }

    @Test
    public void lionHasMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actualResult = lion.doesHaveMane();
        assertEquals("Male lion should have mane", expectedResult, actualResult);
    }
}
