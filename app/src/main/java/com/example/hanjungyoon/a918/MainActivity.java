package com.example.hanjungyoon.a918;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        registerForContextMenu(text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        menu.add("next"); //메뉴추가
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.before:
                text.setTextColor(Color.RED);
                Toast.makeText(this, "1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.after:
                Intent intent = new Intent(this,Main2Activity.class);
                startActivity(intent);
                //text.setTextColor(Color.BLUE);
                //Toast.makeText(this, "2",Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
//글씨누르면 색 바뀌게
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add("이전");
        menu.add("다음");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.before:
                text.setTextColor(Color.RED);
                Toast.makeText(this, "1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.after:
                text.setTextColor(Color.BLUE);
                Toast.makeText(this, "2",Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
