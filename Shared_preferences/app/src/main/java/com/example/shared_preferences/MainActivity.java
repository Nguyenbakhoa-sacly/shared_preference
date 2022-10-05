package com.example.shared_preferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btn_signin;
EditText edt_username,edt_pass;
CheckBox checkbox;
SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_signin = (Button) findViewById(R.id.btn_signin);
        edt_pass = (EditText) findViewById(R.id.edt_pass);
        edt_username = (EditText) findViewById(R.id.edt_username);
        checkbox = (CheckBox) findViewById(R.id.checkbox);
        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);
        edt_username.setText(sharedPreferences.getString("taikhoan",""));
        edt_pass.setText(sharedPreferences.getString("matkhau",""));
        checkbox.setChecked(sharedPreferences.getBoolean("checked",false));

        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edt_username.getText().toString();
                String pass = edt_pass.getText().toString();
                if(username.equals("khoa1") && pass.equals("123")){
                    Toast.makeText(MainActivity.this,"Dang nhap thanh cong",Toast.LENGTH_SHORT);
                    if(checkbox.isChecked()){
                        SharedPreferences .Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan",username);
                        editor.putString("matkhau",pass);
                        editor.putBoolean("checked",true);
                        editor.commit();

                    }

                }else{
                    Toast.makeText(MainActivity.this,"Loi Dang Nhap",Toast.LENGTH_SHORT);
                }
            }
        });
    }
}