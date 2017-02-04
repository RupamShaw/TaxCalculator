package com.jagdiv.android.taxcalculator;

/**
 * Created by Dell on 7/05/2016.
 */
public class BarChartIncome {
     float _AnnualTax=0f;
     int _GrossAmount;
     float _AnnualSuper;
     float _AnnualTakeHome;
     float _TaxPercentage;

    public BarChartIncome(int _GrossAmount,float taxtopay){
     this._GrossAmount= _GrossAmount;
       this._AnnualSuper = _GrossAmount * 0.095f;//9.5%
        this._AnnualTax= taxtopay;
       this._AnnualTakeHome = _GrossAmount - _AnnualSuper - _AnnualTax;
        this._TaxPercentage = (_AnnualTax / _GrossAmount)*100;
    }
     enum SalaryChart {
        AnnTax,G_Amount,AnnSuper,AnnTHome;

    }

}
