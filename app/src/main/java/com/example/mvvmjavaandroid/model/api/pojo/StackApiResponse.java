package com.example.mvvmjavaandroid.model.api.pojo;

import java.util.List;

public class StackApiResponse {
    public List<Item> items;
    public boolean has_more;
    public int quota_max;
    public int quota_remaining;
}