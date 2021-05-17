package adapterRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthy.R;

import java.util.ArrayList;

import data.Dishes;

public class AdapterDishes extends RecyclerView.Adapter<AdapterDishes.ViewHolder>{

    ArrayList<Dishes> listDishes;
    final onDishesListener mOnDishesListener;

    public AdapterDishes(ArrayList<Dishes> listDishes, onDishesListener onDishesListener) {
        this.listDishes = listDishes;
        this.mOnDishesListener = onDishesListener;
    }

    @NonNull
    @Override
    public AdapterDishes.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dishes,parent,false);
        return new AdapterDishes.ViewHolder(v,mOnDishesListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDishes.ViewHolder holder, int position) {
        holder.dishesTitle.setText(listDishes.get(position).getTitle());
        holder.dishesBanner.setImageResource(listDishes.get(position).getBanner());
    }

    @Override
    public int getItemCount() {
        return listDishes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView dishesTitle;
        ImageView dishesBanner;
        onDishesListener onDishesListener;

        public ViewHolder(@NonNull View itemView, onDishesListener onDishesListener) {
            super(itemView);
            dishesTitle = itemView.findViewById(R.id.itemDishesTitle);
            dishesBanner = itemView.findViewById(R.id.itemDishesBanner);
            this.onDishesListener = onDishesListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onDishesListener.onDishesClick(getAdapterPosition());
        }
        }

        public interface onDishesListener{
            void onDishesClick(int position);
        }
}

