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

public class CreateUserActivity extends AppCompatActivity {
    private EditText editLogin, editSenha;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        editLogin = findViewById(R.id.editLogin);
        editSenha = findViewById((R.id.editSenha));

        mAuth = FirebaseAuth.getInstance();
    }

    public void registrar(View view) {
        String login = editLogin.getText().toString();
        String senha = editSenha.getText().toString();

        mAuth.createUserWithEmailAndPassword(login,senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser user =mAuth.getCurrentUser();
                            updateUI(user);
                        }else{
                            Toast.makeText(CreateUserActivity.this,"Falha ao criar novo usuário.",Toast.LENGTH_SHORT);
                            updateUI(null);
                        }
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        if (user != null){
            Intent dashboard = new Intent(CreateUserActivity.this,DashActivity.class);
            startActivity(dashboard);
            finish();
        }
    }
}
