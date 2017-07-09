package com.appbusters.backgroundcomponents2.view.activities;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.appbusters.backgroundcomponents2.R;
import com.appbusters.backgroundcomponents2.controller.EmployeeLoader;
import com.appbusters.backgroundcomponents2.model.EmployeeData;
import com.appbusters.backgroundcomponents2.view.adapters.EmployeeAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<EmployeeData>> {

    ListView listView;
    EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        adapter = new EmployeeAdapter(this, new ArrayList<EmployeeData>());
        listView.setAdapter(adapter);
        getSupportLoaderManager().initLoader(1, null, this).forceLoad();
    }

    @Override
    public Loader<List<EmployeeData>> onCreateLoader(int id, Bundle args) {
        EmployeeLoader loader = new EmployeeLoader(this);
        List<EmployeeData> list = loader.loadInBackground();
        return new EmployeeLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<EmployeeData>> loader, List<EmployeeData> data) {
        adapter.setEmployes(data);
    }

    @Override
    public void onLoaderReset(Loader<List<EmployeeData>> loader) {
        adapter.setEmployes(new ArrayList<EmployeeData>());
    }
}
