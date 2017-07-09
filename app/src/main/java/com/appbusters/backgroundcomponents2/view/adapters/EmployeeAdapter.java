package com.appbusters.backgroundcomponents2.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.appbusters.backgroundcomponents2.R;
import com.appbusters.backgroundcomponents2.model.EmployeeData;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends BaseAdapter{

    private LayoutInflater inflater;
    private List<EmployeeData> employees = new ArrayList<>();

    public EmployeeAdapter(LayoutInflater inflater, List<EmployeeData> employees) {
        this.inflater = inflater;
        this.employees = employees;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        EmployeeData data = (EmployeeData) getItem(position);
        if(view == null){
            view = inflater.inflate(R.layout.employee_data, null);
        }
        TextView id = (TextView) view.findViewById(R.id.empid);
        id.setText(data.getEmpId());
        TextView name = (TextView) view.findViewById(R.id.empname);
        name.setText(data.getEmpName());
        return view;
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Object getItem(int position) {
        return employees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setEmployes(List<EmployeeData> list){
        employees.addAll(list);
        notifyDataSetChanged();
    }
}
