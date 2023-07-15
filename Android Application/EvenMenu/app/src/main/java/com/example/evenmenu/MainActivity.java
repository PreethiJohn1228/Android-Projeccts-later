package com.example.evenmenu;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.InputType;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SoundEffectConstants;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String names[]={"Rosy","Pinky","Lily"};
    List<String> cncts=new ArrayList<String>(Arrays.asList(names));
    ArrayAdapter<String> adapter;
    int itemValue;
    private String m_Text = "";
    int pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.listview);

        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,cncts);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);
        registerForContextMenu(listView);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                itemValue= i;
                return false;
            }
        });

    }


    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {

        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context, menu);
        menu.setHeaderTitle("User Actions");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==R.id.cut){
            String value=cncts.get(itemValue);
            cncts.remove(itemValue);
            adapter.notifyDataSetChanged();
            Toast.makeText(getApplicationContext(),value+" "+"is removed",Toast.LENGTH_SHORT).show();
        }

        else if(item.getItemId()==R.id.copy){
            String value=cncts.get(itemValue);
            Toast.makeText(getApplicationContext(),value+" "+"is copied",Toast.LENGTH_SHORT).show();

        }else{
            return false;
        }
        return true;
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        switch (item.getItemId()) {

            case R.id .edit:
                // do your code
                SparseBooleanArray check=listView.getCheckedItemPositions();
                ArrayList<String> selected=new ArrayList<String>();
                for (int i = 0; i < check.size(); i++) {
                    // Item position in adapter
                    int position = check.keyAt(i);
                    // Add sport if it is checked i.e.) == TRUE!
                    if (check.valueAt(i))
                        selected.add(adapter.getItem(position));
                }
                for(String k:selected)
                {
                    pos=cncts.indexOf(k);

                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("New Name");

// Set up the input
                final EditText input = new EditText(this);
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT );
                builder.setView(input);

// Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_Text = input.getText().toString();
                        cncts.set(pos,m_Text);
                        adapter.notifyDataSetChanged();

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
                selected.clear();
                return true;
            case R.id.delete:
                // do your code
                SparseBooleanArray checked=listView.getCheckedItemPositions();

                ArrayList<String> selectedItems = new ArrayList<String>();
                for (int i = 0; i < checked.size(); i++) {
                    // Item position in adapter
                    int position = checked.keyAt(i);
                    // Add sport if it is checked i.e.) == TRUE!
                    if (checked.valueAt(i))
                        selectedItems.add(adapter.getItem(position));
                }
                for(String k:selectedItems)
                {
                    int sop=cncts.indexOf(k);
                    cncts.remove(sop);
                    adapter.notifyDataSetChanged();
                }
                checked.clear();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}