package br.com.campuscode.tasklist;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertTaskActivity extends AppCompatActivity implements View.OnClickListener {

    Button saveButton;
    EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_task);

        saveButton = (Button) findViewById(R.id.bt_save_task);

        saveButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        text = (EditText) findViewById(R.id.et_task_name);
        SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = shared.edit();
        String nome = shared.getString("pastel", "");
        nome = nome.concat("," + text.getText().toString());
        editor.putString("pastel", nome);
        editor.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
