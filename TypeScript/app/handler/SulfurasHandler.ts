import { Item } from '../gilded-rose';
import { ItemHandler } from './ItemHandler';

export class SulfurasHandler implements ItemHandler {
  handles(item: Item): boolean {
    return item.name === 'Sulfuras, Hand of Ragnaros';
  }

  updateItemQuality(item: Item): void {
    // Sulfuras does not change in quality or sellIn
  }
}
