/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.wiseyak.unicodetokenizer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class UnicodeTokenNames {

    private static final int HEX_BASE = 16;
    public static final int SINGLE_CHAR = 1;
    public static final int DOUBLE_CHAR = 2;
    public static final int MULTI_CHAR = 3;
    public static final int HALANTA_CHAR = 4;
    public static final int SPECIAL_CHAR = 5;
    public static final int NUMBER_CHAR = 6;
    public static final int SINGLE_WITH_JOIN_CHAR = 7;
    public static final int MULTI_CHAR_WITH_JOIN = 8;
    public static final int HALANATA_WITH_JOINER = 9;
    public static final int ELSE_CHAR = -1;

    /**
     * Special Symbol.
     */
    public static final String SPS = "SPS";
    
    /**
     * Whole consonant.
     */
    public static final String WC = "WC";
    
    /**
     * Joining Symbol.
     */
    public static final String JS = "JS";
    
    /**
     * Dependent Vowel.
     */
    public static final String DV = "DV";
    
    /**
     * Halanta.
     */
    public static final String HLN = "HLN";
    
    /**
     * Zero with non-joiner.
     */
    public static final String ZWNJ = "ZWNJ";
    
    /**
     * Zero with joiner.
     */
    public static final String ZWJ = "ZWJ";
    
    /**
     * Number token.
     */
    public static final String NUM = "NUM";
    
    /**
     * Whole Vowel.
     */
    public static final String WV = "WV";
    
    /**
     * Punctuation Marks.
     */
    public static final String PCN = "PCN";
    
    /**
     * Others token.
     */
    public static final String ELSE = "ELSE";
    
    /**
     * Symbol to connect token types for formatted output.
     */
    public static final String CONNECTOR = "_";

    public static final int GROUP_NUM = 0;
    public static final int GROUP_ONE = 1;
    public static final int GROUP_TWO = 2;
    public static final int GROUP_PCN = 5;
    public static final int GROUP_MULTI = 3;
    public static final int GROUP_ELSE = 10;

    ///////////////Special Token Types for unicode character groups.
    public static final String LV_STR = "ि";
    public static final String HALF_RA = "र्";
    public static final String RA = "र";
    public static final String HLN_STR = "्";
    public static final String ZWJ_STR = ((char)(Integer.parseInt(UnicodeTokenizerProperties.GetJoiningCharacter(), HEX_BASE))) + "";
    public static final String ZWNJ_STR = ((char)(Integer.parseInt(UnicodeTokenizerProperties.GetNonJoiningCharacter(), HEX_BASE))) + "";
    public static final String WC_HLN = "WC_HLN";
    private static final HashSet<String> RHF_CHARS_SET = new HashSet<>(Arrays.asList("झ", "फ"));
    private static final HashSet<String> COMPOSITE_HALANTA = new HashSet<>(Arrays.asList("ज्ञ्","क्ष्", "त्त्", "त्र्", "क्र्"));
    
    ///////////////

    private static final HashMap<String, Integer> TOKEN_TYPE_GROUPS = InitializeTokenGroups();

    private static HashMap<String, Integer> InitializeTokenGroups() {
        HashMap<String, Integer> tokenGroups = new HashMap<>();

        //0. NUMBER
        tokenGroups.put("NUM", GROUP_NUM);

        //1. One Letter Group
        tokenGroups.put("SPS", GROUP_ONE);
        tokenGroups.put("WC", GROUP_ONE);
        tokenGroups.put("WV", GROUP_ONE);

        //2. Two Letter Group
        tokenGroups.put("WC_DV", GROUP_TWO);
        tokenGroups.put("WC_HLN", GROUP_TWO);
        tokenGroups.put("WC_JS", GROUP_TWO);

        //3. Multi Letter Group
        tokenGroups.put("WC_DV_ZWNJ", GROUP_MULTI);
        tokenGroups.put("WC_HLN_WC", GROUP_MULTI);
        tokenGroups.put("WC_HLN_ZWNJ", GROUP_MULTI);
        tokenGroups.put("WC_HLN_ZWJ", GROUP_MULTI);
        tokenGroups.put("WC_HLN_WC_DV", GROUP_MULTI);
        tokenGroups.put("WC_HLN_WC_JS", GROUP_MULTI);
        tokenGroups.put("WC_HLN_WC_DV_ZWNJ", GROUP_MULTI);
        tokenGroups.put("WC_HLN_WC_HLN_WC", GROUP_MULTI);
        tokenGroups.put("WC_HLN_WC_HLN_WC_DV", GROUP_MULTI);
        
        //5. Punctuation Letter 
        tokenGroups.put(PCN, GROUP_PCN);

        tokenGroups.put("ELSE", GROUP_ELSE);

        return tokenGroups;
    }

    public static int GetTokenGroup(String tokenType) {
        return TOKEN_TYPE_GROUPS.getOrDefault(tokenType, GROUP_ELSE);
    }
    
    public static boolean IsNextRHFChar(String chStr){
        return RHF_CHARS_SET.contains(chStr);
    }
    
    public static String GetFirstHalfRa(){
        return "र्१";
    }
    
    public static boolean isMultiTokenTypes(int type){
        return type == GROUP_TWO || type == GROUP_MULTI || type == GROUP_ELSE;
    }
    
    /**
     * Checks whether the 
     * @param compositeChr
     * @return true if it is a composite half character, क्ष् or ज्ञ् .
     */
    public static boolean IsCompositeHalanta(String compositeChr){
        return COMPOSITE_HALANTA.contains(compositeChr);
    }
}
