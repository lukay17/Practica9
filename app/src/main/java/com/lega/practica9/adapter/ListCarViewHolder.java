package com.lega.practica9.adapter;

import android.graphics.drawable.Drawable;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.lega.practica9.R;
import com.lega.practica9.databinding.ItemlayoutListCarsBinding;
import com.lega.practica9.domain.CarItem;

public class ListCarViewHolder extends RecyclerView.ViewHolder {

    private final ItemlayoutListCarsBinding binding;
    private final ListCarAdapter.OnItemCarClick listener;

    public ListCarViewHolder(@NonNull ItemlayoutListCarsBinding bindingView, ListCarAdapter.OnItemCarClick listener) {
        super(bindingView.getRoot());
        this.binding = bindingView;
        this.listener = listener;
    }

    public void bind(CarItem carItem){
        binding.itemlayoutListcarname.setText(carItem.getResourcesCar().getCarType());
        binding.itemlayoutListcarImage.setImageResource(getImagefromTypeCar(carItem.getCarType()));
        tintBackgroundView(carItem.getCarType());
        binding.itemlayoutListcarprecio.setText(itemView.getContext().getString(R.string.price_car, carItem.getPrice()));

        itemView.setOnClickListener(view -> listener.onItemClick(carItem));
    }

    private void tintBackgroundView(String carType) {
        switch (carType){
            case "electric":
               createTintBackground(R.color.electricCar);
               break;
            case "bus":
                createTintBackground(R.color.bus);
                break;
            case "sportCar":
                createTintBackground(R.color.sportCar);
                break;
            case "flyCar":
                createTintBackground(R.color.flyCar);
                break;
            case "motorHome":
                createTintBackground(R.color.motorHome);
                break;
            case "pickup":
                createTintBackground(R.color.pickup);
                break;
            case "airplane":
                createTintBackground(R.color.airplane);
                break;
            default:
                createTintBackground(R.color.classicCar);
                break;
        }
    }

    private void createTintBackground(@ColorRes int color){
        Drawable tintDrawable = binding.itemlayoutListenerBackground.getBackground();
        tintDrawable = DrawableCompat.wrap(tintDrawable);
        DrawableCompat.setTint(tintDrawable, ContextCompat.getColor(itemView.getContext(), color));
    }

    private int getImagefromTypeCar(String carType) {
        switch (carType){
            case "electric":
                return R.drawable.electriccar;
            case "bus":
                return R.drawable.bus;
            case "sportCar":
                return R.drawable.sportcar;
            case "flyCar":
                return R.drawable.flyingcar;
            case "motorHome":
                return R.drawable.motorhome;
            case "pickup":
                return R.drawable.pickupcar;
            case "airplane":
                return R.drawable.airplain;
            default:
                return R.drawable.classiccar;
        }
    }
}
