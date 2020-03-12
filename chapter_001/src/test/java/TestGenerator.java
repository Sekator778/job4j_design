import ood.tdd.GeneratorString;
import ood.tdd.Template;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestGenerator {
    Template template = new GeneratorString();

    @Test
    public void whenHaveOneKey() {
        String string = "I love ${subject}";
        Map<String, String> map = new HashMap<>() {
            {
                put("subject", "Java");
            }
        };
        String result = template.generate(string, map);
        assertThat(result, is("I love Java"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotHaveKeyThrowException() {
        String string = "I love ${key}";
        Map<String, String> map = new HashMap<>() {
            {
                put(null, "Java");
            }
        };
        String result = template.generate(string, map);
        assertThat(result, is("I love Java"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotHaveKey() {
        String string = "I love ${one}";
        Map<String, String> map = new HashMap<>() {
            {
                put("key", "Java");
            }
        };
        String result = template.generate(string, map);
        assertThat(result, is("I love Java"));
    }

    @Test
    public void whenHaveManykeys() {
        String string = "I love ${key} and i wont ${do} very ${how}";
        Map<String, String> map = new HashMap<>() {
            {
                put("key", "Java");
                put("do", "study");
                put("how", "hard");
            }
        };
        String result = template.generate(string, map);
        assertThat(result, is("I love Java and i wont study very hard"));
    }

    @Test
    public void whenHaveManySimilarKey() {
        String string = "Help, ${sos}, ${sos}, ${sos}";
        Map<String, String> map = new HashMap<>() {
            {
                put("sos", "Aaa");
                put("do", "study");
                put("how", "hard");
            }
        };
        String result = template.generate(string, map);
        assertThat(result, is("Help, Aaa, Aaa, Aaa"));
    }

}
