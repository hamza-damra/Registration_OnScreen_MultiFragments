package com.example.registrationapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.registrationapp.R;

public class RegistrationFragment extends Fragment {
    private static final String ARG_GENDER = "gender";
    private static final String ARG_NAME = "name";

    private OnSubmitListener listener;

    public RegistrationFragment() {
    }

    public static RegistrationFragment newInstance(String gender, String name) {
        RegistrationFragment fragment = new RegistrationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_GENDER, gender);
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        TextView genderTextView = view.findViewById(R.id.textViewSelectedGender);
        EditText et_name = view.findViewById(R.id.editTextName);

        if (getArguments() != null) {
            genderTextView.setText(getArguments().getString(ARG_GENDER));
            String name = getArguments().getString("name", "");
            et_name.setText(name);
        }

        view.findViewById(R.id.buttonSetGender).setOnClickListener(v -> {
            String name = et_name.getText().toString();
            listener.onSetGender(name);
        });

        view.findViewById(R.id.buttonSubmit).setOnClickListener(v -> {
            String name = et_name.getText().toString();
            String gender = genderTextView.getText().toString();
            listener.onSubmit(name, gender);
        });

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnSubmitListener) {
            listener = (OnSubmitListener) context;
        } else {
            throw new RuntimeException(context + " must implement OnSubmitListener");
        }
    }

    public interface OnSubmitListener {
        void onSubmit(String name, String gender);
        void onSetGender(String name);
    }
}
