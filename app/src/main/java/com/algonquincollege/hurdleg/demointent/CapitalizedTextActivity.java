package com.algonquincollege.hurdleg.demointent;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.CharacterPickerDialog;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import util.StringUtil;

import static com.algonquincollege.hurdleg.demointent.Constants.ABOUT_DIALOG_TAG;
import static com.algonquincollege.hurdleg.demointent.Constants.DEFAULT_LETTER;
import static com.algonquincollege.hurdleg.demointent.Constants.LETTERS;
import static com.algonquincollege.hurdleg.demointent.Constants.THE_LETTER;
import static com.algonquincollege.hurdleg.demointent.Constants.THE_MESSAGE;
import static com.algonquincollege.hurdleg.demointent.Constants.LOG_TAG;

// TODO code inspection (read and understand the code).
/**
 * Display plainMessage with all occurrences of letter in upper-case.
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 *
 */
public class CapitalizedTextActivity extends AppCompatActivity implements View.OnClickListener {
    private DialogFragment        mAboutDialog;
    private EditText              mCapitalizedText;
    private CharacterPickerDialog mLowercaseLettersDialog;
    private char                  mTheLowercaseLetter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capitalized_text);

        Log.i( LOG_TAG, "Capitalized Text Activity :: onCreate()" );

        mAboutDialog = new AboutDialogFragment();
        mTheLowercaseLetter = DEFAULT_LETTER;

        mLowercaseLettersDialog = new CharacterPickerDialog( this, new View(this), null, LETTERS.toLowerCase(), false ) {
            @Override
            public void onClick(View v) {
                int index = LETTERS.indexOf( ((Button)v).getText().toString() );
                if ( index >= 0 ) {
                    mTheLowercaseLetter = LETTERS.charAt( index );
                }
                dismiss();
            }
        };

        Button clearButton = (Button) findViewById( R.id.bClearCapitalized );
        // TODO a new way to register the clearButton's event handler for onClick( ).
        //      Notice: the meta-variable 'this'
        //      In context, 'this' refers to *this* class: CapitalizedTextActivity.
        //      CapitalizedTextActivity is-a View.OnClickListener.
        //      Here's my proof:
        //      (to see: View -> Tool Windows -> Android Monitor)
        //      Set the Log level to: Info
        //      Filter: the value for the "LOG_TAG" constant (go and find it :)
        if ( this instanceof View.OnClickListener ) {
            Log.i( LOG_TAG, "Is class CapitalizedTextActivity an OnClickListener? " +
                    // Java's ternary operator.
                    // Pro-tip: to quickly have the String value of a primitive: "" + <primitive>
                    (this instanceof View.OnClickListener ? "" + true : "" + false) );
        }
        clearButton.setOnClickListener( this );

        mCapitalizedText = (EditText) findViewById( R.id.etCapitalized );
        Bundle bundle = getIntent().getExtras();
        // TODO Get the bundle of extras that was sent to this activity.
        if ( bundle != null ) {
            // GET the Plain Message and the Letter to capitalize
            String plainMessage = bundle.getString( THE_MESSAGE );
            char letter = bundle.getChar( THE_LETTER );
            // Capitalize Plain Message and display to user
            mCapitalizedText.setText(StringUtil.capitalize(plainMessage, letter) );

            Log.i( LOG_TAG, "CapitalizedTextActivity :: The Letter: "
                    + letter + "\tThe Plain Message: " + plainMessage );
        }
    }

    @Override
    public void onClick(View v) {
        //TODO this strategy --- where multiple buttons are handled by the same method --- requires
        //     you to figure out which button was click. This step is called: detect. As in, detect
        //     which <Button> was the one just clicked by the user.
        //     In Android, we can detect by the <Button>'s Id.
        //     After detection, then do what you need to do for that button click.
        switch ( v.getId() ) {
            case R.id.bClearCapitalized:
                mCapitalizedText.setText( "" );
                break;

            //TODO suppose there was another <Button> object registered to this activity.
            //case R.id.bOther:
            //    //do stuff
            //    break;
        }
    }

    // TODO this code to the end was a copy and paste from PlainTextActivity.java
    //      Each activity has it's own dialogs.
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
            mLowercaseLettersDialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
