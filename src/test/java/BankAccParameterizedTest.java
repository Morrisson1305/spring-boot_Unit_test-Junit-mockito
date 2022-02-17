import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(BackAccParameterResolver.class)
public class BankAccParameterizedTest {
    @ParameterizedTest
    @ValueSource(ints = {100, 400, 800, 1000})
    @DisplayName("deposit successfully") //
    public  void  testDepo(int amount, BankAcc bankAcc){
        bankAcc.deposit(amount);
        assertEquals(amount, bankAcc.getBal());
    }

    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names ={"TUESDAY", "THURSDAY"})
    public void testDayOfWeek(DayOfWeek day){
       assertTrue(day.toString().startsWith("T"));
    }

    @ParameterizedTest
    @CsvSource({"100, Mary", "200, Morris", "600, Ian"})
    public void depositNameTest(double amount, String name, BankAcc bankAcc){

        bankAcc.deposit(amount);
        bankAcc.setHoldName(name);
        assertEquals(amount, bankAcc.getBal());
        assertEquals(name, bankAcc.getHoldName());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "detail.csv")
    public void depositNameTestCsv(double amount, String name, BankAcc bankAcc){
        bankAcc.deposit(amount);
        bankAcc.setHoldName(name);
        assertEquals(amount, bankAcc.getBal());
        assertEquals(name, bankAcc.getHoldName());
    }

}
