package meta;

import org.junit.Test;

import static org.junit.Assert.*;

public class HasNonLettersTest {
    public HasNonLetters clazz = new HasNonLetters();
    @Test
    public void test1() {
        String blacklist = "asdf";
        String phrase = "Awwe";
        System.out.println(clazz.hasNoneLetters(blacklist, phrase));
        String phrase2 = "Qwwe";
        System.out.println(clazz.hasNoneLetters(blacklist, phrase2));
    }

}