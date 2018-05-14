package com.example.admin.viewstubdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;

public class MainActivity2 extends AppCompatActivity {

    private ViewStub mNetErrorStub;
    private ViewStub mNoDataStub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNoDataStub = findViewById(R.id.nodata_layout);
        mNetErrorStub = findViewById(R.id.noerror_layout);

//        showNoData();
    }

    /**
     * 无数据
     */
    public void showNoData(){
        mNetErrorStub.setVisibility(View.GONE);
//        if(mNoDataLayout != null){
//            mNoDataLayout.setVisibility(VISIBLE);
//            return;
//        }
        if(mNoDataStub != null){
            mNoDataStub.inflate();
        }
    }

    /**
     * 通用网络错误界面
     */
    public void showNetError(){
        mNoDataStub.setVisibility(View.GONE);

//        if(mNetErrorLayout != null){
//            mNetErrorLayout.setVisibility(VISIBLE);
//            return;
//        }
        if(mNetErrorStub != null){
            mNetErrorStub.inflate();
        }
    }
}
