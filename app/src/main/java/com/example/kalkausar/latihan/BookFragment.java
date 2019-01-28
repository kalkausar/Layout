package com.example.kalkausar.latihan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kalkausar.latihan.booking.BookRecyclerViewAdapter;
import com.example.kalkausar.latihan.booking.dataset_book;

import java.util.ArrayList;
import java.util.List;


public class BookFragment extends Fragment {

    View v;
    private RecyclerView myrecyclerviewbook;
    private List<dataset_book> lstdatabook;

    public BookFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_book, container, false);
        myrecyclerviewbook = (RecyclerView) v.findViewById(R.id.book_recyclerview);
        BookRecyclerViewAdapter bookRecyclerViewAdapter = new BookRecyclerViewAdapter(getContext(), lstdatabook);
        myrecyclerviewbook.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerviewbook.setAdapter(bookRecyclerViewAdapter);

        //set title
        getActivity().setTitle("Booking List");
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstdatabook = new ArrayList<>();
        lstdatabook.add(new dataset_book("Banda Aceh - Jakarta", "Today", R.drawable.plane));
        lstdatabook.add(new dataset_book("Banda Aceh - Kuala Lumpur", "Today", R.drawable.plane));
        lstdatabook.add(new dataset_book("Banda Aceh - Sabang", "Today", R.drawable.ship));
    }
}
