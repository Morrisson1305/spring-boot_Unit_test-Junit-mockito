import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BackAccParameterResolver.class)
public class BankAccDependencyInjectionTest {

    @Test
    @DisplayName("deposit 400 successfully") //
    public  void  testDepo(BankAcc bankAcc){
        bankAcc.deposit(500);
        assertEquals(500, bankAcc.getBal());
    }
}
