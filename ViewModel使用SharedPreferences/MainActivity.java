package com.example.jft;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.jft.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    AVM avm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        avm=new ViewModelProvider(this,new SavedStateViewModelFactory(getApplication(),this)).get(AVM.class);
        activityMainBinding.setData(avm);
        activityMainBinding.setLifecycleOwner(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        avm.save();
    }
}
