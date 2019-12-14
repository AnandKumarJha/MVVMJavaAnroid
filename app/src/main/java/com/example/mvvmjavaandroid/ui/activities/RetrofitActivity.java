package com.example.mvvmjavaandroid.ui.activities;

import android.os.Bundle;
import android.view.View;

import com.example.mvvmjavaandroid.R;
import com.example.mvvmjavaandroid.databinding.ActivityRetrofitBinding;
import com.example.mvvmjavaandroid.model.api.pojo.Employee;
import com.example.mvvmjavaandroid.ui.adapter.EmployeeDataAdapter;
import com.example.mvvmjavaandroid.viewmodel.EmployeeViewModel;
import com.facebook.shimmer.ShimmerFrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class RetrofitActivity extends AppCompatActivity {
    private EmployeeViewModel employeeViewModel;
    private EmployeeDataAdapter employeeDataAdapter;
    private ShimmerFrameLayout mShimmerViewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRetrofitBinding activityRetrofitBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_retrofit);

        mShimmerViewContainer = activityRetrofitBinding.shimmerViewContainer;
        mShimmerViewContainer.startShimmer();
        // bind RecyclerView
        RecyclerView recyclerView = activityRetrofitBinding.rvEmployees;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        employeeViewModel = ViewModelProviders.of(this).get(EmployeeViewModel.class);
        employeeDataAdapter = new EmployeeDataAdapter();
        recyclerView.setAdapter(employeeDataAdapter);
        getAllEmployee();
    }

    private void getAllEmployee() {
        employeeViewModel.getAllEmployee().observe(this, new Observer<List<Employee>>() {
            @Override
            public void onChanged(@Nullable List<Employee> employees) {
                mShimmerViewContainer.stopShimmer();
                mShimmerViewContainer.setVisibility(View.GONE);
                employeeDataAdapter.setEmployeeList((ArrayList<Employee>) employees);
            }
        });
    }
}