package fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healthy.R;

import java.util.ArrayList;

import activity.FavoriteDishesActivity;
import adapterRecyclerView.AdapterDishesFavorite;
import content.FavoriteDishesContent;
import data.Dishes;

public class FavoriteDishesFragment extends Fragment  implements AdapterDishesFavorite.onDishesListener{

    View dishesView;
    RecyclerView dishesList;
    AdapterDishesFavorite adapterDishes;
    ArrayList<Dishes> dishes = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        dishesView = inflater.inflate(R.layout.fragment_favorite_dishes, container, false);

        dishesList = dishesView.findViewById(R.id.favoriteDishesList);
        dishesList.setLayoutManager(new LinearLayoutManager(getContext()));
        dishes = FavoriteDishesContent.getDishes();

        adapterDishes = new AdapterDishesFavorite(dishes,this);
        dishesList.setAdapter(adapterDishes);

        return dishesView;
    }

    @Override
    public void onDishesClick(int position) {
        dishes.get(position);
        Intent intent = new Intent(getContext(), FavoriteDishesActivity.class);
        intent.putExtra("dishesTitle",dishes.get(position).getTitle());
        intent.putExtra("dishesDirections",dishes.get(position).getDirections());
        intent.putExtra("dishesNutritionFacts",dishes.get(position).getNutritionFacts());
        intent.putStringArrayListExtra("dishesIngredients",dishes.get(position).getIngredients());
        intent.putExtra("dishesImage",dishes.get(position).getImage());
        startActivity(intent);
    }
}