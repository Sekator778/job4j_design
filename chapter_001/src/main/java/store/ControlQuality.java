package store;

public class ControlQuality {
    private final Storage shop;
    private final Storage warehouse;
    private final Storage trash;


    public ControlQuality(Storage shop, Storage warehouse, Storage trash) {
        this.shop = shop;
        this.warehouse = warehouse;
        this.trash = trash;
    }

    public void sortFood(Food food) throws EmptyStorageException {
        if (warehouse.validate(food)) {
            warehouse.add(food);
        } else if (shop.validate(food)) {
            shop.add(food);
        } else if (trash.validate(food)) {
            trash.add(food);
        } else {
            throw new EmptyStorageException("wrong food");
        }
    }
}
