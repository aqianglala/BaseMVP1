package com.qiang.basemvp.main;

public interface MainContract {

    interface View {
        void showData(String data);

        void showError();
    }

    interface Presenter {
        void getData();
    }
}
