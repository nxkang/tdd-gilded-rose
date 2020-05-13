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
        this.sellIn -= passDays;
        this.quality -= initialQualityGoDownSpeed * passDays;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }
}
