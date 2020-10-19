package work.com.studyapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class NormalActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputEt;
    private ImageView iconIv;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        Button getDatBtn = (Button)findViewById(R.id.get_data_btn);
        inputEt = (EditText)findViewById(R.id.input_et);
        getDatBtn.setOnClickListener(this);

        iconIv = (ImageView)findViewById(R.id.icon_iv);

        Button switchIcon = (Button)findViewById(R.id.switch_icon_btn);
        switchIcon.setOnClickListener(this);

        progressBar = (ProgressBar)findViewById(R.id.progress_bar);
        Button showHideBtn = (Button)findViewById(R.id.show_hide_btn);
        showHideBtn.setOnClickListener(this);

        Button showDownLoadBtn = (Button)findViewById(R.id.show_download_btn);
        showDownLoadBtn.setOnClickListener(this);

        Button showAlertDialogBtn = (Button)findViewById(R.id.show_alterDialog_btn);
        showAlertDialogBtn.setOnClickListener(this);

        Button showProgressDialogBtn = (Button)findViewById(R.id.show_progressDialog_btn);
        showProgressDialogBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.get_data_btn:
                String inputText = inputEt.getText().toString();
                Toast.makeText(this, inputText, Toast.LENGTH_SHORT).show();
                break;

            case R.id.switch_icon_btn:
                iconIv.setImageResource(R.drawable.lx);
                break;

            case R.id.show_hide_btn:
                if(progressBar.getVisibility() == View.GONE) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.INVISIBLE);
                }
                break;

            case R.id.show_download_btn:
                int progress = progressBar.getProgress();
                progress = progress + 10;
                progressBar.setProgress(progress);
                break;

            case R.id.show_alterDialog_btn:
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("警告");
                dialog.setMessage("删除此文件会异常，确定删除吗？");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //删除文件
                        Toast.makeText(NormalActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
                break;

            case R.id.show_progressDialog_btn:
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setCancelable(true);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("DownLoading...");
                progressDialog.show();
                break;

            default:
                break;
        }
    }
}
