package com.example.reecle.ui.logout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.reecle.MainActivity;
import com.example.reecle.R;
import com.example.reecle.signup;

public class logoutFragment extends Fragment {

    private logoutViewModel slideshowViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater ,
                             ViewGroup container , Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
            Intent intent = new Intent(getActivity(), MainActivity.class);
            getActivity().startActivity(intent);
        return rootView;
    }
}