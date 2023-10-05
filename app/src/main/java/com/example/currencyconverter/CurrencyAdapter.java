package com.example.currencyconverter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.DesignViewHolder> {
    private final ArrayList<Currency> currencyArrayList;

    private Context context;

    public CurrencyAdapter(ArrayList<Currency> currencyArrayList, Context context) {
        this.currencyArrayList = currencyArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CurrencyAdapter.DesignViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.currency_design, parent, false);

        return new DesignViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrencyAdapter.DesignViewHolder holder, int position) {
        holder.currencyNameTV_design.setText(currencyArrayList.get(position).getCurrencyName());
        holder.currencySymbolTV_design.setText(currencyArrayList.get(position).getCurrencySymbol());

        // holder.cardView.setOnClickListener(v -> Toast.makeText(context, "You selected " + users_for_display.get(position).getFullName(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return currencyArrayList.size();
    }


    public static class DesignViewHolder extends RecyclerView.ViewHolder {
        private final TextView currencyNameTV_design;
        private final TextView currencySymbolTV_design;

        public DesignViewHolder(@NonNull View itemView) {
            super(itemView);

            currencyNameTV_design = itemView.findViewById(R.id.currencyNameTV_design);
            currencySymbolTV_design = itemView.findViewById(R.id.currencyCodeTV_design);

        }
    }
}
