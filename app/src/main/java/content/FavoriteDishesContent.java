package content;

import java.util.ArrayList;

import data.Dishes;

public class FavoriteDishesContent {

    static ArrayList<Dishes> dishesList = new ArrayList<>();

    public static ArrayList<Dishes> getDishes() {
        return dishesList;
    }

    public static void addDishes(Dishes dishes) {
        dishesList.add(dishes);
    }

    public static void removeDishes(int position) { dishesList.remove(position); }
}
