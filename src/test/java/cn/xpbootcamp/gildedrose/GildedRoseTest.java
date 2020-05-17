package cn.xpbootcamp.gildedrose;


import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GildedRoseTest {

    @Nested
    class OrdinaryProduct {

        @Test
        void given_InSellIn_and_quality_gt_1_when_passDays_then_qualityGoDown1PerDay() {
            Product product = new Product(1,30,40);
            product.passDays(1);
            assertThat(product.getSellIn(), equalTo(29));
            assertThat(product.getQuality(), equalTo(39));
        }

        @Test
        void given_InSellIn_and_quality_is_0_when_passDays_then_qualityIs0() {
            Product product = new Product(1,30,0);
            product.passDays(1);
            assertThat(product.getSellIn(), equalTo(29));
            assertThat(product.getQuality(), equalTo(0));
        }

        @Test
        void given_OverSellIn_and_quality_gt_1_when_passDays_then_qualityGoDown2PerPay() {
            Product product = new Product(1,0,40);
            product.passDays(1);
            assertThat(product.getSellIn(), equalTo(-1));
            assertThat(product.getQuality(), equalTo(38));
        }

        @Test
        void given_OverSellIn_and_quality_eq_1_when_passDays_then_qualityToBe0() {
            Product product = new Product(1,0,1);
            product.passDays(1);
            assertThat(product.getSellIn(), equalTo(-1));
            assertThat(product.getQuality(), equalTo(0));
        }

        @Nested
        class AgedBrieTest {

            // ge : great or equal
            @Test
            void given_InSellIn_and_quality_lt_50_when_passDays_then_qualityGoUp1PerDay() {
                AgedBrie agedBrie = new AgedBrie(1, 30, 40);
                agedBrie.passDays(1);
                assertThat(agedBrie.getSellIn(), equalTo(29));
                assertThat(agedBrie.getQuality(), equalTo(41));
            }

            @Test
            void given_InSellIn_and_quality_eq_50_when_passDays_then_quality_eq_50() {
                AgedBrie agedBrie = new AgedBrie(1, 30, 50);
                agedBrie.passDays(1);
                assertThat(agedBrie.getSellIn(), equalTo(29));
                assertThat(agedBrie.getQuality(), equalTo(50));
            }

            @Test
            void given_OverSellIn_and_quality_lt_50_when_passDays_then_qualityGoUp1PerDay() {
                AgedBrie agedBrie = new AgedBrie(1, 0, 40);
                agedBrie.passDays(1);
                assertThat(agedBrie.getSellIn(), equalTo(-1));
                assertThat(agedBrie.getQuality(), equalTo(41));
            }
        }

        @Nested
        class SulfurasTest {

            @Test
            void given_pass_any_days_when_passDays_then_qualityFixed() {
                Sulfuras sulfuras = new Sulfuras(40);
                sulfuras.passDays(200);
                assertThat(sulfuras.getQuality(), equalTo(40));
            }
        }

        @Nested
        class BackstagePassTest {

            @Test
            void given_SellInGe10_when_passDays_then_qualityGoUp1PerDay() {
                BackstagePass backstagePass = new BackstagePass(1, 12, 20);
                backstagePass.passDays(1);
                assertThat(backstagePass.getSellIn(), equalTo(11));
                assertThat(backstagePass.getQuality(), equalTo(21));
            }

            @Test
            void given_SellInLt10Ge5_when_passDays_then_qualityGoUp2PerDay() {
                BackstagePass backstagePass = new BackstagePass(1, 12, 20);
                backstagePass.passDays(3);
                assertThat(backstagePass.getSellIn(), equalTo(9));
                assertThat(backstagePass.getQuality(), equalTo(24));
            }

            @Test
            void given_SellInLt5Ge0_when_passDays_then_qualityGoUp3PerDay() {
                BackstagePass backstagePass = new BackstagePass(1, 12, 20);
                backstagePass.passDays(8);
                assertThat(backstagePass.getSellIn(), equalTo(4));
                assertThat(backstagePass.getQuality(), equalTo(35));
            }

            @Test
            void given_OverSellIn_when_passDays_then_qualityToBe0() {
                BackstagePass backstagePass = new BackstagePass(1, 12, 20);
                backstagePass.passDays(13);
                assertThat(backstagePass.getSellIn(), equalTo(-1));
                assertThat(backstagePass.getQuality(), equalTo(0));
            }
        }
    }
}
