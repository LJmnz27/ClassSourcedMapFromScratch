package com.rusili.a0411mapfromscratch;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rusili.a0411mapfromscratch.fragment.MainFragment;
import com.rusili.a0411mapfromscratch.model.Museum;
import com.rusili.a0411mapfromscratch.view.FragmentInterface;
import com.rusili.a0411mapfromscratch.view.MapsActivity;

public class MainActivity extends AppCompatActivity implements FragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = MainFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, mainFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void startMap(Museum museum) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("name", museum.getName());
        intent.putExtra("address", museum.getAddress());
        startActivity(intent);
    }
}
