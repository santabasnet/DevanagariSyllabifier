/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.wiseyak.ttftokenizer;

import com.wiseyak.unicodetokenizer.UnicodeTokenizerProperties;

import java.util.HashMap;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class TTFTokenNames {
    
    //Hex code base 16
    private static final int HEX_BASE = 16;

    public static final int SINGLE_CHAR = 0;
    public static final int DOUBLE_CHAR = 1;
    public static final int MULTI_CHAR = 2;
    public static final int SPECIAL_SYMBOL = 3;
    public static final int SPECIAL_CHARACTER = 4;
    public static final int NUMBER_CHAR = 5;
    public static final int HALANTA_CHAR = 6;
    public static final int COMPOUND_CHAR = 7;
    public static final int COMPOUND_DOUBLE_CHAR = 8;
    public static final int COMPOUND_MULTI_CHAR = 9;
    public static final int VOWEL_MULTI_CHAR = 10;
    public static final int CONSONANT_MULTI_CHAR = 11;
    public static final int HALANTA_MULTI_CHAR = 12;
    public static final int HALANTA_SINGLE_CHAR = 13;
    public static final int HALANTA_SINGLE_BINDU = 14;
    public static final int ELSE_CHAR = -1;

    public static final String NUM = "NUM"; //Number
    public static final String WV = "WV"; //Whole Vowel
    public static final String TV = "TV"; //Top Vowel
    public static final String RV = "RV"; //Right Vowel
    public static final String WC = "WC"; //Whole Consonant
    public static final String BV = "BV"; //Bottom Vowel
    public static final String LV = "LV"; //Left Vowel
    public static final String CSC = "CSC"; //Compound Single Character
    public static final String HLN = "HLN"; //Halanta
    public static final String HFC = "HFC"; //Half Consonant
    public static final String BDU = "BDU"; //Bindu
    public static final String SPS = "SPS"; //Special Symbol
    public static final String SPC = "SPC"; //Special Character
    public static final String RHF = "RHF"; //Right Half Character
    public static final String ELSE = "ELSE"; //Else token
    public static final String CONNECTOR = "_";

    public static final String RV_TV = "RV_TV";
    public static final String HFC_RV = "HFC_RV";
    public static final String WC_HLN = "WC_HLN";
    public static final String SP_TV = "{";
    public static final String SP_RV = "L";
    public static final String ZWNJ = ((char)(Integer.parseInt(UnicodeTokenizerProperties.GetNonJoiningCharacter(), HEX_BASE))) + "";;
    public static final String ZWJ = ((char)(Integer.parseInt(UnicodeTokenizerProperties.GetJoiningCharacter(), HEX_BASE))) + "";

    /**
     * Constant for token group types.
     */
    public static final int GROUP_NUM = 0;
    public static final int GROUP_ONE = 1;
    public static final int GROUP_TWO = 2;
    public static final int GROUP_THREE = 3;
    public static final int GROUP_FOUR = 4;
    public static final int GROUP_FIVE = 5;
    public static final int GROUP_ELSE = 10;

    private static final HashMap<String, Integer> TOKEN_TYPE_GROUPS = InitializeTokenGroups();

    private static HashMap<String, Integer> InitializeTokenGroups() {
        HashMap<String, Integer> tokenGroups = new HashMap<>();

        //0. NUMBER
        tokenGroups.put("NUM", GROUP_NUM);

        //1. One Letter Group
        tokenGroups.put("CSC", GROUP_ONE);
        tokenGroups.put("HFC", GROUP_ONE);
        tokenGroups.put("LV", GROUP_ONE);
        tokenGroups.put("SPC", GROUP_ONE);
        tokenGroups.put("SPS", GROUP_ONE);
        tokenGroups.put("WC", GROUP_ONE);
        tokenGroups.put("WV", GROUP_ONE);

        //2. Two Letter Group
        tokenGroups.put("CSC_BDU", GROUP_TWO);
        tokenGroups.put("CSC_BV", GROUP_TWO);
        tokenGroups.put("CSC_RV", GROUP_TWO);
        tokenGroups.put("CSC_TV", GROUP_TWO);
        tokenGroups.put("HFC_CSC", GROUP_TWO);
        tokenGroups.put("HFC_WC", GROUP_TWO);
        tokenGroups.put("HFC_RV", GROUP_TWO);
        tokenGroups.put("HFC_HLN", GROUP_TWO);
        tokenGroups.put("LV_CSC", GROUP_TWO);
        tokenGroups.put("LV_HFC", GROUP_TWO);
        tokenGroups.put("LV_WC", GROUP_TWO);
        tokenGroups.put("WC_BDU", GROUP_TWO);
        tokenGroups.put("WC_BV", GROUP_TWO);
        tokenGroups.put("WC_HLN", GROUP_TWO);
        tokenGroups.put("WC_RV", GROUP_TWO);
        tokenGroups.put("WC_TV", GROUP_TWO);
        tokenGroups.put("WV_RV", GROUP_TWO);
        tokenGroups.put("WV_RHF", GROUP_TWO);
        tokenGroups.put("WV_TV", GROUP_TWO);
        tokenGroups.put("WC_RHF", GROUP_TWO);
        tokenGroups.put("WC_BDU", GROUP_TWO);

        //3. Three Letter Group
        tokenGroups.put("CSC_HLN_RV", GROUP_THREE);
        tokenGroups.put("CSC_RV_TV", GROUP_THREE);
        tokenGroups.put("HFC_WC_BV", GROUP_THREE);
        tokenGroups.put("HFC_WC_TV", GROUP_THREE);
        tokenGroups.put("HFC_WC_RV", GROUP_THREE);
        tokenGroups.put("HFC_WC_RV", GROUP_THREE);
        tokenGroups.put("HFC_WC_HLN", GROUP_THREE);
        tokenGroups.put("HFC_WC_RV", GROUP_THREE);
        tokenGroups.put("HFC_CSC_RV", GROUP_THREE);
        tokenGroups.put("HFC_CSC_BV", GROUP_THREE);
        tokenGroups.put("HFC_CSC_TV", GROUP_THREE);
        tokenGroups.put("HFC_RV_BV", GROUP_THREE);
        tokenGroups.put("HFC_RV_BDU", GROUP_THREE);
        tokenGroups.put("HFC_RV_RV", GROUP_THREE);
        tokenGroups.put("HFC_RV_TV", GROUP_THREE);
        tokenGroups.put("HFC_RV_HLN", GROUP_THREE);
        tokenGroups.put("LV_CSC_HLN", GROUP_THREE);
        tokenGroups.put("LV_HFC_WC", GROUP_THREE);
        tokenGroups.put("LV_HFC_RV", GROUP_THREE);
        tokenGroups.put("LV_WC_BDU", GROUP_THREE);
        tokenGroups.put("LV_WC_TV", GROUP_THREE);
        tokenGroups.put("LV_WC_HLN", GROUP_THREE);
        tokenGroups.put("LV_WC_RHF", GROUP_THREE);
        tokenGroups.put("LV_HFC_CSC", GROUP_THREE);
        tokenGroups.put("WC_BV_BDU", GROUP_THREE);
        tokenGroups.put("WC_BV_RHF", GROUP_THREE);
        tokenGroups.put("WC_BV_TV", GROUP_THREE);
        tokenGroups.put("WC_HLN_BDU", GROUP_THREE);
        tokenGroups.put("WC_HLN_RV", GROUP_THREE);
        tokenGroups.put("WC_RV_TV", GROUP_THREE);
        tokenGroups.put("WC_TV_BDU", GROUP_THREE);
        tokenGroups.put("WC_TV_RHF", GROUP_THREE);
        tokenGroups.put("WV_RV_TV", GROUP_THREE);
        tokenGroups.put("WV_RHF_BDU", GROUP_THREE);
        tokenGroups.put("WC_HLN_RHF", GROUP_THREE);
        tokenGroups.put("WC_RHF_RV", GROUP_THREE);
        tokenGroups.put("WC_RHF_TV", GROUP_THREE);
        tokenGroups.put("WC_TV_TV", GROUP_THREE);
        tokenGroups.put("WV_BDU_RHF", GROUP_THREE);

        //4. Four Letter Group
        tokenGroups.put("HFC_WC_HLN_RV", GROUP_FOUR);
        tokenGroups.put("HFC_WC_HLN_TV", GROUP_FOUR);
        tokenGroups.put("HFC_CSC_RV_TV", GROUP_FOUR);
        tokenGroups.put("HFC_WC_RV_TV", GROUP_FOUR);
        tokenGroups.put("HFC_WC_BV_RHF", GROUP_FOUR);
        tokenGroups.put("HFC_RV_RV_TV", GROUP_FOUR);
        tokenGroups.put("HFC_RV_TV_BDU", GROUP_FOUR);
        tokenGroups.put("HFC_RV_BV_BDU", GROUP_FOUR);
        tokenGroups.put("HFC_RV_RV_BDU", GROUP_FOUR);
        tokenGroups.put("HFC_WC_BV_BDU", GROUP_FOUR);
        tokenGroups.put("HFC_WC_TV_BDU", GROUP_FOUR);
        tokenGroups.put("HFC_WC_BDU_RHF", GROUP_FOUR);
        tokenGroups.put("HFC_RV_TV_TV", GROUP_FOUR);
        tokenGroups.put("LV_HFC_WC_BDU", GROUP_FOUR);
        tokenGroups.put("LV_HFC_WC_RHF", GROUP_FOUR);
        tokenGroups.put("LV_HFC_WC_HLN", GROUP_FOUR);
        tokenGroups.put("LV_HFC_CSC_HLN", GROUP_FOUR);
        tokenGroups.put("LV_WC_HLN_BDU", GROUP_FOUR);
        tokenGroups.put("LV_WC_TV_BDU", GROUP_FOUR);
        tokenGroups.put("LV_HFC_RV_BDU", GROUP_FOUR);
        tokenGroups.put("WC_HLN_RV_TV", GROUP_FOUR);
        tokenGroups.put("WC_RV_TV_BDU", GROUP_FOUR);
        tokenGroups.put("WV_RV_TV_BDU", GROUP_FOUR);
        tokenGroups.put("WC_TV_RHF_BDU", GROUP_FOUR);
        tokenGroups.put("WC_BV_RHF_BDU", GROUP_FOUR);
        tokenGroups.put("WC_RHF_RV_TV", GROUP_FOUR);
        tokenGroups.put("WC_RV_TV_TV", GROUP_FOUR);
        tokenGroups.put("WC_TV_BDU_RHF", GROUP_FOUR);
        

        //5. Five Letter Group
        tokenGroups.put("HFC_WC_HLN_RV_TV", GROUP_FIVE);
        tokenGroups.put("HFC_WC_HLN_RV_TV_TV", GROUP_FIVE);
        tokenGroups.put("WC_HLN_RV_TV_BDU", GROUP_FIVE);
        tokenGroups.put("WC_HLN_RHF_RV_TV", GROUP_FIVE);
        tokenGroups.put("WC_HLN_RHF_RV_TV_BDU", GROUP_FIVE);
        tokenGroups.put("WC_RHF_RV_TV_BDU", GROUP_FIVE);
        tokenGroups.put("HFC_RV_RV_TV_BDU", GROUP_FIVE);
        tokenGroups.put("HFC_CSC_RV_TV_BDU", GROUP_FIVE);
        tokenGroups.put("HFC_RV_TV_TV_BDU", GROUP_FIVE);
        tokenGroups.put("HFC_WC_RV_TV_BDU", GROUP_FIVE);
        tokenGroups.put("LV_HFC_CSC_HLN_BDU", GROUP_FIVE);
        tokenGroups.put("LV_HFC_WC_HLN_BDU", GROUP_FIVE);
        tokenGroups.put("LV_HFC_WC_BDU_RHF", GROUP_FIVE);

        //6. Else Group
        tokenGroups.put("ELSE", GROUP_ELSE);
        return tokenGroups;
    }

    public static int GetTokenGroup(String tokenType) {
        return TOKEN_TYPE_GROUPS.getOrDefault(tokenType, GROUP_ELSE);
    }

}
