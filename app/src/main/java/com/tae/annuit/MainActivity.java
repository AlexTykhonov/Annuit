package com.tae.annuit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<AnnuString> table = new ArrayList<>();
    EditText payEdittext;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();


        setTable(10d);
        for (int i=0;i<100;i++) {
        System.out.println("# "+i+" "+ table.get(i).getAmount()+" "+ table.get(i).getDuration()+ " "+ table.get(i).getRate()+" -> "+table.get(i).getPayment());
        }


    }

    public List <AnnuString> setTable (Double payment) {
    table = new ArrayList<>();

        for (int i=0;i<100;i++) {
            AnnuString annuString = new AnnuString();
            annuString.setAmount(i*100d);
            annuString.setRate(0.12d);
            annuString.setDuration(180);
            double amount = i*100d;
            double pay = (amount * 0.12/12)/(1-Math.pow((1+amount* 0.12/12),-180));
            annuString.setPayment(pay);
            table.add(i, annuString);
        }
        return table;
    }
}
