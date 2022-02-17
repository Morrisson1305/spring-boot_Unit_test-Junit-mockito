import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BackAccParameterResolver.class)
public class BankAccRepeatedTest {

    @RepeatedTest(5)
    @DisplayName("deposit 500 successfully") //
    public  void  testDepo(BankAcc bankAcc){
        bankAcc.deposit(500);
        assertEquals(500, bankAcc.getBal());
    }

    @RepeatedTest(5)
    @DisplayName("deposit 500 successfully") //
    public  void  testDepositRepetition(BankAcc bankAcc, RepetitionInfo info){
        bankAcc.deposit(500);
        assertEquals(500, bankAcc.getBal());
        System.out.println("Number of repetition " + info.getCurrentRepetition());
    }
}
