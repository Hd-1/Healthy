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

import java.util.ArrayList;

import com.example.healthy.R;

import content.FavoriteTrainingContent;
import data.Training;

public class AdapterTrainingFavorite extends RecyclerView.Adapter<AdapterTrainingFavorite.ViewHolder> {

    ArrayList<Training> listTraining;
    final onTrainingListener mOnTrainingListener;

    public AdapterTrainingFavorite(ArrayList<Training> listTraining, onTrainingListener onTrainingListener) {
        this.listTraining = listTraining;
        this.mOnTrainingListener = onTrainingListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_training,parent,false);
        return new ViewHolder(v,mOnTrainingListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.trainingTitle.setText(listTraining.get(position).getTitle());
        holder.trainingBanner.setImageResource(listTraining.get(position).getBanner());

        holder.favBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Training training = listTraining.get(position);

                training.setFavStatus(false);
                notifyItemRemoved(position);
                holder.favBtn.setBackgroundResource(R.drawable.ic_favorite_uncheck);
                FavoriteTrainingContent.removeTraining(position);
                Toast.makeText(holder.itemView.getContext(), "Remove from Favorite", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listTraining.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView trainingTitle;
        ImageView trainingBanner;
        onTrainingListener onTrainingListener;
        Button favBtn;

        public ViewHolder(@NonNull View itemView, onTrainingListener onTrainingListener) {
            super(itemView);
            trainingTitle = itemView.findViewById(R.id.itemTrainingTitle);
            trainingBanner = itemView.findViewById(R.id.itemTrainingBanner);
            favBtn = itemView.findViewById(R.id.favBtnTraining);
            favBtn.setBackgroundResource(R.drawable.ic_favorite);

            this.onTrainingListener = onTrainingListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onTrainingListener.onTrainingClick(getAdapterPosition());
        }
    }

    public interface onTrainingListener{
        void onTrainingClick(int position);
    }
}
