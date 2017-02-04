package com.jagdiv.android.taxcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity // implements        AdapterView.OnItemSelectedListener
        {

    protected EditText editTextIncome;
    protected TextView textViewTax;
    protected Button submitBtn;
    protected Spinner spinnerResidentType;
    private BarChart barChart;
    private PieChart pieChart;

    int income=0;

    float taxToPay=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editTextIncome = (EditText) findViewById(R.id.editTextIncome);
        textViewTax = (TextView) findViewById(R.id.textViewTax);
       // submitBtn = (Button) findViewById(R.id.submitButton);
        barChart = (BarChart) findViewById(R.id.barchart);
        pieChart = (PieChart) findViewById(R.id.piechart);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        addKeyListenerEditTextIncome();
        int index = 0;
        String[] residentType = new String[AustraliaTax.ResidentType.values().length];
         for (AustraliaTax.ResidentType states :  AustraliaTax.ResidentType.values()) {
            residentType[index++] = states.name();
        }

       // for java8 getting  enum.values() to string array
       // Stream.of(AustraliaTax.ResidentType.values()).map(AustraliaTax.ResidentType::name).toArray(String[]::new);

         spinnerResidentType = (Spinner) findViewById(R.id.spinnerResidentType);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, residentType);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerResidentType.setAdapter(adapter);
       // spinnerResidentType.setOnItemSelectedListener(this);
    }
    public void addKeyListenerEditTextIncome() {

        // get edittext component
      //  edittext = (EditText) findViewById(R.id.editText);

        // add a keylistener to keep track user input
        editTextIncome.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                // if keydown and "enter" is pressed
                if ((event.getAction() == KeyEvent.ACTION_DOWN)
                        && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    submitData();
                    // display a floating message
                    //  Toast.makeText(MyAndroidAppActivity.this,
                    //        edittext.getText(), Toast.LENGTH_LONG).show();
                    return true;

                } /*else if ((event.getAction() == KeyEvent.ACTION_DOWN)                        && (keyCode == KeyEvent.KEYCODE_9)) {

                    // display a floating message
                    //   Toast.makeText(MyAndroidAppActivity.this,
                    //         "Number 9 is pressed!", Toast.LENGTH_LONG).show();
                    return true;
                }*/

                return false;
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

  ///  public void submitButtonClicked(View view) {
        public void submitData() {
        String txtIncome = editTextIncome.getText().toString();
            String txtResidentType = spinnerResidentType.getSelectedItem().toString();

        if (txtIncome != null) {
            txtIncome = txtIncome.trim();
            if (txtIncome.equals("0") || txtIncome.equals("")) {
                Toast.makeText(this, "Please Enter Gross Salary", Toast.LENGTH_SHORT).show();
            } else {
                income=Integer.parseInt(txtIncome);
               taxToPay= AustraliaTax.Wealth.getWealth(income,txtResidentType);
                textViewTax.setText(taxToPay + "");
                barchart();
                piechart();

            }
        } else {
            Toast.makeText(this, "Please Enter Gross Salary", Toast.LENGTH_SHORT).show();
        }
    }

  /*  public void cancelButtonClicked(View view) {
      editTextIncome.setText("");
        textViewTax.setText( "");
    }*/
//    public void barchartButtonClicked(View view) {
        public void barchart( ) {

            // LinearLayout  chartLayout =(LinearLayout) findViewById(R.id.linearLayoutChart);
        System.out.print("barchartButtonClicked");

      //  barChart.addView(barchart);
        ArrayList<BarEntry> entries = new ArrayList<>();

        BarChartIncome incomeChart=new BarChartIncome(income,taxToPay);
        entries.add(new BarEntry(incomeChart._AnnualTax, 0));
        entries.add(new BarEntry(incomeChart._GrossAmount, 1));
        entries.add(new BarEntry(incomeChart._AnnualSuper, 2));
        entries.add(new BarEntry(incomeChart._AnnualTakeHome, 3));
     //   entries.add(new BarEntry(incomeChart._TaxPercentage, 4));
        System.out.print("barchartButtonClicked incomeChart ");
        BarDataSet dataset = new BarDataSet(entries, "salary divides");
        ArrayList<String> labels = new ArrayList<String>();
        for (BarChartIncome.SalaryChart w :BarChartIncome.SalaryChart.values()){
            System.out.print("Name" +w.name());
                   labels.add(w.name());
        }
        System.out.print("barchartButtonClicked label filled ");
        BarData data = new BarData(labels, dataset);
        barChart.refreshDrawableState();

        barChart.setData(data);
        barChart.setDescription("Income Splitted");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        System.out.print("barchartButtonClicked ends ");
        barChart.animateXY(2000, 2000);
        barChart.invalidate();
    }
   // public void piechartButtonClicked(View view) {
   public void piechart() {

       // LinearLayout  chartLayout =(LinearLayout) findViewById(R.id.linearLayoutChart);
        System.out.print("piechartButtonClicked");

        //  barChart.addView(barchart);
        ArrayList<Entry> entries = new ArrayList<>();

        PieChartIncome incomeChart=new PieChartIncome(income,taxToPay);
        //entries.add(new Entry(incomeChart._AnnualTax, 0));
       // entries.add(new Entry(incomeChart._GrossAmount, 1));
        entries.add(new Entry(incomeChart._Super, 0));
        entries.add(new Entry(incomeChart._TakeHome, 1));
        entries.add(new Entry(incomeChart._Tax,2));
        System.out.print("barchartButtonClicked incomeChart ");

        PieDataSet dataset = new PieDataSet(entries, "salary percentage%");

        ArrayList<String> labels = new ArrayList<String>();
        for (PieChartIncome.SalaryChart w :PieChartIncome.SalaryChart.values()){
            System.out.print("Name" +w.name());
            labels.add(w.name());
        }
       //     labels.add(PieChartIncome.SalaryChart.Super);
        //labels.add(PieChartIncome.SalaryChart.Takehome);
        //labels.add(PieChartIncome.SalaryChart.Tax);
                //}
                System.out.print("barchartButtonClicked label filled ");

        PieData data = new PieData(labels, dataset);
        pieChart.refreshDrawableState();
        pieChart.setData(data);
        pieChart.setDescription("Income Splitted");
        dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        System.out.print("barchartButtonClicked ends ");
        pieChart.animateXY(2000, 2000);
        pieChart.invalidate();
    }


}
