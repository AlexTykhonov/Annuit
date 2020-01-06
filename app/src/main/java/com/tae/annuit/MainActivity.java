package com.tae.annuit;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<AnnuString> table = new ArrayList<>();
    EditText payEdittext;
    Button submitBtn;
    TextView amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        payEdittext = findViewById(R.id.payment);
        submitBtn = findViewById(R.id.buttonok);
        amount = findViewById(R.id.output);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTable(0.12, 180);
                showTable();
               amount.setText((getTheAmount(Double.valueOf(payEdittext.getText().toString()))).toString());
            }
        });

    }

    private Double getTheAmount (Double thePayment) {

        int position = 0;
        Double proximAmount = null; 
        Double checkmin;
        Double runner = table.get(1).getPayment();
        checkmin = Math.abs(runner-thePayment);

        for (int i=1;i<=table.size()-1;i++) {
            System.out.println("THIS IS MIN AMOUNT " + checkmin + " FOR THE POSITION #" + i);
            runner = table.get(i).getPayment();

                if (checkmin > (Math.abs(runner - thePayment))) {
                    checkmin = Math.abs(runner - thePayment);
                    position = i;
                }
            }
        proximAmount = table.get(position).getAmount();
        System.out.println("Loan Amount is: "+proximAmount);
        return proximAmount;
    }


    public List <AnnuString> setTable (Double rate, int period) {
    table = new ArrayList<>();

        for (int i=0;i<20000;i++) {
            AnnuString annuString = new AnnuString();
            table.add(i, annuString);
            double amount = i*100d;
            annuString.setAmount(amount);
            annuString.setRate(rate);
            annuString.setDuration(period);
            double pay = amount * (rate/12+((rate/12)/((Math.pow(1+rate/12,period))-1)));
            annuString.setPayment(pay);
        }
        return table;
    }

    public void showTable () {
        for (int i=0;i<20000;i++) {
        System.out.println("# "+i+" "+ table.get(i).getAmount()+" "+ table.get(i).getDuration()+ " "+ table.get(i).getRate()+" -> "+table.get(i).getPayment());
    }
}
}


//  Выкидывает ошибки диапазона.