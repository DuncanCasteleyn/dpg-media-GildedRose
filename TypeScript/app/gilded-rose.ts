export class Item {
  name: string;
  sellIn: number;
  quality: number;

  constructor(name, sellIn, quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }
}

export class GildedRose {
  items: Array<Item>;

  constructor(items = [] as Array<Item>) {
    this.items = items;
  }

  private isAgedBrie(item: Item): boolean {
    return item.name === 'Aged Brie';
  }

  private isBackstagePass(item: Item): boolean {
    return item.name === 'Backstage passes to a TAFKAL80ETC concert';
  }

  private isSulfuras(item: Item): boolean {
    return item.name === 'Sulfuras, Hand of Ragnaros';
  }

  private increaseQuality(item: Item, amount: number = 1): void {
    item.quality = Math.min(50, item.quality + amount);
  }

  private decreaseQuality(item: Item, amount: number = 1): void {
    item.quality = Math.max(0, item.quality - amount);
  }

  private decreaseSellIn(item: Item): void {
    if (!this.isSulfuras(item)) {
      item.sellIn -= 1;
    }
  }

  private handleAgedBrie(item: Item): void {
    if (item.quality < 50) {
      this.increaseQuality(item);
    }
  }

  private handleBackstagePass(item: Item): void {
    if (item.quality < 50) {
      this.increaseQuality(item);
      if (item.sellIn < 11) {
        this.increaseQuality(item);
      }
      if (item.sellIn < 6) {
        this.increaseQuality(item);
      }
    }
  }

  private handleNormalItem(item: Item): void {
    if (item.quality > 0 && !this.isSulfuras(item)) {
      this.decreaseQuality(item);
    }
  }

  private handleExpired(item: Item): void {
    if (this.isAgedBrie(item)) {
      this.handleAgedBrie(item);
    } else if (this.isBackstagePass(item)) {
      item.quality = 0;
    } else {
      this.handleNormalItem(item);
    }
  }

  updateQuality() {
    for (const item of this.items) {
      if (this.isAgedBrie(item)) {
        this.handleAgedBrie(item);
      } else if (this.isBackstagePass(item)) {
        this.handleBackstagePass(item);
      } else {
        this.handleNormalItem(item);
      }
      this.decreaseSellIn(item);
      if (item.sellIn < 0) {
        this.handleExpired(item);
      }
    }
    return this.items;
  }
}
