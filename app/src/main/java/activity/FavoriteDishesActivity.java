package activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthy.R;

import java.util.ArrayList;
import java.util.Objects;

public class FavoriteDishesActivity extends AppCompatActivity {

    TextView mDishesTitle, mDirectionsDishes, mNutritionFactsDishes, mIngredientsDishes;
    ImageView mImageDishes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_dishes);

        mDishesTitle = findViewById(R.id.favoriteDishesTitle);
        mDirectionsDishes = findViewById(R.id.favoriteDirectionsDishes);
        mNutritionFactsDishes = findViewById(R.id.favoriteNutritionFactsDishes);
        mIngredientsDishes = findViewById(R.id.favoriteIngredientsDishes);
        mImageDishes = findViewById(R.id.favoriteImageDishes);

        String dishesTitle = "Title not found";
        String dishesDirections = "Directions not found";
        String dishesNutritionFacts = "Nutrition Facts not found";
        ArrayList<String> ingredients = new ArrayList<>();
        String dishesIngredients = "Ingredients not found";
        int dishesImage = 0;

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            dishesTitle = extras.getString("dishesTitle");
            dishesDirections = extras.getString("dishesDirections");
            dishesNutritionFacts = extras.getString("dishesNutritionFacts");
            ingredients = extras.getStringArrayList("dishesIngredients");
            dishesImage = extras.getInt("dishesImage");
        }

        dishesIngredients = arrayToString(ingredients);

        mDishesTitle.setText(dishesTitle);
        mDirectionsDishes.setText(dishesDirections);
        mNutritionFactsDishes.setText(dishesNutritionFacts);
        mIngredientsDishes.setText(dishesIngredients);
        mImageDishes.setImageResource(dishesImage);

        Objects.requireNonNull(getSupportActionBar()).setTitle(dishesTitle);
    }

    public String arrayToString(ArrayList<String> table){
        String s = "";

        for(int i = 0; i < table.size(); i++){
            s = s + table.get(i) + "\n";
        }

        return s;
    }
}