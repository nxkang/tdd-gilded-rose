package cn.xpbootcamp.gildedrose;

public class AgedBrie {

    private final int qualityGoUpSpeed;
    private int sellIn;
    private int quality;

    public AgedBrie(int qualityGoUpSpeed, int sellIn, int quality) {
        this.qualityGoUpSpeed = qualityGoUpSpeed;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void passOneDay() {
        this.passDays(1);
    }

    private void passDays(int passDays) {
        this.quality += qualityGoUpSpeed * passDays;
        if (quality >= 50) {
           this.quality = 50;
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
