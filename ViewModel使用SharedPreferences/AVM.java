package com.example.jft;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;

public class AVM extends AndroidViewModel {
    SavedStateHandle handle;
    public AVM(@NonNull Application application,SavedStateHandle handle) {
        super(application);
        this.handle=handle;
        if(!handle.contains("key")){
            load();
        }
    }

    public LiveData<Integer> getnumber(){
        return handle.getLiveData("key");
    }

    void load(){
        SharedPreferences shp = getApplication().getSharedPreferences("whatever", Context.MODE_PRIVATE);
        handle.set("key",shp.getInt("key",0));
    }

    public void save(){
        SharedPreferences shp =getApplication().getSharedPreferences("key",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= shp.edit();
        editor.putInt("key",getnumber().getValue());
        editor.apply();
    }
    public void add(int x){
        handle.set("key",getnumber().getValue()+x);
    }
}
