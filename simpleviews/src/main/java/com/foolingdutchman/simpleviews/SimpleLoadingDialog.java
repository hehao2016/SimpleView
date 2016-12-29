package com.foolingdutchman.simpleviews;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ldoublem.loadingviewlib.LVCircularRing;

/**
 * Created by hehao on 16/12/27.
 */
public class SimpleLoadingDialog {
    LVCircularRing mLoadingView;
    Dialog mLoadingDialog;
    TextView loadingText;
    boolean isShow=false;

    public SimpleLoadingDialog(Context context) {
        // 首先得到整个View
        View view = LayoutInflater.from(context).inflate(
                R.layout.loading_dialog_view, null);
        // 获取整个布局
        LinearLayout layout = (LinearLayout) view.findViewById(R.id.dialog_view);
        // 页面中的LoadingView
        mLoadingView = (LVCircularRing) view.findViewById(R.id.lv_circularring);
        // 页面中显示文本
        loadingText = (TextView) view.findViewById(R.id.loading_text);

        // 创建自定义样式的Dialog
        mLoadingDialog = new Dialog(context, R.style.loading_dialog);
        // 设置返回键无效
        mLoadingDialog.setCancelable(false);

        mLoadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

    }

    public void show(){
        mLoadingDialog.show();
        mLoadingView.startAnim();
        isShow=true;
    }
    public void showWithText(String msg){
        // 显示文本
        loadingText.setText(msg);
        loadingText.setVisibility(View.VISIBLE);
        mLoadingDialog.show();
        mLoadingView.startAnim();
    }

    public void dismiss(){
        if (mLoadingDialog!=null) {
            mLoadingView.stopAnim();
            mLoadingDialog.dismiss();
            isShow=false;
        }
    }

    public void close(){
        if (mLoadingDialog!=null) {
            mLoadingView.stopAnim();
            mLoadingDialog.dismiss();
            mLoadingDialog=null;
        }
    }

    public boolean isShow() {
        return isShow;
    }
}
