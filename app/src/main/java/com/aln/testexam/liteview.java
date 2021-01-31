package com.aln.testexam;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class liteview extends AppCompatActivity {
    ListView lv1;
    mysqlite mysql1= new mysqlite(this);
    SQLiteDatabase db;
    Cursor cur1;
    ArrayList<String> arl=new ArrayList<>();
//   String[] at={"tt","rt","tr"};
    ArrayAdapter alat;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liteview);

        lv1=findViewById(R.id.lv1);
        db=mysql1.getReadableDatabase();
        cur1=mysql1.Selectdtaall();
        arl.clear();

        if(cur1!=null){
            while (cur1.moveToNext()){
                arl.add(cur1.getString(1));
            }
        }
        cur1.close();
        db.close();

        alat=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,arl) ;
        lv1.setAdapter(alat);
    }
}
