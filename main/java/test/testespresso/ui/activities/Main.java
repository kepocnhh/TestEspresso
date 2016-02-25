package test.testespresso.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import test.testespresso.R;

public class Main
        extends AppCompatActivity
{
    TextView main_test_text;
    EditText main_test_edit;
    Button main_test_button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //
        initViews();
        init();
    }

    private void initViews()
    {
        main_test_text = (TextView) findViewById(R.id.main_test_text);
        main_test_edit = (EditText) findViewById(R.id.main_test_edit);
        main_test_button = (Button) findViewById(R.id.main_test_button);
    }

    private void init()
    {
        main_test_button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                main_test_text.setText(main_test_edit.getText().toString());
            }
        });
    }
}