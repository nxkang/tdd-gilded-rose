package cn.xpbootcamp.gildedrose;

public class OrdinaryProduct {

    private final int initialQualityGoDownSpeed;
    private int sellIn;
    private int quality;

    public OrdinaryProduct(int initialQualityGoDownSpeed, int sellIn, int quality) {
        this.initialQualityGoDownSpeed = initialQualityGoDownSpeed;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void passOneDay() {
        this.passDays(1);
    }

    private void passDays(int passDays) {
        if (passDays <= this.sellIn) {
            passDaysLtSellIn(passDays);
        } else {
            passDaysGtSellIn(passDays);
        }
    }

    private void passDaysGtSellIn(int passDays) {
        this.quality -= initialQualityGoDownSpeed * this.sellIn;
        int overSellInDays = passDays - this.sellIn;
        this.quality -= initialQualityGoDownSpeed * 2 * overSellInDays;
        if (this.quality < 0) {
            this.quality = 0;
        }

        this.sellIn -= passDays;
    }

    private void passDaysLtSellIn(int passDays) {
        this.quality -= initialQualityGoDownSpeed * passDays;
        if (this.quality < 0) {
            this.quality = 0;
        }
        this.sellIn -= passDays;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }
}
