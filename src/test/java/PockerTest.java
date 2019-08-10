import com.thoughtworks.tdd.Pocker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class PockerTest {
    @Test
    public void should_return_5a_when_call_compareLarger_given_3a_and_5a(){
        String s1="3a";
        String s2="5a";
        Pocker pocker = new Pocker(s1,s2);
        String largerResult = pocker.compareLager(s1,s2);
        assertSame(largerResult,s2);
    }
}
