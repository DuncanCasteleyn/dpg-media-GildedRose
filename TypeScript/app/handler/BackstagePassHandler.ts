import { Item } from '../gilded-rose';
import { ItemHandler } from './ItemHandler';
import { ItemUtils } from '../utility/ItemUtils';

export class BackstagePassHandler implements ItemHandler {
  handles(item: Item): boolean {
    return item.name === 'Backstage passes to a TAFKAL80ETC concert';
  }

  updateItemQuality(item: Item): void {
    if (item.quality < 50) {
      ItemUtils.increaseQuality(item);
      if (item.sellIn < 11) {
        ItemUtils.increaseQuality(item);
      }
      if (item.sellIn < 6) {
        ItemUtils.increaseQuality(item);
      }
    }
    ItemUtils.decreaseSellIn(item);
    if (item.sellIn < 0) {
      item.quality = 0;
    } else {
      item.quality = Math.min(50, item.quality);
    }
  }
}
