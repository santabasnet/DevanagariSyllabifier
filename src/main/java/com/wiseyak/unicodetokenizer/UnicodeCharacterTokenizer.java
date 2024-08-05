/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.wiseyak.unicodetokenizer;

import com.wiseyak.util.GroupToken;
import com.wiseyak.util.States;

import java.util.ArrayList;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class UnicodeCharacterTokenizer {

    /**
     * Unicode Tokenizer Data
     */
    private static final UnicodeTokenizerData TOKENIZER_DATA = new UnicodeTokenizerData();

    String srcString;
    ArrayList<GroupToken> tokensList;

    public UnicodeCharacterTokenizer(String srcString) {
        this.srcString = srcString;
        this.tokensList = new ArrayList<>();
        Tokenize();
    }

    private void Tokenize() {
        InitializeTokenizer();
        GroupToken token = GetNextToken();
        while (token != null) {
            tokensList.add(token);
            token = GetNextToken();
        }
    }

    ///////////////////////Tokenizer Implementation
    //Token data
    private int strIndex;
    private int currentState;
    String currentTokenStr;
    String tokenType;

    private void InitializeTokenizer() {
        this.strIndex = States.ZERO;
    }

    private GroupToken GetNextToken() {
        if (this.strIndex >= this.srcString.length()) {
            return null;
        }
        this.currentTokenStr = "";
        this.currentState = States.ONE;
        this.tokenType = UnicodeTokenNames.ELSE;

        for (; this.strIndex < this.srcString.length();) {
            String chStr = GetNextChar() + "";
            //System.out.println("char :" + chStr + "\ttokenstr -> " + currentTokenStr + "\tstate :" + currentState + "\ttokentype :" + tokenType);
            switch (this.currentState) {
                case States.ONE:
                    if (TOKENIZER_DATA.IsWholeVowel(chStr)) {
                        tokenType = UnicodeTokenNames.WV;
                        this.currentState = States.SIX;
                    } else if (TOKENIZER_DATA.IsWholeConsonant(chStr)) {
                        tokenType = UnicodeTokenNames.WC;
                        this.currentState = States.TWO;
                    } else if (TOKENIZER_DATA.IsDevanagariNumber(chStr)) {
                        tokenType = UnicodeTokenNames.NUM;
                        this.currentState = States.FIVE;
                    } else if (TOKENIZER_DATA.IsPunctuationMark(chStr)) {
                        tokenType = UnicodeTokenNames.PCN;
                        this.currentState = States.SEVEN;
                    } else if (TOKENIZER_DATA.IsSpecialSymbol(chStr)) {
                        tokenType = UnicodeTokenNames.SPS;
                        this.currentState = States.UNICODE_FINAL_STATE;
                    } else {
                        this.currentState = States.UNICODE_FINAL_STATE;
                    }
                    currentTokenStr += chStr;
                    break;
                case States.TWO:
                    if (TOKENIZER_DATA.IsJoinableSymbol(chStr)) {
                        currentTokenStr += chStr;
                        tokenType += UnicodeTokenNames.CONNECTOR + UnicodeTokenNames.JS;
                        this.currentState = States.UNICODE_FINAL_STATE;
                    } else if (TOKENIZER_DATA.IsHalanta(chStr)) {
                        currentTokenStr += chStr;
                        tokenType += UnicodeTokenNames.CONNECTOR + UnicodeTokenNames.HLN;
                        this.currentState = States.THREE;
                    } else if (TOKENIZER_DATA.IsDependentVowel(chStr)) {
                        currentTokenStr += chStr;
                        tokenType += UnicodeTokenNames.CONNECTOR + UnicodeTokenNames.DV;
                        this.currentState = States.FOUR;
                    } else if (TOKENIZER_DATA.IsPunctuationMark(chStr)) {
                        UnGetCurrentChar();
                        this.currentState = States.SEVEN;
                    } else {
                        this.currentState = States.UNICODE_FINAL_STATE;
                        UnGetCurrentChar();
                    }
                    break;
                case States.THREE:
                    if (TOKENIZER_DATA.IsWholeConsonant(chStr)) {
                        currentTokenStr += chStr;
                        tokenType += UnicodeTokenNames.CONNECTOR + UnicodeTokenNames.WC;
                        currentState = States.TWO;
                    } else if (TOKENIZER_DATA.IsZWNJ(chStr)) {
                        currentTokenStr += chStr;
                        currentState = States.UNICODE_FINAL_STATE;
                        tokenType += UnicodeTokenNames.CONNECTOR + UnicodeTokenNames.ZWNJ;
                    } else if (TOKENIZER_DATA.IsZWJ(chStr)) {
                        currentTokenStr += chStr;
                        currentState = States.UNICODE_FINAL_STATE;
                        tokenType += UnicodeTokenNames.CONNECTOR + UnicodeTokenNames.ZWJ;
                    } else if (TOKENIZER_DATA.IsPunctuationMark(chStr)) {
                        UnGetCurrentChar();
                        this.currentState = States.SEVEN;
                    } else {
                        this.currentState = States.UNICODE_FINAL_STATE;
                        UnGetCurrentChar();
                    }
                    break;
                case States.FOUR:
                    if (TOKENIZER_DATA.IsJoinableSymbol(chStr)) {
                        tokenType += UnicodeTokenNames.CONNECTOR + UnicodeTokenNames.JS;
                        currentTokenStr += chStr;
                    } else if (TOKENIZER_DATA.IsPunctuationMark(chStr)) {
                        UnGetCurrentChar();
                        this.currentState = States.SEVEN;
                    } else {
                        UnGetCurrentChar();
                    }
                    this.currentState = States.UNICODE_FINAL_STATE;
                    break;
                case States.FIVE:
                    if (TOKENIZER_DATA.IsDevanagariNumber(chStr)) {
                        this.currentState = States.FIVE;
                        currentTokenStr += chStr;
                    } else if (TOKENIZER_DATA.IsPunctuationMark(chStr)) {                        
                        this.currentState = States.SEVEN;
                        UnGetCurrentChar();
                    } else {
                        this.currentState = States.UNICODE_FINAL_STATE;
                        UnGetCurrentChar();
                    }
                    break;
                case States.SIX:
                    if (TOKENIZER_DATA.IsJoinableSymbol(chStr)) {
                        tokenType += UnicodeTokenNames.CONNECTOR + UnicodeTokenNames.JS;
                        currentTokenStr += chStr;
                    } else if (TOKENIZER_DATA.IsPunctuationMark(chStr)) {
                        UnGetCurrentChar();
                        this.currentState = States.SEVEN;
                    } else {
                        UnGetCurrentChar();
                    }
                    this.currentState = States.UNICODE_FINAL_STATE;
                    break;

                case States.SEVEN:
                    if (TOKENIZER_DATA.IsPunctuationMark(chStr)) {
                        currentTokenStr += chStr;
                        tokenType += UnicodeTokenNames.CONNECTOR + UnicodeTokenNames.PCN;
                        this.currentState = States.SEVEN;
                    } else {
                        UnGetCurrentChar();
                    }
                    break;

                default:
                    this.currentState = States.UNICODE_FINAL_STATE;
                    this.tokenType += UnicodeTokenNames.ELSE;
                    this.currentTokenStr += chStr;
            }
            if (this.currentState == States.UNICODE_FINAL_STATE || this.currentState == States.SEVEN) {
                break;
            }
        }
        return currentTokenStr.isEmpty() == true ? null : new GroupToken(tokenType, currentTokenStr);
    }

    private char GetNextChar() {
        return this.srcString.charAt(this.strIndex++);
    }

    private void UnGetCurrentChar() {
        this.strIndex--;
    }

    ///////////////////////End of Tokenizer Implementation
    /**
     * Returns the list of tokens i.e. the output of the Tokenizer.
     *
     * @return tokenizedData
     */
    public ArrayList<GroupToken> GetGroupedCharacters() {
        return this.tokensList;
    }
}
