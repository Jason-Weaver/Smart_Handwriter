package com.jasonweaver.eleventh.smarthandwriter;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;


public class MainActivity extends ActionBarActivity {

    private EditText userNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textGreeting = (TextView) findViewById(R.id.greeting);
        Typeface theTypeFace = Typeface.createFromAsset(getAssets(), "British Quest.otf");
        textGreeting.setTypeface(theTypeFace);

        userNameEditText = (EditText) findViewById(R.id.userNameEditText);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onSubmitClick(View view) {

        String userName = String.valueOf(userNameEditText.getText());
        String toast1 = "Thank you " + userName + ".";
        String toast2 = "We will transcribe that just as soon as we can";
        makeText(this, toast1, Toast.LENGTH_SHORT).show();
        makeText(this, toast2, Toast.LENGTH_LONG).show();

    }
}
