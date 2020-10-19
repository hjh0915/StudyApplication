package work.com.studyapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private TextView showDataTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            String temp_data_key = savedInstanceState.getString("temp_data_key");
            Log.d(TAG, temp_data_key);
        }
        Log.d(TAG, "onCreate 已执行");
        Button loginBtn = (Button) findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(this);
//        选择make
        Button registerBtn = (Button) findViewById(R.id.btn_register);
        registerBtn.setOnClickListener(this);

        Button hideBtn = (Button) findViewById(R.id.hide_btn);
        hideBtn.setOnClickListener(this);

        Button baidurBtn = (Button) findViewById(R.id.baidu_btn);
        baidurBtn.setOnClickListener(this);

        Button dailBtn = (Button) findViewById(R.id.dail_btn);
        dailBtn.setOnClickListener(this);

        Button backBtn = (Button) findViewById(R.id.back_btn);
        backBtn.setOnClickListener(this);

        showDataTv = (TextView) findViewById(R.id.show_return_data);

        Button startNormalBtn = (Button) findViewById(R.id.start_normal_btn);
        startNormalBtn.setOnClickListener(this);

        Button startDialogBtn = (Button) findViewById(R.id.start_dialog_btn);
        startDialogBtn.setOnClickListener(this);

        Button startRelativeBtn = (Button) findViewById(R.id.start_relative_btn);
        startRelativeBtn.setOnClickListener(this);

        Button startQQLoginBtn = (Button) findViewById(R.id.start_QQLogin_btn);
        startQQLoginBtn.setOnClickListener(this);

        Button startListviewBtn = (Button) findViewById(R.id.start_listview_btn);
        startListviewBtn.setOnClickListener(this);

        Button jumpBtn = (Button) findViewById(R.id.jump_btn);
        jumpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this, "你点击了Button3", Toast.LENGTH_SHORT).show();
                //使用显示的意图实现跳转
                String data = "Hello SecondActivity";
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                intent重载
                intent.putExtra("extra_data", data);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                Toast.makeText(this, "登录的按钮被点击",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_register:
                Toast.makeText(this, "注册的按钮被点击", Toast.LENGTH_SHORT).show();
                break;

            case R.id.hide_btn:
                //隐式意图实现页面跳转
                Intent intent = new Intent("work.com.studyapplication.ACTION_START");
                intent.addCategory("android.intent.category.DEFAULT");
                startActivity(intent);
                break;

            case R.id.baidu_btn:
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent1);
                break;

            case R.id.dail_btn:
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:10000"));
                startActivity(intent2);
                break;

            case R.id.back_btn:
                Intent intent3 = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(intent3, 1);
                break;

            case R.id.start_normal_btn:
                Intent intent4 = new Intent(this, NormalActivity.class);
                startActivity(intent4);
                break;

            case R.id.start_dialog_btn:
                Intent intent5 = new Intent(this, DialogActivity.class);
                startActivity(intent5);
                break;

            case R.id.start_relative_btn:
                Intent intent6 = new Intent(this, RelativeActivity.class);
                startActivity(intent6);
                break;

            case R.id.start_QQLogin_btn:
                Intent intent7 = new Intent(this, QQLoginActivity.class);
                startActivity(intent7);
                break;

            case R.id.start_listview_btn:
                Intent intent8 = new Intent(this, ListViewActivity.class);
                startActivity(intent8);
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_add:
                Toast.makeText(MainActivity.this, "You click add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_remove:
                Toast.makeText(MainActivity.this, "You click remove",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case 1:
                if(resultCode == RESULT_OK) {
                    String returnData = data.getStringExtra("extra_return_data");
                    Log.d(TAG, returnData);
                    showDataTv.setText(returnData);
                }
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
//        可交互变不可交互
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
//        从第二个activity转到第一个
        Log.d(TAG, "onRestart");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String tempData = "This is temp data";
        outState.putString("tem_data_key", tempData);
    }
}
