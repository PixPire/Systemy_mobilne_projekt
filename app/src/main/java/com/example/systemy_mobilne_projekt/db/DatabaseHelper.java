package com.example.systemy_mobilne_projekt.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.systemy_mobilne_projekt.db.entity.DoItNote;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contact_db";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
           db.execSQL(DoItNote.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+ DoItNote.TABLE_NAME);

    onCreate(db);

    }
/*

    public long insertNote(String name, String content){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DoItNote.COLUMN_NAME, name);
        values.put(DoItNote.COLUMN_CONTENTS, content);

        long id = db.insert(DoItNote.TABLE_NAME, null, values);

        db.close();

        return id;
    }

    public DoItNote getNote(long id){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DoItNote.TABLE_NAME,
                new String[]{
                 DoItNote.COLUMN_ID,
                        DoItNote.COLUMN_NAME,
                        DoItNote.COLUMN_CONTENTS},
                        DoItNote.COLUMN_ID+"=?",
            new String[]{
                    String.valueOf(id)
            },
        null,
        null,
        null,
        null);

        if(cursor!=null)cursor.moveToFirst();

        DoItNote doItNote = new DoItNote(
              cursor.getString(cursor.getColumnIndex(DoItNote.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(DoItNote.COLUMN_CONTENTS)),
               cursor.getInt(cursor.getColumnIndex(DoItNote.COLUMN_ID))
        );
        cursor.close();
        return doItNote;

    }

    public ArrayList<DoItNote> getAllNotes(){
    ArrayList<DoItNote> notes = new ArrayList<>();

    String selectQuery = "SELECT * FROM "+DoItNote.TABLE_NAME+ " ORDER BY "+DoItNote.COLUMN_ID+" DESC";
    SQLiteDatabase db=this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);

    (cursor.moveToFirst()){
        do{
            DoItNote doItNote = new DoItNote();
            doItNote.setId(cursor.getInt());
        }
    }


    }
*/
}
