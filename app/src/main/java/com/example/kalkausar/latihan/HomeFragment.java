package com.example.kalkausar.latihan;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.kalkausar.latihan.Event.EventRecyclerViewAdapter;
import com.example.kalkausar.latihan.Event.cardMenu;
import com.example.kalkausar.latihan.Grid_Adapter.CustomGridViewAdapter;
import com.example.kalkausar.latihan._sliders.FragmentSlider;
import com.example.kalkausar.latihan._sliders.SliderIndicator;
import com.example.kalkausar.latihan._sliders.SliderPagerAdapter;
import com.example.kalkausar.latihan._sliders.SliderView;
import com.example.kalkausar.latihan.model.grid_menu;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private RecyclerView myrecyclerview;
    private List<cardMenu> lstdata;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;
    List<grid_menu> mGridList;
    grid_menu mGridData;

    RecyclerView recylerView;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment
        /*declare*/
        sliderView = view.findViewById(R.id.sliderView);
        mLinearLayout = view.findViewById(R.id.pagesContainer);
        setupSlider();

        recylerView = view.findViewById(R.id.Reclyer_Layout_Menu);

        mGridList = new ArrayList<>();
        mGridData = new grid_menu("Pesawat",
                R.drawable.plane);
        mGridList.add(mGridData);
        mGridData = new grid_menu("Hotel",
                R.drawable.hotel);
        mGridList.add(mGridData);
        mGridData = new grid_menu("Wisata",
                R.drawable.destination);
        mGridList.add(mGridData);
        mGridData = new grid_menu("Sewa Mobil",
                R.drawable.taxi);
        mGridList.add(mGridData);
        mGridData = new grid_menu("Ferry",
                R.drawable.ship);
        mGridList.add(mGridData);
        mGridData = new grid_menu("Event",
                R.drawable.ticket);
        mGridList.add(mGridData);

        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recylerView.setLayoutManager(mGridLayoutManager);

        CustomGridViewAdapter myAdapter = new CustomGridViewAdapter(getActivity(), mGridList);
        recylerView.setAdapter(myAdapter);
        //menset data di dalam gridview

        //set adapter event
        myrecyclerview = (RecyclerView) view.findViewById(R.id.event_recyclerview);
        EventRecyclerViewAdapter eventRecyclerViewAdapter = new EventRecyclerViewAdapter(getContext(), lstdata);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        myrecyclerview.setAdapter(eventRecyclerViewAdapter);

        //set title
        getActivity().setTitle("Sardifa Travel");
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-1.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-2.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-3.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-4.jpg"));

        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
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
