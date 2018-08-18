package de.mide.wear.glossar_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


/**
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class MainActivity extends WearableActivity
                          implements AdapterView.OnItemClickListener {

    /** Key für Extra, um Glossar-Begriff zu übergeben. */
    public static final String EXTRA_KEY_BEGRIFF = "GLOSSAR_BEGRIFF";

    /** Key für Extra, um Erklärung für Glossar-Begriff zu übergeben. */
    public static final String EXTRA_KEY_ERKLAERUNG = "GLOSSAR_ERKLAERUNG";

    /** Liste mit Strings, die von ListView-Element angezeigt werden sollen. */
    protected List<String> glossarBegriffListe = null;


    /**
     * Lifecycle-Methode.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView glossarListView = findViewById( R.id.glossarListView );

        glossarBegriffListe = GlossarDaten.getGlossarBegriffe();
        ArrayAdapter<String> glossarArrayAdapter =
                new ArrayAdapter<String>(this,
                        R.layout.glossar_list_item,
                        R.id.glossarEintrag,
                        glossarBegriffListe);

        glossarListView.setAdapter(glossarArrayAdapter);

        glossarListView.setOnItemClickListener(this);

        Toast toast = Toast.makeText(this,
                "Anzahl Glossar-Einträge: " + glossarBegriffListe.size(),
                Toast.LENGTH_LONG);
        toast.show();

        setAmbientEnabled(); // Enables Always-on
    }


    /**
     * Einzige Methode aus Interface {@link AdapterView.OnItemClickListener}.
     *
     * @param position 0-basierter Index des Listen-Eintrags, auf den geklickt wurde.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String glossarBegriff = glossarBegriffListe.get(position);

        String erklaerung = GlossarDaten.getErklaerung(glossarBegriff);

        if (erklaerung == null) {

            Toast toast = Toast.makeText(this,
                    "Interner Fehler: Keine Erklärung für \"" + glossarBegriff + "\".",
                    Toast.LENGTH_LONG);
            toast.show();

        } else {

            Intent intent = new Intent(this, ErklaerungsActivity.class);
            intent.putExtra(EXTRA_KEY_BEGRIFF   , glossarBegriff);
            intent.putExtra(EXTRA_KEY_ERKLAERUNG, erklaerung    );
            startActivity(intent);
        }
    }

}
