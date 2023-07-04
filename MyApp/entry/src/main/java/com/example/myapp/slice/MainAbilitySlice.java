package com.example.myapp.slice;

import com.example.myapp.PageProvider;
import com.example.myapp.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.PageSlider;
import ohos.agp.components.TabList;

import java.util.ArrayList;
import java.util.List;

public class MainAbilitySlice extends AbilitySlice {
    private TabList tabList;
    private PageSlider pageSlider;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);

        initTablist();
        initPageSlider();
        tabList.selectTabAt(0);
        tabList.addTabSelectedListener(new TabList.TabSelectedListener() {
            @Override
            public void onSelected(TabList.Tab tab) {
                pageSlider.setCurrentPage(tab.getPosition());
            }

            @Override
            public void onUnselected(TabList.Tab tab) {

            }

            @Override
            public void onReselected(TabList.Tab tab) {

            }
        });
        pageSlider.addPageChangedListener(new PageSlider.PageChangedListener() {
            @Override
            public void onPageSliding(int i, float v, int i1) {

            }

            @Override
            public void onPageSlideStateChanged(int i) {

            }

            @Override
            public void onPageChosen(int i) {
                if (i!=tabList.getSelectedTabIndex()){
                    tabList.selectTabAt(i);
                }
            }
        });
    }


    //初始化TabList
    private void initTablist() {

        tabList = (TabList) findComponentById(ResourceTable.Id_tabList);
        //添加数据
        String[] title = {"首页","分类","我的"};
        //将数据添加到tab当中
        for(int i = 0;i < title.length;i++){
            TabList.Tab tab = tabList.new Tab(this);
            tab.setText(title[i]);
            tabList.addTab(tab);
        }
    }

    //    初始化PageSlider
    private void initPageSlider() {
        pageSlider = (PageSlider) findComponentById(ResourceTable.Id_pageSlider);

        PageProvider pageProvider = new PageProvider(saveData(),this);
        pageSlider.setProvider(pageProvider);
    }



    public List<Integer> saveData(){
        List<Integer> list = new ArrayList<>();
        list.add(ResourceTable.Layout_layout1);
        list.add(ResourceTable.Layout_layout2);
        list.add(ResourceTable.Layout_layout3);

        return list;
    }


    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
