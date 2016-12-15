package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    protected static String cipher_text;
    protected static String known_plaintext;

    public static void main(String[] args) {
        javafx.application.Application.launch(GUIinterface.class);
    }
    public static void testRun(){
        Running runningKey = new Running(cipher_text, known_plaintext);
        ArrayList<CipherTextSnippet> snippets = runningKey.getCipherTextSnippets();
        Collections.sort(snippets);

        for (CipherTextSnippet snippet : snippets) {
            System.out.println(snippet.getIndex() + " " + snippet.toString() + " " + snippet.getIndexOfCoincidence());
        }

        System.out.println("asdf");
    }

}
