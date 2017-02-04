package com.jagdiv.android.taxcalculator;

/**
 * Created by Dell on 9/05/2016.
 */
public class PieChartIncome {

    float _Super;
    float _TakeHome;
    float _Tax;
    public PieChartIncome(int _GrossAmount,float taxtopay){

        this._Super =0.095f*100;;//9.5%

        this._TakeHome = ((_GrossAmount - _Super - taxtopay )/ _GrossAmount)*100;
        this._Tax = (taxtopay / _GrossAmount)*100;
    }
    enum SalaryChart {
        Super,Takehome,Tax;

    }
}
