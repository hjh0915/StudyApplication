package work.com.studyapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button finishBtn = (Button)findViewById(R.id.finish_btn);
        finishBtn.setOnClickListener(this);

        TextView tvContent = (TextView)findViewById(R.id.tv);

        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        tvContent.setText(data);
        Log.d("TAG", data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.finish_btn:
                //结束当前页面
                finish();
                break;
        }
    }
}
