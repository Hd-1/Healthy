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

import content.ScheduleContent;
import data.Schedule;
import data.Training;

public class AdapterSchedule extends RecyclerView.Adapter<AdapterSchedule.ViewHolder> {

    ArrayList<Schedule> list;
    final onScheduleListener mScheduleListener;

    public AdapterSchedule(ArrayList<Schedule> list, onScheduleListener onScheduleListener) {
        this.list = list;
        this.mScheduleListener = onScheduleListener;
    }

    @NonNull
    @Override
    public AdapterSchedule.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule,parent,false);
        return new AdapterSchedule.ViewHolder(v,mScheduleListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSchedule.ViewHolder holder, int position) {
        holder.hour.setText(list.get(position).getHours() + "h" + list.get(position).getMinutes());
        holder.day.setText(list.get(position).getDay());
        holder.trainingTitle.setText(list.get(position).getTitle());
        holder.trainingBanner.setImageResource(list.get(position).getBanner());

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScheduleContent.removeSchedule(position);
                notifyItemRemoved(position);
                Toast.makeText(holder.itemView.getContext(), "Remove", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView trainingTitle,day,hour;
        ImageView trainingBanner;
        Button deleteBtn;
        AdapterSchedule.onScheduleListener onScheduleListener;


        public ViewHolder(@NonNull View itemView, AdapterSchedule.onScheduleListener onScheduleListener) {
            super(itemView);

            trainingBanner = itemView.findViewById(R.id.itemScheduleBanner);
            trainingTitle = itemView.findViewById(R.id.itemScheduleTitle);
            day = itemView.findViewById(R.id.itemDay);
            hour = itemView.findViewById(R.id.itemHour);
            deleteBtn = itemView.findViewById(R.id.deleteScheduleBtn);

            this.onScheduleListener = onScheduleListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onScheduleListener.onScheduleClick(getAdapterPosition());
        }
    }

    public interface onScheduleListener{
        void onScheduleClick(int position);
    }
}
