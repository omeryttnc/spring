package spring.selenium.demo.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class TestFunction  {
    Deneme d = (a,b) -> (a+b);



    //@Test
    public void test1() {
        System.out.println(d.topla(3, 5));

    }
    //@Test
    public void test2() {

        Function<Integer, String> converter = num -> Integer.toString(num);
        System.out.println("length of 17423426: " + converter.apply(17423426).length());
        Function<Integer, Integer> square = num -> num * num;
        System.out.println(square.apply(3));
        Function<Integer, Boolean> isEven = num -> num % 2 == 0;
        System.out.println(isEven.apply(3));
        System.out.println(isEven.apply(4));
        BiFunction<Integer, Integer, Double> doubleConstructor = (num1, num2) -> new Double(num1 + "." + num2);
        System.out.println("Constructing a double using 3 and 1415: " + doubleConstructor.apply(3, 1415));
        System.out.println("Constructing a double using 0 and 26: " + doubleConstructor.apply(0, 26));

        Predicate<Integer>predicateCheckIfPositive = x -> x>=0;
        System.out.println(predicateCheckIfPositive.test(15));

        Assert.assertTrue(predicateCheckIfPositive.test(15));

    }


}
