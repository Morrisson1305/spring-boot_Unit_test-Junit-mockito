import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedExecutionTest {

    static BankAcc bankAcc = new  BankAcc(0,0);

    @Test
    @Order(2)
    public void testWithdraw(){
        bankAcc.withdraw(300);
        assertEquals(200, bankAcc.getBal());
    }
    @Test
    @Order(1)
    public void testDeposit(){
        bankAcc.deposit(500);
        assertEquals(500, bankAcc.getBal());
    }

}
