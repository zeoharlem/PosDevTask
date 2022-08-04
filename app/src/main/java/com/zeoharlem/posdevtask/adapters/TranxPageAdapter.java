package com.zeoharlem.posdevtask.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.zeoharlem.posdevtask.R;
import com.zeoharlem.posdevtask.models.Transactions;

public class TranxPageAdapter extends ListAdapter<Transactions, TranxPageAdapter.MyViewHolder> {

    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClicked(Transactions transactions);
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public TranxPageAdapter() {
        super(Transactions.transactionsItemCallback);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater   = LayoutInflater.from(parent.getContext());
        View view   = layoutInflater.inflate(R.layout.transactions_item_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView transactionTitle;
        private final TextView statusName;
        private final TextView dateString;
        private final TextView amount;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            dateString          = itemView.findViewById(R.id.date_paid);
            transactionTitle    = itemView.findViewById(R.id.transaction_title);
            statusName          = itemView.findViewById(R.id.status_name);
            amount              = itemView.findViewById(R.id.amount);
        }

        @Override
        public void onClick(View view) {
            onItemClickListener.onItemClicked(getItem(getBindingAdapterPosition()));
        }

        public void bind(Transactions transactions){
            dateString.setText(transactions.getTransactionDate());
            transactionTitle.setText(transactions.getTransactionTypeName());
            amount.setText(String.valueOf(transactions.getAmount()));
            statusName.setText(transactions.getStatusName());
            switch (transactions.getStatusName()){
                case "Failed":
                    statusName.setTextColor(itemView.getResources().getColor(R.color.red));
                    break;
                case "Pending":
                    statusName.setTextColor(itemView.getResources().getColor(R.color.grey));
                    break;
                default:
                    statusName.setTextColor(itemView.getResources().getColor(R.color.teal_700));
                    break;
            }
        }
    }
}
