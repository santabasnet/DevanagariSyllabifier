/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.wiseyak.unicodetokenizer;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class UnicodeTokenizerData {

    /**
     * Hex code base 16
     */
    private static final int HEX_BASE = 16;

    /**
     * Data structure to check for different character (substring) during
     * character grouping
     */
    private final HashSet<String> WHOLE_CONSONANTS;
    private final HashSet<String> WHOLE_VOWELS;
    private final HashSet<String> DEPENDENT_VOWELS;
    private final HashSet<String> DEVANAGARI_NUMBERS;
    private final HashSet<String> JOINING_SYMBOLS;
    private final HashSet<String> SPECIAL_SYMBOLS;
    private final HashSet<String> PUNCTUATION_MARKS;
    private final String HALANTA_SYMBOL;
    private final String NON_JOINING_CHAR;
    private final String JOINING_CHAR;

    /**
     * Default constructor
     */
    public UnicodeTokenizerData() {
        this.WHOLE_CONSONANTS = new HashSet<>(Arrays.asList(UnicodeTokenizerProperties.GetWholeConsonants().split(",")));
        this.WHOLE_VOWELS = new HashSet<>(Arrays.asList(UnicodeTokenizerProperties.GetWholeVowels().split(",")));
        this.DEPENDENT_VOWELS = new HashSet<>(Arrays.asList(UnicodeTokenizerProperties.GetDependentVowels().split(",")));
        this.DEVANAGARI_NUMBERS = new HashSet<>(Arrays.asList(UnicodeTokenizerProperties.GetDevanagariNumbers().split(",")));
        this.JOINING_SYMBOLS = new HashSet<>(Arrays.asList(UnicodeTokenizerProperties.GetJoiningSymbols().split(",")));
        this.SPECIAL_SYMBOLS = new HashSet<>(Arrays.asList(UnicodeTokenizerProperties.GetSpecialSymbols().split(",")));
        this.PUNCTUATION_MARKS = new HashSet<>(
                //Arrays.asList(",", "'", "\"", "!", "—", "।।")
                //Arrays.asList(",", "'", "\"", "!", "-", "—", "?", "(", ")", "]", "[", "{", "}", ".", ";", "।", "।।")
        );
        this.HALANTA_SYMBOL = UnicodeTokenizerProperties.GetHalanta();
        this.NON_JOINING_CHAR = ((char) (Integer.parseInt(UnicodeTokenizerProperties.GetNonJoiningCharacter(), HEX_BASE))) + "";
        this.JOINING_CHAR = ((char) (Integer.parseInt(UnicodeTokenizerProperties.GetJoiningCharacter(), HEX_BASE))) + "";
    }

    /**
     * Checks whether a given string chunk is a consonant character or not.
     *
     * @param chStr
     * @return true if the given string segment is a whole consonant character.
     */
    public boolean IsWholeConsonant(String chStr) {
        return this.WHOLE_CONSONANTS.contains(chStr);
    }

    /**
     * Checks whether a given string chunk is an independent vowel character or
     * not.
     *
     * @param chStr
     * @return true if the given string segment is an independent vowel
     * character.
     */
    public boolean IsWholeVowel(String chStr) {
        return this.WHOLE_VOWELS.contains(chStr);
    }

    /**
     * Checks whether a given string chunk is a dependent vowel character or
     * not.
     *
     * @param chStr
     * @return true if the given string segment is a dependent vowel character.
     */
    public boolean IsDependentVowel(String chStr) {
        return this.DEPENDENT_VOWELS.contains(chStr);
    }

    /**
     * Checks whether a given string chunk is a devanagari number or not.
     *
     * @param chStr
     * @return true if the given string segment is a devanagari number.
     */
    public boolean IsDevanagariNumber(String chStr) {
        return this.DEVANAGARI_NUMBERS.contains(chStr);
    }

    /**
     * Checks whether a given string chunk is a joinable symbol after
     * vowel/consonant character or not.
     *
     * @param chStr
     * @return true if the given string segment is a joinable symbols after
     * vowel/consonant character.
     */
    public boolean IsJoinableSymbol(String chStr) {
        return this.JOINING_SYMBOLS.contains(chStr);
    }

    /**
     * Checks whether a given string chunk is a special symbols(can appear
     * alone) or not.
     *
     * @param chStr
     * @return true if the given string segment is a special symbol.
     */
    public boolean IsSpecialSymbol(String chStr) {
        return this.SPECIAL_SYMBOLS.contains(chStr);
    }

    /**
     * Checks whether a given string chunk is halanta(viram) or not.
     *
     * @param chStr
     * @return true if the given string segment is halanta.
     */
    public boolean IsHalanta(String chStr) {
        return this.HALANTA_SYMBOL.equals(chStr);
    }

    /**
     * Checks whether a given string chunk is zero with non-joiner or not.
     *
     * @param chStr
     * @return true if the given string segment is zwnj.
     */
    public boolean IsZWNJ(String chStr) {
        return this.NON_JOINING_CHAR.equals(chStr);
    }

    /**
     * Checks whether a given string chunk is zero with joiner or not.
     *
     * @param chStr
     * @return true if the given string segment is zwj.
     */
    public boolean IsZWJ(String chStr) {
        return this.JOINING_CHAR.equals(chStr);
    }

    /**
     * Determines whether the given character string is of punctuation marks.
     *
     * @param chStr
     * @return true if the given string is punctuation mark.
     */
    public boolean IsPunctuationMark(final String chStr) {
        return this.PUNCTUATION_MARKS.contains(chStr);
    }
}
