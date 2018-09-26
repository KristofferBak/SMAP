package com.example.kristoffer.stockmonitor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

    Intent intent;
    Intent intent2;
    public Stock HCStock = new Stock("Tesla", 1000, 10, "Technology");
    ImageView iv;
    TextView tv;
    TextView pricetv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        intent2 = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.imageView);
        tv = findViewById(R.id.textView4);
        pricetv = findViewById(R.id.PriceTextView);

        if(intent2.hasExtra("Name") == true){
            String temp = intent2.getStringExtra("Name");
            tv.setText(temp);

            HCStock.setName(temp);
            HCStock.setPrice(intent2.getIntExtra("Price",0));
            HCStock.setAmount(intent2.getIntExtra("Amount", 0));
            String tempSector = intent2.getStringExtra("Sector");
            HCStock.setSector(tempSector);

            pricetv.setText(String.valueOf(HCStock.getPrice()));
        }
        else {
            tv.setText(HCStock.getName());
            pricetv.setText(String.valueOf(HCStock.getPrice()));
        }

        switch(HCStock.getSector()){
            case "Technology":
                iv.setImageResource(R.drawable.icon_blk_tech);
                break;

            case "HealthCare":
                iv.setImageResource(R.drawable.healthcare_icon);
                break;

            case "BasicResources":
                iv.setImageResource(R.drawable.soil_icon);
                break;

            case "":
                iv.setImageResource(R.drawable.soil_icon);
                break;
        }
    }

    public void details(View view) {
        intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("Amount", HCStock.getAmount());
        intent.putExtra("Price", HCStock.getPrice());
        intent.putExtra("Name",HCStock.getName());
        intent.putExtra("Sector", HCStock.getSector());
        startActivity(intent);
    }
}
