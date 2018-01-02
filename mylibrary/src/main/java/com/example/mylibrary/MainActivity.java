package com.example.mylibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    /**
     *
     * library 中
     * 1、初始化使用R2
     * 2、单击事件中不能使用swith case
     * 3、switch case 转换成if else 如下
     *
     */

    /**
     * 特别注意：当副Module使用R2时候可会报红，没关系，rebuild 就好了
     * 强烈建议大家 用插件 Android ButterKnife Zelezny 生成 然后在library中根据每个地方修改成R2
     */


    /**
     * 关于资源文件，layout、res 下的资源文件 每一个module 命名必须不同，如果相同运行后跑程序将以主Module资源为准
     * 也就是library中资源、布局将会被替换或者忽视。
     */

    @BindView(R2.id.button)
    Button button;
    @BindView(R2.id.button2)
    Button button2;
    @BindView(R2.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_library);
        ButterKnife.bind(this);
    }


    /**
     * 单击事件
     * @param view
     */
    @OnClick({R2.id.button, R2.id.button2})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.button) {
            Toast.makeText(MainActivity.this,"点击了副Module",Toast.LENGTH_SHORT).show();
        } else if (i == R.id.button2) {
            finish();
        }
    }
}
