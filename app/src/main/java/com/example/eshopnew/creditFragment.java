package com.example.eshopnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class creditFragment extends AppCompatActivity {
    EditText CardNumber,CardName,ExpiryDate,CVV;
    Button submitcredit;
    CreditPay CreditPay;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_fragment);
        //TextView txt=(TextView) vw.findViewById(R.id.txt);
        CardNumber=(EditText) findViewById(R.id.cardnumber);
        CardName=(EditText) findViewById(R.id.cardname);
        ExpiryDate=(EditText) findViewById(R.id.expdate);
        CVV=(EditText) findViewById(R.id.cvv);

        submitcredit=(Button)findViewById(R.id.submitcreditbutton);

        reff= FirebaseDatabase.getInstance().getReference().child("CreditPay");
        CreditPay=new CreditPay();
        submitcredit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cardnum = CardNumber.getText().toString();
                String cardname = CardName.getText().toString();
                String expdate = ExpiryDate.getText().toString();
                String cardcvv = CVV.getText().toString();
                Intent intent=new Intent(creditFragment.this, MainActivity.class);
                startActivity(intent);

                if(TextUtils.isEmpty(cardnum))
                {
                    Toast.makeText(getApplicationContext(), "Please enter Card Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(cardname))
                {
                    Toast.makeText(getApplicationContext(),"Please enter Name on Card",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(expdate))
                {
                    Toast.makeText(getApplicationContext(),"Please enter Expiry Date on Card",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(cardcvv))
                {
                    Toast.makeText(getApplicationContext(),"Please enter CVV Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    CreditPay.setCardNumber(CardNumber.getText().toString().trim());
                    CreditPay.setCardName(CardName.getText().toString().trim());
                    CreditPay.setExpiryDate(ExpiryDate.getText().toString().trim());
                    CreditPay.setCVV(CVV.getText().toString().trim());
                    reff.push().setValue(CreditPay);
                    Toast.makeText(getApplicationContext(),"Data inserted Successfully",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}