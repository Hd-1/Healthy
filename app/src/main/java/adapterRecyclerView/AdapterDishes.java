package adapterRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthy.R;

import java.util.ArrayList;

import content.FavoriteDishesContent;
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
        if (listDishes.get(position).isFavStatus()) {
            holder.favBtn.setBackgroundResource(R.drawable.ic_favorite);
        } else {
            holder.favBtn.setBackgroundResource(R.drawable.ic_favorite_uncheck);
        }
        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dishes dishes = listDishes.get(position);

                if (dishes.isFavStatus()){
                    dishes.setFavStatus(false);
                    holder.favBtn.setBackgroundResource(R.drawable.ic_favorite_uncheck);
                    FavoriteDishesContent.removeDishes(position);
                    Toast.makeText(holder.itemView.getContext(), "Remove from Favorite", Toast.LENGTH_SHORT).show();
                } else {
                    dishes.setFavStatus(true);
                    holder.favBtn.setBackgroundResource(R.drawable.ic_favorite);
                    FavoriteDishesContent.addDishes(dishes);
                    Toast.makeText(holder.itemView.getContext(), "Added to Favorite", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDishes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView dishesTitle;
        ImageView dishesBanner;
        Button favBtn;
        onDishesListener onDishesListener;

        public ViewHolder(@NonNull View itemView, onDishesListener onDishesListener) {
            super(itemView);
            dishesTitle = itemView.findViewById(R.id.itemDishesTitle);
            dishesBanner = itemView.findViewById(R.id.itemDishesBanner);
            favBtn = itemView.findViewById(R.id.favBtnDishes);

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

