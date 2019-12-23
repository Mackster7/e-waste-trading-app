package com.example.reecle.ui.contactus;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class contactusViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public contactusViewModel() {

    }

    public LiveData<String> getText() {
        return mText;
    }
}