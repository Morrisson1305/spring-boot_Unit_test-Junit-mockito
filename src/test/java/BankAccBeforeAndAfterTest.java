import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccBeforeAndAfterTest {


    static BankAcc bankAcc;

    @BeforeAll
    public static void prepTest(){
        bankAcc = new  BankAcc(500,0);

    }
    @Test
    public void testWithdraw(){
        bankAcc.withdraw(300);
        assertEquals(200, bankAcc.getBal());
    }
    @Test
    public void testDeposit(){
        bankAcc.deposit(500);
        assertEquals(700, bankAcc.getBal());
    }

//    @AfterEach.. goes with static method
    @AfterAll
    public static void endTest(){
        System.out.println("bye!");
    }

}
