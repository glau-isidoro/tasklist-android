package br.com.campuscode.tasklist;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView listView;
    List<String> model;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv_tasks);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(this);

        model = new ArrayList<>();
        model.add("Fazer pastel");
        model.add("Fazer hamburger");
        model.add("Fazer batata frita");
        model.add("Fazer guacamole");
        model.add("Fazer uma saladinha");

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, model);
        listView.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        //TODO obtenha os dados da sharedPreference
        //TODO coloque os dados no modelo
        //TODO notifique o adapter que houve mudança no modelo
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, InsertTaskActivity.class);
        startActivity(intent);

    }
}
