import {Item} from '../gilded-rose';
import {ItemHandler} from './ItemHandler';
import {ItemUtils} from '../utility/ItemUtils';

export class BackstagePassHandler implements ItemHandler {
  handles(item: Item): boolean {
    return item.name === 'Backstage passes to a TAFKAL80ETC concert';
  }

  updateItemQuality(item: Item): void {
    let increment = 1;

    if (item.sellIn < 11) increment++;

    if (item.sellIn < 6) increment++;

    ItemUtils.increaseQuality(item, increment);

    ItemUtils.decreaseSellIn(item);

    if (item.sellIn < 0) {
      item.quality = 0;
    }
  }
}
