package com.example.ssl.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button alertdialog,dialog;
    private View dlgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alertdialog = (Button)findViewById(R.id.Alert_Dialog);
        dialog = (Button)findViewById(R.id.Dialog);
        alertdialog.setOnClickListener(this);
        dialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Alert_Dialog:
                alertdialog();
                break;
            case R.id.Dialog:
                dialog();
                break;
        }
    }

    private void alertdialog() {
        dlgView = LayoutInflater.from(this).inflate(R.layout.dialog_layout,null);
        final RadioGroup hobby = (RadioGroup) dlgView.findViewById(R.id.Hobby);
        AlertDialog alertdialog = new AlertDialog.Builder(this)
                .setTitle("对话框")
                .setView(dlgView)
                .setPositiveButton("确定",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,((RadioButton)dlgView.findViewById(hobby.getCheckedRadioButtonId())).getText().toString(),
                        Toast.LENGTH_LONG).show();
                    }
        })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
        alertdialog.show();


    }


    private void dialog() {
        MyDialog myDialog = new MyDialog(this);
        myDialog.show();

    }

}
