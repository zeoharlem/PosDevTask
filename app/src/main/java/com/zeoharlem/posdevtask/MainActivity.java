package com.zeoharlem.posdevtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.zeoharlem.posdevtask.adapters.TransactionFragAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPagerTr = findViewById(R.id.viewPagerTwo);
        TransactionFragAdapter fragAdapter = new TransactionFragAdapter(getSupportFragmentManager(), getLifecycle());
        viewPagerTr.setAdapter(fragAdapter);

        new TabLayoutMediator(tabLayout, viewPagerTr, (tab, position) -> {
            //tab.setText("number ok")
            switch (position){
                case 0:
                    tab.setText("All");
                    break;
                case 1:
                    tab.setText("Credit");
                    break;
                case 2:
                    tab.setText("Debit");
                    break;
            }
        }).attach();
    }
}