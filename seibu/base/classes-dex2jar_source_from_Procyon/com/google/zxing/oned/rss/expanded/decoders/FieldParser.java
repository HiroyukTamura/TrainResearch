// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;

final class FieldParser
{
    private static final Object[][] FOUR_DIGIT_DATA_LENGTH;
    private static final Object[][] THREE_DIGIT_DATA_LENGTH;
    private static final Object[][] THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH;
    private static final Object[][] TWO_DIGIT_DATA_LENGTH;
    private static final Object VARIABLE_LENGTH;
    
    static {
        VARIABLE_LENGTH = new Object();
        TWO_DIGIT_DATA_LENGTH = new Object[][] { { "00", 18 }, { "01", 14 }, { "02", 14 }, { "10", FieldParser.VARIABLE_LENGTH, 20 }, { "11", 6 }, { "12", 6 }, { "13", 6 }, { "15", 6 }, { "17", 6 }, { "20", 2 }, { "21", FieldParser.VARIABLE_LENGTH, 20 }, { "22", FieldParser.VARIABLE_LENGTH, 29 }, { "30", FieldParser.VARIABLE_LENGTH, 8 }, { "37", FieldParser.VARIABLE_LENGTH, 8 }, { "90", FieldParser.VARIABLE_LENGTH, 30 }, { "91", FieldParser.VARIABLE_LENGTH, 30 }, { "92", FieldParser.VARIABLE_LENGTH, 30 }, { "93", FieldParser.VARIABLE_LENGTH, 30 }, { "94", FieldParser.VARIABLE_LENGTH, 30 }, { "95", FieldParser.VARIABLE_LENGTH, 30 }, { "96", FieldParser.VARIABLE_LENGTH, 30 }, { "97", FieldParser.VARIABLE_LENGTH, 30 }, { "98", FieldParser.VARIABLE_LENGTH, 30 }, { "99", FieldParser.VARIABLE_LENGTH, 30 } };
        THREE_DIGIT_DATA_LENGTH = new Object[][] { { "240", FieldParser.VARIABLE_LENGTH, 30 }, { "241", FieldParser.VARIABLE_LENGTH, 30 }, { "242", FieldParser.VARIABLE_LENGTH, 6 }, { "250", FieldParser.VARIABLE_LENGTH, 30 }, { "251", FieldParser.VARIABLE_LENGTH, 30 }, { "253", FieldParser.VARIABLE_LENGTH, 17 }, { "254", FieldParser.VARIABLE_LENGTH, 20 }, { "400", FieldParser.VARIABLE_LENGTH, 30 }, { "401", FieldParser.VARIABLE_LENGTH, 30 }, { "402", 17 }, { "403", FieldParser.VARIABLE_LENGTH, 30 }, { "410", 13 }, { "411", 13 }, { "412", 13 }, { "413", 13 }, { "414", 13 }, { "420", FieldParser.VARIABLE_LENGTH, 20 }, { "421", FieldParser.VARIABLE_LENGTH, 15 }, { "422", 3 }, { "423", FieldParser.VARIABLE_LENGTH, 15 }, { "424", 3 }, { "425", 3 }, { "426", 3 } };
        THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH = new Object[][] { { "310", 6 }, { "311", 6 }, { "312", 6 }, { "313", 6 }, { "314", 6 }, { "315", 6 }, { "316", 6 }, { "320", 6 }, { "321", 6 }, { "322", 6 }, { "323", 6 }, { "324", 6 }, { "325", 6 }, { "326", 6 }, { "327", 6 }, { "328", 6 }, { "329", 6 }, { "330", 6 }, { "331", 6 }, { "332", 6 }, { "333", 6 }, { "334", 6 }, { "335", 6 }, { "336", 6 }, { "340", 6 }, { "341", 6 }, { "342", 6 }, { "343", 6 }, { "344", 6 }, { "345", 6 }, { "346", 6 }, { "347", 6 }, { "348", 6 }, { "349", 6 }, { "350", 6 }, { "351", 6 }, { "352", 6 }, { "353", 6 }, { "354", 6 }, { "355", 6 }, { "356", 6 }, { "357", 6 }, { "360", 6 }, { "361", 6 }, { "362", 6 }, { "363", 6 }, { "364", 6 }, { "365", 6 }, { "366", 6 }, { "367", 6 }, { "368", 6 }, { "369", 6 }, { "390", FieldParser.VARIABLE_LENGTH, 15 }, { "391", FieldParser.VARIABLE_LENGTH, 18 }, { "392", FieldParser.VARIABLE_LENGTH, 15 }, { "393", FieldParser.VARIABLE_LENGTH, 18 }, { "703", FieldParser.VARIABLE_LENGTH, 30 } };
        FOUR_DIGIT_DATA_LENGTH = new Object[][] { { "7001", 13 }, { "7002", FieldParser.VARIABLE_LENGTH, 30 }, { "7003", 10 }, { "8001", 14 }, { "8002", FieldParser.VARIABLE_LENGTH, 20 }, { "8003", FieldParser.VARIABLE_LENGTH, 30 }, { "8004", FieldParser.VARIABLE_LENGTH, 30 }, { "8005", 6 }, { "8006", 18 }, { "8007", FieldParser.VARIABLE_LENGTH, 30 }, { "8008", FieldParser.VARIABLE_LENGTH, 12 }, { "8018", 18 }, { "8020", FieldParser.VARIABLE_LENGTH, 25 }, { "8100", 6 }, { "8101", 10 }, { "8102", 2 }, { "8110", FieldParser.VARIABLE_LENGTH, 70 }, { "8200", FieldParser.VARIABLE_LENGTH, 70 } };
    }
    
    private FieldParser() {
    }
    
    static String parseFieldsInGeneralPurpose(final String s) throws NotFoundException {
        if (s.isEmpty()) {
            return null;
        }
        if (s.length() < 2) {
            throw NotFoundException.getNotFoundInstance();
        }
        final String substring = s.substring(0, 2);
        final Object[][] two_DIGIT_DATA_LENGTH = FieldParser.TWO_DIGIT_DATA_LENGTH;
        final int length = two_DIGIT_DATA_LENGTH.length;
        int i = 0;
        while (i < length) {
            final Object[] array = two_DIGIT_DATA_LENGTH[i];
            if (array[0].equals(substring)) {
                if (array[1] == FieldParser.VARIABLE_LENGTH) {
                    return processVariableAI(2, (int)array[2], s);
                }
                return processFixedAI(2, (int)array[1], s);
            }
            else {
                ++i;
            }
        }
        if (s.length() < 3) {
            throw NotFoundException.getNotFoundInstance();
        }
        final String substring2 = s.substring(0, 3);
        final Object[][] three_DIGIT_DATA_LENGTH = FieldParser.THREE_DIGIT_DATA_LENGTH;
        final int length2 = three_DIGIT_DATA_LENGTH.length;
        int j = 0;
        while (j < length2) {
            final Object[] array2 = three_DIGIT_DATA_LENGTH[j];
            if (array2[0].equals(substring2)) {
                if (array2[1] == FieldParser.VARIABLE_LENGTH) {
                    return processVariableAI(3, (int)array2[2], s);
                }
                return processFixedAI(3, (int)array2[1], s);
            }
            else {
                ++j;
            }
        }
        final Object[][] three_DIGIT_PLUS_DIGIT_DATA_LENGTH = FieldParser.THREE_DIGIT_PLUS_DIGIT_DATA_LENGTH;
        final int length3 = three_DIGIT_PLUS_DIGIT_DATA_LENGTH.length;
        int k = 0;
        while (k < length3) {
            final Object[] array3 = three_DIGIT_PLUS_DIGIT_DATA_LENGTH[k];
            if (array3[0].equals(substring2)) {
                if (array3[1] == FieldParser.VARIABLE_LENGTH) {
                    return processVariableAI(4, (int)array3[2], s);
                }
                return processFixedAI(4, (int)array3[1], s);
            }
            else {
                ++k;
            }
        }
        if (s.length() < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        final String substring3 = s.substring(0, 4);
        final Object[][] four_DIGIT_DATA_LENGTH = FieldParser.FOUR_DIGIT_DATA_LENGTH;
        final int length4 = four_DIGIT_DATA_LENGTH.length;
        int l = 0;
        while (l < length4) {
            final Object[] array4 = four_DIGIT_DATA_LENGTH[l];
            if (array4[0].equals(substring3)) {
                if (array4[1] == FieldParser.VARIABLE_LENGTH) {
                    return processVariableAI(4, (int)array4[2], s);
                }
                return processFixedAI(4, (int)array4[1], s);
            }
            else {
                ++l;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
    
    private static String processFixedAI(final int n, final int n2, String str) throws NotFoundException {
        if (str.length() < n) {
            throw NotFoundException.getNotFoundInstance();
        }
        final String substring = str.substring(0, n);
        if (str.length() < n + n2) {
            throw NotFoundException.getNotFoundInstance();
        }
        final String substring2 = str.substring(n, n + n2);
        str = str.substring(n + n2);
        final String string = "(" + substring + ')' + substring2;
        str = parseFieldsInGeneralPurpose(str);
        if (str == null) {
            return string;
        }
        return string + str;
    }
    
    private static String processVariableAI(final int n, int length, String str) throws NotFoundException {
        final String substring = str.substring(0, n);
        if (str.length() < n + length) {
            length = str.length();
        }
        else {
            length += n;
        }
        final String substring2 = str.substring(n, length);
        str = str.substring(length);
        final String string = "(" + substring + ')' + substring2;
        str = parseFieldsInGeneralPurpose(str);
        if (str == null) {
            return string;
        }
        return string + str;
    }
}
