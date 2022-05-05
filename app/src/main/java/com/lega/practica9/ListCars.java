package com.lega.practica9;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import com.lega.practica9.adapter.ListCarAdapter;
import com.lega.practica9.databinding.FragmentListCarsBinding;
import com.lega.practica9.domain.CarItem;
import com.lega.practica9.domain.ResourcesCar;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListCars#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListCars extends Fragment {

    public ListCars() {
        // Required empty public constructor
    }

    public static ListCars newInstance() {
        return new ListCars();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        return FragmentListCarsBinding.inflate(inflater, container, false).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentListCarsBinding binding = FragmentListCarsBinding.bind(view);
        setupRecycler(binding);
    }

    private void setupRecycler(FragmentListCarsBinding binding) {
        binding.fragmentListContainer.setHasFixedSize(true);
        binding.fragmentListContainer.setAdapter(new ListCarAdapter(getFakeCarList(), new ListCarAdapter.OnItemCarClick() {
            @Override
            public void onItemClick(CarItem carItem) {
                Toast.makeText(requireActivity(), "Has pulsado en la Imagen " + carItem.getPrice() + " eso cuesta",Toast.LENGTH_SHORT).show();
            }
        }));
    }

    private List<CarItem> getFakeCarList() {
       List<CarItem> list = new ArrayList<>();
       list.add(new CarItem(34f, "classic",new ResourcesCar("Classic Car")));
       list.add(new CarItem(55f, "sportCar",new ResourcesCar("Sport Car")));
       list.add(new CarItem(500f, "flyCar",new ResourcesCar("Flying Car")));
       list.add(new CarItem(45f, "electric",new ResourcesCar("Electric Car")));
       list.add(new CarItem(23f, "motorHome",new ResourcesCar("Motor Home")));
       list.add(new CarItem(34f, "pickup",new ResourcesCar("Pickup")));
       list.add(new CarItem(11f, "airplane",new ResourcesCar("Airplane")));
       list.add(new CarItem(14f, "bus",new ResourcesCar("Bus")));

       return list;
    }
}