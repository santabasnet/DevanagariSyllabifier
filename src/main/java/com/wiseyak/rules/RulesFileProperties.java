/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.wiseyak.rules;

import com.wiseyak.util.Global;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class RulesFileProperties {
    /**
     * All properties information.
     */
    private static final Properties RULEFILE_PROPERTIES = RulesFileProperties();
    
    /**
     * Loads the rules files information from the properties file.
     * 
     * @return rulesProperties. 
     */
    private static Properties RulesFileProperties() {
        Properties rulesProperties = new Properties();
        try {
            rulesProperties.load(new FileInputStream(Global.RULES_PROPERTIES_FILE));
        } catch (IOException ee) {
            throw new RuntimeException("\nError: Unable to find the rule file properties file. System could not continue further.\nDetail: " + ee.toString());
        }
        return (rulesProperties);
    }
    
    /**
     * Get the location of the forward (ttf to unicode) font maps.
     * 
     * @return forwardFontsMapPath
     */
    public static String GetForwardFontsMapPath(){
        return RulesFileProperties.RULEFILE_PROPERTIES.getProperty("ttftounicodemapspath");
    }
    
    /**
     * Get the location of the backward (unicode to ttf) font maps.
     * 
     * @return backwardFontsMapPath
     */
    public static String GetBackwardFontsMapPath(){
        return RulesFileProperties.RULEFILE_PROPERTIES.getProperty("unicodetottfmapspath");
    }
    
    /**
     * Return the data path for ttf tokenizer data.
     * 
     * @return ttfTokenizerDataPath
     */
    public static String GetTTFTokenizerDataPath(){
        return RulesFileProperties.RULEFILE_PROPERTIES.getProperty("ttftokenizerpath");
    }
    
    /**
     * Return the data path for unicode tokenizer data.
     * 
     * @return unicodeTokenizerDataPath
     */
    public static String GetUnicodeTokenizerDataPath(){
        return RulesFileProperties.RULEFILE_PROPERTIES.getProperty("unicodetokenizerpath");
    }
    
    /**
     * Returns the default fonts map file, a file that has all common fonts map
     * for both the unicode and the fonts data.
     * 
     * @return defaultFontMapFileName
     */
    public static String GetDefaultFontsMapFileName(){
        return RulesFileProperties.RULEFILE_PROPERTIES.getProperty("defaultfontsmap");
    }
    
    /**
     * Returns the file name template for the forward conversion.
     * 
     * @return forwardFileNameTemplate
     */
    public static String GetForwardFilesNameTemplate(){
        return RulesFileProperties.RULEFILE_PROPERTIES.getProperty("forwardfilesnametemplate");
    }
    
    /**
     * Returns the file name template for the backward conversion.
     * 
     * @return backwardFileNameTemplate
     */
    public static String GetBackwardFilesNameTemplate(){
        return RulesFileProperties.RULEFILE_PROPERTIES.getProperty("backwardfilesnametemplate");
    }
    
}
