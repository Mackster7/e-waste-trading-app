package com.example.reecle.ui.about_us;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class aboutusViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public aboutusViewModel() {

    }

    public LiveData<String> getText() {
        return mText;
    }
}