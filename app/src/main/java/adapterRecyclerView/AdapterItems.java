package adapterRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthy.R;

import java.util.ArrayList;

public class AdapterItems extends RecyclerView.Adapter<AdapterItems.ViewHolder>{

    ArrayList<String> list;

    public AdapterItems(ArrayList<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterItems.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_strings,parent,false);
        return new AdapterItems.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItems.ViewHolder holder, int position) {
        holder.item.setText(list.get(position));
        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView item;
        Button deleteBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);
            deleteBtn = itemView.findViewById(R.id.deleteItemBtn);
        }
    }

}
