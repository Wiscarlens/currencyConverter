package com.example.currencyconverter;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;


public class ListCurrency extends Fragment {
    private ArrayList<Currency> currencyArrayList = new ArrayList<>();

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currencies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton backButton = view.findViewById(R.id.backButtonIM);
        TextView currentSelectedCurrency = view.findViewById(R.id.currentSelectedTV);
        RecyclerView recyclerView = view.findViewById(R.id.currenciesRV);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        currencyArrayList.add(new Currency("United States Dollar", "USD"));
        currencyArrayList.add(new Currency("Euro", "EUR"));
        currencyArrayList.add(new Currency("Canada", "CAD"));
        currencyArrayList.add(new Currency("Gourde", "HTG"));

        CurrencyAdapter currencyAdapter = new CurrencyAdapter(currencyArrayList, getContext());

        recyclerView.setAdapter(currencyAdapter);

        backButton.setOnClickListener(v -> {
            FragmentManager fragmentManager =  getActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            HomeFragment homeFragment = new HomeFragment();
            fragmentTransaction.replace(R.id.fragment_container, homeFragment);
            fragmentTransaction.commit();
        });


    }
}