/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.wiseyak.util;

import com.wiseyak.rules.GeneralRules;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class Global {
    
    private static final HashMap<String, Integer> FONT_NAME_IDS = GeneralRules.GetFontsNameMap();
    private static final HashMap<Integer, String> FONT_ID_NAMES = GetFontsIdMap();
    
    public static final String DEFAULT_FONT_NAME = "KANTIPUR";
    public static final String UNICODE_NAME = "UNICODE";
    public static final int FORWARD_CALL = 0;
    public static final int BACKWARD_CALL = 1;
    public static final int NEGATIVE = -1;
    public static final String EMPTY_STRING = "";
    public static final String SPACE_STRING = " ";
    public static final String EQUALS_STRING = "=";
    public static final String TAB_STRING = "\t";
    public static final String DEFAULT_STRING = "DEFAULT";
    
    /**
     * file name that holds the location of the font maps and the tokenizer data
     * files.
     */
    public static final String RULES_PROPERTIES_FILE = "resources/rules/fonts/rulefiles.properties";
    public static final String GENERAL_RULES_FILE = "resources/rules/fonts/GeneralRules.properties";
    
    /**
     * Returns the equivalent ID of a font name.
     *
     * @param name
     * @return fontID or -1 if not found.
     */
    public static int GetID(String name) {
        return FONT_NAME_IDS.getOrDefault(name.toUpperCase(), NEGATIVE);
    }
    
    /**
     * Return the equivalent Name of a font id.
     *
     * @param id
     * @return fontName or empty if not found.
     */
    public static String GetName(int id) {
        return FONT_ID_NAMES.getOrDefault(id, EMPTY_STRING);
    }
    
    /**
     * Prepares map of font ids with their names.
     *
     * @return fontIdMap
     */
    private static HashMap<Integer, String> GetFontsIdMap() {
        HashMap<Integer, String> fontIdNames = new HashMap<>();
        for (String fontName : FONT_NAME_IDS.keySet()) {
            fontIdNames.put(FONT_NAME_IDS.get(fontName), fontName);
        }
        return fontIdNames;
    }
    
    /**
     * Converts array of string to a single string with tab separated.
     *
     * @param stringArr
     * @return resultString
     */
    public static String GetStringFromArr(String[] stringArr) {
        StringBuilder result = new StringBuilder();
        for (String currentStr : stringArr) {
            result.append(currentStr).append(TAB_STRING);
        }
        return result.toString().trim();
    }
    
    /**
     * Retrieves all the loaded fonts.
     *
     * @return listOfFontNames
     */
    public static List<String> GetAllFontNames() {
        return new ArrayList<>(FONT_NAME_IDS.keySet());
    }
    
    /**
     * Replaces the last occurrence of a sub-string.
     *
     * @param sourceString
     * @param toReplace
     * @param replacement
     * @return replacedString
     */
    public static String replaceLast(String sourceString, String toReplace, String replacement) {
        int pos = sourceString.lastIndexOf(toReplace);
        String result = sourceString;
        if (pos > -1) {
            result = sourceString.substring(0, pos) + replacement
                    + sourceString.substring(pos + toReplace.length(), sourceString.length());
        }
        return result;
    }
    
}
