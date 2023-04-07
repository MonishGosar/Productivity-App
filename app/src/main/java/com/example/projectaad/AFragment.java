package com.example.projectaad;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
public class AFragment extends Fragment {
    ArrayList<Event> ev = new ArrayList<>();
    RecyclerView recycler;

    public AFragment(ArrayList<Event> a) {
        ev=a;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_a, container, false);
        recycler=view.findViewById(R.id.recycler);


        recycler.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.Adapter adapter = new MainAdapter(ev);
        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter);

        return view;
    }


}