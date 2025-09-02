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


import { ItemHandler } from './handler/ItemHandler';
import { NormalItemHandler } from './handler/NormalItemHandler';
import { AgedBrieHandler } from './handler/AgedBrieHandler';
import { BackstagePassHandler } from './handler/BackstagePassHandler';
import { SulfurasHandler } from './handler/SulfurasHandler';
import { ConjuredItemHandler } from './handler/ConjuredItemHandler';

export class GildedRose {
  items: Array<Item>;
  private readonly handlers: ItemHandler[];
  private readonly normalHandler: NormalItemHandler;

  constructor(items = [] as Array<Item>) {
    this.items = items;

    this.handlers = [
      new AgedBrieHandler(),
      new BackstagePassHandler(),
      new SulfurasHandler(),
      new ConjuredItemHandler(),
    ];

    this.normalHandler = new NormalItemHandler();
  }


  updateQuality() {
    for (const item of this.items) {
      const handler = this.handlers.find(h => h.handles(item)) || this.normalHandler;

      handler.updateItemQuality(item);
    }

    return this.items;
  }
}
