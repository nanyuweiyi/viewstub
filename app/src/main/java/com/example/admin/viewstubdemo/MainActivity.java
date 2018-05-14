package com.example.admin.viewstubdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewStub mNetErrorStub, mNoDataStub;
    private View mNetErrorView, mNoDataView;
    TextView goActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNoDataStub = findViewById(R.id.nodata_layout);
        mNetErrorStub = findViewById(R.id.noerror_layout);
        goActivity = findViewById(R.id.go);
        goActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

        new TextCreator(this)
                .addTextOfColor("蓝色", R.color.colorPrimary)
                .addTextOfColor("红色", R.color.colorAccent)
                .addTextOfScale("大字体",2)
                .addText("默认颜色")
                .builder(goActivity);

//        showNoData();
//        showNetError();
    }

    /**
     * 无数据
     */
    public void showNoData(){
        mNetErrorStub.setVisibility(View.GONE);
        if(mNoDataView != null){
            mNoDataView.setVisibility(View.VISIBLE);
            return;
        }
        if(mNoDataStub != null){
            mNoDataView = mNoDataStub.inflate();
        }
    }

    /**
     * 通用网络错误界面
     */
    public void showNetError(){
        mNoDataStub.setVisibility(View.GONE);
        if(mNetErrorView != null){
            mNetErrorView.setVisibility(View.VISIBLE);
            return;
        }
        if(mNetErrorStub != null){
            mNetErrorView = mNetErrorStub.inflate();
        }
    }
}
