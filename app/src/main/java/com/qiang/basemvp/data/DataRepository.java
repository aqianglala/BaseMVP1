package com.qiang.basemvp.data;

import com.qiang.library.net.rx.RxRestClient;

import io.reactivex.Observable;

public class DataRepository {

    private static DataRepository INSTANCE;
    private static final Object sLock = new Object();

    private DataRepository() {
    }

    public static DataRepository getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        } else {
            synchronized (sLock) {
                if (INSTANCE == null) {
                    INSTANCE = new DataRepository();
                }
                return INSTANCE;
            }
        }
    }

    /**
     * 对外暴露简单的调用，内部封装细节，比如按内存 - 数据库 - 网络 的方式获取数据。
     * 就算是简单的请求网络，也不要在此处全部处理，比如生命周期的绑定应该在presenter
     * 中处理，否则model层将持有view的引用。
     *
     * @return 返回Observable 代替以前传入callback 的方式
     */
    public Observable<String> getData() {
        final String url = "https://www.baidu.com/";
        return RxRestClient.builder()
                .url(url)
                .build()
                .get();
    }

}
