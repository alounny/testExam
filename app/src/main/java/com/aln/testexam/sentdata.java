package com.aln.testexam;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class sentdata extends AppCompatActivity {
    TextView tvId,tvname,tvemail,tvgender;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sentdata);
        Bundle bd = getIntent().getExtras();
        tvId=findViewById(R.id.tvID);
        tvname=findViewById(R.id.tvname);
        tvemail=findViewById(R.id.tvemail);
        tvgender=findViewById(R.id.tvgender);
        tvId.setText(bd.getString("id"));
        tvname.setText(bd.getString("name"));
        tvemail.setText(bd.getString("email"));
        tvgender.setText(bd.getString("radio"));
    }
}
