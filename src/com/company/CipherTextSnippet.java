package com.company;

/**
 * Created by konzy on 11/15/2016.
 */
public class CipherTextSnippet implements Comparable {
    private double indexOfCoincidence = 0;
    private double likelihoodOfLettersInEnglish = 0;
    private String cipherText;
    private int index;

    public CipherTextSnippet(String cipherText, int index) {
        this.cipherText = cipherText;
        this.index = index;
        indexOfCoincidence = computeIndexOfCoincidence();
        likelihoodOfLettersInEnglish = computeLiklihood();
    }

    private double computeIndexOfCoincidence() {
        double result = 0.0;
        for (Letters letters : Letters.values()) {
            String current = letters.name();
            int appearances = 0;
            for (char c : cipherText.toCharArray()) {
                if (current.equals(Character.toString(c))) {
                    appearances++;
                }
            }
            result += ((double)appearances / cipherText.length()) * ((double)(appearances - 1) / (cipherText.length() - 1));
        }
        return result;
    }



    private double computeLiklihood() {
        double result = 0.0;

        for (char c : cipherText.toCharArray()) {
            String s = Character.toString(c);
            result += Letters.getProbabilityBasedOnString(s);
        }
        return result;
    }

    public int length() {
        return cipherText.length();
    }

    public char charAt(int i) {
        return cipherText.charAt(i);
    }

    public double getLikelihoodOfLettersInEnglish() {
        return likelihoodOfLettersInEnglish;
    }

    public String getCipherText() {
        return cipherText;
    }

    public double getIndexOfCoincidence() {
        return indexOfCoincidence;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof CipherTextSnippet) {
            if (getLikelihoodOfLettersInEnglish() > ((CipherTextSnippet) o).getLikelihoodOfLettersInEnglish()) {
                return - 1;
            } else if (getLikelihoodOfLettersInEnglish() < ((CipherTextSnippet) o).getLikelihoodOfLettersInEnglish()) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return cipherText;
    }
}
