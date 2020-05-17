package cn.xpbootcamp.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Nested
class SulfurasTest {

    @Test
    void given_pass_any_days_when_passDays_then_qualityFixed() {
        Sulfuras sulfuras = new Sulfuras(40);
        sulfuras.passOneDay();
        assertThat(sulfuras.getQuality(), equalTo(40));
    }
}
