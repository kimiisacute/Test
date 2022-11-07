package com.example.unny.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.unny.R;

public class XgdizActivity extends AppCompatActivity {
    ImageView iv_fh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xgdiz);

        iv_fh=findViewById(R.id.iv_fh);

        Button button=(Button) findViewById(R.id.qrj);
        final EditText e1=(EditText) findViewById(R.id.xgdz_ku);
        final EditText e2=(EditText) findViewById(R.id.xgdz_ku1);
        final EditText e3=(EditText) findViewById(R.id.xgdz_ku2);
        final EditText e4=(EditText) findViewById(R.id.xgdz_ku3);
        Bundle bundle=new Bundle();
        Intent i=getIntent();
        bundle=i.getExtras();
        String us=bundle.getString("u_name");
        String ps=bundle.getString("p_name");
        String ds=bundle.getString("d_name");
        String zs=bundle.getString("z_name");
        //将主activity编辑框的内容自动填写到该activity中
        e1.setText(us);
        e2.setText(ps);
        e3.setText(ds);
        e4.setText(zs);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                Bundle bundle=new Bundle();
                Intent i=getIntent();
                bundle=i.getExtras();
                //对主activity传输过来的内容进行处理，然后传递回主activity
                bundle.putCharSequence("uname", e1.getText().toString());
                bundle.putCharSequence("phone", e2.getText().toString());
                bundle.putCharSequence("di", e3.getText().toString());
                bundle.putCharSequence("zhi", e4.getText().toString());

                intent.putExtras(bundle);
                setResult(0x11,intent);
                finish();
            }
        });


        //返回上一页面
        iv_fh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                finish();
            }
        });
    }
}