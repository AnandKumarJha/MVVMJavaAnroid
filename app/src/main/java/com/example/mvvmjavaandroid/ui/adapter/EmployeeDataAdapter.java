package com.example.mvvmjavaandroid.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmjavaandroid.R;
import com.example.mvvmjavaandroid.databinding.RowEmpBinding;
import com.example.mvvmjavaandroid.model.api.pojo.Employee;

public class EmployeeDataAdapter
        extends RecyclerView.Adapter<EmployeeDataAdapter.EmployeeViewHolder> {

    private ArrayList<Employee> employees;

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        RowEmpBinding employeeListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.row_emp, viewGroup, false);
        return new EmployeeViewHolder(employeeListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder employeeViewHolder, int i) {
        Employee currentStudent = employees.get(i);
        employeeViewHolder.employeeListItemBinding.setEmployee(currentStudent);
    }

    @Override
    public int getItemCount() {
        if (employees != null) {
            return employees.size();
        } else {
            return 0;
        }
    }

    public void setEmployeeList(ArrayList<Employee> employees) {
        this.employees = employees;
        notifyDataSetChanged();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private RowEmpBinding employeeListItemBinding;

        public EmployeeViewHolder(@NonNull RowEmpBinding employeetListItemBinding) {
            super(employeetListItemBinding.getRoot());

            this.employeeListItemBinding = employeetListItemBinding;
        }
    }
}
