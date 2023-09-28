package com.example.currencyconverter;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {
    private FragmentActivity fragmentActivity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentActivity = (FragmentActivity) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView ISO_code = view.findViewById(R.id.ISOCodeTV);
        TextView amount = view.findViewById(R.id.amountTV);
        TextView currencySign = view.findViewById(R.id.currencySignTV);
        TextView currencyName = view.findViewById(R.id.currencyNameTV);

        FloatingActionButton switchButton = view.findViewById(R.id.switchFAB);

        TextView ISO_code2 = view.findViewById(R.id.ISOCodeTV2);
        TextView amount2 = view.findViewById(R.id.amountTV2);
        TextView currencySign2 = view.findViewById(R.id.currencySignTV2);
        TextView currencyName2 = view.findViewById(R.id.currencyNameTV2);


        amount.setText("1.00");

        amount.setOnClickListener(v -> {

            FragmentManager fragmentManager =  fragmentActivity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            LocalCurrencyFragment localCurrency = new LocalCurrencyFragment();
            fragmentTransaction.replace(R.id.fragment_container, localCurrency);
            fragmentTransaction.commit();
        });

        amount2.setText("1.00");

        amount2.setOnClickListener(v -> {

            FragmentManager fragmentManager =  fragmentActivity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            ForeignCurrency foreignCurrency = new ForeignCurrency();
            fragmentTransaction.replace(R.id.fragment_container, foreignCurrency);
            fragmentTransaction.commit();
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}