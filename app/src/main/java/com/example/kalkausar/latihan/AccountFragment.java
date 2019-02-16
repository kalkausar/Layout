package com.example.kalkausar.latihan;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.kalkausar.latihan.utils.PreferenceUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    View v;

    private TextView text_view_email_account;
    private Button buttonLogout;

    public AccountFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_account, container, false);


        //set title
        getActivity().setTitle("Account");

        buttonLogout = (Button) v.findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonLogout:
                        PreferenceUtils.savePassword(null, getActivity());
                        PreferenceUtils.saveEmail(null, getActivity());
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                        return;
                }
                return;
            }
        });
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
