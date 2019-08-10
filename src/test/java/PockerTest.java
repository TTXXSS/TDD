import com.thoughtworks.tdd.Pocker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class PockerTest {
    @Test
    public void should_return_5a_when_call_compareLarger_given_3a_and_5a(){
        String s1="3a";
        String s2="5a";
        Pocker pocker = new Pocker(s1,s2);
        String largerResult = pocker.compareLager(pocker.getPocker1(),pocker.getPocker2());
        assertSame(largerResult,s2);
    }
    @Test
    public void should_return_2c_3h_4s_8c_ah_when_call_compareLarger_given_2h_3d_5s_9c_kd_and_2c_3h_4s_8c_ah(){
        String s1="2h 3d 5s 9c kd";
        String s2="2c 3h 4s 8c ah";
        Pocker pocker = new Pocker(s1,s2);
        String largerResult = pocker.compareLager(pocker.getPocker1(),pocker.getPocker2());
        assertSame(largerResult,s2);
    }
    @Test
    public void should_return_2c_3h_4s_8c_ah_when_call_compareLarger_given_2h_3d_5s_9c_kd_and_2c_3h_4s_8c_kh(){
        String s1="2h 3d 5s 9c kd";
        String s2="2c 3h 4s 8c kh";
        Pocker pocker = new Pocker(s1,s2);
        String largerResult = pocker.compareLager(pocker.getPocker1(),pocker.getPocker2());
        assertSame(largerResult,s1);
    }

    @Test
    public void should_return_2h_2d_5s_9c_kd_when_call_compareLarger_given_2h_2d_5s_9c_kd_and_2c_3h_4s_8c_ah() {
        String s1 = "2h 2d 5s 9c kd";
        String s2 = "2c 3h 4s 8c ah";
        Pocker pocker = new Pocker(s1,s2);
        String largerResult = pocker.compareLager(pocker.getPocker1(),pocker.getPocker2());
        assertSame(largerResult,s1);

    }
    @Test
    public void should_return_2h_2d_2s_9c_kd_when_call_compareLarger_given_2h_2d_2s_9c_kd_and_2c_2d_5s_9c_kd() {
        String s1 = "2h 2d 2s 9c kd";
        String s2 = "2c 2d 5s 9c kd";
        Pocker pocker = new Pocker(s1,s2);
        String largerResult = pocker.compareLager(pocker.getPocker1(),pocker.getPocker2());
        assertSame(largerResult,s1);
    }
    @Test
    public void should_return_3h_4d_5s_6c_7d_when_call_compareLarger_given_3h_4d_5s_6c_7d_and_2h_2d_2s_9c_kd() {
        String s1 = "3h 4d 5s 6c 7d";
        String s2 = "2h 2d 2s 9c kd";
        Pocker pocker = new Pocker(s1,s2);
        String largerResult = pocker.compareLager(pocker.getPocker1(),pocker.getPocker2());
        assertSame(largerResult,s1);
    }
    @Test
    public void should_return_3h_4d_5s_6c_7d_when_call_compareLarger_given_3h_4d_5s_6c_7d_and_2h_2d_2s_9c_9d() {
        String s1 = "3h 4d 5s 6c 7d";
        String s2 = "2h 2d 2s 9c 9d";
        Pocker pocker = new Pocker(s1,s2);
        String largerResult = pocker.compareLager(pocker.getPocker1(),pocker.getPocker2());
        assertSame(largerResult,s2);
    }
    @Test
    public void should_return_2h_2d_2s_2c_3d_when_call_compareLarger_given_2h_2d_2s_2c_3d_and_2h_2d_2s_3c_3d() {
        String s1 = "2h 2d 2s 2c 3d";
        String s2 = "2h 2d 2s 3c 3d";
        Pocker pocker = new Pocker(s1,s2);
        String largerResult = pocker.compareLager(pocker.getPocker1(),pocker.getPocker2());
        assertSame(largerResult,s1);
    }




}
