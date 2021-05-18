package data;

import java.util.ArrayList;

public class Dishes {
    String title;
    int banner;
    String directions;
    String nutritionFacts;
    ArrayList<String> ingredients;
    int image;
    boolean favStatus;

    public Dishes(String title, int banner, String directions, String nutritionFacts, ArrayList<String> ingredients, int image, boolean favStatus) {
        this.title = title;
        this.banner = banner;
        this.directions = directions;
        this.nutritionFacts = nutritionFacts;
        this.ingredients = ingredients;
        this.image = image;
        this.favStatus = favStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBanner() {
        return banner;
    }

    public void setBanner(int banner) {
        this.banner = banner;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getNutritionFacts() {
        return nutritionFacts;
    }

    public void setNutritionFacts(String nutritionFacts) {
        this.nutritionFacts = nutritionFacts;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isFavStatus() {
        return favStatus;
    }

    public void setFavStatus(boolean favStatus) {
        this.favStatus = favStatus;
    }
}
