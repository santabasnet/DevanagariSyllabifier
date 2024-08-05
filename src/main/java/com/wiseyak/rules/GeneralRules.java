/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.wiseyak.rules;

import com.wiseyak.util.Global;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class GeneralRules {

    /**
     * File Naming rule and the template.
     */
    private static final String DEFAULT_TTF_PATH = RulesFileProperties.GetForwardFontsMapPath();
    private static final String DEFAULT_UNICODE_PATH = RulesFileProperties.GetBackwardFontsMapPath();
    private static final String DEFAULT_MAP_FILE = RulesFileProperties.GetDefaultFontsMapFileName();
    private static final String FORWARDFONTMAPDATA = RulesFileProperties.GetForwardFilesNameTemplate();
    private static final String BACKWARDFONTMAPDATA = RulesFileProperties.GetBackwardFilesNameTemplate();
    
    private static final Properties GENERAL_PROPERTIES = GeneralRulesProperties();

    private static Properties GeneralRulesProperties() {
        Properties generalProperties = new Properties();
        try {
            generalProperties.load(new FileInputStream(Global.GENERAL_RULES_FILE));
        } catch (Exception ee) {
            throw new RuntimeException("\nError: Unable to find the general properties file. System could not continue further.\nDetail: " + ee.toString());
        }
        return (generalProperties);
    }

    /**
     * Return the HashMap of font names and their integer ids.
     *
     * @return fontNameIdsMap, or null if there not exists.
     */
    public static HashMap<String, Integer> GetFontsNameMap() {
        HashMap<String, Integer> fontsMap = new HashMap<>();
        String[] fontNames = GeneralRules.GENERAL_PROPERTIES.getProperty("FontsName").split(",");
        String[] fontIds = GeneralRules.GENERAL_PROPERTIES.getProperty("FontsId").split(",");
        try {
            int i = 0;
            for (String fontName : fontNames) {
                fontsMap.put(fontName.trim(), Integer.parseInt(fontIds[i++].trim()));
            }
        } catch (Exception ee) {
            return null;
        }
        return fontsMap;
    }

    /**
     * Returns the actual font mapping data file name for forward conversion.
     *
     * @param fontName
     * @return forwardFontDataFile
     */
    public static String GetForwardFontDataFile(String fontName) {
        return DEFAULT_TTF_PATH + FORWARDFONTMAPDATA.replaceFirst(Global.EQUALS_STRING, fontName);
    }

    /**
     * Returns the actual font mapping data file name for backward conversion.
     *
     * @param fontName
     * @return backwardFontDataFile
     */
    public static String GetBackwardFontDataFile(String fontName) {
        return DEFAULT_UNICODE_PATH + BACKWARDFONTMAPDATA.replaceFirst(Global.EQUALS_STRING, fontName);
    }

    /**
     * Returns the default font mapping data file name for the forward conversion.
     * 
     * @return defaultFontFile.
     */
    public static String GetDefaultForwardFontDataFile() {
        return DEFAULT_TTF_PATH + DEFAULT_MAP_FILE;
    }
    
    /**
     * Returns the default font mapping data file name for the backward conversion.
     * 
     * @return defaultFontFile.
     */
    public static String GetDefaultBackwardFontDataFile(){
        return DEFAULT_UNICODE_PATH + DEFAULT_MAP_FILE;
    }
}
