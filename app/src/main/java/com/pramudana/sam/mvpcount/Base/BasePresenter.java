package com.pramudana.sam.mvpcount.Base;

/**
 * Created by sampramudana on 10/11/18.
 */

public interface BasePresenter <T extends BaseView> {
    void onAttach(T v);
    void onDettach();
}
