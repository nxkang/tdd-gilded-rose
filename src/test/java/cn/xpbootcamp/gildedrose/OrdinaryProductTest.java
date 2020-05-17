package cn.xpbootcamp.gildedrose;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrdinaryProductTest {

    @Test
    void given_InSellIn_and_quality_gt_1_when_passDays_then_qualityGoDown1PerDay() {
        OrdinaryProduct product = new OrdinaryProduct(1,30,40);
        product.passOneDay();
        assertThat(product.getSellIn(), equalTo(29));
        assertThat(product.getQuality(), equalTo(39));
    }

    @Test
    void given_InSellIn_and_quality_is_0_when_passDays_then_qualityIs0() {
        OrdinaryProduct product = new OrdinaryProduct(1,30,0);
        product.passOneDay();
        assertThat(product.getSellIn(), equalTo(29));
        assertThat(product.getQuality(), equalTo(0));
    }

    @Test
    void given_OverSellIn_and_quality_gt_1_when_passDays_then_qualityGoDown2PerPay() {
        OrdinaryProduct product = new OrdinaryProduct(1,0,40);
        product.passOneDay();
        assertThat(product.getSellIn(), equalTo(-1));
        assertThat(product.getQuality(), equalTo(38));
    }

    @Test
    void given_OverSellIn_and_quality_eq_1_when_passDays_then_qualityToBe0() {
        OrdinaryProduct product = new OrdinaryProduct(1,0,1);
        product.passOneDay();
        assertThat(product.getSellIn(), equalTo(-1));
        assertThat(product.getQuality(), equalTo(0));
    }
}
