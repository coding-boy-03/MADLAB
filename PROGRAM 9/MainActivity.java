
package com.example.a10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    
EditText emailEditText,passwordEditText;
Button signUpBtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        emailEditText = findViewById(R.id.editTextTextEmailAddress);
        passwordEditText = findViewById(R.id.editTextTextPassword);
        signUpBtn = findViewById(R.id.button);
        
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                
                if(!isValidPassword(password)){
                    Toast.makeText(MainActivity.this,"Password Does Not Match the Rules",Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this,loginPage.class);
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
    }
    
    Pattern lowercase = Pattern.compile("^.*[a-z].*$");
    Pattern uppercase = Pattern.compile("^.*[A-Z].*$");
    Pattern number = Pattern.compile("^.*[0-9].*$");
    Pattern specialCharacter = Pattern.compile("^.*[^a-zA-Z0-9].*$");
    
    private Boolean isValidPassword(String password){
        if(password.length()<8){
            return false;
        }
        if(!lowercase.matcher(password).matches()){
            return false;
        }
        if(!uppercase.matcher(password).matches()){
            return false;
        }
        if(!number.matcher(password).matches()){
            return false;
        }
        if(!specialCharacter.matcher(password).matches()){
            return false;
        }
        return true;
    }
}
