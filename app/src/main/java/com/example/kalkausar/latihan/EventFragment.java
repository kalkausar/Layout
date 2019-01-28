package com.example.kalkausar.latihan;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kalkausar.latihan.Event.EventRecyclerViewAdapter;
import com.example.kalkausar.latihan.Event.cardMenu;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragment extends Fragment {

    View v;
    private RecyclerView myrecyclerview;
    private List<cardMenu> lstdata;

    public EventFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_event, container, false);
        myrecyclerview = (RecyclerView) v.findViewById(R.id.event_recyclerview);
        EventRecyclerViewAdapter eventRecyclerViewAdapter = new EventRecyclerViewAdapter(getContext(), lstdata);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        myrecyclerview.setAdapter(eventRecyclerViewAdapter);


        //set title
        getActivity().setTitle("Event");
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstdata = new ArrayList<>();
        lstdata.add(new cardMenu("Festival Kopi 1", "Various versions have evolved over the years, sometimes by accident", R.drawable.masjid));
        lstdata.add(new cardMenu("Festival Kopi 2", "Various versions have evolved over the years, sometimes by accident", R.drawable.kapal));
        lstdata.add(new cardMenu("Festival Kopi 3", "Various versions have evolved over the years, sometimes by accident", R.drawable.museum));
    }
}
