// SetGenderFragment.java
package com.example.registrationapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.registrationapp.R;


public class SetGenderFragment extends Fragment {
    String gender = "N/A";
    OnGenderSelectedListener listener;

    public SetGenderFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_set_gender, container, false);
        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);

        Bundle bundle = getArguments();
        String name = bundle.getString("name", "");

        view.findViewById(R.id.buttonSet).setOnClickListener(v -> {
            int checkedId = radioGroup.getCheckedRadioButtonId();
            if (checkedId == R.id.radioButtonMale)
                gender = "male";
            else if (checkedId == R.id.radioButtonFemale)
                gender = "female";

            listener.onGenderSelected(gender, name); // Pass the selected gender and name to the listener
        });

        view.findViewById(R.id.buttonCancel).setOnClickListener(v -> listener.onGenderSelected("N/A", name)); // Pass null to the listener to indicate that the user cancelled the selection

        return view;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnGenderSelectedListener) {
            listener = (OnGenderSelectedListener) context;
        } else {
            throw new RuntimeException(context + " must implement OnGenderSelectedListener");
        }
    }

    public interface OnGenderSelectedListener {
        void onGenderSelected(String gender, String name);
    }
}
