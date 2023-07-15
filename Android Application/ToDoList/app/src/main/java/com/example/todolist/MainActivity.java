package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String tasks[]={};
    int count=0;
    List<String> cncts=new ArrayList<String>(Arrays.asList(tasks));
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
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                // do your code
                count++;
                AlertDialog.Builder build = new AlertDialog.Builder(this);
                build.setTitle("New Name");
                // Set up the input
                final EditText inp = new EditText(this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                inp.setInputType(InputType.TYPE_CLASS_TEXT );
                build.setView(inp);
                // Set up the buttons
                build.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_Text = inp.getText().toString();
                        cncts.add(count+" "+m_Text);
                        adapter.notifyDataSetChanged();
                    }
                });
                build.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                build.show();
                return true;
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
                builder.setTitle("New Name for the Task");
                // Set up the input
                final EditText input = new EditText(this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT );
                builder.setView(input);
                // Set up the buttons
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_Text = count+" "+input.getText().toString();
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
                AlertDialog.Builder b=new AlertDialog.Builder(this);
                final EditText inp1 = new EditText(this);
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                inp1.setInputType(InputType.TYPE_CLASS_TEXT );
                b.setView(inp1);
                b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_Text = inp1.getText().toString();
                        int p=Integer.parseInt(m_Text)-1;
                        cncts.remove(p);
                        adapter.notifyDataSetChanged();
                        count--;
                    }
                });
                b.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                b.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}




