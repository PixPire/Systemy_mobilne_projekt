package com.example.systemy_mobilne_projekt.db.entity;

public class DoItNote {

    public static final String TABLE_NAME="notes";
    public static final String COLUMN_NAME="note_name";
    public static final String COLUMN_ID="note_id";
    public static final String COLUMN_CONTENTS ="note_content";

    private String name;
    private String content;
    private int id;

    public DoItNote(String name, String content, int id){
        this.name = name;
        this.content=content;
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    //CREATING THE TABLE
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("+ COLUMN_ID +"INTEGER PRIMARY KEY AUTOINCREMENT,"+ COLUMN_NAME + " TEXT,"+COLUMN_CONTENTS+" TEXT"  + ")";




}
