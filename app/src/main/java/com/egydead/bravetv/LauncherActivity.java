package com.egydead.bravetv;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class LauncherActivity extends Activity {
    private static final String BRAVE_PACKAGE = "com.brave.browser";
    private static final String TARGET_URL = "https://tv10.egydead.live/h3/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        launchBrave();
    }

    private void launchBrave() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(TARGET_URL));
            intent.setPackage(BRAVE_PACKAGE);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            Toast.makeText(this, "Brave browser not installed", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // If somehow returned, go back to Brave
        launchBrave();
    }
}
