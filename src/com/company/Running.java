package com.company;

import java.util.ArrayList;

/**
 * Created by konzy on 11/15/2016.
 */

public class Running {
    private String cipherText;
    private String knownPlainText;
    private ArrayList<CipherTextSnippet> cipherTextSnippets;

    private static final int OFFSET = 64;

    public Running(String cipherText, String knownPlainText) {
        this.cipherText = cipherText;
        this.knownPlainText = knownPlainText;
        cipherTextSnippets = new ArrayList<>();
        computeCipherTextSnippets();
    }

    private void computeCipherTextSnippets() {
        for (int i = 0; i < cipherText.length() - knownPlainText.length() - 1; i++) {//go down cipher text string
            String acc = "";
            int currentPlainTextIndex = 0;
            for (int startOfCipher = i; startOfCipher < knownPlainText.length() + i; startOfCipher++) {//
                int ct = cipherText.charAt(startOfCipher) - OFFSET;
                int pt = knownPlainText.charAt(currentPlainTextIndex++) - OFFSET;
                int keyLetter = ((pt - ct) + 26) % 26 + OFFSET;
                if (keyLetter == OFFSET) {
                    keyLetter = 'Z';
                }
                acc += Character.toString((char) keyLetter);
            }
            cipherTextSnippets.add(new CipherTextSnippet(acc, i));
        }
    }

    public String getCipherText() {
        return cipherText;
    }

    public String getKnownPlainText() {
        return knownPlainText;
    }

    public ArrayList<CipherTextSnippet> getCipherTextSnippets() {
        return cipherTextSnippets;
    }
}
