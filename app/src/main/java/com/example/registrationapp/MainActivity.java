package com.example.registrationapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.registrationapp.fragments.ProfileFragment;
import com.example.registrationapp.fragments.RegistrationFragment;
import com.example.registrationapp.fragments.SetGenderFragment;
import com.example.registrationapp.fragments.WelcomeFragment;

public class MainActivity extends AppCompatActivity implements SetGenderFragment.OnGenderSelectedListener, RegistrationFragment.OnSubmitListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.rootView), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.rootView, new WelcomeFragment()).commit();
    }

    @Override
    public void onGenderSelected(String gender, String name) {
        RegistrationFragment registrationFragment = RegistrationFragment.newInstance(gender, name);
        getSupportFragmentManager().beginTransaction().replace(R.id.rootView, registrationFragment).addToBackStack(null).commit();
    }

    @Override
    public void onSubmit(String name, String gender) {
        ProfileFragment profileFragment = ProfileFragment.newInstance(name, gender);
        getSupportFragmentManager().beginTransaction().replace(R.id.rootView, profileFragment).addToBackStack(null).commit();
    }

    @Override
    public void onSetGender(String name) {
        SetGenderFragment setGenderFragment = new SetGenderFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        setGenderFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.rootView, setGenderFragment).addToBackStack(null).commit();
    }

    // Method to clear SharedPreferences
}
