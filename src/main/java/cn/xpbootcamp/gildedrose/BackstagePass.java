package cn.xpbootcamp.gildedrose;

public class BackstagePass {

    private int initialQualityGoUpSpeed;

    private int sellIn;

    private int quality;

    public BackstagePass(int initialQualityGoUpSpeed, int sellIn, int quality) {
        this.initialQualityGoUpSpeed = initialQualityGoUpSpeed;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public void passDays(int passDays) {
        for (int i = passDays; i > 0; i--) {
            this.sellIn -= 1;
            if (this.sellIn >= 10) {
                this.quality += this.initialQualityGoUpSpeed;
            } else {
                this.quality += 2 * this.initialQualityGoUpSpeed;
            }
        }
    }
}
