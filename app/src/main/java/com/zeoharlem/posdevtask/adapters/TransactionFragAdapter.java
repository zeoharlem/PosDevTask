package com.zeoharlem.posdevtask.adapters;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zeoharlem.posdevtask.fragments.AllTransFragment;
import com.zeoharlem.posdevtask.fragments.CreditFragment;
import com.zeoharlem.posdevtask.fragments.DebitFragment;

public class TransactionFragAdapter extends FragmentStateAdapter {
    public TransactionFragAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public TransactionFragAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public TransactionFragAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new CreditFragment();
            case 2:
                return new DebitFragment();
            case 0:
            default:
                return new AllTransFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
