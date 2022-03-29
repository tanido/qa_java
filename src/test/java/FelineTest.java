import com.example.Animal;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    private Animal animal;

    Feline feline = new Feline();

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        assertEquals("Should eat 'Животные, Птицы, Рыба'", expectedFood, actualFood);
    }

    @Test
    public void eatMeatExceptionTest() {
        try {
            Mockito.when(feline.eatMeat()).thenReturn(animal.getFood("Птица"));
            feline.eatMeat();
        } catch (Exception exception) {
            System.out.println("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        }
    }

    @Test
    public void getFamilyTest() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals("Should be 'Кошачьи'", expectedFamily, actualFamily);
    }

    @Test
    public void getKittensTest() {
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        assertEquals("Should have 1 kitten", expectedKittens, actualKittens);
    }
}
