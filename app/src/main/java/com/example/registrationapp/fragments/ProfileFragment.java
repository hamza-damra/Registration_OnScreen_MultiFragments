package com.example.registrationapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.registrationapp.R;


public class ProfileFragment extends Fragment {

    private static final String ARG_NAME = "param1";
    private static final String ARG_GENDER = "param2";

    private String name;
    private String gender;


    public ProfileFragment() {
        // Required empty public constructor
    }


    public static ProfileFragment newInstance(String name, String gender) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putString(ARG_GENDER, gender);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
            gender = getArguments().getString(ARG_GENDER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView nameTextView = view.findViewById(R.id.textViewName);
        TextView genderTextView = view.findViewById(R.id.textViewGender);
        nameTextView.setText(name);
        genderTextView.setText(gender);
        view.findViewById(R.id.buttonClose).setOnClickListener(v -> {
            requireActivity().finish();
        });
        return view;
    }
}