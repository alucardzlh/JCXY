package com.example.alucard.jcxy.Activitys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.alucard.jcxy.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends Activity {
    private boolean isExit = false;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = (GridView) findViewById(R.id.gridView);

        //生成动态数组，并且转入数据
        ArrayList<HashMap<String, Object>> listImageItem = new ArrayList<HashMap<String, Object>>();
        int img[] = {R.mipmap.main_icon1, R.mipmap.main_icon2, R.mipmap.main_icon3, R.mipmap.main_icon4, R.mipmap.main_icon5, R.mipmap.main_icon6, R.mipmap.main_icon7, R.mipmap.main_icon8};
        String name[] = {"移动科研", "移动教务", "资源共享", "智慧图书馆", "就业信息", "最新资讯", "移动OA", "校园地图"};
        for (int i = 0; i < 8; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", img[i]);//添加图像资源的ID
            map.put("ItemText", name[i]);//按需好做ItemText
            listImageItem.add(map);
        }
        //生成适配器的ImageItem <====> 动态数组的元素，两者一一对应
        SimpleAdapter adapter = new SimpleAdapter(this, listImageItem, R.layout.grid_item,
                new String[]{"ItemImage", "ItemText"}, new int[]{R.id.ItemImage, R.id.Text});
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new ItemClickListener());

    }

    //当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
    class ItemClickListener implements AdapterView.OnItemClickListener {
        public void onItemClick(AdapterView<?> arg0,//The AdapterView where the click happened
                                View arg1,//The view within the AdapterView that was clicked
                                int arg2,//The position of the view in the adapter
                                long arg3//The row id of the item that was clicked
        ) {
            switch (arg2) {
                case 0:
                    Toast.makeText(getApplicationContext(), "研发中...", Toast.LENGTH_SHORT).show();

                    break;
                case 1:
                    Toast.makeText(getApplicationContext(), "研发中...", Toast.LENGTH_SHORT).show();

                    break;
                case 2:
                    //Toast.makeText(getApplicationContext(), "研发中...", Toast.LENGTH_SHORT).show();
                 /*   intent=new Intent(MainActivity.this, WebActivity.class);
                    intent.putExtra("URL","http://appzq.dichuang.cc/shuxianqinhua/Search.aspx");
                    startActivity(intent);*/
                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.chaoxing.fanya.aphone");
                    if (intent != null) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "请先安装超星泛雅应用", Toast.LENGTH_LONG).show();
                    }


                    break;
                case 3:
                    startActivity(new Intent(MainActivity.this, WebActivity.class));
                    break;
                case 4:
                    //Intent intent0 = new Intent(MainActivity.this, WebActivity.class);
                    intent=new Intent(MainActivity.this, WebActivity.class);
                    intent.putExtra("URL", "http://appzq.dichuang.cc/zhaopinxinxi/list.aspx");
                    startActivity(intent);
                    break;
                case 5:
                    //Intent intent1 = new Intent(MainActivity.this, WebActivity.class);
                    intent=new Intent(MainActivity.this, WebActivity.class);
                    intent.putExtra("URL", "http://appzq.dichuang.cc/xinwendontai/list.aspx");
                    startActivity(intent);
                    break;
                case 6:
                    Intent intent1 = getPackageManager().getLaunchIntentForPackage("com.JCXYOA.Activity");
                    if (intent1 != null) {
                        startActivity(intent1);
                    } else {
                        Toast.makeText(getApplicationContext(), "请先安装警察学院移动OA应用", Toast.LENGTH_LONG).show();
                    }
                    break;
                case 7:
                    Toast.makeText(getApplicationContext(), "研发中...", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
           /* //在本例中arg2=arg3
            HashMap<String, Object> item=(HashMap<String, Object>) arg0.getItemAtPosition(arg2);
            //显示所选Item的ItemText
            setTitle((String)item.get("ItemText"));*/
        }
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // TODO Auto-generated method stub
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            return true;
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            // 所有页面，则点击两次退出应用
            exitBy2Click();
        }
        return false;

    }


    /**
     * 双击退出
     */
    private void exitBy2Click() {
        if (!isExit) {
            isExit = true; // 准备退出
            Toast.makeText(this, "再按一次退出应用", Toast.LENGTH_SHORT).show();

            new Thread(new Runnable() {

                @Override
                public void run() {
                    SystemClock.sleep(2000);
                    isExit = false; // 取消退出
                }
            }).start();
        } else {
            /*for (int i = (Constants.list.size() - 1); i >= 0; i--) {
                ((Activity) Constants.list.get(i)).*/finish();

            /*}*/
        }
    }





}
