package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    private static final String CIPHER_TEXT = "PPPQCNOYQFRRREQCPAYMOGCJXOKXIESSNVKOGNMFDWHLIPJGKXLLAYBLWLAWCBQMMAMIOEEFXJMUBRT";
    private static final String KNOWN_PLAINTEXT = "FIREDMAN";

    public static void main(String[] args) {
        Running runningKey = new Running(CIPHER_TEXT, KNOWN_PLAINTEXT);
        ArrayList<CipherTextSnippet> snippets = runningKey.getCipherTextSnippets();
        Collections.sort(snippets);

        for (CipherTextSnippet snippet : snippets) {
            System.out.println(snippet.getIndex() + " " + snippet.toString() + " " + snippet.getIndexOfCoincidence());
        }

        System.out.println("asdf");
    }
}
