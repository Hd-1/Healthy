package fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healthy.R;

import java.util.ArrayList;

import adapterRecyclerView.AdapterDishes;
import data.Dishes;

public class DishesFragment extends Fragment {

    View dishesView;
    RecyclerView dishesList;
    AdapterDishes adapterDishes;
    ArrayList<Dishes> dishes = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


            dishesView = inflater.inflate(R.layout.fragment_dishes, container, false);

            dishesList = dishesView.findViewById(R.id.dishesList);
            dishesList.hasFixedSize();
            dishesList.setLayoutManager(new LinearLayoutManager(getContext()));

            addDishes();

        adapterDishes = new AdapterDishes(dishes);
            dishesList.setAdapter(adapterDishes);

            return dishesView;
        }

        public void addDishes(){
            dishes.add(new Dishes("First"));
            dishes.add(new Dishes("Second"));
            dishes.add(new Dishes("Third"));
            dishes.add(new Dishes("First"));
            dishes.add(new Dishes("Second"));
            dishes.add(new Dishes("Third"));
            dishes.add(new Dishes("First"));
            dishes.add(new Dishes("Second"));
            dishes.add(new Dishes("Third"));
            dishes.add(new Dishes("First"));
            dishes.add(new Dishes("Second"));
            dishes.add(new Dishes("Third"));
        }

}