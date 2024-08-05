/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.wiseyak.unicodetokenizer;

import com.wiseyak.rules.RulesFileProperties;

import java.io.FileInputStream;
import java.util.Properties;

/**
 *
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class UnicodeTokenizerProperties {

    private static final String FILE_NAME = "tokenizerdata.properties";
    private static final Properties TOKENIZER_PROPERTIES = LoadTokenizerProperties();
    
    private static Properties LoadTokenizerProperties() {
        Properties tokenizerProperties = new Properties();
        try {
            tokenizerProperties.load(new FileInputStream(RulesFileProperties.GetUnicodeTokenizerDataPath() + FILE_NAME));
        } catch (Exception ee) {
            final String errorMessage = "Unable to find the tokenizer properties file. System could not continue further.\tDetail: " + ee.toString();
            throw new RuntimeException("Unable to find the tokenizer properties file. System could not continue further.\nDetail: " + ee.toString());
        }
        return (tokenizerProperties);
    }
    
    public static String GetWholeConsonants(){
        return UnicodeTokenizerProperties.TOKENIZER_PROPERTIES.getProperty("DevanagariConsonants");
    }
    
    public static String GetWholeVowels(){
        return UnicodeTokenizerProperties.TOKENIZER_PROPERTIES.getProperty("DevanagariVowels");
    }  
    
    public static String GetDependentVowels(){
        return UnicodeTokenizerProperties.TOKENIZER_PROPERTIES.getProperty("DevanagariDependentVowels");
    }
    
    public static String GetDevanagariNumbers(){
        return UnicodeTokenizerProperties.TOKENIZER_PROPERTIES.getProperty("DevanagariNumbers");
    }
    
    public static String GetJoiningSymbols(){
        return UnicodeTokenizerProperties.TOKENIZER_PROPERTIES.getProperty("SpecialJoiningSymbols");
    }
    
    public static String GetSpecialSymbols(){
        return UnicodeTokenizerProperties.TOKENIZER_PROPERTIES.getProperty("SpecialSymbols");
    }
    
    public static String GetHalanta(){
        return UnicodeTokenizerProperties.TOKENIZER_PROPERTIES.getProperty("Halanta");
    }
    
    public static String GetNonJoiningCharacter(){
        return UnicodeTokenizerProperties.TOKENIZER_PROPERTIES.getProperty("NonJoinChar");
    }
    
    public static String GetJoiningCharacter(){
        return UnicodeTokenizerProperties.TOKENIZER_PROPERTIES.getProperty("JoinChar");
    }
    
}
