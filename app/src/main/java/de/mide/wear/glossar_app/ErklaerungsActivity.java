package de.mide.wear.glossar_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Activity zur Darstellung der Erklärung für den ausgewählten Glossar-Begriff.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class ErklaerungsActivity extends WearableActivity  {

    /**
     * Lifecycle-Methode.
     *
     * Holt sich aus Intent, mit dem diese Activity aufgerufen wurde,
     * den als Extra mitgegebenen Erklärungs-String, der dann im
     * TextView-Element dargestellt wird.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erklaerung);

        Intent intent = getIntent();
        String glossarBegriff = intent.getStringExtra(MainActivity.EXTRA_KEY_BEGRIFF   );
        String erklaerung     = intent.getStringExtra(MainActivity.EXTRA_KEY_ERKLAERUNG);

        TextView glossarTextView = findViewById(R.id.begriffTextView);
        glossarTextView.setText(glossarBegriff);

        TextView erklaerungsTextView = findViewById(R.id.erklaerungTextView);
        erklaerungsTextView.setText(erklaerung);

        setAmbientEnabled(); // Enables Always-on
    }


}
