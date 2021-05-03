package com.example.vizi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.charts.Map;
import com.anychart.core.map.series.Choropleth;
import com.anychart.core.ui.ColorRange;
import com.anychart.enums.SelectionMode;
import com.anychart.enums.SidePosition;
import com.anychart.scales.LinearColor;
import com.google.android.material.slider.Slider;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class GoogleMobility extends AppCompatActivity {
    JSONObject json, jsonMonth;
    String year;
    TextView subTitle;
    Slider yearSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_one);

        subTitle = findViewById(R.id.sub_title);
        subTitle.setText(R.string.mobility);

        String[] yearList = getResources().getStringArray(R.array.year_values_xml);
        yearSlider = findViewById(R.id.year_slider);
        yearSlider.setLabelFormatter(value -> {
            return yearList[(int) value];
        });
        year = yearList[(int) yearSlider.getValue()];

        AnyChartView anyChartView = findViewById(R.id.any_chart_view);
        Map map = AnyChart.map();
        map.geoData(SharedHelper.loadJSONFromAsset(this, "vietnam_cleaned.json"));

        ColorRange colorRange = map.colorRange();
        colorRange.enabled(true)
                .colorLineSize(10)
                .stroke("#B9B9B9")
                .labels("{ 'padding': 3 }")
                .labels("{ 'size': 7 }");
        colorRange.ticks()
                .enabled(true)
                .stroke("#B9B9B9")
                .position(SidePosition.OUTSIDE)
                .length(10);
        colorRange.minorTicks()
                .enabled(true)
                .stroke("#B9B9B9")
                .position("outside")
                .length(5);

        map.animation(true);
        map.interactivity().selectionMode(SelectionMode.NONE);
        map.padding(0, 0, 0, 0);
        map.margin()
                .right(125d);

        json = SharedHelper.getJSON(this, "mobility_monthly.json");
        try {
            jsonMonth = json.getJSONObject(year);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Choropleth series = map.choropleth(SharedHelper.getData(this, jsonMonth));
        LinearColor linearColor = LinearColor.instantiate();
        linearColor.colors(new String[]{"#ef476f", "#f66c85", "#ffaab4", "#ffc6cc", "#ffe3e5",
                                        "#f3f3f3", "#97bed3", "#118ab2"});
        series.colorScale(linearColor);
        series.selected()
                .fill(String.format("#%06x", ContextCompat.getColor(this,
                        R.color.primary_red) & 0xffffff))
                .stroke("#efefef");
        series.tooltip()
                .useHtml(true)
                .format("function() {\n" +
                        "            return '<span style=\"font-size: 13px\">' + this.value + ' Mean Mobility Change</span>';\n" +
                        "          }");

        anyChartView.addScript(SharedHelper.loadJSONFromAsset(this, "vietnam.js"));
        anyChartView.addScript(SharedHelper.loadJSONFromAsset(this, "proj4.js"));
        anyChartView.setChart(map);

        yearSlider.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {

            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider) {
                year = yearList[(int) slider.getValue()];
                try {
                    jsonMonth = json.getJSONObject(year);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                series.data(SharedHelper.getData(GoogleMobility.this, jsonMonth));
            }
        });

    }

}