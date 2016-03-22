package injoin.com.webcalldashboad;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.InterpolatorRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.PercentFormatter;

import java.util.ArrayList;

/**
 * Created by danielmarques on 2/28/16.
 */
public class FirstFragment extends Fragment {

    private float[] yData = {5, 10};
    private String[] xData = {"SMS", "MMS"};

    private float[] yDataLigacoes = {40, 20, 80};
    private String[] xDataLigacoes = {"Min. Loc", "Min LD", "Min LDI"};

    private PieChart pie;
    private PieChart pie2;

    public FirstFragment(){
        // Constructor
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        BarChart chart = (BarChart) getView().findViewById(R.id.chart);
        BarData data = new BarData(getXAxisValues(), getDataSet());

        chart.setData(data);
        chart.setDescription("My Chart");
        chart.animateXY(2000, 2000);
        chart.invalidate();

        pie = (PieChart) getView().findViewById(R.id.pie);
        pie.setDescription("");
        pie.setUsePercentValues(false);
        pie.setHoleRadius(0);

        pie2 = (PieChart) getView().findViewById(R.id.pie2);
        pie2.setDescription("");
        pie2.setUsePercentValues(false);
        pie2.setHoleRadius(0);

        dataPie();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View firstView = inflater.inflate(R.layout.first_fragment, container, false);

        return firstView;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    private ArrayList<BarDataSet> getDataSet() {
        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(110.000f, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(40.000f, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(60.000f, 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(30.000f, 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(90.000f, 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(100.000f, 5); // Jun
        valueSet1.add(v1e6);

        ArrayList<BarEntry> valueSet2 = new ArrayList<>();
        BarEntry v2e1 = new BarEntry(150.000f, 0); // Jan
        valueSet2.add(v2e1);
        BarEntry v2e2 = new BarEntry(90.000f, 1); // Feb
        valueSet2.add(v2e2);
        BarEntry v2e3 = new BarEntry(120.000f, 2); // Mar
        valueSet2.add(v2e3);
        BarEntry v2e4 = new BarEntry(60.000f, 3); // Apr
        valueSet2.add(v2e4);
        BarEntry v2e5 = new BarEntry(20.000f, 4); // May
        valueSet2.add(v2e5);
        BarEntry v2e6 = new BarEntry(80.000f, 5); // Jun
        valueSet2.add(v2e6);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Brand 1");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        BarDataSet barDataSet2 = new BarDataSet(valueSet2, "Brand 2");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);
        dataSets.add(barDataSet2);
        return dataSets;
    }

    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAR");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");
        return xAxis;
    }

    private void dataPie(){

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for(int c: ColorTemplate.VORDIPLOM_COLORS)
                colors.add(c);

        // Chart 1
        ArrayList<Entry> yVals = new ArrayList<Entry>();

        for(int i = 0; i < yData.length; i++)
            yVals.add(new Entry(yData[i], i));


        ArrayList<String> xVals = new ArrayList<String>();

        for(int i = 0; i < xData.length; i++)
            xVals.add(xData[i]);


        // Create pie Dataset
        PieDataSet pieSet = new PieDataSet(yVals, "Consumo");
        pieSet.setSliceSpace(1);
        pieSet.setSelectionShift(5);

        pieSet.setColors(colors);


        // Create Data
        PieData data = new PieData(xVals, pieSet);
        data.setValueTextSize(11f);

        pie.setData(data);
        pie.invalidate();


        // Chart 2
        yVals = new ArrayList<Entry>();

        for(int i = 0; i < yDataLigacoes.length; i++)
            yVals.add(new Entry(yDataLigacoes[i], i));


        xVals = new ArrayList<String>();

        for(int i = 0; i < xDataLigacoes.length; i++)
            xVals.add(xDataLigacoes[i]);


        // Create pie Dataset
        pieSet = new PieDataSet(yVals, "Minutos");
        pieSet.setSliceSpace(1);
        pieSet.setSelectionShift(5);

        pieSet.setColors(colors);


        // Create Data
        data = new PieData(xVals, pieSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);

        pie2.setData(data);
        pie2.invalidate();
    }
}
