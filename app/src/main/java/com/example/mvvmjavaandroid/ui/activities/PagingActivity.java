package com.example.mvvmjavaandroid.ui.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvvmjavaandroid.R;
import com.example.mvvmjavaandroid.model.api.StackRetrofitClient;
import com.example.mvvmjavaandroid.model.api.pojo.Item;
import com.example.mvvmjavaandroid.model.api.pojo.StackApiResponse;
import com.example.mvvmjavaandroid.ui.adapter.AnswerPagerAdapter;
import com.example.mvvmjavaandroid.viewmodel.ItemViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PagingActivity extends AppCompatActivity {

    //getting recyclerview
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);


        //setting up recyclerview
        recyclerView = findViewById(R.id.rv_answers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //getting our ItemViewModel
        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);

        //creating the Adapter
        final AnswerPagerAdapter adapter = new AnswerPagerAdapter(this);


        //observing the itemPagedList from view model
        itemViewModel.itemPagedList.observe(this, new Observer<PagedList<Item>>() {
            @Override
            public void onChanged(@Nullable PagedList<Item> items) {

                //in case of any changes
                //submitting the items to adapter
                adapter.submitList(items);
            }
        });

        //setting the adapter
        recyclerView.setAdapter(adapter);
    }
}
