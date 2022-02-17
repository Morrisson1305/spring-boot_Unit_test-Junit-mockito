import  static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class testTest {
    @Test
    public void test(){
        Code code =new Code();
        assertEquals("Hello world", code.sayHello());
    }
}
