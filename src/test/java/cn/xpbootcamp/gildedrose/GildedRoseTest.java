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
            product.passOneDay();
            assertThat(product.getSellIn(), equalTo(29));
            assertThat(product.getQuality(), equalTo(39));
        }

        @Test
        void given_InSellIn_and_quality_is_0_when_passDays_then_qualityIs0() {
            Product product = new Product(1,30,0);
            product.passOneDay();
            assertThat(product.getSellIn(), equalTo(29));
            assertThat(product.getQuality(), equalTo(0));
        }

        @Test
        void given_OverSellIn_and_quality_gt_1_when_passDays_then_qualityGoDown2PerPay() {
            Product product = new Product(1,0,40);
            product.passOneDay();
            assertThat(product.getSellIn(), equalTo(-1));
            assertThat(product.getQuality(), equalTo(38));
        }

        @Test
        void given_OverSellIn_and_quality_eq_1_when_passDays_then_qualityToBe0() {
            Product product = new Product(1,0,1);
            product.passOneDay();
            assertThat(product.getSellIn(), equalTo(-1));
            assertThat(product.getQuality(), equalTo(0));
        }

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

        @Nested
        class SulfurasTest {

            @Test
            void given_pass_any_days_when_passDays_then_qualityFixed() {
                Sulfuras sulfuras = new Sulfuras(40);
                sulfuras.passOneDay();
                assertThat(sulfuras.getQuality(), equalTo(40));
            }
        }

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
    }
}
