package com.appbusters.backgroundcomponents2.controller;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.appbusters.backgroundcomponents2.model.EmployeeData;

import java.util.ArrayList;
import java.util.List;

public class EmployeeLoader extends AsyncTaskLoader<List<EmployeeData>> {

    public EmployeeLoader(Context context) {
        super(context);
    }

    @Override
    public List<EmployeeData> loadInBackground() {
        List<EmployeeData> list = new ArrayList<>();
        list.add(new EmployeeData("emp1", "Robin"));
        list.add(new EmployeeData("emp2", "Shubham"));
        list.add(new EmployeeData("emp3", "Vipin"));
        return list;
    }
}
