package com.example.android.cardview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<User> userList;
    RecyclerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        recyclerView =(RecyclerView) findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        initializeData();
        adapter= new RecyclerAdapter(userList,getApplication().getApplicationContext());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void initializeData(){
        userList = new ArrayList<>();
        userList.add(new User("Jair Barzola","Este texto es para probar solamente,Este texto es para probar solamente,Este texto es para probar solamente,Este texto es para probar solamente",R.drawable.foto1));
        userList.add(new User("Jair Barzola","Este texto es para probar solamente,Este texto es para probar solamente,Este texto es para probar solamente,Este texto es para probar solamente",R.drawable.foto2));
        userList.add(new User("Javier Barzola","Este texto es para probar solamente,Este texto es para probar solamente,Este texto es para probar solamente,Este texto es para probar solamente",R.drawable.buho));
        userList.add(new User("Luna - LLena","Este texto es para probar solamente,Este texto es para probar solamente,Este texto es para probar solamente,Este texto es para probar solamente",R.drawable.paisaje1));
        userList.add(new User("Anochecer - Moonset","Este texto es para probar solamente,Este texto es para probar solamente,Este texto es para probar solamente,Este texto es para probar solamente",R.drawable.paisaje2));
        userList.add(new User("Otuzco - Trujillo","Este texto es para probar solamente,Este texto es para probar solamente,Este texto es para probar solamente,Este texto es para probar solamente",R.drawable.paisaje1));
    }
}
