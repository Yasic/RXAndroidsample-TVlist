package com.yasic.tvlist.Presenter;

import com.yasic.tvlist.Util.StaticStringUtil;
import com.yasic.tvlist.View.TVClassificationView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Yasic on 2016/4/6.
 */
public class TVClassificationPresenter extends BasePresenterFragment<TVClassificationView> {

    @Override
    protected void onBindBVI(){
        BVIView.setPresenter(this);
        BVIView.initRvTVClassification(getActivity());
        setRvTVClassification();
    }

    private void setRvTVClassification() {
        List<String> tvClassificationList = new ArrayList<>();
        tvClassificationList = (new StaticStringUtil()).getTVTypeList();
        BVIView.setRvTVClassification(getActivity(), tvClassificationList);
    }

    @Override
    protected Class getBVIClass() {
        return TVClassificationView.class;
    }
}
