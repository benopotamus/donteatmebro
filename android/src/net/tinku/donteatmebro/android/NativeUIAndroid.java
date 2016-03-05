package net.tinku.donteatmebro.android;

import android.app.AlertDialog;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.Toast;

import com.badlogic.gdx.backends.android.AndroidApplication;

import net.tinku.donteatmebro.NativeUI;

/**
 * Created by ben on 24/02/16.
 *
 * Code originally copied from these URLs
 * https://code.google.com/archive/p/libgdx-users/wikis/IntegratingAndroidNativeUiElements.wiki
 * http://octagen.at/2013/01/native-android-ui-and-libgdx/
 */
public class NativeUIAndroid implements NativeUI {

    Handler uiThread;
    AndroidApplication appContext;
    View testView;

    public NativeUIAndroid(AndroidApplication appContext) {
        uiThread = new Handler();
        this.appContext = appContext;
    }


    @Override
    public void showShortToast(final CharSequence toastMessage) {
        uiThread.post(new Runnable() {
            public void run() {
                Toast.makeText(appContext, toastMessage, Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }

    @Override
    public void showLongToast(final CharSequence toastMessage) {
        uiThread.post(new Runnable() {
            public void run() {
                Toast.makeText(appContext, toastMessage, Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

    @Override
    public void showAlertBox(final String alertBoxTitle,
                             final String alertBoxMessage, final String alertBoxButtonText) {
        uiThread.post(new Runnable() {
            public void run() {
                new AlertDialog.Builder(appContext)
                        .setTitle(alertBoxTitle)
                        .setMessage(alertBoxMessage)
                        .setNeutralButton(alertBoxButtonText,
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int whichButton) {
                                    }
                                }).create().show();
            }
        });
    }

    @Override
    public void openUri(String uri) {
        Uri myUri = Uri.parse(uri);
        Intent intent = new Intent(Intent.ACTION_VIEW, myUri);
        appContext.startActivity(intent);
    }

   /* @Override
    public void showView(final int view)
    {
        switch (view)
        {
            case VIEW_TEST:
                appContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (testView==null) {




                            setContentView(R.layout.wizard);

                            LayoutInflater inflater = appContext.getLayoutInflater();
                            testView = inflater.inflate(R.layout.test_list_item, null);
                            appContext.addContentView(testView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                    ViewGroup.LayoutParams.MATCH_PARENT));
                            //appContext.initOnClickView(testView);
                        }
                        else
                            testView.setVisibility(View.VISIBLE);
                    }
                });
        }
    }

    @Override
    public void hideView(final int view)
    {
        switch(view)
        {
            case VIEW_TEST:
                testView.setVisibility(View.GONE);
        }
    }*/

    @Override
    public void showUI() {
        //appContext.startActivity(new Intent(this.appContext, Wizard.class)); }
        Intent intent1= new Intent(this.appContext, Wizard.class);
        appContext.startActivity(intent1);
    }
    @Override
    public void hideUI() {
    }
}
