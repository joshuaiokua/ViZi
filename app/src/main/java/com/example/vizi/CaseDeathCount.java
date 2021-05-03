package com.example.vizi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.widget.TextView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Column;
import com.anychart.enums.Anchor;
import com.anychart.enums.Position;
import com.anychart.APIlib;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CaseDeathCount extends AppCompatActivity {
    TextView titleHeader, subTitle;
    JSONObject json, jsonCases, jsonDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_two);

        // Load Data
        json = SharedHelper.getJSON(this, "covid.json");
        try {
            jsonCases = json.getJSONObject("Case Count");
            jsonDeaths = json.getJSONObject("Death Count");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Instatiate Objects
        titleHeader = findViewById(R.id.title);

        List<DataEntry> dataCases = new ArrayList<>();
        List<DataEntry> dataDeaths = new ArrayList<>();

        Iterator<String> keys = jsonCases.keys();
        for (Iterator<String> it = keys; it.hasNext(); ) {
            String i = it.next();
            try {
                dataCases.add(new ValueDataEntry(i, jsonCases.getDouble(i)));
                dataDeaths.add(new ValueDataEntry(i, jsonDeaths.getDouble(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        // Cases Chart Formatting
        AnyChartView anyChartViewOne = findViewById(R.id.any_chart_view_1);
        APIlib.getInstance().setActiveAnyChartView(anyChartViewOne);

        Cartesian cartesianCases = AnyChart.column();
        Column columnCases = cartesianCases.column(dataCases);
        columnCases.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("{%Value}");

        cartesianCases.title(false);
        cartesianCases.animation(true);
        cartesianCases.isVertical(true);
        cartesianCases.xScale().inverted(true);
        cartesianCases.xAxis(0)
                .labels(false)
                .ticks(false);
        cartesianCases.yAxis(0)
                 .orientation("top")
                 .ticks().position("inside");
        columnCases.color(String.format("#%06x", ContextCompat.getColor(this,
                R.color.primary_blue) & 0xffffff));

        anyChartViewOne.setChart(cartesianCases);

        // Deaths Chart Formatting
        AnyChartView anyChartViewTwo = findViewById(R.id.any_chart_view_2);
        APIlib.getInstance().setActiveAnyChartView(anyChartViewTwo);
        Cartesian cartesianDeaths = AnyChart.column();
        Column columnDeaths = cartesianDeaths.column(dataDeaths);
        columnDeaths.tooltip()
                .titleFormat("{%X}")
                .position(Position.CENTER_BOTTOM)
                .anchor(Anchor.CENTER_BOTTOM)
                .offsetX(0d)
                .offsetY(5d)
                .format("{%Value}");

        cartesianDeaths.title(false);
        cartesianDeaths.animation(true);
        cartesianDeaths.isVertical(true);
        cartesianDeaths.xScale().inverted(true);
        cartesianDeaths.xAxis(0)
                .labels(false)
                .ticks(false);
        cartesianDeaths.yAxis(0)
                .orientation("top")
                .ticks().position("inside");
        columnDeaths.color(String.format("#%06x", ContextCompat.getColor(this,
                R.color.primary_red) & 0xffffff));

        anyChartViewTwo.setChart(cartesianDeaths);


    }


}