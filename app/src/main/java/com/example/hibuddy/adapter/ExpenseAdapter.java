package com.example.hibuddy.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hibuddy.R;
import com.example.hibuddy.holder.ExpenseViewHolder;
import com.example.hibuddy.model.Expense;

import java.util.Vector;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseViewHolder>
{
    private final LayoutInflater inflater;
    private final Vector<Expense> expenses;
    public ExpenseAdapter(LayoutInflater inflater, Vector<Expense> expenses)
    {
        this.inflater = inflater;
        this.expenses = expenses;
    }

    @Override
    public ExpenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = inflater.inflate(R.layout.item_expenses, parent, false);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        holder.setExpense(expenses.get(position));
    }

    @Override
    public int getItemCount() {
        return expenses.size();
    }
}
