package com.zxyoyo.apk.testlocal;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.zxyoyo.apk.zzlibrary.DensityUtils;
import com.zxyoyo.apk.zzlibrary.FormFragment;
import com.zxyoyo.apk.zzlibrary.zview.ZzPieChar;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ZzPieChar pieChart = findViewById(R.id.pie_chart);
        pieChart.setRadius(DensityUtils.dp2px(this, 75));
        pieChart.setOnItemClickListener(new ZzPieChar.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });
        List<ZzPieChar.ZzPieCharEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new ZzPieChar.ZzPieCharEntry(1, Color.RED, true));
        pieEntries.add(new ZzPieChar.ZzPieCharEntry(2, Color.GREEN, false));
        pieEntries.add(new ZzPieChar.ZzPieCharEntry(3, Color.BLUE, false));

        pieChart.setPieEntries(pieEntries);
    }
}
