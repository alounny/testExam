package com.aln.testexam;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class sqlite extends AppCompatActivity {
    Button btnsave,btnedit,btndelete;
    EditText txtid,txtname,txtemaill;
    RadioButton rb1,rb2;
    RadioGroup rg;
    mysqlite mysql= new mysqlite(this);
    SQLiteDatabase db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_data);
        db=mysql.getWritableDatabase();
        initail();
        System.out.println("===================================================================");

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gender;
                if ((rb1.isChecked()==true)){
                   gender= rb1.getText().toString();

                }else {
                   gender= rb2.getText().toString();
                }
               long l = mysql.insertData(txtid.getText().toString(),
                       txtname.getText().toString(),
                       txtemaill.getText().toString(),
               gender);
               if(l>0){
                   Toast.makeText(getApplicationContext(),"save successfully",Toast.LENGTH_LONG).show();
               }else{
                   Toast.makeText(getApplicationContext(),"save is fail ",Toast.LENGTH_LONG).show();
               }
                System.out.println("===================================================================");
            }
        });

    }
    public void initail(){
        btnsave=findViewById(R.id.btnsave);
        btnedit=findViewById(R.id.btnedit);
        btndelete=findViewById(R.id.btndelete);
        txtid=findViewById(R.id.txtid);
        txtname=findViewById(R.id.txtname);
        txtemaill=findViewById(R.id.txtemail);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
    }
}
