package com.example.currencyconverter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONException;

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

        // Receiving input amount from BaseCurrencyFragment
        getParentFragmentManager().setFragmentResultListener(
                "amountData",
                this,
                (requestKey, result) -> {
                    double data = result.getDouble("amount");
                    amount.setText(String.valueOf(data));
                });



        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.d("HomeFragment", "Before API Request");
//
//                try {
//                    Log.i("Exchange Rate", String.valueOf(sendLiveRequest("USD", "EUR")));
//                    //sendLiveRequest("USD", "EUR");
//                } catch (JSONException e) {
//                    Log.e("HomeFragment", "API Request Error: " + e.getMessage());
//                }
//
//                Log.d("HomeFragment", "After API Request");

                Double temp = null;
                try {
                    temp = ExchangeAPI.sendLiveRequest("USD", "EUR");
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }

                Log.i("Exchange Rate", String.valueOf(temp));
            }
        });


        amount.setOnClickListener(v -> {
            FragmentManager fragmentManager =  fragmentActivity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            BaseCurrencyFragment localCurrency = new BaseCurrencyFragment();
            fragmentTransaction.replace(R.id.fragment_container, localCurrency);
            fragmentTransaction.commit();
        });

        amount2.setText("1.00");

        amount2.setOnClickListener(v -> {

            FragmentManager fragmentManager =  fragmentActivity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            ConvertedCurrencyFragment foreignCurrency = new ConvertedCurrencyFragment();
            fragmentTransaction.replace(R.id.fragment_container, foreignCurrency);
            fragmentTransaction.commit();
        });

        ISO_code.setOnClickListener(v -> {

            FragmentManager fragmentManager =  fragmentActivity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            ListCurrency currenciesFragment = new ListCurrency();
            fragmentTransaction.replace(R.id.fragment_container, currenciesFragment);

            fragmentTransaction.commit();
        });

        ISO_code2.setOnClickListener(v -> {
            FragmentManager fragmentManager =  fragmentActivity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            ListCurrency currenciesFragment = new ListCurrency();
            fragmentTransaction.replace(R.id.fragment_container, currenciesFragment);

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