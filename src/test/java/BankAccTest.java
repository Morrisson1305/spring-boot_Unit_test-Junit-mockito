import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumingThat;

@DisplayName("Test for bank account class")
public class BankAccTest {

    @Test
    @DisplayName("withdraw 500 successfully")
    public void testWithdraw(){
        BankAcc bankAcc = new BankAcc(500, -1000);
        bankAcc.withdraw(300);
        assertEquals(200, bankAcc.getBal());
    }
    @Test
    @DisplayName("deposit 400 successfully") //
    public  void  testDepo(){
        BankAcc bankAcc = new BankAcc(400, 0);
        bankAcc.deposit(500);
        assertEquals(900, bankAcc.getBal());
    }

    @Test
    @DisplayName("withdraw  will become negative")
    public  void testWithdrawNotStuckATZero(){
        BankAcc bankAcc = new BankAcc(500, -1000);
        bankAcc.withdraw(800);
        assertNotEquals(0, bankAcc.getBal());
    }

    @Test
    @DisplayName("Test activation")
    public void testActive(){
        BankAcc bankAcc = new BankAcc(500, 0);
        assertTrue(bankAcc.isActive());
    }

    @Test
    @DisplayName("Test to set holder name")
    public void testHolderName(){
        BankAcc bankAcc = new BankAcc(500, 0);
        bankAcc.setHoldName("Morris");
        assertNotNull(bankAcc.getHoldName());
    }

    @Test
    @DisplayName("Test that we can't withdraw below minimum")
    public void testNoWithdrawerBelowMinimum(){
        BankAcc bankAcc = new BankAcc(500, -1000);
        assertThrows(RuntimeException.class,()-> bankAcc.withdraw(2000));
    }

    @Test
    @DisplayName("Test no exceptions for withdraw and deposit")
    public void  testWithdrawAndDepositWithoutExceptions(){
        BankAcc bankAcc = new BankAcc(500, -1000);
        assertAll(()-> bankAcc.deposit(200), ()-> bankAcc.withdraw(450));
    }

    @Test
    @DisplayName("test for timeout")
    public  void testDepositTimeout(){
        BankAcc bankAcc = new BankAcc(400, 0);
        assertTimeout(Duration.ofNanos(10), ()-> bankAcc.deposit(200));
    }

//    Assumption testing

//    @Test
//    @DisplayName("Test activation")
//    public void testisActive(){
//        BankAcc bankAcc = new BankAcc(500, 0);
//        assumeFalse(bankAcc == null);
//        assertTrue(bankAcc.isActive());
//    }

    @Test
    @DisplayName("Test activation 2")
    public void testisActive(){
        BankAcc bankAcc = new BankAcc(500, 0);
        assumingThat(bankAcc == null,()->assertTrue(bankAcc.isActive()));

    }

}
