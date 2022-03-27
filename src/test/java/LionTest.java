import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittens = feline.getKittens();
        int actualKittens = lion.getKittens();
        assertEquals("Should have 1 kitten", expectedKittens, actualKittens);
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        List<String> mockFoodList = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(lion.getFood()).thenReturn(mockFoodList);
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualFood = lion.getFood();
        assertEquals("Should eat 'Животные, Птицы, Рыба'", expectedFood, actualFood);
    }

    @Test
    public void doesHaveManeEmptyExceptionTest() throws Exception {
        Lion lion = new Lion(" ", feline);
        try {
            lion.doesHaveMane();
        } catch (Exception exception) {
            System.out.println("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    @Test
    public void doesHaveManeWrongTextExceptionTest() throws Exception {
        Lion lion = new Lion("львенок", feline);
        try {
            lion.doesHaveMane();
        } catch (Exception exception) {
            System.out.println("Используйте допустимые значения пола животного - самец или самка");
        }
    }

    @Test
    public void doesHaveManeNumbersExceptionTest() throws Exception {
        Lion lion = new Lion("1234", feline);
        try {
            lion.doesHaveMane();
        } catch (Exception exception) {
            System.out.println("Используйте допустимые значения пола животного - самец или самка");
        }
    }
}
