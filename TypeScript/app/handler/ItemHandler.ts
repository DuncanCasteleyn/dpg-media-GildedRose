export interface ItemHandler {
  handles(item: Item): boolean;
  updateItemQuality(item: Item): void;
}

// Import Item from the main file if needed
import { Item } from '../gilded-rose';
