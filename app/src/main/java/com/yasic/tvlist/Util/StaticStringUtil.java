package com.yasic.tvlist.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yasic on 2016/4/6.
 */
public class StaticStringUtil {
    private List<String> tvTypeList;

    public StaticStringUtil(){
    }

    public List<String> getTVTypeList(){
        tvTypeList = new ArrayList<>();
        tvTypeList.add("CCTV-1 综合");
        tvTypeList.add("CCTV-2 财经");
        tvTypeList.add("CCTV-3 综艺");
        tvTypeList.add("CCTV-4 中文国际(亚)");
        tvTypeList.add("CCTV-4 中文国际(欧)");
        tvTypeList.add("CCTV-4 中文国际(美)");
        tvTypeList.add("CCTV-5 体育");
        tvTypeList.add("CCTV-6 电影");
        tvTypeList.add("CCTV-7 军事·农业");
        tvTypeList.add("CCTV-8 电视剧");
        tvTypeList.add("CCTV-纪录");
        tvTypeList.add("CCTV-10 科教");
        tvTypeList.add("CCTV-11 戏曲");
        tvTypeList.add("CCTV-12 社会与法");
        tvTypeList.add("CCTV-13 新闻");
        tvTypeList.add("CCTV-14 少儿");
        tvTypeList.add("CCTV-15 音乐");
        return tvTypeList;
    }
}
