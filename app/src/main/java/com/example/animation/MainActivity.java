package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    final int MENU_APLHA_ID = 1;
    final int MENU_SCALE_ID = 2;

    TextView tv;

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo){
        switch (v.getId()){
            case R.id.tv:
                menu.add(0, MENU_APLHA_ID,0,"alpha");
                menu.add(0, MENU_SCALE_ID,0,"scale");
                break;
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        Animation anim = null;
        switch (item.getItemId()){
            case MENU_APLHA_ID:
                anim = AnimationUtils.loadAnimation(this,R.anim.myalpha);
                break;
            case MENU_SCALE_ID:
                anim = AnimationUtils.loadAnimation(this,R.anim.myscale);
                break;
        }
        tv.startAnimation(anim);
        return super.onContextItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        registerForContextMenu(tv);
    }
}