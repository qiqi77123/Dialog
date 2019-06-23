package com.example.ssl.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by ssl on 2019/6/23.
 */

public class MyDialog extends Dialog {
    Context context;
    public MyDialog(Context context) {
        super(context);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog);

        Button btnok = (Button)findViewById(R.id.btn_ok);
        final RadioGroup rgHobby = (RadioGroup)findViewById(R.id.Hobby);
        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,((RadioButton)findViewById(rgHobby.getCheckedRadioButtonId())).getText().toString(),Toast.LENGTH_LONG).show();
                MyDialog.this.dismiss();
            }
        });
    }

}
