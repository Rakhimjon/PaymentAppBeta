package com.technology.paymentappbeta;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.ViewGroup;

import com.technology.paymentappbeta.model.Header;
import com.technology.paymentappbeta.model.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String[] imageurl ={
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
    };
    List<String> texts= Arrays.asList("Hod dog","froyo","eclair","ginger","honey","kitkat","lollipop");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Object> data = generateItems();
        TextItemAdapterDelegate itemDelagate = new TextItemAdapterDelegate(this);
        HeaderItemAdapterDelegate headerDelegate = new HeaderItemAdapterDelegate(data);
        SampleAdapter<Object> adapter = new SampleAdapter<>(data);

        adapter.addDelegate(itemDelagate);
        adapter.addDelegate(headerDelegate);


                LinearLayoutManager manager = new GridLayoutManager(this, 2);
        ((GridLayoutManager) manager).setSpanSizeLookup(
                new StickyHeaderSpanSizeLookup(new DefaultHeaderSpanSizeProvider(
                        (GridLayoutManager) manager), headerDelegate));


        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
        ViewGroup stiky = (ViewGroup) findViewById(R.id.sticky);
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new StickyHeaderItemDecoration(manager,headerDelegate,
                stiky,getThemeColorAttribute(this,android.R.attr.windowBackground)));
        recyclerView.setAdapter(adapter);


    }

    private int getThemeColorAttribute(MainActivity mainActivity, int windowBackground) {
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme= mainActivity.getTheme();
        theme.resolveAttribute(windowBackground,typedValue,true);
        return typedValue.data;

    }



    private List<Object> generateItems() {
        final  List<Object> data =new ArrayList<>();
        for (int i=0;i<7; ++i){
            String text =texts.get(i);
            String image=imageurl[i];
            data.add(i%3 == 0? new Header(text): new Item(image));
        }
        return  data;
    }
}
