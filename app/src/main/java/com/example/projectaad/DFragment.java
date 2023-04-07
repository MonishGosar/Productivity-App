package com.example.projectaad;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
public class DFragment extends Fragment {
    Spinner spinnermood;
    Button music;
    public DFragment() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_d, container, false);

        spinnermood=view.findViewById(R.id.spinnermood);
        music=view.findViewById(R.id.music);

        Intent sendUrl=new Intent(getActivity(), wv.class);

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mood=spinnermood.getSelectedItem().toString();

                switch(mood) {
                    case "Sad":{
                        sendUrl.putExtra("URL", "https://open.spotify.com/playlist/6nxPNnmSE0d5WlplUsa5L3?si=ead00272f17942df");
                        startActivity(sendUrl);
                        break;}

                    case "HeartBroken":{
                        sendUrl.putExtra("URL", "https://open.spotify.com/playlist/37i9dQZF1DXbrUpGvoi3TS?si=1b053ae9e3754905");
                        startActivity(sendUrl);
                        break;}

                    case "Energize":{
                        sendUrl.putExtra("URL", "https://open.spotify.com/playlist/37i9dQZF1DX35X4JNyBWtb?si=88e1256f86444fc3");
                        startActivity(sendUrl);
                        break;}

                    case "Top of the World": {
                        sendUrl.putExtra("URL", "https://open.spotify.com/playlist/4m1DKpy99nrTLX6VaMCjfF?si=2f578aa9e75846d1");
                        startActivity(sendUrl);
                        break;
                    }

                    default:{
                        Toast.makeText(getContext(), "Please Choose A Category!!", Toast.LENGTH_SHORT).show();

                        break;
                }
                }

            }
        });
        return view;
    }
}