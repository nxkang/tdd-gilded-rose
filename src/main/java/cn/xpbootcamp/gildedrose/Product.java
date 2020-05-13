package cn.xpbootcamp.gildedrose;

public class Product {

    private int initialQualitySpeed;
    private int sellIn;
    private int quality;

    public Product(int initialQualitySpeed, int sellIn, int quality) {
        this.initialQualitySpeed = initialQualitySpeed;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void passDays(int passDays) {
        if (passDays <= this.sellIn) {
            passDaysLtSellIn(passDays);
        } else {
            passDaysGtSellIn(passDays);
        }
    }

    private void passDaysGtSellIn(int passDays) {
        this.quality += initialQualitySpeed * this.sellIn;
        int overSellInDays = passDays - this.sellIn;
        this.quality += initialQualitySpeed * 2 * overSellInDays;
        if (this.quality < 0) {
            this.quality = 0;
        }

        this.sellIn -= passDays;
    }

    private void passDaysLtSellIn(int passDays) {
        this.quality += initialQualitySpeed * passDays;
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
