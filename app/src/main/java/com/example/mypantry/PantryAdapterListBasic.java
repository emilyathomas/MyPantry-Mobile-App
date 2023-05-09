package com.example.mypantry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mypantry.model.PantryItem;

import java.util.List;

public class PantryAdapterListBasic extends RecyclerView.Adapter<PantryAdapterListBasic.ViewHolder> {

    private Context context;
    private List<PantryItem> items;

    public PantryAdapterListBasic(Context context, List<PantryItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pantry_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PantryItem currentItem = items.get(position);

        holder.itemName.setText(currentItem.getPantryName());
        holder.itemQuantity.setText(currentItem.getPantryQuantity());
        holder.itemExpDate.setText(currentItem.getPantryExpDate());
        holder.itemLocation.setText(currentItem.getPantryLocation());

        holder.itemRemoval.setOnClickListener(view -> {
            items.remove(position);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemName;
        TextView itemQuantity;
        TextView itemExpDate;
        TextView itemLocation;
        TextView itemNote;
        Button itemRemoval;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.pantryItemName);
            itemLocation = itemView.findViewById(R.id.itemLocation);
            itemQuantity = itemView.findViewById(R.id.itemQuantity);
            itemExpDate = itemView.findViewById(R.id.itemExpDate);
            itemNote = itemView.findViewById(R.id.itemNotes);
            itemRemoval = itemView.findViewById(R.id.itemRemoval);
        }
    }
}
