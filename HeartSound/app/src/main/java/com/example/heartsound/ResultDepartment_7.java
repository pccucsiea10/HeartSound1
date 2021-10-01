package com.example.heartsound;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;

public class ResultDepartment_7 extends Fragment {
    public static ArrayList<Entry> enties = new ArrayList<Entry>();
    private View mainView;
    private TextView tital_startnormal;
    LineChartData_7 lineChartData;
    LineChart lineChart;
    ArrayList<String> xData = new ArrayList<>();
    ArrayList<Entry> yData = new ArrayList<>();





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        mainView = inflater.inflate(R.layout.result_department_7, container, false);

        tital_startnormal = mainView.findViewById(R.id.First);

        lineChart = mainView.findViewById(R.id.lineChart);
        lineChartData = new LineChartData_7(lineChart,this);

//            RequestParams params = new RequestParams();

//        ElasticRestClient.get("hh2/_search?q=name:張", params, new JsonHttpResponseHandler());


//        ElasticRestClient.get("hh2/_search?q=name:張&size=100", params, new JsonHttpResponseHandler());

//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        for(int i = 0;i<enties.size();i++){
            xData.add("" + i );
        }

        lineChartData.initX(xData);
        lineChartData.initY(50F,150F);

        lineChartData.initDataSet(enties);



        return mainView;
    }

}
