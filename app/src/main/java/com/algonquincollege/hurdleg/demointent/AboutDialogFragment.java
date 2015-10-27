package com.algonquincollege.hurdleg.demointent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

// TODO code inspection (read and understand the code).
/**
 * Create an AboutDialogFragment displaying your full name and username.
 *
 * @author Gerald.Hurdle@AlgonquinCollege.com
 */
public class AboutDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder( getActivity() );
        //TODO pro-tip: cascading messages
        builder.setTitle( R.string.action_about )
                .setMessage( R.string.author )
                .setCancelable( false )
                .setPositiveButton( android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick( DialogInterface dialog, int which ) {
                        dialog.dismiss();
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }
}
