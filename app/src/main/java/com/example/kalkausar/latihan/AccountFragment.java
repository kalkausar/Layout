package com.example.kalkausar.latihan;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    View v;

    private TextView username;
    private TextView email_account;
    private Button buttonLogout;
    private CircleImageView imgProfile;

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

        email_account = (TextView) v.findViewById(R.id.text_view_email_account);
        username = v.findViewById(R.id.text_view_name_account);
        imgProfile = v.findViewById(R.id.image_view_account);
        setInfo();

        buttonLogout = (Button) v.findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.buttonLogout:
                        showDialog();
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

    private void setInfo() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        final StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("users_photos");
        storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(AccountFragment.this)
                        .load(storageReference)
                        .into(imgProfile);
            }
        });
        email_account.setText(new StringBuilder("").append(user.getEmail()));
        username.setText(new StringBuilder("").append(user.getDisplayName()));
    }

    private void showDialog() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Are you sure to logout?")
                .setCancelable(false)
                .setPositiveButton("Keluar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        FirebaseAuth.getInstance().signOut();
                        Intent intent = new Intent(getActivity(), LoginActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                        AccountFragment.this.getActivity().finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });
        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();
        // menampilkan alert dialog
        alertDialog.show();
    }
}
