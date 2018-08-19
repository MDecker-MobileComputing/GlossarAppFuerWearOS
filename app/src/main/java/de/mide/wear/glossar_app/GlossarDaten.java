package de.mide.wear.glossar_app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


/**
 * Diese Klasse stellt die anzuzeigenden Glossar-Begriffe für den Wissensbereich
 * "Android-Programmierung" zur Verfügung.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class GlossarDaten {

    /** Hashmap, bildet Glossar-Eintrag auf Erklärungs-Text ab. */
    protected static HashMap<String,String> sHashMap = null;


    /**
     * Schreibt die Glossar-Einträge als Paare "Begriff -- Erklärung" in eine Hashmap
     * (Begriff ist der Key).
     * Begriffe werden in alphabetischer Reihenfolge hinzugefügt, damit man im Quellcode
     * schnell erkennt, ob ein Begriff schon vorhanden ist.
     * <br><br>
     *
     * Diese Methode wird beim ersten Aufruf einer der beiden public-Methoden aufgerufen,
     * die Glossar initialisiert sich also quasi selbst.
     */
    protected static void initDaten() {

        sHashMap = new HashMap<String,String>();

        sHashMap.put("Activity",
                "Bildschirm-Seite einer Android-App.");

        sHashMap.put("ADB",
                "Android Debug Bridge");

        sHashMap.put("Android Studio",
                "Offizielle Entwicklungsumgebung für Android-Apps; " +
                "basiert auf Java-Entwicklungsumgebung \"IntelliJ\" von der Firma JetBrains; " +
                "vor Android Studio war Eclipse mit dem Plugin \"ADT\" (Android Development Tools) " +
                " die offizielle IDE für Android.");

        sHashMap.put("APK",
                "Android Package; Dateiformat für die Installationsdatei einer Android-App.");

        sHashMap.put("ARM",
                "CPU-Architektur, die in den meisten Android-Geräten (Smartphones & Tablets) sowie " +
                "Smartwatches und auch iOS-Geräten zum Einsatz kommt.");

        sHashMap.put("AVD",
                "Android Virtual Device; Instanz eines Android-Gerätes im Emulator.");

        sHashMap.put("Extra",
                "Daten in Form eines Key-Value-Paars, die einem Intent mitgegeben werden können; " +
                "der Key muss immer ein String sein, für den Value sind verschiedene Datentypen möglich.");

        sHashMap.put("IDE",
                "Integrated Development Environment; Entwicklungsumgebung für Software; " +
                "für Android-Apps ist derzeit \"Android Studio\" die offizielle IDE.");

        sHashMap.put("Intent",
                "Asynchrone Nachricht zwischen verschiedenen Android-Komponenten.");

        sHashMap.put("Java ME",
                "Java MicroEdition; \"Handy-Java\"; nicht kompatibel zu Android.");
    }

    /* *************************************** */
    /* ********* Start innere Klasse ********* */
    /* *************************************** */

    /**
     * Comparator, der beim Vergleich die Groß-/Kleinschreibung
     * ignoriert; wird für die Sortierung der Glossar-Begriffe
     * verwendet.
     */
    private static class MeinComparator implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            return str1.compareToIgnoreCase(str2);
        }
    };
    /* *************************************** */
    /* ********* Ende innere Klasse  ********* */
    /* *************************************** */

    /**
     * Liefert sortierte Liste mit allen Glossar-Begriffen zurück (nur die Begriffe, nicht die
     * Erklärung).
     *
     * @return List mit den Glossar-Begriffe, z.B. "ADB" oder "Daydream".
     */
    public static List<String> getGlossarBegriffe() {

        if (sHashMap == null) initDaten();

        List<String> begriffsListe = new ArrayList<String>( sHashMap.keySet() );

        Collections.sort(begriffsListe, new MeinComparator() );

        return begriffsListe;
    }


    /**
     * Abfragen des Erklärungstextes für einen Glossar-Begriff.
     *
     * @param glossarBegriff Begriff, für den die Erklärung benötigt wird.
     *
     * @return Erklärung oder <i>null</i>, wenn nicht gefunden.
     */
    public static String getErklaerung(String glossarBegriff) {

        if (sHashMap == null) initDaten();

        return sHashMap.get(glossarBegriff);
    }

};
