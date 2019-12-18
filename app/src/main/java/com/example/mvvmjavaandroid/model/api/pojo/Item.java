package com.example.mvvmjavaandroid.model.api.pojo;

public class Item {
    public Owner owner;
    public boolean is_accepted;
    public int score;
    public long last_activity_date;
    public long creation_date;
    public long answer_id;
    public long question_id;

    @Override
    public boolean equals(Object obj) {
        return ((Item) obj).question_id == this.question_id && this.answer_id == ((Item) obj).answer_id;
    }
}