// 
// Decompiled by Procyon v0.5.36
// 

package com.google.zxing.client.result;

import java.util.regex.Matcher;
import com.google.zxing.Result;
import java.util.Collection;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.ByteArrayOutputStream;
import java.util.regex.Pattern;

public final class VCardResultParser extends ResultParser
{
    private static final Pattern BEGIN_VCARD;
    private static final Pattern COMMA;
    private static final Pattern CR_LF_SPACE_TAB;
    private static final Pattern EQUALS;
    private static final Pattern NEWLINE_ESCAPE;
    private static final Pattern SEMICOLON;
    private static final Pattern SEMICOLON_OR_COMMA;
    private static final Pattern UNESCAPED_SEMICOLONS;
    private static final Pattern VCARD_ESCAPES;
    private static final Pattern VCARD_LIKE_DATE;
    
    static {
        BEGIN_VCARD = Pattern.compile("BEGIN:VCARD", 2);
        VCARD_LIKE_DATE = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
        CR_LF_SPACE_TAB = Pattern.compile("\r\n[ \t]");
        NEWLINE_ESCAPE = Pattern.compile("\\\\[nN]");
        VCARD_ESCAPES = Pattern.compile("\\\\([,;\\\\])");
        EQUALS = Pattern.compile("=");
        SEMICOLON = Pattern.compile(";");
        UNESCAPED_SEMICOLONS = Pattern.compile("(?<!\\\\);+");
        COMMA = Pattern.compile(",");
        SEMICOLON_OR_COMMA = Pattern.compile("[;,]");
    }
    
    private static String decodeQuotedPrintable(final CharSequence charSequence, final String s) {
        final int length = charSequence.length();
        final StringBuilder sb = new StringBuilder(length);
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
    Label_0107_Outer:
        while (i < length) {
            final char char1 = charSequence.charAt(i);
            int n = i;
            while (true) {
                switch (char1) {
                    default: {
                        maybeAppendFragment(byteArrayOutputStream, s, sb);
                        sb.append(char1);
                        n = i;
                    }
                    case 10:
                    case 13: {
                        i = n + 1;
                        continue Label_0107_Outer;
                    }
                    case 61: {
                        n = i;
                        if (i >= length - 2) {
                            continue;
                        }
                        final char char2 = charSequence.charAt(i + 1);
                        n = i;
                        if (char2 == '\r') {
                            continue;
                        }
                        n = i;
                        if (char2 != '\n') {
                            final char char3 = charSequence.charAt(i + 2);
                            final int hexDigit = ResultParser.parseHexDigit(char2);
                            final int hexDigit2 = ResultParser.parseHexDigit(char3);
                            if (hexDigit >= 0 && hexDigit2 >= 0) {
                                byteArrayOutputStream.write((hexDigit << 4) + hexDigit2);
                            }
                            n = i + 2;
                        }
                        continue;
                    }
                }
                break;
            }
        }
        maybeAppendFragment(byteArrayOutputStream, s, sb);
        return sb.toString();
    }
    
    private static void formatNames(final Iterable<List<String>> iterable) {
        if (iterable != null) {
            for (final List<String> list : iterable) {
                final String s = list.get(0);
                final String[] array = new String[5];
                int beginIndex = 0;
                int i;
                int index;
                for (i = 0; i < 4; ++i, beginIndex = index + 1) {
                    index = s.indexOf(59, beginIndex);
                    if (index < 0) {
                        break;
                    }
                    array[i] = s.substring(beginIndex, index);
                }
                array[i] = s.substring(beginIndex);
                final StringBuilder sb = new StringBuilder(100);
                maybeAppendComponent(array, 3, sb);
                maybeAppendComponent(array, 1, sb);
                maybeAppendComponent(array, 2, sb);
                maybeAppendComponent(array, 0, sb);
                maybeAppendComponent(array, 4, sb);
                list.set(0, sb.toString().trim());
            }
        }
    }
    
    private static boolean isLikeVCardDate(final CharSequence input) {
        return input == null || VCardResultParser.VCARD_LIKE_DATE.matcher(input).matches();
    }
    
    static List<String> matchSingleVCardPrefixedField(final CharSequence charSequence, final String s, final boolean b, final boolean b2) {
        final List<List<String>> matchVCardPrefixedField = matchVCardPrefixedField(charSequence, s, b, b2);
        if (matchVCardPrefixedField == null || matchVCardPrefixedField.isEmpty()) {
            return null;
        }
        return matchVCardPrefixedField.get(0);
    }
    
    static List<List<String>> matchVCardPrefixedField(final CharSequence obj, final String input, final boolean b, final boolean b2) {
        Object o = null;
        int n = 0;
        final int length = input.length();
    Label_0608_Outer:
        while (true) {
            if (n >= length) {
                return (List<List<String>>)o;
            }
            Object o2 = Pattern.compile("(?:^|\n)" + (Object)obj + "(?:;([^:]*))?:", 2).matcher(input);
            int start;
            if ((start = n) > 0) {
                start = n - 1;
            }
            if (!((Matcher)o2).find(start)) {
                return (List<List<String>>)o;
            }
            final int end = ((Matcher)o2).end(0);
            final String group = ((Matcher)o2).group(1);
            List<String> list = null;
            List<String> list2 = null;
            int n2 = 0;
            int n3 = 0;
            Object o3 = null;
            Object o4 = null;
            Object anObject = null;
            o2 = null;
            if (group != null) {
                final String[] split = VCardResultParser.SEMICOLON.split(group);
                final int length2 = split.length;
                int n4 = 0;
                while (true) {
                    list = list2;
                    n2 = n3;
                    o3 = o4;
                    anObject = o2;
                    if (n4 >= length2) {
                        break;
                    }
                    final String input2 = split[n4];
                    List<String> list3;
                    if ((list3 = list2) == null) {
                        list3 = new ArrayList<String>(1);
                    }
                    list3.add(input2);
                    final String[] split2 = VCardResultParser.EQUALS.split(input2, 2);
                    int n5 = n3;
                    Object o5 = o4;
                    Object o6 = o2;
                    if (split2.length > 1) {
                        final String anotherString = split2[0];
                        final String anotherString2 = split2[1];
                        if ("ENCODING".equalsIgnoreCase(anotherString) && "QUOTED-PRINTABLE".equalsIgnoreCase(anotherString2)) {
                            n5 = 1;
                            o6 = o2;
                            o5 = o4;
                        }
                        else if ("CHARSET".equalsIgnoreCase(anotherString)) {
                            n5 = n3;
                            o5 = anotherString2;
                            o6 = o2;
                        }
                        else {
                            n5 = n3;
                            o5 = o4;
                            o6 = o2;
                            if ("VALUE".equalsIgnoreCase(anotherString)) {
                                n5 = n3;
                                o5 = o4;
                                o6 = anotherString2;
                            }
                        }
                    }
                    ++n4;
                    list2 = list3;
                    n3 = n5;
                    o4 = o5;
                    o2 = o6;
                }
            }
            n = end;
            int index;
            while (true) {
                index = input.indexOf(10, n);
                if (index < 0) {
                    break;
                }
                if (index < input.length() - 1 && (input.charAt(index + 1) == ' ' || input.charAt(index + 1) == '\t')) {
                    n = index + 2;
                }
                else {
                    if (n2 == 0 || ((index <= 0 || input.charAt(index - 1) != '=') && (index < 2 || input.charAt(index - 2) != '='))) {
                        break;
                    }
                    n = index + 1;
                }
            }
            if (index < 0) {
                n = length;
                continue;
            }
            Label_0779: {
                if (index <= end) {
                    break Label_0779;
                }
                if ((o4 = o) == null) {
                    o4 = new ArrayList<List<String>>(1);
                }
                if ((n = index) > 0) {
                    n = index;
                    if (input.charAt(index - 1) == '\r') {
                        n = index - 1;
                    }
                }
                final String s = (String)(o2 = input.substring(end, n));
                if (b) {
                    o2 = s.trim();
                }
                Label_0680: {
                    if (n2 == 0) {
                        break Label_0680;
                    }
                    final String input3 = (String)(o2 = decodeQuotedPrintable((CharSequence)o2, (String)o3));
                    if (b2) {
                        o2 = VCardResultParser.UNESCAPED_SEMICOLONS.matcher(input3).replaceAll("\n").trim();
                    }
                Label_0632_Outer:
                    while (true) {
                        CharSequence schemeSpecificPart = (CharSequence)o2;
                        while (true) {
                            if (!"uri".equals(anObject)) {
                                break Label_0632;
                            }
                            try {
                                schemeSpecificPart = URI.create((String)o2).getSchemeSpecificPart();
                                if (list == null) {
                                    o2 = new ArrayList<String>(1);
                                    ((List<String>)o2).add((String)schemeSpecificPart);
                                    ((List<List<String>>)o4).add((List<String>)o2);
                                }
                                else {
                                    list.add(0, (String)schemeSpecificPart);
                                    ((List<List<String>>)o4).add(list);
                                }
                                ++n;
                                o = o4;
                                continue Label_0608_Outer;
                                Object trim = o2;
                                // iftrue(Label_0706:, !b2)
                                trim = VCardResultParser.UNESCAPED_SEMICOLONS.matcher((CharSequence)o2).replaceAll("\n").trim();
                                Label_0706: {
                                    break Label_0706;
                                    n = index + 1;
                                    continue Label_0608_Outer;
                                }
                                o2 = VCardResultParser.CR_LF_SPACE_TAB.matcher((CharSequence)trim).replaceAll("");
                                o2 = VCardResultParser.NEWLINE_ESCAPE.matcher((CharSequence)o2).replaceAll("\n");
                                o2 = VCardResultParser.VCARD_ESCAPES.matcher((CharSequence)o2).replaceAll("$1");
                                continue Label_0632_Outer;
                            }
                            catch (IllegalArgumentException ex) {
                                schemeSpecificPart = (CharSequence)o2;
                                continue;
                            }
                            break;
                        }
                        break;
                    }
                }
            }
        }
    }
    
    private static void maybeAppendComponent(final String[] array, final int n, final StringBuilder sb) {
        if (array[n] != null && !array[n].isEmpty()) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(array[n]);
        }
    }
    
    private static void maybeAppendFragment(final ByteArrayOutputStream byteArrayOutputStream, String s, final StringBuilder sb) {
        if (byteArrayOutputStream.size() > 0) {
            final byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (s == null) {
                s = new String(byteArray, StandardCharsets.UTF_8);
            }
            else {
                try {
                    s = new String(byteArray, s);
                }
                catch (UnsupportedEncodingException ex) {
                    s = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb.append(s);
        }
    }
    
    private static String toPrimaryValue(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    private static String[] toPrimaryValues(final Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        final ArrayList<String> list = new ArrayList<String>(collection.size());
        final Iterator<List<String>> iterator = collection.iterator();
        while (iterator.hasNext()) {
            final String s = iterator.next().get(0);
            if (s != null && !s.isEmpty()) {
                list.add(s);
            }
        }
        return list.toArray(new String[list.size()]);
    }
    
    private static String[] toTypes(final Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        final ArrayList<String> list = new ArrayList<String>(collection.size());
    Label_0123_Outer:
        for (final List<String> list2 : collection) {
            final String s = list2.get(0);
            if (s != null && !s.isEmpty()) {
                final String s2 = null;
                int n = 1;
                while (true) {
                    String substring = null;
                    int index = 0;
                    Block_6: {
                        while (true) {
                            substring = s2;
                            if (n >= list2.size()) {
                                break;
                            }
                            substring = list2.get(n);
                            index = substring.indexOf(61);
                            if (index < 0) {
                                break;
                            }
                            if ("TYPE".equalsIgnoreCase(substring.substring(0, index))) {
                                break Block_6;
                            }
                            ++n;
                        }
                        list.add(substring);
                        continue Label_0123_Outer;
                    }
                    substring = substring.substring(index + 1);
                    continue;
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }
    
    @Override
    public AddressBookParsedResult parse(final Result result) {
        final String massagedText = ResultParser.getMassagedText(result);
        final Matcher matcher = VCardResultParser.BEGIN_VCARD.matcher(massagedText);
        if (!matcher.find() || matcher.start() != 0) {
            return null;
        }
        List<List<String>> list;
        if ((list = matchVCardPrefixedField("FN", massagedText, true, false)) == null) {
            list = matchVCardPrefixedField("N", massagedText, true, false);
            formatNames(list);
        }
        final List<String> matchSingleVCardPrefixedField = matchSingleVCardPrefixedField("NICKNAME", massagedText, true, false);
        String[] split;
        if (matchSingleVCardPrefixedField == null) {
            split = null;
        }
        else {
            split = VCardResultParser.COMMA.split(matchSingleVCardPrefixedField.get(0));
        }
        final List<List<String>> matchVCardPrefixedField = matchVCardPrefixedField("TEL", massagedText, true, false);
        final List<List<String>> matchVCardPrefixedField2 = matchVCardPrefixedField("EMAIL", massagedText, true, false);
        final List<String> matchSingleVCardPrefixedField2 = matchSingleVCardPrefixedField("NOTE", massagedText, false, false);
        final List<List<String>> matchVCardPrefixedField3 = matchVCardPrefixedField("ADR", massagedText, true, true);
        final List<String> matchSingleVCardPrefixedField3 = matchSingleVCardPrefixedField("ORG", massagedText, true, true);
        List<String> matchSingleVCardPrefixedField4;
        final List<String> list2 = matchSingleVCardPrefixedField4 = matchSingleVCardPrefixedField("BDAY", massagedText, (boolean)(1 != 0), (boolean)(0 != 0));
        if (list2 != null) {
            matchSingleVCardPrefixedField4 = list2;
            if (!isLikeVCardDate(list2.get(0))) {
                matchSingleVCardPrefixedField4 = null;
            }
        }
        final List<String> matchSingleVCardPrefixedField5 = matchSingleVCardPrefixedField("TITLE", massagedText, true, false);
        final List<List<String>> matchVCardPrefixedField4 = matchVCardPrefixedField("URL", massagedText, true, false);
        final List<String> matchSingleVCardPrefixedField6 = matchSingleVCardPrefixedField("IMPP", massagedText, true, false);
        final List<String> matchSingleVCardPrefixedField7 = matchSingleVCardPrefixedField("GEO", massagedText, true, false);
        String[] split2;
        if (matchSingleVCardPrefixedField7 == null) {
            split2 = null;
        }
        else {
            split2 = VCardResultParser.SEMICOLON_OR_COMMA.split(matchSingleVCardPrefixedField7.get(0));
        }
        String[] array = split2;
        if (split2 != null) {
            array = split2;
            if (split2.length != 2) {
                array = null;
            }
        }
        return new AddressBookParsedResult(toPrimaryValues(list), split, null, toPrimaryValues(matchVCardPrefixedField), toTypes(matchVCardPrefixedField), toPrimaryValues(matchVCardPrefixedField2), toTypes(matchVCardPrefixedField2), toPrimaryValue(matchSingleVCardPrefixedField6), toPrimaryValue(matchSingleVCardPrefixedField2), toPrimaryValues(matchVCardPrefixedField3), toTypes(matchVCardPrefixedField3), toPrimaryValue(matchSingleVCardPrefixedField3), toPrimaryValue(matchSingleVCardPrefixedField4), toPrimaryValue(matchSingleVCardPrefixedField5), toPrimaryValues(matchVCardPrefixedField4), array);
    }
}
