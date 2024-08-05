/*
 * Copyright: 2015 Integrated ICT Pvt. Ltd.
 * Kathmandu, Nepal
 * http://www.integratedict.com.np
 */
package com.wiseyak.util;

import com.wiseyak.ttftokenizer.TTFTokenNames;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Santa Basnet <sbasnet [at] google.com>
 */
public class GroupToken implements Comparable {
    
    String type;
    String name;
    ArrayList<String> typeList;
    
    /**
     * Initializes the token type and name in the String format.
     *
     * @param type
     * @param name
     */
    public GroupToken(final String type, final String name) {
        this.type = type;
        this.name = name;
        this.typeList = new ArrayList<>(Arrays.asList(this.type.split(TTFTokenNames.CONNECTOR)));
    }
    
    /**
     * Initializes the token type and name in the String format.
     *
     * @param type
     * @param name
     * @param typeList
     */
    public GroupToken(final String type, final String name, final ArrayList<String> typeList) {
        this.type = type;
        this.name = name;
        this.typeList = typeList;
    }
    
    /**
     * Creates an empty group token.
     *
     * @return emptyGroupToken.
     */
    public static GroupToken empty() {
        return new GroupToken(Global.EMPTY_STRING, Global.EMPTY_STRING);
    }
    
    /**
     * Check if the token is empty.
     */
    public Boolean isEmpty() {
        return this.type.isEmpty() || this.name.isEmpty();
    }
    
    /**
     * Check if the token is of non-empty instance.
     */
    public Boolean nonEmpty() {
        return !isEmpty();
    }
    
    /**
     * Returns the String content of the token type.
     *
     * @return
     */
    public String getType() {
        return type;
    }
    
    /**
     * Returns the String content of the token.
     *
     * @return tokenName
     */
    public String getName() {
        return name;
    }
    
    /**
     * Sets the token type.
     *
     * @param type
     */
    public void setType(final String type) {
        this.type = type;
        this.typeList = new ArrayList<>(Arrays.asList(this.type.split(TTFTokenNames.CONNECTOR)));
    }
    
    /**
     * Sets the token String.
     *
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }
    
    /**
     * Check if the token name is started with give string.
     *
     * @param tokenStr
     * @return true if it is stared with given tokenStr.
     */
    public boolean isStartedWith(final String tokenStr) {
        return this.name.startsWith(tokenStr);
    }
    
    /**
     * Check if the token name is ended with give string.
     *
     * @param tokenStr
     * @return true if it is stared with given tokenStr.
     */
    public boolean isEndedWith(final String tokenStr) {
        return this.name.endsWith(tokenStr);
    }
    
    /**
     * Checks if the current token has left vowel as in starting character.
     *
     * @param typeStr
     * @return true if it is start with Left Vowel
     */
    public boolean isTypeStartedWith(final String typeStr) {
        return this.type.startsWith(typeStr);
    }
    
    /**
     * Checks if the current token has ending of the given token string.
     *
     * @param typeStr
     * @return true if it is ended with the parameter tokenStr.
     */
    public boolean isTypeEndedWith(final String typeStr) {
        return this.type.endsWith(typeStr);
    }
    
    /**
     * Checks if the current token contains the given token type.
     *
     * @param tokenStr
     * @return true if the the current token has the given token types.
     */
    public boolean hasTokenType(final String tokenStr) {
        return this.type.contains(tokenStr);
    }
    
    /**
     * Checks if the token type list contains the given type or not and returns
     * its index as a result.
     *
     * @param typeStr
     * @return tokIndex as a index of the given token type.
     */
    public int GetTokenIndex(String typeStr) {
        try {
            return this.typeList.indexOf(typeStr);
        } catch (Exception ee) {
            return Global.NEGATIVE;
        }
    }
    
    /**
     * Checks if the token type list contains the given type or not and return
     * its last index as a result.
     *
     * @param typeStr
     * @return lastTokenIndex
     */
    public int GetLastTokenIndex(String typeStr) {
        try {
            return this.typeList.lastIndexOf(typeStr);
        } catch (Exception ee) {
            return Global.NEGATIVE;
        }
    }
    
    /**
     * Checks if the token type list contains the given index and returns its
     * index as a result.
     *
     * @param typeIndex
     * @return tokenString as a result from the list of token types.
     */
    public String IndexOfTokenType(int typeIndex) {
        try {
            return this.typeList.get(typeIndex);
        } catch (Exception ee) {
            return Global.EMPTY_STRING;
        }
    }
    
    /**
     * Remove the given token type from the first occurrence and return the
     * remaining type.
     *
     * @param typeStr
     * @return remainType as a truncated from the first of the current token
     * type.
     */
    public String RemoveType(String typeStr) {
        if (typeStr.length() < this.type.length()) {
            return this.type.substring(typeStr.length() + 1);
        }
        return Global.EMPTY_STRING;
    }
    
    /**
     * Remove the given token type upto nth position.
     *
     * @param n
     * @return remainType as a truncated from the first nth position.
     */
    public String RemoveTypeUpto(int n) {
        return this.type.substring(StringUtils.ordinalIndexOf(type, TTFTokenNames.CONNECTOR, n) + 1);
    }
    
    /**
     * Extract the given token type upto nth position.
     *
     * @param n
     * @return partType as a truncated to the first nth position.
     */
    public String GetTypeUpto(int n) {
        return this.type.substring(0, StringUtils.ordinalIndexOf(type, TTFTokenNames.CONNECTOR, n));
    }
    
    /**
     * Removes(Truncates) the token type from its last position and return the
     * rest of it.
     *
     * @param typeStr
     * @return typeStr the first of the token type.
     */
    public String RemoveLastType(String typeStr) {
        if (this.type.length() > typeStr.length()) {
            return this.type.substring(0, this.type.length() - (typeStr.length() + 1));
        }
        return Global.EMPTY_STRING;
    }
    
    /**
     * Returns the string of rhf token posistion.
     *
     * @param rhfPosition
     * @return strPriorToRHF
     */
    public String PreviousToken(int rhfPosition) {
        try {
            return this.typeList.get(rhfPosition - 1);
        } catch (Exception ee) {
            return Global.EMPTY_STRING;
        }
    }
    
    /**
     * Moves the given position of token type the last and return string
     * formation of the give types.
     *
     * @param tokPosition
     * @return strTokenTypes
     */
    public String MoveNthTokenTypeToLast(int tokPosition) {
        final ArrayList<String> tmpTypeList = new ArrayList<>(this.typeList);
        final String typeStr = tmpTypeList.remove(tokPosition);
        tmpTypeList.add(typeStr);
        String resultTypeStr = "";
        for (String tStr : tmpTypeList) {
            resultTypeStr += tStr + TTFTokenNames.CONNECTOR;
        }
        return resultTypeStr.substring(0, resultTypeStr.length() - 1);
    }
    
    /**
     * Get next position to compute.
     *
     * @param index
     * @return nextIndex to be processed.
     */
    public int GetNextPosition(int index) {
        try {
            if (this.typeList.get(index + 1).equals(TTFTokenNames.RV)) {
                try {
                    if (this.typeList.get(index + 2).equals(TTFTokenNames.TV)) {
                        return (2 + index);
                    }
                } catch (Exception ee) {
                    return (1 + index);
                }
            }
            return index;
        } catch (Exception ee) {
            return index;
        }
    }
    
    /**
     * Converts the token to its string representation.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.name + "{" + this.type + "}";
    }
    
    /**
     * Compares the tokens according to the token type.
     *
     * @param newObject
     * @return
     */
    @Override
    public boolean equals(Object newObject) {
        if (newObject == null) {
            return false;
        }
        return this.getType().compareTo(((GroupToken) newObject).getType()) == 0;
    }
    
    /**
     * Compares the tokens according to the token type.
     *
     * @param newObject
     * @return cmpResult as an integer.
     */
    @Override
    public int compareTo(Object newObject) {
        return this.getType().compareTo(((GroupToken) newObject).getType());
    }
    
    /**
     * Returns the altered RHF typed token. It is designed to handled right half
     * special character that appears with wrong neighboring characters.
     *
     * @param rhfPosition
     * @return alteredGroupToken
     */
    public GroupToken GetRHFAltered(final int rhfPosition) {
        final ArrayList<String> tTypeList = new ArrayList<>(this.typeList);
        final String removedType = tTypeList.remove(rhfPosition - 1);
        tTypeList.add(rhfPosition, removedType);
        final String tName = this.name.substring(0, rhfPosition - 1)
                + this.name.substring(rhfPosition, rhfPosition + 1)
                + this.name.substring(rhfPosition - 1, rhfPosition);
        final String tType = tTypeList.stream().collect(Collectors.joining("_"));
        return new GroupToken(tType, tName, tTypeList);
    }
}
