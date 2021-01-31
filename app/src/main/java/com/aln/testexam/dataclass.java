package com.aln.testexam;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class dataclass extends AppCompatActivity {
    Button tbnsave,btnEdit,btndelete,tbnsave1,btnEdit1,btndelete1,btnsendata,btnsearch,btnshowall;
    EditText txtId,txtname,txtemail;
    RadioGroup rbg1;
    RadioButton rb1,rb2;
    mysqlite mysql= new mysqlite(this);
    SQLiteDatabase db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.layout_data);
        db=mysql.getWritableDatabase();
       txtId=findViewById(R.id.txtid);
       txtname=findViewById(R.id.txtname);
       txtemail=findViewById(R.id.txtemail);
       btnEdit=findViewById(R.id.btnedit);
       btnEdit1=findViewById(R.id.btnedit1);
       btndelete=findViewById(R.id.btndelete);
       btndelete1=findViewById(R.id.btndelete1);
       tbnsave=findViewById(R.id.btnsave);
       tbnsave1=findViewById(R.id.btnsave1);
       btnsendata=findViewById(R.id.btnsentdata);
       rb1=findViewById(R.id.rb1);
       rb2=findViewById(R.id.rb2);
       btnsearch=findViewById(R.id.btnsearch);
       btnshowall=findViewById(R.id.btnshowall);
       btnsearch.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String [] data=mysql.Selectdta(txtname.getText().toString());
               if(data!=null){
                   txtId.setText(data[0]);
                   txtname.setText(data[1]);
                   txtemail.setText(data[2]);
                  if(data[3]=="male"){
                      rb1.isChecked();

                  }else {
                      rb2.isChecked();
                  }
               }else{
                   Toast.makeText(getApplicationContext(),"don have data",Toast.LENGTH_LONG).show();
               }
           }
       });
       btnshowall.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent it2= new Intent(dataclass.this,liteview.class);
               startActivity(it2);
           }
       });
        tbnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gender;
                if ((rb1.isChecked()==true)){
                    gender= rb1.getText().toString();

                }else {
                    gender= rb2.getText().toString();
                }
                long l = mysql.insertData(txtId.getText().toString(),
                        txtname.getText().toString(),
                        txtemail.getText().toString(),
                        gender);
                if(l>0){
                    Toast.makeText(getApplicationContext(),"save successfully",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"save is fail ",Toast.LENGTH_LONG).show();
                }
                System.out.println("===================================================================");
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gender;
                if ((rb1.isChecked()==true)){
                    gender= rb1.getText().toString();

                }else {
                    gender= rb2.getText().toString();
                }
                long l = mysql.updatetData(
                        txtname.getText().toString(),
                        txtemail.getText().toString(),gender,
                        txtId.getText().toString()
                        );
                if(l>0){
                    Toast.makeText(getApplicationContext(),"edit successfully",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"edit is fail ",Toast.LENGTH_LONG).show();
                }
                System.out.println("===================================================================");
            }
        });
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gender;
                if ((rb1.isChecked()==true)){
                    gender= rb1.getText().toString();

                }else {
                    gender= rb2.getText().toString();
                }
                long l = mysql.deletedata(
                        txtId.getText().toString());
                if(l>0){
                    Toast.makeText(getApplicationContext(),"delete successfully",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"delete is fail ",Toast.LENGTH_LONG).show();
                }
                System.out.println("===================================================================");
            }
        });


       btnsendata.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent it1 = new Intent(dataclass.this,sentdata.class);
               it1.putExtra("id",txtId.getText().toString());
               it1.putExtra("name",txtname.getText().toString());
               it1.putExtra("email",txtemail.getText().toString());
               if (rb1.isChecked()){
                   it1.putExtra("radio",rb1.getText().toString());
               }else{
                   it1.putExtra("radio",rb2.getText().toString());
               }
               startActivity(it1);

           }
       });

    }
}
