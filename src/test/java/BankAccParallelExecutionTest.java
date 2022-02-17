import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BackAccParameterResolver.class)
public class BankAccParallelExecutionTest {

    @Test
    @DisplayName("deposit was successful")
    public void testDeposit(BankAcc bankAcc){
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){e.printStackTrace();}

        bankAcc.deposit(500);
        assertEquals(500, bankAcc.getBal());

    }

    @Test
    @DisplayName("deposit 1 was successful")
    public void testDeposit1(BankAcc bankAcc){
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){e.printStackTrace();}

        bankAcc.deposit(500);
        assertEquals(500, bankAcc.getBal());

    }

    @Test
    @DisplayName("deposit 2 was successful")
    public void testDeposit2(BankAcc bankAcc){
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){e.printStackTrace();}

        bankAcc.deposit(500);
        assertEquals(500, bankAcc.getBal());

    }
}
