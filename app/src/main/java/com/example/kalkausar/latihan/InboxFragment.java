package com.example.kalkausar.latihan;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kalkausar.latihan.inbox.RecyclerViewAdapter;
import com.example.kalkausar.latihan.inbox.dataset_inbox;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class InboxFragment extends Fragment {

    View v;
    private RecyclerView mrecyclerview;
    private List<dataset_inbox> lstinbox;

    public InboxFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_inbox, container, false);
        mrecyclerview = (RecyclerView) v.findViewById(R.id.inbox_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), lstinbox);
        mrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mrecyclerview.setAdapter(recyclerViewAdapter);

        //set title
        getActivity().setTitle("Inbox");
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstinbox = new ArrayList<>();
        lstinbox.add(new dataset_inbox("Lorem Ipsum1", "It is a long established fact that a reader will..."));
        lstinbox.add(new dataset_inbox("Lorem Ipsum2", "It is a long established fact that a reader will2..."));
        lstinbox.add(new dataset_inbox("Lorem Ipsum3", "It is a long established fact that a reader will3..."));
    }
}
