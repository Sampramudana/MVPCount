package com.pramudana.sam.mvpcount.Count.Presenter;

import com.pramudana.sam.mvpcount.Base.BasePresenter;
import com.pramudana.sam.mvpcount.Count.View.CountView;

/**
 * Created by sampramudana on 10/11/18.
 */

public class CountPresenter implements BasePresenter<CountView>{

    private CountView countView;
    private double result;

    public void plus(String bil1, String bil2) {
        if (!bil1.equals("") && !bil2.equals("")) {
            result = Double.parseDouble(bil1) + Double.parseDouble(bil2);
            countView.onSuccess("Result is " + result);
        } else {
            countView.onError("Number Cannot be null");
        }
    }

    public void minus(String bil1, String bil2) {
        if (!bil1.equals("") && !bil2.equals("")) {
            result = Double.parseDouble(bil1) - Double.parseDouble(bil2);
            countView.onSuccess("Result is " + result);
        } else {
            countView.onError("Number Cannot be null");
        }
    }

    public void multiple(String bil1, String bil2) {
        if (!bil1.equals("") && !bil2.equals("")) {
            result = Double.parseDouble(bil1) * Double.parseDouble(bil2);
            countView.onSuccess("Result is " + result);
        } else {
            countView.onError("Number Cannot be null");
        }
    }

    public void divide(String bil1, String bil2) {
        if (!bil1.equals("") && !bil2.equals("")) {
            result = Double.parseDouble(bil1) / Double.parseDouble(bil2);
            countView.onSuccess("Result is " + result);
        } else {
            countView.onError("Number Cannot be null");
        }
    }

    @Override
    public void onAttach(CountView v) {
        countView = v;
    }

    @Override
    public void onDettach() {
        countView = null;
    }
}
