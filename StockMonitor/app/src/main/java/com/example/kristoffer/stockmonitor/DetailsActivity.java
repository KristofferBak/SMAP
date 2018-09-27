package com.example.kristoffer.stockmonitor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailsActivity extends Activity {

    Intent intent;
    Stock HCStock;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        intent = getIntent();

        index = intent.getIntExtra("Sector",0);

        HCStock = new Stock(intent.getStringExtra("Name"), intent.getIntExtra("Price", 0), intent.getIntExtra("Amount",0));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView tv1 = findViewById(R.id.NameTextView);
        TextView tv2 = findViewById(R.id.SectortextView);
        TextView tv3 = findViewById(R.id.PriceTextView);
        TextView tv4 = findViewById(R.id.AmountTextView);

        tv1.setText(intent.getStringExtra("Name"));

        String tech = getString(R.string.Tech);
        String med = getString(R.string.Medical);
        String bas = getString(R.string.BasicRes);

       if(index ==0){
           tv2.setText(tech);
       }

       if(index == 1){tv2.setText(med);}

       if(index == 2){
           tv2.setText(bas);
        }


        int temp = intent.getIntExtra("Price", 0);
        String tempString =  String.valueOf(temp);
        tv3.setText(tempString);

        int temp2 = intent.getIntExtra("Amount", 0);
        String tempString2 = String.valueOf(temp2);
        tv4.setText(tempString2);
    }

    public void edit(View view){
        intent = new Intent(this, editActivity.class);
        setValues();
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    public void back(View view){

        this.finish();
    }

    private void setValues(){
        intent.putExtra("Amount", HCStock.getAmount());
        intent.putExtra("Price", HCStock.getPrice());
        intent.putExtra("Name",HCStock.getName());
        intent.putExtra("Sector", index);
    }
}
