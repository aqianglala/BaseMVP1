package com.qiang.basemvp.main;

import android.annotation.SuppressLint;

import com.qiang.basemvp.data.DataRepository;
import com.qiang.library.app.BasePresenter;
import com.qiang.library.net.rx.RxHelper;

import io.reactivex.functions.Consumer;

public class MainPresenter extends BasePresenter<MainActivity> implements MainContract.Presenter {

    @SuppressLint("CheckResult")
    @Override
    public void getData() {
        DataRepository.getInstance().getData()
                .compose(RxHelper.<String>io_main())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        getIView().showData(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getIView().showError();
                    }
                });
    }
}