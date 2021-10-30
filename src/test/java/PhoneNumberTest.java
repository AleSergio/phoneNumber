
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PhoneNumberTest {
    @Test
    public void test1() {

        PhoneNumber ph = new PhoneNumber("+1(810)760-2868");

        assertThat("+1(810)760-2868", is(ph.getOriginalText()));
        assertThat("+18107602868", is(ph.getStrippedNumber()));
        assertThat("(810)760-2868", is(ph.getValueAsNorthAmerican()));
        assertThat("+1.810.760.2868", is(ph.getValueAsInternational()));
    }

    @Test
    public void test2() {
        PhoneNumber ph = new PhoneNumber("+1(649)386-2868x123");

        assertThat("+1(649)386-2868x123", is(ph.getOriginalText()));
        assertThat("+16493862868x123", is(ph.getStrippedNumber()));
        assertThat("(649)386-2868x123", is(ph.getValueAsNorthAmerican()));
        assertThat("+1(649)386-2868x123", is(ph.getValueAsInternational()));
    }

    @Test
    public void test3() {
        PhoneNumber ph = new PhoneNumber("+598.123.4567x858");

        assertThat("+598.123.4567x858", is(ph.getOriginalText()));
        assertThat("+5981234567x858", is(ph.getStrippedNumber()));
        assertThat(null, is(ph.getValueAsNorthAmerican()));
       assertThat("+598.123.456.7x858", is(ph.getValueAsInternational()));
    }

    @Test
    public void test4() {
        PhoneNumber ph = new PhoneNumber("+27 1234 5678 ext 4");

        assertThat("+27 1234 5678 ext 4", is(ph.getOriginalText()));
        assertThat("+2712345678x4", is(ph.getStrippedNumber()));
        assertThat(null, is(ph.getValueAsNorthAmerican()));
        assertThat("+27 1234 5678 ext 4", is(ph.getValueAsInternational()));
    }

    @Test
    public void test5() {
        PhoneNumber ph = new PhoneNumber("858-775-2868");

        assertThat("858-775-2868", is(ph.getOriginalText()));
        assertThat("+18587752868", is(ph.getStrippedNumber()));
        assertThat("(858)775-2868", is(ph.getValueAsNorthAmerican()));
        assertThat("+1.858.775.2868", is(ph.getValueAsInternational()));
    }

    @Test
    public void test6() {
        PhoneNumber ph = new PhoneNumber("1234567890");

        assertThat("1234567890", is(ph.getOriginalText()));
        assertThat("+11234567890", is(ph.getStrippedNumber()));
        assertThat("(123)456-7890", is(ph.getValueAsNorthAmerican()));
        assertThat("+1.123.456.7890", is(ph.getValueAsInternational()));
    }

    @Test
    public void test7() {
        PhoneNumber ph = new PhoneNumber("1234567extended890");

        assertThat("1234567extended890", is(ph.getOriginalText()));
        assertThat("+11234567x890", is(ph.getStrippedNumber()));
        assertThat("(123)456-7x890", is(ph.getValueAsNorthAmerican()));
        assertThat("+1.123.456.7x890", is(ph.getValueAsInternational()));
    }
}
