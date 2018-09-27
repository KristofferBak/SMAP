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
    public Stock HCStock = new Stock("Tesla", 1000, 10);
    int index = 0;
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
             index = intent2.getIntExtra("Sector",0);
          // HCStock.setSector(tempSector);

            pricetv.setText(String.valueOf(HCStock.getPrice()));
        }
        else {
            tv.setText(HCStock.getName());
            pricetv.setText(String.valueOf(HCStock.getPrice()));
        }

        //String tech = getResources().getString(R.string.Tech);


        switch(index){
            case 0:
                iv.setImageResource(R.drawable.icon_blk_tech);
                break;

            case 1:
                iv.setImageResource(R.drawable.healthcare_icon);
                break;

            case 2:
                iv.setImageResource(R.drawable.soil_icon);
                break;
        }
    }

    public void details(View view) {
        intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("Amount", HCStock.getAmount());
        intent.putExtra("Price", HCStock.getPrice());
        intent.putExtra("Name",HCStock.getName());
        intent.putExtra("Sector", index);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }

    }
}
