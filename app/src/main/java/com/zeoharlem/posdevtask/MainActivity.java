package com.zeoharlem.posdevtask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.zeoharlem.posdevtask.adapters.TransactionFragAdapter;
import com.zeoharlem.posdevtask.adapters.TranxPageAdapter;
import com.zeoharlem.posdevtask.models.Transactions;
import com.zeoharlem.posdevtask.utils.FileAssetsUtils;
import com.zeoharlem.posdevtask.viewmodels.MyViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int buttonState = 0;
    private ArrayList<Transactions> transactionsArrayList = new ArrayList<>();
    private TranxPageAdapter tranxPageAdapter;
    private MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tranxPageAdapter    = new TranxPageAdapter();
        viewModel           = new ViewModelProvider(this).get(MyViewModel.class);

        TabLayout tabLayout     = findViewById(R.id.tabLayout);
        ViewPager2 viewPagerTr  = findViewById(R.id.viewPagerTwo);

        TransactionFragAdapter fragAdapter = new TransactionFragAdapter(getSupportFragmentManager(), getLifecycle());

        viewPagerTr.setAdapter(fragAdapter);
        viewPagerTr.setUserInputEnabled(false);
        viewPagerTr.setOffscreenPageLimit(3);

        new TabLayoutMediator(tabLayout, viewPagerTr, (tab, position) -> {
            initSearchField();
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

        viewPagerTr.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position){
                    case 1:
                        clickedCredit();
                        break;
                    case 2:
                        clickedDebit();
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

        //Toggle tabs
        Button filterBtn = findViewById(R.id.filter_btn);
        filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(buttonState == 0){
                    tabLayout.setVisibility(View.VISIBLE);
                    viewPagerTr.setUserInputEnabled(true);
                    buttonState++;
                }
                else{
                    tabLayout.setVisibility(View.GONE);
                    viewPagerTr.setUserInputEnabled(false);
                    buttonState = 0;
                }
            }
        });
        transactionsArrayList   = FileAssetsUtils.getInstance()
                .loadJsonResults("transactions.json", "ALL", this);

        viewModel.setMutableLiveData(transactionsArrayList);

        viewModel.getMutableLiveData().observe(this, new Observer<ArrayList<Transactions>>() {
            @Override
            public void onChanged(ArrayList<Transactions> transactions) {
                tranxPageAdapter.submitList(transactions);
            }
        });
    }

    private void initSearchField(){
        SearchView searchView   = findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ArrayList<Transactions> filterResults   = new ArrayList<>();
                for(Transactions transaction: transactionsArrayList){
                    if(transaction.getTransactionTypeName().toLowerCase().contains(query.toLowerCase())){
                        filterResults.add(transaction);
                    }
                }
                viewModel.setMutableLiveData(filterResults);
                tranxPageAdapter.submitList(filterResults);
                Log.e("QueryTextSubmit", "onQueryTextSubmit: "+ query );
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Transactions> filterResults   = new ArrayList<>();
                for(Transactions transaction: transactionsArrayList){
                    if(transaction.getTransactionTypeName().toLowerCase().contains(newText.toLowerCase())){
                        filterResults.add(transaction);
                    }
                }
                viewModel.setMutableLiveData(filterResults);
                tranxPageAdapter.submitList(filterResults);
                Log.e("QueryTextChange", "onQueryTextChange: "+ newText );
                return false;
            }
        });
    }

    private void clickedAll(){
        transactionsArrayList   = FileAssetsUtils.getInstance()
                .loadJsonResults("transactions.json", "ALL", this);
        viewModel.setMutableLiveData(transactionsArrayList);
        tranxPageAdapter.submitList(transactionsArrayList);
    }

    private void clickedCredit(){
        ArrayList<Transactions> filterResults   = new ArrayList<>();
        for(Transactions transaction: transactionsArrayList){
            if(transaction.isCredit()){
                filterResults.add(transaction);
            }
        }
        viewModel.setMutableLiveData(filterResults);
        tranxPageAdapter.submitList(filterResults);
        Log.e("CreditSize", "clickedCredit: "+filterResults.size() );
    }

    private void clickedDebit(){
        ArrayList<Transactions> filterResults   = new ArrayList<>();
        for(Transactions transaction: transactionsArrayList){
            if(!transaction.isCredit()){
                filterResults.add(transaction);
            }
        }
        viewModel.setMutableLiveData(filterResults);
        tranxPageAdapter.submitList(filterResults);
        Log.e("DebitSize", "clickedCredit: "+filterResults.size() );
    }
}