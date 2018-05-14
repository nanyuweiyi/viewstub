package com.example.admin.viewstubdemo;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * ================================================
 * 描   述:
 * 作   者：tnn
 * 创建日期：2018/5/14
 * 版   本：1.0.0
 * ================================================
 */
public class TextCreator {
    private final int TYPE_NULL=-1;//默认字体
    private final int TYPE_COLOR=0;//设置颜色
    private final int TYPE_SCALE=1;//比例大小


    private StringBuilder mStringBuilder;
    private Context mContext;
    private List<Integer> texts = new ArrayList<>();
    private List<Float> values = new ArrayList<>();
    private List<Integer> types=new ArrayList<>();
    private int mIndex;//当前渲染的起点


    public TextCreator(Context context) {
        mContext = context;
        mStringBuilder=new StringBuilder();
    }

    /**
     * 默认textview 的颜色
     *
     * @param text
     * @return
     */
    public TextCreator addText(String text) {
        mStringBuilder.append(text);
        texts.add(text.length());
        values.add(-1f);
        types.add(TYPE_NULL);
        return this;
    }

    /**
     * 添加有颜色文字
     *
     * @param text
     * @param colorId
     * @return
     */
    public TextCreator addTextOfColor(String text, int colorId) {
        mStringBuilder.append(text);
        texts.add(text.length());
        int color = mContext.getResources().getColor(colorId);
        values.add((float) color);
        types.add(TYPE_COLOR);
        return this;
    }
    /**
     * 添加设置比例的文字
     *
     * @param text
     * @param scale  比例大小  1.0原比例大小
     * @return
     */
    public TextCreator addTextOfScale(String text, float scale) {
        mStringBuilder.append(text);
        texts.add(text.length());
        values.add(scale);
        types.add(TYPE_SCALE);
        return this;
    }

    /**
     * 生成
     *
     * @return
     */
    public String builder(TextView textView) {
        String content=mStringBuilder.toString();
        SpannableString spannableString = new SpannableString(content);
        for (int i = 0; i < texts.size(); i++) {
            float value = values.get(i);
            int type=types.get(i);
            if(type==TYPE_COLOR){
                ForegroundColorSpan colorSpan = new ForegroundColorSpan((int) value);
                spannableString.setSpan(colorSpan, mIndex, mIndex=texts.get(i) + mIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            }else if(type==TYPE_SCALE){
                RelativeSizeSpan sizeSpan = new RelativeSizeSpan(value);
                spannableString.setSpan(sizeSpan, mIndex, mIndex=texts.get(i) + mIndex, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            }
        }
        textView.setText(spannableString);
        return content;
    }
}
