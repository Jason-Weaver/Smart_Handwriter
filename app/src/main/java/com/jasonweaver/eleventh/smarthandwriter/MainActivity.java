package com.jasonweaver.eleventh.smarthandwriter;

import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;


public class MainActivity extends ActionBarActivity {

    private EditText userNameEditText;
    private EditText theTextBody;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTypeFace("British Quest.otf");

        userNameEditText = (EditText) findViewById(R.id.userNameEditText);
        theTextBody = (EditText) findViewById(R.id.theTextBody);
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

    public void onSubmitToToastClick(View view) {

        String userName = String.valueOf(userNameEditText.getText());
        String toast1 = "Thank you " + userName + ".";
        String toast2 = "We will transcribe that just as soon as we can";
        makeText(this, toast1, Toast.LENGTH_SHORT).show();
        makeText(this, toast2, Toast.LENGTH_LONG).show();

    }

    public void onSubmitClick(View view) {

        String theText = String.valueOf(theTextBody.getText());
        XWPFDocument document = new XWPFDocument();

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();

        run.setText("Pancakes");
        run.setText(" and Peanut Butter!");
        run.addBreak();
        run.setText("I'm hungry dude.");


        XWPFParagraph paragraph2 = document.createParagraph();
        XWPFRun run2 = paragraph2.createRun();

        run2.setText("Notice the line Break for a new paragraph.");


        try {
            FileOutputStream output = new FileOutputStream("Awesome.docx");
            document.write(output);
            output.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void setTypeFace(String font) {
        TextView textGreeting = (TextView) findViewById(R.id.greeting);
        Button submitButton = (Button) findViewById(R.id.submitButton);

        Typeface theTypeFace = Typeface.createFromAsset(getAssets(), font);
        textGreeting.setTypeface(theTypeFace);
        submitButton.setTypeface(theTypeFace);
    }
}
