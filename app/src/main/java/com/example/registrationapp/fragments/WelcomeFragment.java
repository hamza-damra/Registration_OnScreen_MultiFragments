package com.example.registrationapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.registrationapp.R;


public class WelcomeFragment extends Fragment {


    public WelcomeFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_welcome, container, false);
        view.findViewById(R.id.buttonStart).setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.rootView, new RegistrationFragment()).addToBackStack(null).commit();
        });
        return view;
    }
}