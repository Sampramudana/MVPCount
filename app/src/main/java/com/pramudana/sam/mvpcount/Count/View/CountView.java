package com.pramudana.sam.mvpcount.Count.View;

import com.pramudana.sam.mvpcount.Base.BaseView;

/**
 * Created by sampramudana on 10/11/18.
 */

public interface CountView extends BaseView {
    void onSuccess(String result);
    void onError(String msg);
}
