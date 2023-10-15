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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TargetCurrencyFragment extends Fragment {

    private FragmentActivity fragmentActivity;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentActivity = (FragmentActivity) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView amount = view.findViewById(R.id.foreign_amountTV);
        TextView one = view.findViewById(R.id.foreign_currency_one);
        TextView two = view.findViewById(R.id.foreign_currency_two);
        TextView three = view.findViewById(R.id.foreign_currency_three);
        TextView four = view.findViewById(R.id.foreign_currency_four);
        TextView five = view.findViewById(R.id.foreign_currency_five);
        TextView six = view.findViewById(R.id.foreign_currency_six);
        TextView seven = view.findViewById(R.id.foreign_currency_seven);
        TextView eight = view.findViewById(R.id.foreign_currency_eight);
        TextView nine = view.findViewById(R.id.foreign_currency_nine);
        TextView zero = view.findViewById(R.id.foreign_currency_zero);
        TextView decimal = view.findViewById(R.id.foreign_currency_decimal);
        TextView check = view.findViewById(R.id.foreign_currency_check);

        ImageView closeButton = view.findViewById(R.id.foreign_currency_swipeUp);


        one.setOnClickListener(v -> {
            amount.setText(amount.getText() + "1");
        });

        two.setOnClickListener(v -> {
            amount.setText(amount.getText() + "2");
        });

        three.setOnClickListener(v -> {
            amount.setText(amount.getText() + "3");
        });

        four.setOnClickListener(v -> {
            amount.setText(amount.getText() + "4");
        });

        five.setOnClickListener(v -> {
            amount.setText(amount.getText() + "5");
        });

        six.setOnClickListener(v -> {
            amount.setText(amount.getText() + "6");
        });

        seven.setOnClickListener(v -> {
            amount.setText(amount.getText() + "7");
        });

        eight.setOnClickListener(v -> {
            amount.setText(amount.getText() + "8");
        });

        nine.setOnClickListener(v -> {
            amount.setText(amount.getText() + "9");
        });

        zero.setOnClickListener(v -> {
            amount.setText(amount.getText() + "0");
        });

        decimal.setOnClickListener(v -> {
            amount.setText(amount.getText() + ".");
        });

        check.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Check", Toast.LENGTH_SHORT).show();
        });

        closeButton.setOnClickListener(v -> {
            FragmentManager fragmentManager =  fragmentActivity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            HomeFragment homeFragment = new HomeFragment();
            fragmentTransaction.replace(R.id.fragment_container, homeFragment);
            fragmentTransaction.commit();
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_converted_currency, container, false);
    }
}