package com.example.kristoffer.stockmonitor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class editActivity extends Activity implements AdapterView.OnItemSelectedListener {

    Intent intent;
    //Stock HCStock;
    EditText et1;
    EditText et2;
    EditText et3;
    Spinner sc;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

      //  HCStock  = new Stock(intent.getStringExtra("Name"), intent.getIntExtra("Price", 0), intent.getIntExtra("Amount",0), intent.getStringExtra("Sector"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        intent = getIntent();
        et1 = findViewById(R.id.NameEditText);
        et2 = findViewById(R.id.PriceEditText);
        et3 = findViewById(R.id.AmountEditText);
        sc = findViewById(R.id.ScrollSpinner);

        index = intent.getIntExtra("Sector", 0);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Sectors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sc.setAdapter(adapter);
        sc.setOnItemSelectedListener(this);

       // index = sc.getSelectedItemPosition();

        switch (index){
            case 0:
                sc.setSelection(0);
                break;

            case 1:
                sc.setSelection(1);
                break;

            case 2:
                sc.setSelection(2);
                break;
        }

        et1.setText(intent.getStringExtra("Name"));

        int temp = intent.getIntExtra("Price",0);
        String tempString = String.valueOf(temp);
        et2.setText(tempString);

        int temp2 = intent.getIntExtra("Amount", 0);
        String tempString2 = String.valueOf(temp2);
        et3.setText(tempString2);
    }

    public void back(View view){
        this.finish();
    }

    public boolean hasOnlyNumbers(String s){
        boolean boo = true;
        String ss = s.toLowerCase();
        char[] forbiddenChars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
                'q','r','s','t','u','v','x','y','z','ø','æ','å','!','"','#','¤','%','/','&','(',
                ')','=','?','+','-','*','@','£','$','{','[',']','}',';',':',',','.','<','>','½',
                '§'};

        int length = s.length();

        for (int x = 0; x < length; x++ ){
            for(int y = 0; y < forbiddenChars.length; y++){
                if(s.charAt(x) == forbiddenChars[y]){
                    boo = false;
                    break;
                }
            }
        }

        return boo;
    }

    public void save(View view){
        if(et1.getText().length() < 1 ){
            et1.setError("Name is not valid");
            return;
        }

        if(et2.getText().length() < 1 || hasOnlyNumbers(et2.getText().toString()) == false){
            et2.setError("Price is not valid");
            return;
        }

        if(et3.getText().length() < 1|| hasOnlyNumbers(et3.getText().toString()) == false){
            et3.setError("Amount is not valid");
            return;
        }

        else {
            intent = new Intent( this, MainActivity.class);

            intent.putExtra("Name", et1.getText().toString());

            String temp = et2.getText().toString();
            int tempInt = Integer.parseInt(temp);
            intent.putExtra("Price", tempInt);

            String temp2 = et3.getText().toString();
            int tempInt2 = Integer.parseInt(temp2);
            intent.putExtra("Amount", tempInt2);

            intent.putExtra("Sector", index);

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            if(intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }

            this.finish();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        index = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //intent.putExtra("Sector", selectedItem);
    }
}
