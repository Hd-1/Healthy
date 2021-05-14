package adapterRecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.healthy.R;

import data.Training;

public class AdapterTraining extends RecyclerView.Adapter<AdapterTraining.ViewHolder> {

    ArrayList<Training> listTraining;
    private onTrainingListener mOnTrainingListener;

    public AdapterTraining(ArrayList<Training> listTraining, onTrainingListener onTrainingListener) {
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
    }

    @Override
    public int getItemCount() {
        return listTraining.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView trainingTitle;
        onTrainingListener onTrainingListener;

        public ViewHolder(@NonNull View itemView, onTrainingListener onTrainingListener) {
            super(itemView);
            trainingTitle = itemView.findViewById(R.id.itemTrainingTitle);
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