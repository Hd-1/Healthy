package adapterRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthy.R;

import java.util.ArrayList;

import data.Dishes;

public class AdapterDishes extends RecyclerView.Adapter<AdapterDishes.ViewHolder>{

    ArrayList<Dishes> listDishes;

    public AdapterDishes(ArrayList<Dishes> listDishes) {
        this.listDishes = listDishes;
    }

    @NonNull
    @Override
    public AdapterDishes.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dishes,parent,false);
        return new AdapterDishes.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDishes.ViewHolder holder, int position) {
        holder.trainingDishes.setText(listDishes.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return listDishes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView trainingDishes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            trainingDishes = itemView.findViewById(R.id.itemDishesTitle);
        }
    }
}
