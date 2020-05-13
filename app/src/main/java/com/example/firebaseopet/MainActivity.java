package com.example.firebaseopet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.security.PrivilegedAction;

public class MainActivity extends AppCompatActivity {

    private EditText editLogin, editSenha;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLogin = findViewById(R.id.editLogin);
        editSenha = findViewById(R.id.editSenha);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser){
        if (currentUser != null){
            Intent dashboard = new Intent(MainActivity.this,DashActivity.class);
            startActivity(dashboard);
            finish();
        }
    }

    public void entrar(View view){
        String login = editLogin.getText().toString();
        String senha = editSenha.getText().toString();

        mAuth.signInWithEmailAndPassword(login,senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser user =mAuth.getCurrentUser();
                    updateUI(user);
                }else{
                    Toast.makeText(MainActivity.this,"Falha ao Autenticar.",Toast.LENGTH_SHORT);
                    updateUI(null);
                }
            }
        });
    }
}
