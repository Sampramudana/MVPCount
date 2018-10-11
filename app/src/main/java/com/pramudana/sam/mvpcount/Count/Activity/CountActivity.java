package com.pramudana.sam.mvpcount.Count.Activity;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pramudana.sam.mvpcount.Count.Presenter.CountPresenter;
import com.pramudana.sam.mvpcount.Count.View.CountView;
import com.pramudana.sam.mvpcount.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CountActivity extends AppCompatActivity implements CountView {

    Button btnPlus, btnMin, btnMultiple, btnDiv, btnClear;
    TextInputEditText edtBilPertama, edtBilKedua;

    private CountPresenter presenter;
    String bilangansatu, bilangandua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnPlus = findViewById(R.id.btnPlus);
        btnMin = findViewById(R.id.btnMin);
        btnMultiple = findViewById(R.id.btnMultiple);
        btnDiv = findViewById(R.id.btnDiv);
        btnClear = findViewById(R.id.btnClear);
        edtBilPertama = findViewById(R.id.edtBilPertama);
        edtBilKedua = findViewById(R.id.edtBilKedua);


        presenter = new CountPresenter();
        onAttachView();

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bilangansatu = edtBilPertama.getText().toString();
                bilangandua = edtBilKedua.getText().toString();

                presenter.plus(bilangansatu, bilangandua);
            }
        });

        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.minus(bilangansatu, bilangandua);
            }
        });

        btnMultiple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.multiple(bilangansatu, bilangandua);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.divide(bilangansatu, bilangandua);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                edtBilPertama.setText("");
                edtBilKedua.setText("");
                edtBilPertama.requestFocus();

            }
        });
    }

    public void onAttachView() {
        presenter.onAttach(this);
    }

    @Override
    public void onDettachView() {

    }

    @Override
    public void onSuccess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        Log.e("Result = ", result);
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        Log.e("Result: ", msg);
    }
}
