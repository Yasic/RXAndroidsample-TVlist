package com.yasic.tvlist.Model;

import com.yasic.tvlist.Bean.CallbackBean;

/**
 * Created by ESIR on 2016/3/17.
 */
public interface ITVModel {
    CallbackBean getCCTVListFromNetwork();
    CallbackBean getCCTVShowFromNetwork(int position);
}
