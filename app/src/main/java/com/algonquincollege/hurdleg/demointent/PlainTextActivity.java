package com.algonquincollege.hurdleg.demointent;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.CharacterPickerDialog;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

// TODO notice the difference in syntax for the import statement.
//      The '*' imports all of the public static class vars (in this example).
import static com.algonquincollege.hurdleg.demointent.Constants.*;

// TODO code inspection (read and understand the code).
/**
 * Demo Android's Intent.
 *
 * Usage: enter some text, click the settings menu item and select the letter you wish to
 *        capitalize, and press the symbol in the FloatingActionBar (FAB).
 *        Click the Clear button to clear the text.
 *
 * Navigation: PlainTextActivity --- FAB ---> CapitalizedTextActivity
 *
 * TODOs
 *    Please review the TODOs
 *    View -> Tool Windows... -> TODO
 *
 * Features:
 *     two (multiple) activities
 *     an Intent
 *     passing Data
 *     CharacterPickerDialog (a specialized picker as a dialog)
 *     handling FAB events
 *     event handling by implementing an interface
 *     event handling with an anonymous inner class
 *
 * Limitations:
 *     the lab is same but different from this demo (I'm sure you've heard me say: same but different...)
 *     DO study this demo to learn
 *     DO apply what you've learned from this demo to build the lab :)
 *     there is only one intent from PlainTextActivity to CapitalizedTextActivity
 *     THEREFORE, I challenge you to implement the other intent to go from CapitalizedTextActivity
 *         back to PlainTextActivity & display the message with all occurrences of the selected
 *         letter in lower-case.
 *     the toast message should be externalized
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 *
 */
public class PlainTextActivity extends AppCompatActivity {
    private DialogFragment        mAboutDialog;
    private CharacterPickerDialog mCapitalLettersDialog;
    private EditText              mPlainText;
    private char                  mTheCapitalLetter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plain_text);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String plainText = mPlainText.getText().toString();
                // TODO :: prevent the user from capitalizing empty messages!
                // IF plainText is empty
                // THEN
                //     display a toast message: Empty Message!
                //     return

                Intent intent = new Intent( getApplicationContext(), CapitalizedTextActivity.class );
                intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );
                intent.putExtra( THE_MESSAGE, plainText );
                intent.putExtra( THE_LETTER, mTheCapitalLetter );
                Log.i( LOG_TAG, "PlainTextActivity -> CapitalizedTextActivity :: The Letter: " +
                        mTheCapitalLetter + "\tThe Plain Message: " + plainText );
                startActivity( intent );
            }
        });

        Log.i( LOG_TAG, "Plain Text Activity :: onCreate()" );

        mAboutDialog = new AboutDialogFragment();
        mTheCapitalLetter = DEFAULT_LETTER;

        mCapitalLettersDialog = new CharacterPickerDialog( this, new View(this), null, LETTERS, false ) {
            @Override
            public void onClick(View v) {
                int index = LETTERS.indexOf( ((Button)v).getText().toString() );
                if ( index >= 0 ) {
                    mTheCapitalLetter = LETTERS.charAt( index );
                }
                dismiss();
            }
        };

        Button clearButton = (Button) findViewById( R.id.bClearPlain );
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlainText.setText( "" );
            }
        });

        mPlainText = (EditText) findViewById( R.id.etPlain );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        // TODO compare my new style of showing the About dialog box to my previous way.
        //      This way is more efficient: the dialog is instantiated once, and shown each time
        //      the user taps the About menu item.
        //      The previous way: a new dialog is created *each* time the user taps the About
        //      menu item.
        if ( id == R.id.action_about) {
            mAboutDialog.show( getFragmentManager(), ABOUT_DIALOG_TAG );
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mCapitalLettersDialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // TODO Remaining lifecycle method overrides (in alphabetical order).

    @Override
    public void onDestroy() {
        Log.i( LOG_TAG, "onDestroy()" );

        super.onDestroy();
    }

    @Override
    public void onPause() {
        Log.i( LOG_TAG, "onPause()" );

        super.onPause();
    }

    @Override
    public void onRestart() {
        Log.i( LOG_TAG, "onRestart()" );

        super.onRestart();
    }

    @Override
    public void onResume() {
        Log.i( LOG_TAG, "onResume()");

        super.onResume();
    }

    @Override
    public void onStart() {
        Log.i( LOG_TAG, "onStart()" );

        super.onStart();
    }

    @Override
    public void onStop() {
        Log.i( LOG_TAG, "onStop()" );

        super.onStop();
    }
}
