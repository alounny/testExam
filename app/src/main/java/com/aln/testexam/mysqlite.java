package com.aln.testexam;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public  class mysqlite extends SQLiteOpenHelper {
    private  static final String dbname="db1";
    private static   final  int dbversion=1;
//    public  mysqlite(@Nullable Context c){
//        super(c,dbname,null,1);
//    }
String create= "create table employee(id Text(10) primary key, emame Text(50), ememail Text(50),gender Text(20))";
    public mysqlite(@Nullable Context context) {
        super(context, dbname, null,dbversion );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long insertData(String id,String name,String email,String gender){
      try {
          SQLiteDatabase sdb = this.getWritableDatabase();
          String sql= "insert into employee (id,emame,ememail,gender) values(?,?,?,?)";
          SQLiteStatement stm= sdb.compileStatement(sql);
          stm.bindString(1,id);
          stm.bindString(2,name);
          stm.bindString(3,email);
          stm.bindString(4,gender);
          long l = stm.executeInsert();
          sdb.close();
          return  l;
      }catch (Exception ex){
          ex.printStackTrace();
          return -1;
      }
    }
    public String [] Selectdta(String name){
        try{
            String[] data=null;
            SQLiteDatabase db=this.getReadableDatabase();
            String sql="select * from employee where emame=?";
            String [] arr = new String[]{name};
            Cursor cur=db.rawQuery(sql,arr);
            if(cur!=null){
                if(cur.moveToFirst()){
                    data= new String[cur.getColumnCount()];
                    data[0]=cur.getString(0);
                    data[1]=cur.getString(1);
                    data[2]=cur.getString(2);
                    data[3]=cur.getString(3);

                }
                System.out.println("===========================Have data....");
            }
            db.close();
            return  data;
        }catch (Exception ex){
            ex.printStackTrace();
            return  null;
        }
    }
    public Cursor Selectdtaall(){
        try{
            SQLiteDatabase db=this.getReadableDatabase();
            String sql="select * from employee ";
            Cursor cur=db.rawQuery(sql,null);
            //db.close();

            return  cur;
        }catch (Exception ex){
            ex.printStackTrace();
            return  null;
        }
    }
    public long updatetData(String id,String name,String email,String gender){
        try {
            SQLiteDatabase sdb = this.getWritableDatabase();
            String sql= "update employee  set emame=?,ememail=?,gender=? where  id=?";
            SQLiteStatement stm= sdb.compileStatement(sql);
            stm.bindString(2,name);
            stm.bindString(3,email);
            stm.bindString(4,gender);
            stm.bindString(1,id);
            long l = stm.executeUpdateDelete();
            sdb.close();
            return  l;
        }catch (Exception ex){
            return -1;
        }
    }
    public  long deletedata(String id){
        try {
            SQLiteDatabase db=this.getWritableDatabase();
            String sql1="delete  from employee where id=? ";
            SQLiteStatement stm=db.compileStatement(sql1);
            stm.bindString(1,id);
            long l= stm.executeUpdateDelete();

            db.close();
            return l;
        }catch (Exception ex){
            return  -1;
        }
    }
}

