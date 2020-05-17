package cn.xpbootcamp.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Nested
class AgedBrieTest {

    // ge : great or equal
    @Test
    void given_InSellIn_and_quality_lt_50_when_passDays_then_qualityGoUp1PerDay() {
        AgedBrie agedBrie = new AgedBrie(1, 30, 40);
        agedBrie.passOneDay();
        assertThat(agedBrie.getSellIn(), equalTo(29));
        assertThat(agedBrie.getQuality(), equalTo(41));
    }

    @Test
    void given_InSellIn_and_quality_eq_50_when_passDays_then_quality_eq_50() {
        AgedBrie agedBrie = new AgedBrie(1, 30, 50);
        agedBrie.passOneDay();
        assertThat(agedBrie.getSellIn(), equalTo(29));
        assertThat(agedBrie.getQuality(), equalTo(50));
    }

    @Test
    void given_OverSellIn_and_quality_lt_50_when_passDays_then_qualityGoUp1PerDay() {
        AgedBrie agedBrie = new AgedBrie(1, 0, 40);
        agedBrie.passOneDay();
        assertThat(agedBrie.getSellIn(), equalTo(-1));
        assertThat(agedBrie.getQuality(), equalTo(41));
    }
}
