package com.qiang.basemvp.main;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.qiang.basemvp.R;
import com.qiang.library.app.BaseActivity;

import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @OnClick(R.id.btn_net)
    void net() {
        mPresenter.getData();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onBindView(@Nullable Bundle savedInstanceState) {
    }

    @Override
    protected MainPresenter loadPresenter() {
        return new MainPresenter();
    }

    @Override
    public void showData(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {
        Toast.makeText(this, "获取失败", Toast.LENGTH_SHORT).show();
    }
}
