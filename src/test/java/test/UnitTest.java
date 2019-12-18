package test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class UnitTest {
    public int intAdd(int a, int b) {
        return a + b;
    }

    public int intSubtract(int a, int b) {
        return a - b;
    }

    public long intMultiply(int a, int b) {
        return a * b;
    }

    @Test
    public void testAddInt() {
        int a = new Random().nextInt(1000);
        int b = new Random().nextInt(2000);
        int c = a + b;
        int r = intAdd(a, b);
        Assert.assertEquals("检查intAdd(a, b)函数返回值是否正确", c, r);
    }

    @Test
    public void testSubstractInt(){
        int a = new Random().nextInt(1000);
        int b = new Random().nextInt(2000);
        int c = a - b;
        int r = intSubtract(a, b);
        Assert.assertEquals("检查intSunstract(a, b)函数返回值是否正确", c, r);
    }

    @Test
    public void testMultiplyInt(){
        int a = new Random().nextInt(1000);
        int b = new Random().nextInt(2000);
        long c = a * b;
        long r = intMultiply(a, b);
        Assert.assertEquals("检查intMultiply(a, b)函数返回值是否正确", c, r);
    }


}
