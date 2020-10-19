package work.com.studyapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button finishBtn = (Button)findViewById(R.id.finish_btn);
        finishBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.finish_btn:
                String data = "Hello World";
                Intent intent = new Intent();
                intent.putExtra("extra_return_data", data);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        String data = "Hello World";
        Intent intent = new Intent();
        intent.putExtra("extra_return_data", data);
        setResult(RESULT_OK, intent);
        finish();
    }
}
