package com.company;

/**
 * Created by konzy on 11/15/2016.
 */

public enum Letters {
    A(0.08167),
    B(0.01492),
    C(0.02784),
    D(0.04253),
    E(0.12702),
    F(0.02228),
    G(0.02015),
    H(0.06094),
    I(0.06966),
    J(0.00153),
    K(0.00772),
    L(0.04025),
    M(0.02406),
    N(0.06749),
    O(0.07507),
    P(0.01929),
    Q(0.00095),
    R(0.05987),
    S(0.06327),
    T(0.09056),
    U(0.02758),
    V(0.00978),
    W(0.02360),
    X(0.00150),
    Y(0.01974),
    Z(0.00074);

    private final double probability;

    Letters(double probability) {
        this.probability = probability;
    }

    public double getProbability() {
        return probability;
    }

    public static double getProbabilityBasedOnString(String s) {
        for (Letters letters : Letters.values()) {
            if (letters.toString().equals(s)) {
                return letters.probability;
            }
        }
        return 0.0;
    }
}
