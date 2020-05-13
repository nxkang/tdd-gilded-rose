package cn.xpbootcamp.gildedrose;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GildedRoseTest {

    @Nested
    class OrdinaryProduct {

        @Test
        void given_InSellIn_when_passDays_then_qualityGoDown1PerDay() {
            Product product = new Product(1,30,40);
            product.passDays(1);
            assertThat(product.getSellIn(), equalTo(29));
            assertThat(product.getQuality(), equalTo(39));
        }

        @Test
        void given_OverSellIn_when_passDays_then_qualityGoDown2PerPay() {
            Product product = new Product(1,30,40);
            product.passDays(32);
            assertThat(product.getSellIn(), equalTo(-2));
            assertThat(product.getQuality(), equalTo(6));
        }

        @Test
        void given_FarOverSellIn_when_passDays_then_qualityToBe0() {
            Product product = new Product(1,30,40);
            product.passDays(200);
            assertThat(product.getSellIn(), equalTo(-170));
            assertThat(product.getQuality(), equalTo(0));
        }
    }
}
