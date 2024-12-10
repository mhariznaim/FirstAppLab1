package com.example.hibuddy.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hibuddy.R;
import com.example.hibuddy.model.Expense;

public class ExpenseViewHolder extends RecyclerView.ViewHolder {

    private TextView txtVwExpName, txtVwExpDate, txtVwExpPrice, txtVwExpQty;
    public ExpenseViewHolder(@NonNull View itemView) {
        super(itemView);
        this.txtVwExpName = itemView.findViewById(R.id.itmExpName);
        this.txtVwExpDate = itemView.findViewById(R.id.itmExpDate);
        this.txtVwExpPrice = itemView.findViewById(R.id.itmExpPrice);
        this.txtVwExpQty = itemView.findViewById(R.id.itmExpQty);
    }

    public void setExpense(Expense expense) { //will be used on the Adapter to set the data

    txtVwExpName.setText(expense.getExpName());
    txtVwExpDate.setText(expense.getExpDate());
    txtVwExpPrice.setText(String.valueOf(expense.getExpValue()));
    txtVwExpQty.setText(String.valueOf(expense.getExpQty()));

    }
}
