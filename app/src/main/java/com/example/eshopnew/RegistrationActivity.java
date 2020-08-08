package com.example.eshopnew;



import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {


    private EditText fNameEd,lNameEd,emailAddEd,passEd,confirmpassword;

    private Button joinBtn;

    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        fNameEd=(EditText) findViewById(R.id.firsteditText);
        lNameEd=(EditText) findViewById(R.id.lasteditText);
        emailAddEd=(EditText) findViewById(R.id.EmaileditText);
        passEd=(EditText) findViewById(R.id.passwordeditText);
        joinBtn=(Button) findViewById(R.id.joinbtn);

        confirmpassword=(EditText)findViewById(R.id.confirmpasswordeditText);



        firebaseAuth= FirebaseAuth.getInstance();

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstname = fNameEd.getText().toString().trim();
                String lastname = lNameEd.getText().toString().trim();

                String email = emailAddEd.getText().toString().trim();

                String password = passEd.getText().toString().trim();

                String confrmPasword= confirmpassword.getText().toString().trim();



                if(TextUtils.isEmpty(firstname))
                {
                    Toast.makeText(RegistrationActivity.this,"Please enter first name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(lastname))
                {
                    Toast.makeText(RegistrationActivity.this,"Please enter last name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(email))
                {
                    Toast.makeText(RegistrationActivity.this,"Please enter email name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password))
                {
                    Toast.makeText(RegistrationActivity.this,"Please enter password name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(confrmPasword))
                {
                    Toast.makeText(RegistrationActivity.this,"Please enter confirm password name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length()<6)
                {
                    Toast.makeText(RegistrationActivity.this,"PASWORD IS TOO SHORT", Toast.LENGTH_SHORT).show();
                }

                if (password.equals(confrmPasword))
                {
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {


                                                    startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                                                    Toast.makeText(RegistrationActivity.this, "Registation Complete.please check your email for verification", Toast.LENGTH_SHORT).show();
                                                }
                                                else {
                                                    Toast.makeText(RegistrationActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                                                }
                                            }
                                        });


                                    } else {

                                        Toast.makeText(RegistrationActivity.this,"Authentication Failed", Toast.LENGTH_SHORT).show();

                                    }

                                    // ...
                                }
                            });
                }
                else {
                    Toast.makeText(RegistrationActivity.this,"pasword dose not match", Toast.LENGTH_SHORT).show();
                }


            }


        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.back, menu);
            return true;

        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.back:
                DOo();
                Toast.makeText(this,"SigOut Sucessfully",Toast.LENGTH_SHORT);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void DOo()
    {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
