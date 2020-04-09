package test;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static test.Analyzer.*;

import static org.junit.Assert.*;

public class AnalyzerTest {

    @Test
    public void whenNoChangeShouldInfoNoChange() {
        Info info = new Analyzer().diff(
                List.of(new Analyzer.User(1, "Mike"),
                new Analyzer.User(2, "Pike")),
                List.of(new Analyzer.User(1, "Mike"),
                        new Analyzer.User(2, "Pike"))
        );
        assertThat(info.added, is(0));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(0));
    }

    @Test
    public void whenAddNewUserShouldInfoAddOne() {
        Info info = new Analyzer().diff(
                List.of(new Analyzer.User(1, "Mike")),
                List.of(new Analyzer.User(1, "Mike"),
                        new Analyzer.User(2, "Pike"))
        );
        assertThat(info.added, is(1));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(0));
    }

    @Test
    public void whenChangeUserShouldInfoChangeTwo() {
        Info info = new Analyzer().diff(
                List.of(new Analyzer.User(1, "Mike"),
                        new Analyzer.User(2, "Pike")),
                List.of(new Analyzer.User(1, "Mike2"),
                        new Analyzer.User(2, "Pike2"))
        );
        assertThat(info.added, is(0));
        assertThat(info.changed, is(2));
        assertThat(info.deleted, is(0));
    }

    @Test
    public void whenDeletedUserShouldInfoDeleteTwo() {
        Info info = new Analyzer().diff(
                List.of(new Analyzer.User(1, "Mike"),
                        new Analyzer.User(2, "Pike")),
                List.of()
        );
        assertThat(info.added, is(0));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(2));
    }
}
