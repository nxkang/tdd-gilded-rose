package cn.xpbootcamp.gildedrose;

public class Product {

    private int initialQualityGoDownSpeed;
    private int sellIn;
    private int quality;

    public Product(int initialQualityGoDownSpeed, int sellIn, int quality) {
        this.initialQualityGoDownSpeed = initialQualityGoDownSpeed;
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
        this.quality -= initialQualityGoDownSpeed * this.sellIn;
        int overSellInDays = passDays - this.sellIn;
        this.quality -= initialQualityGoDownSpeed * 2 * overSellInDays;
        this.sellIn -= passDays;
    }

    private void passDaysLtSellIn(int passDays) {
        this.quality -= initialQualityGoDownSpeed * passDays;
        this.sellIn -= passDays;
        return;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }
}
