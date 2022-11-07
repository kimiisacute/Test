package com.example.unny.framgement;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.unny.R;
import com.example.unny.activity.GrzxActivity;
import com.example.unny.activity.GuaActivity;

/**
 * 分类
 */
public class FenLeiFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_fen_lei, container, false);
        ImageView iv_xigua,iv_mugua,iv_xianggua,iv_xiyou,iv_chengzi,iv_juzi,iv_putao,iv_ci,iv_mihoutao,iv_lizi,iv_taozi,iv_xingzi;
        TextView tv_tv1,tv_tv2,tv_tv3,tv_tv4;
        tv_tv1=view.findViewById(R.id.tv_tv1);
        tv_tv2=view.findViewById(R.id.tv_tv2);
        tv_tv3=view.findViewById(R.id.tv_tv3);
        tv_tv4=view.findViewById(R.id.tv_tv4);
        iv_xigua=view.findViewById(R.id.iv_xigua);
        iv_mugua=view.findViewById(R.id.iv_mugua);
        iv_xianggua=view.findViewById(R.id.iv_xianggua);
        iv_xiyou=view.findViewById(R.id.iv_xiyou);
        iv_chengzi=view.findViewById(R.id.iv_chengzi);
        iv_juzi=view.findViewById(R.id.iv_juzi);
        iv_putao=view.findViewById(R.id.iv_putao);
        iv_ci=view.findViewById(R.id.iv_ci);
        iv_mihoutao=view.findViewById(R.id.iv_mihoutao);
        iv_lizi=view.findViewById(R.id.iv_lizi);
        iv_taozi=view.findViewById(R.id.iv_taozi);
        iv_xingzi=view.findViewById(R.id.iv_xingzi);
        iv_xigua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GuaActivity.class);
                startActivity(intent);
            }
        });
        iv_mugua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GuaActivity.class);
                startActivity(intent);
            }
        });
        iv_xianggua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GuaActivity.class);
                startActivity(intent);
            }
        });
        iv_xiyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GrzxActivity.class);
                startActivity(intent);
            }
        });
        iv_chengzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GrzxActivity.class);
                startActivity(intent);
            }
        });
        iv_juzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GrzxActivity.class);
                startActivity(intent);
            }
        });
        iv_putao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GrzxActivity.class);
                startActivity(intent);
            }
        });
        iv_ci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GrzxActivity.class);
                startActivity(intent);
            }
        });
        iv_mihoutao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GrzxActivity.class);
                startActivity(intent);
            }
        });
        iv_lizi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GrzxActivity.class);
                startActivity(intent);
            }
        });
        iv_taozi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GrzxActivity.class);
                startActivity(intent);
            }
        });
        iv_xingzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GrzxActivity.class);
                startActivity(intent);
            }
        });
        tv_tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GuaActivity.class);
                startActivity(intent);
            }
        });
        tv_tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GrzxActivity.class);
                startActivity(intent);
            }
        });
        tv_tv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GrzxActivity.class);
                startActivity(intent);
            }
        });
        tv_tv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), GrzxActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}