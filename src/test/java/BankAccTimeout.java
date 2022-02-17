import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BackAccParameterResolver.class)
public class BankAccTimeout {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testDepositTimeoutAssertion(BankAcc bankAcc){

        try{
            Thread.sleep(200);
        }catch (InterruptedException e){e.printStackTrace();}

        bankAcc.deposit(300);
        assertEquals(300, bankAcc.getBal());
    }

    public void testDepositTimeoutAnnotation(BankAcc bankAcc){

    }
}
