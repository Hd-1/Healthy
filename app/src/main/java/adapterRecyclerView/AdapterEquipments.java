package adapterRecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthy.R;

import java.util.ArrayList;

public class AdapterEquipments extends RecyclerView.Adapter<AdapterEquipments.ViewHolder>{

    ArrayList<String> list;

    public AdapterEquipments(ArrayList<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public AdapterEquipments.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_equipments,parent,false);
        return new AdapterEquipments.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEquipments.ViewHolder holder, int position) {
        holder.item.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.itemEquipments);
        }
    }
}
