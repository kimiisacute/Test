package com.example.unny.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.unny.R;
import com.example.unny.util.OrderDBService;

public class OrderSuccessActivity extends AppCompatActivity {

    ImageView tv_back_order;
    Button bu_orderdetail,bu_orderlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        tv_back_order=findViewById(R.id.tv_back_order);
        bu_orderdetail=findViewById(R.id.bu_orderdetail);
        bu_orderlist=findViewById(R.id.bu_orderlist);

        tv_back_order.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v) {

                finish();
            }
        });

    }
}