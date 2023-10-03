package com.example.currencyconverter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class LocalCurrencyFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView amount = view.findViewById(R.id.local_currency_amount);
        TextView one = view.findViewById(R.id.local_currency_one);
        TextView two = view.findViewById(R.id.local_currency_two);
        TextView three = view.findViewById(R.id.local_currency_three);
        TextView four = view.findViewById(R.id.local_currency_four);
        TextView five = view.findViewById(R.id.local_currency_five);
        TextView six = view.findViewById(R.id.local_currency_six);
        TextView seven = view.findViewById(R.id.local_currency_seven);
        TextView eight = view.findViewById(R.id.local_currency_eight);
        TextView nine = view.findViewById(R.id.local_currency_nine);
        TextView zero = view.findViewById(R.id.local_currency_zero);
        TextView decimal = view.findViewById(R.id.local_currency_decimal);
        TextView check = view.findViewById(R.id.local_currency_check);

        
        one.setOnClickListener(v -> {


            //amount.setText(updateAmount(amount.getText().toString(), 1));
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


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_local_currency, container, false);
    }

    public static String updateAmount(String amount, int intValue) {
        // Split the input amount into the integer and fractional parts
        String[] parts = amount.split("\\.");

        // Extract the integer and fractional parts
        String integerPart = parts[0];
        String fractionalPart = parts[1];

        // Convert the fractional part to an integer
        int fractionalValue = Integer.parseInt(fractionalPart);

        // Update the fractional value based on the input integer
        fractionalValue += intValue;

        // Ensure the fractional value is within the range [0, 99]
        fractionalValue = Math.min(99, Math.max(0, fractionalValue));

        // Convert the updated fractional value back to a string
        fractionalPart = String.format("%02d", fractionalValue);

        // Update the amount with the new fractional part
        return integerPart + "." + fractionalPart;
    }
}