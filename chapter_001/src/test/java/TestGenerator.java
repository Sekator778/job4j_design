import ood.tdd.GeneratorString;
import ood.tdd.Template;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestGenerator {
    @Test
    public void whenHaveOneKey() {
        Template template = new GeneratorString();
        String string = "I love ${subject}";
        Map<String, String> map = new HashMap<>();
        map.put("subject", "Java");
        String result = template.generate(string, map);
        assertThat(result, is("I love Java"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotHaveKeyThrowException() {
        Template template = new GeneratorString();
        String string = "I love ${key}";
        Map<String, String> map = new HashMap<>();
        String result = template.generate(string, map);
        assertThat(result, is("I love Java"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotHaveKey() {
        Template template = new GeneratorString();
        String string = "I love ${one}";
        Map<String, String> map = new HashMap<>();
        String result = template.generate(string, map);
        assertThat(result, is("I love Java"));
    }

    @Test
    public void whenHaveManykeys() {
        Template template = new GeneratorString();
        String string = "I love ${key} and i wont ${do} very ${how}";
        Map<String, String> map = new HashMap<>();
        map.put("key", "Java");
        map.put("do", "study");
        map.put("how", "hard");
        String result = template.generate(string, map);
        assertThat(result, is("I love Java and i wont study very hard"));
    }

    @Test
    public void whenHaveManySimilarKey() {
        Template template = new GeneratorString();
        String string = "Help, ${sos}, ${sos}, ${sos}";
        Map<String, String> map = new HashMap<>();
        map.put("sos", "Aaa");
        String result = template.generate(string, map);
        assertThat(result, is("Help, Aaa, Aaa, Aaa"));
    }
}
