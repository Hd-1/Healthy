package adapterRecyclerView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthy.R;

import java.util.ArrayList;

import content.FavoriteDishesContent;
import data.Dishes;

public class AdapterDishesFavorite  extends RecyclerView.Adapter<AdapterDishesFavorite.ViewHolder>{

    ArrayList<Dishes> listDishes;
    final onDishesListener mOnDishesListener;

    public AdapterDishesFavorite(ArrayList<Dishes> listDishes, onDishesListener onDishesListener) {
        this.listDishes = listDishes;
        this.mOnDishesListener = onDishesListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dishes,parent,false);
        return new ViewHolder(v, mOnDishesListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.dishesTitle.setText(listDishes.get(position).getTitle());
        holder.dishesBanner.setImageResource(listDishes.get(position).getBanner());
        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dishes dishes = listDishes.get(position);
                dishes.setFavStatus(false);
                FavoriteDishesContent.removeDishes(position);
                notifyItemRemoved(position);
                holder.favBtn.setBackgroundResource(R.drawable.ic_favorite_uncheck);
                Toast.makeText(holder.itemView.getContext(), "Remove from Favorite", Toast.LENGTH_SHORT).show();
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
        AdapterDishesFavorite.onDishesListener onDishesListener;

        public ViewHolder(@NonNull View itemView, AdapterDishesFavorite.onDishesListener onDishesListener) {
            super(itemView);
            dishesTitle = itemView.findViewById(R.id.itemDishesTitle);
            dishesBanner = itemView.findViewById(R.id.itemDishesBanner);
            favBtn = itemView.findViewById(R.id.favBtnDishes);
            favBtn.setBackgroundResource(R.drawable.ic_favorite);

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