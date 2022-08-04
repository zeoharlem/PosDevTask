package com.zeoharlem.posdevtask.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zeoharlem.posdevtask.R;
import com.zeoharlem.posdevtask.adapters.TranxPageAdapter;
import com.zeoharlem.posdevtask.models.Transactions;
import com.zeoharlem.posdevtask.utils.FileAssetsUtils;
import com.zeoharlem.posdevtask.viewmodels.MyViewModel;

import java.util.ArrayList;

public class CreditFragment extends Fragment implements TranxPageAdapter.OnItemClickListener {
    private TranxPageAdapter tranxPageAdapter;
    private ArrayList<Transactions> transactionsArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MyViewModel viewModel;


    public CreditFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel   = new ViewModelProvider(requireActivity()).get(MyViewModel.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Get items from json file
        View view   = inflater.inflate(R.layout.fragment_credit, container, false);
        recyclerView        = view.findViewById(R.id.recycler_view);
        tranxPageAdapter    = new TranxPageAdapter();
        tranxPageAdapter.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.getMutableLiveData().observe(requireActivity(), new Observer<ArrayList<Transactions>>() {
            @Override
            public void onChanged(ArrayList<Transactions> transactions) {
                tranxPageAdapter.submitList(transactions);
                recyclerView.setAdapter(tranxPageAdapter);
            }
        });
        //recyclerView.setAdapter(tranxPageAdapter);
    }

    @Override
    public void onItemClicked(Transactions transactions) {
        Log.e("TransactionClick", "onItemClicked: "+transactions.toString() );
    }
}