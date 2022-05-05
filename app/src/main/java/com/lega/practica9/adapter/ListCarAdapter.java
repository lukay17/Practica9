package com.lega.practica9.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.lega.practica9.databinding.ItemlayoutListCarsBinding;
import com.lega.practica9.domain.CarItem;

import java.util.List;

public class ListCarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CarItem> items;
    private OnItemCarClick listener;

    public ListCarAdapter(List<CarItem> items, OnItemCarClick listener){
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemlayoutListCarsBinding binding = ItemlayoutListCarsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ListCarViewHolder(binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ListCarViewHolder){
            ((ListCarViewHolder)holder).bind(items.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public interface OnItemCarClick{
        void onItemClick(CarItem carItem);
    }
}
