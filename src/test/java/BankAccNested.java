import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccNested {

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

    @Nested
    class  whenBalEqualsZero{
        @Test
        @DisplayName("withdrawing below minimum balance: exception")
        public void testWithdrawMinimumBalIs0(){
            BankAcc bankAcc = new BankAcc(0,0);
            assertThrows(RuntimeException.class, ()-> bankAcc.withdraw(500));
        }

        @Test
        @DisplayName("withdrawing and getting negative balance ")
        public void testWithdrawBalNegative1000(){
            BankAcc bankAcc = new BankAcc(0, -1000);
            bankAcc.withdraw(500);
            assertEquals(-500, bankAcc.getBal());
        }
    }
}
