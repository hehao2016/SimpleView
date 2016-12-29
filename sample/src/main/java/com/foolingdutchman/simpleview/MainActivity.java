package com.foolingdutchman.simpleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.foolingdutchman.simpleviews.SimpleFlowLayout;
import com.foolingdutchman.simpleviews.SimpleInputFloatView;
import com.foolingdutchman.simpleviews.SimpleLoadingDialog;
import com.foolingdutchman.simpleviews.SimpleMarqueeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SimpleLoadingDialog mDialog;
    private SimpleMarqueeView mMarqueeView;
    private SimpleFlowLayout mFlowLayout;
    private SimpleInputFloatView mInputFloatView;
    private List<String>notices=new ArrayList<>();
    private List<String> textlist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        for (int i = 0; i < 5; i++) {
            String string="";
            for (int j = 0; j < i; j++) {
                string=string+"a";
            }
            textlist.add(string);
        }
        for (int i = 0; i < 5; i++) {
            notices.add("this is a notice "+i);
        }
    }

    private void initView() {
        mDialog=new SimpleLoadingDialog(this);
        mMarqueeView= (SimpleMarqueeView) findViewById(R.id.mqv);
        mFlowLayout= (SimpleFlowLayout) findViewById(R.id.sfl);
        mInputFloatView= (SimpleInputFloatView) findViewById(R.id.sifv);
        mMarqueeView.setNotices(notices);
        mMarqueeView.setOnItemClickListener(new SimpleMarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                Toast.makeText(MainActivity.this,textView.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
       mFlowLayout.setTextList(textlist);
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.button:
                    mDialog.show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mDialog.isShow()) {
            mDialog.dismiss();
        }else
        super.onBackPressed();
    }
}
