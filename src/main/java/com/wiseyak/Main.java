package com.wiseyak;

import com.wiseyak.unicodetokenizer.UnicodeCharacterTokenizer;

/**
 * This class is a part of the package com.wiseyak and the package
 * is a part of the project Default (Template) Project.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://integratedict.com.np/
 * https://semantro.com/
 * <p>
 * Created by santa on 2024-08-05.
 * https://github.com/santabasnet
 */
public class Main {
    public static void main(String[] args) {

        String resultExpected = "[रा{WC_DV}, ष्ट्रि{WC_HLN_WC_HLN_WC_DV}, य{WC}, ता{WC_DV}, को{WC_DV}]";
        String testData = "राष्ट्रियताको";
        UnicodeCharacterTokenizer tokenizer;

        String numberExpected = "[१२३४०{NUM}]";
        String numberTest = "१२३४०";

        tokenizer = new UnicodeCharacterTokenizer(testData);
        String resultOutcome1 = tokenizer.GetGroupedCharacters().toString();
        System.out.println("\nInput: " + testData);
        System.out.println("\t" + resultOutcome1);

        tokenizer = new UnicodeCharacterTokenizer(numberTest);
        String resultOutcome2 = tokenizer.GetGroupedCharacters().toString();
        System.out.println("\nInput: " + numberTest);
        System.out.println("\t" + resultOutcome2);

    }
}