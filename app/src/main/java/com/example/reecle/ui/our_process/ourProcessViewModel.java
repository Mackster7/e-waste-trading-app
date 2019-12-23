package com.example.reecle.ui.our_process;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ourProcessViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ourProcessViewModel() {

    }

    public LiveData<String> getText() {
        return mText;
    }
}