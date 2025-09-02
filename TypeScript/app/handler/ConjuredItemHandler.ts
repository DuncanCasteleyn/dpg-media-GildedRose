import { Item } from '../gilded-rose';
import { ItemHandler } from './ItemHandler';
import { ItemUtils } from '../utility/ItemUtils';

export class ConjuredItemHandler implements ItemHandler {
  handles(item: Item): boolean {
    return item.name.toLowerCase().includes('conjured');
  }

  updateItemQuality(item: Item): void {
    if (item.quality > 0) {
      ItemUtils.decreaseQuality(item, 2);
    }

    ItemUtils.decreaseSellIn(item);

    if (item.sellIn < 0 && item.quality > 0) {
      ItemUtils.decreaseQuality(item, 2);
    }
  }
}
