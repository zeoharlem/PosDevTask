package com.zeoharlem.posdevtask.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zeoharlem.posdevtask.models.Transactions;

import java.util.ArrayList;

public class MyViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Transactions>> mutableLiveData = new MutableLiveData<>();

    public MutableLiveData<ArrayList<Transactions>> getMutableLiveData() {
        return mutableLiveData;
    }

    public void setMutableLiveData(ArrayList<Transactions> mutableLiveData) {
        this.mutableLiveData.setValue(mutableLiveData);
    }
}
