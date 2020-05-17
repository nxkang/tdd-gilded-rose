package cn.xpbootcamp.gildedrose;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Nested
class BackstagePassTest {

    @Test
    void given_SellInGt10_and_qualityLt50_when_passDays_then_qualityGoUp1PerDay() {
        BackstagePass backstagePass = new BackstagePass(1, 11, 20);
        backstagePass.passOneDay();
        assertThat(backstagePass.getSellIn(), equalTo(10));
        assertThat(backstagePass.getQuality(), equalTo(21));
    }

    @Test
    void given_SellInGt10_and_qualityEq50_when_passDays_then_qualityIs50() {
        BackstagePass backstagePass = new BackstagePass(1, 11, 50);
        backstagePass.passOneDay();
        assertThat(backstagePass.getSellIn(), equalTo(10));
        assertThat(backstagePass.getQuality(), equalTo(50));
    }

    @Test
    void given_SellInLt10Ge5_and_qualityLt48_when_passDays_then_qualityGoUp2PerDay() {
        BackstagePass backstagePass = new BackstagePass(1, 10, 20);
        backstagePass.passOneDay();
        assertThat(backstagePass.getSellIn(), equalTo(9));
        assertThat(backstagePass.getQuality(), equalTo(22));
    }

    @Test
    void given_SellInLt10Ge5_and_qualityGe49_when_passDays_then_qualityIs50() {
        BackstagePass backstagePass = new BackstagePass(1, 10, 50);
        backstagePass.passOneDay();
        assertThat(backstagePass.getSellIn(), equalTo(9));
        assertThat(backstagePass.getQuality(), equalTo(50));
    }

    @Test
    void given_SellInLt5Gt0_and_qualityLt47_when_passDays_then_qualityGoUp3PerDay() {
        BackstagePass backstagePass = new BackstagePass(1, 5, 20);
        backstagePass.passOneDay();
        assertThat(backstagePass.getSellIn(), equalTo(4));
        assertThat(backstagePass.getQuality(), equalTo(23));
    }

    @Test
    void given_SellInLt5Gt0_and_qualityGe48_when_passDays_then_qualityIs50() {
        BackstagePass backstagePass = new BackstagePass(1, 5, 48);
        backstagePass.passOneDay();
        assertThat(backstagePass.getSellIn(), equalTo(4));
        assertThat(backstagePass.getQuality(), equalTo(50));
    }

    @Test
    void given_OverSellIn_when_passDays_then_qualityToBe0() {
        BackstagePass backstagePass = new BackstagePass(1, 0, 20);
        backstagePass.passOneDay();
        assertThat(backstagePass.getSellIn(), equalTo(-1));
        assertThat(backstagePass.getQuality(), equalTo(0));
    }
}