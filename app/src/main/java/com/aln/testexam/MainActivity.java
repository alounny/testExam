package com.aln.testexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 Button btnlobin,btncancel,btnnew;
 EditText txtpassword, txtname;
 TextView tvpass,tvname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtpassword=findViewById(R.id.txtpassword);
        txtname=findViewById(R.id.txtname);
        btnlobin=findViewById(R.id.btnLogin);
        btnnew=findViewById(R.id.btnnew);
        btncancel=findViewById(R.id.btncancel);
        btnlobin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View vw = View.inflate(MainActivity.this, R.layout.showalerd,null);
                AlertDialog.Builder al1 = new AlertDialog.Builder(MainActivity.this);
                tvpass= vw.findViewById(R.id.tvpassword);
                tvname= vw.findViewById(R.id.tvname);
                tvpass.setText(txtpassword.getText());
                tvname.setText(txtname.getText());
                al1.setView(vw);
                al1.show();
            }
        });
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        btnnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(MainActivity.this,dataclass.class);
                startActivity(it);
            }
        });
    }
}
