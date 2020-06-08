package com.example.grupodeestudos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {

    Button btn_register, btn_login;
    FirebaseUser firebaseUser;



    //Start
    @Override
    protected void onStart() {
        super.onStart();

        //Recebe o usuário que está logado
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();


        if(firebaseUser != null){
            //Está logado
            Intent intent = new Intent(StartActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);





        //Atribuições
        btn_register = findViewById(R.id.btn_register);
        btn_login = findViewById(R.id.btn_login);

        //Redireciona para tela de login
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));

            }
        });

        //Redireciona para tela de cadastro
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));

            }
        });
    }
}
