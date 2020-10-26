// 
// Decompiled by Procyon v0.5.36
// 

package okhttp3;

import okhttp3.internal.http.HttpDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import java.util.regex.Pattern;

public final class Cookie
{
    private static final Pattern DAY_OF_MONTH_PATTERN;
    private static final Pattern MONTH_PATTERN;
    private static final Pattern TIME_PATTERN;
    private static final Pattern YEAR_PATTERN;
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;
    
    static {
        YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
        MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
        TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }
    
    private Cookie(final String name, final String value, final long expiresAt, final String domain, final String path, final boolean secure, final boolean httpOnly, final boolean hostOnly, final boolean persistent) {
        this.name = name;
        this.value = value;
        this.expiresAt = expiresAt;
        this.domain = domain;
        this.path = path;
        this.secure = secure;
        this.httpOnly = httpOnly;
        this.hostOnly = hostOnly;
        this.persistent = persistent;
    }
    
    Cookie(final Cookie.Cookie$Builder cookie$Builder) {
        if (cookie$Builder.name == null) {
            throw new NullPointerException("builder.name == null");
        }
        if (cookie$Builder.value == null) {
            throw new NullPointerException("builder.value == null");
        }
        if (cookie$Builder.domain == null) {
            throw new NullPointerException("builder.domain == null");
        }
        this.name = cookie$Builder.name;
        this.value = cookie$Builder.value;
        this.expiresAt = cookie$Builder.expiresAt;
        this.domain = cookie$Builder.domain;
        this.path = cookie$Builder.path;
        this.secure = cookie$Builder.secure;
        this.httpOnly = cookie$Builder.httpOnly;
        this.persistent = cookie$Builder.persistent;
        this.hostOnly = cookie$Builder.hostOnly;
    }
    
    private static int dateCharacterOffset(final String s, int i, final int n, final boolean b) {
        while (i < n) {
            final char char1 = s.charAt(i);
            int n2;
            if ((char1 < ' ' && char1 != '\t') || char1 >= '\u007f' || (char1 >= '0' && char1 <= '9') || (char1 >= 'a' && char1 <= 'z') || (char1 >= 'A' && char1 <= 'Z') || char1 == ':') {
                n2 = 1;
            }
            else {
                n2 = 0;
            }
            int n3;
            if (!b) {
                n3 = 1;
            }
            else {
                n3 = 0;
            }
            if (n2 == n3) {
                return i;
            }
            ++i;
        }
        return n;
    }
    
    private static boolean domainMatch(final String s, final String s2) {
        return s.equals(s2) || (s.endsWith(s2) && s.charAt(s.length() - s2.length() - 1) == '.' && !Util.verifyAsIpAddress(s));
    }
    
    @Nullable
    static Cookie parse(final long p0, final HttpUrl p1, final String p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   java/lang/String.length:()I
        //     4: istore          5
        //     6: aload_3        
        //     7: iconst_0       
        //     8: iload           5
        //    10: bipush          59
        //    12: invokestatic    okhttp3/internal/Util.delimiterOffset:(Ljava/lang/String;IIC)I
        //    15: istore          4
        //    17: aload_3        
        //    18: iconst_0       
        //    19: iload           4
        //    21: bipush          61
        //    23: invokestatic    okhttp3/internal/Util.delimiterOffset:(Ljava/lang/String;IIC)I
        //    26: istore          6
        //    28: iload           6
        //    30: iload           4
        //    32: if_icmpne       37
        //    35: aconst_null    
        //    36: areturn        
        //    37: aload_3        
        //    38: iconst_0       
        //    39: iload           6
        //    41: invokestatic    okhttp3/internal/Util.trimSubstring:(Ljava/lang/String;II)Ljava/lang/String;
        //    44: astore          27
        //    46: aload           27
        //    48: invokevirtual   java/lang/String.isEmpty:()Z
        //    51: ifne            63
        //    54: aload           27
        //    56: invokestatic    okhttp3/internal/Util.indexOfControlOrNonAscii:(Ljava/lang/String;)I
        //    59: iconst_m1      
        //    60: if_icmpeq       65
        //    63: aconst_null    
        //    64: areturn        
        //    65: aload_3        
        //    66: iload           6
        //    68: iconst_1       
        //    69: iadd           
        //    70: iload           4
        //    72: invokestatic    okhttp3/internal/Util.trimSubstring:(Ljava/lang/String;II)Ljava/lang/String;
        //    75: astore          28
        //    77: aload           28
        //    79: invokestatic    okhttp3/internal/Util.indexOfControlOrNonAscii:(Ljava/lang/String;)I
        //    82: iconst_m1      
        //    83: if_icmpeq       88
        //    86: aconst_null    
        //    87: areturn        
        //    88: ldc2_w          253402300799999
        //    91: lstore          8
        //    93: ldc2_w          -1
        //    96: lstore          10
        //    98: aconst_null    
        //    99: astore          24
        //   101: aconst_null    
        //   102: astore          23
        //   104: iconst_0       
        //   105: istore          19
        //   107: iconst_0       
        //   108: istore          20
        //   110: iconst_1       
        //   111: istore          17
        //   113: iconst_0       
        //   114: istore          18
        //   116: iload           4
        //   118: iconst_1       
        //   119: iadd           
        //   120: istore          4
        //   122: iload           4
        //   124: iload           5
        //   126: if_icmpge       511
        //   129: aload_3        
        //   130: iload           4
        //   132: iload           5
        //   134: bipush          59
        //   136: invokestatic    okhttp3/internal/Util.delimiterOffset:(Ljava/lang/String;IIC)I
        //   139: istore          6
        //   141: aload_3        
        //   142: iload           4
        //   144: iload           6
        //   146: bipush          61
        //   148: invokestatic    okhttp3/internal/Util.delimiterOffset:(Ljava/lang/String;IIC)I
        //   151: istore          7
        //   153: aload_3        
        //   154: iload           4
        //   156: iload           7
        //   158: invokestatic    okhttp3/internal/Util.trimSubstring:(Ljava/lang/String;II)Ljava/lang/String;
        //   161: astore          29
        //   163: iload           7
        //   165: iload           6
        //   167: if_icmpge       265
        //   170: aload_3        
        //   171: iload           7
        //   173: iconst_1       
        //   174: iadd           
        //   175: iload           6
        //   177: invokestatic    okhttp3/internal/Util.trimSubstring:(Ljava/lang/String;II)Ljava/lang/String;
        //   180: astore          25
        //   182: aload           29
        //   184: ldc             "expires"
        //   186: invokevirtual   java/lang/String.equalsIgnoreCase:(Ljava/lang/String;)Z
        //   189: ifeq            272
        //   192: aload           25
        //   194: iconst_0       
        //   195: aload           25
        //   197: invokevirtual   java/lang/String.length:()I
        //   200: invokestatic    okhttp3/Cookie.parseExpires:(Ljava/lang/String;II)J
        //   203: lstore          12
        //   205: iconst_1       
        //   206: istore          16
        //   208: lload           10
        //   210: lstore          14
        //   212: iload           17
        //   214: istore          22
        //   216: iload           19
        //   218: istore          21
        //   220: aload           23
        //   222: astore          26
        //   224: aload           24
        //   226: astore          25
        //   228: iload           6
        //   230: iconst_1       
        //   231: iadd           
        //   232: istore          4
        //   234: lload           12
        //   236: lstore          8
        //   238: aload           25
        //   240: astore          24
        //   242: aload           26
        //   244: astore          23
        //   246: iload           21
        //   248: istore          19
        //   250: iload           22
        //   252: istore          17
        //   254: iload           16
        //   256: istore          18
        //   258: lload           14
        //   260: lstore          10
        //   262: goto            122
        //   265: ldc             ""
        //   267: astore          25
        //   269: goto            182
        //   272: aload           29
        //   274: ldc             "max-age"
        //   276: invokevirtual   java/lang/String.equalsIgnoreCase:(Ljava/lang/String;)Z
        //   279: ifeq            315
        //   282: aload           25
        //   284: invokestatic    okhttp3/Cookie.parseMaxAge:(Ljava/lang/String;)J
        //   287: lstore          14
        //   289: iconst_1       
        //   290: istore          16
        //   292: lload           8
        //   294: lstore          12
        //   296: aload           24
        //   298: astore          25
        //   300: aload           23
        //   302: astore          26
        //   304: iload           19
        //   306: istore          21
        //   308: iload           17
        //   310: istore          22
        //   312: goto            228
        //   315: aload           29
        //   317: ldc             "domain"
        //   319: invokevirtual   java/lang/String.equalsIgnoreCase:(Ljava/lang/String;)Z
        //   322: ifeq            358
        //   325: aload           25
        //   327: invokestatic    okhttp3/Cookie.parseDomain:(Ljava/lang/String;)Ljava/lang/String;
        //   330: astore          25
        //   332: iconst_0       
        //   333: istore          22
        //   335: lload           8
        //   337: lstore          12
        //   339: aload           23
        //   341: astore          26
        //   343: iload           19
        //   345: istore          21
        //   347: iload           18
        //   349: istore          16
        //   351: lload           10
        //   353: lstore          14
        //   355: goto            228
        //   358: aload           29
        //   360: ldc             "path"
        //   362: invokevirtual   java/lang/String.equalsIgnoreCase:(Ljava/lang/String;)Z
        //   365: ifeq            399
        //   368: aload           25
        //   370: astore          26
        //   372: lload           8
        //   374: lstore          12
        //   376: aload           24
        //   378: astore          25
        //   380: iload           19
        //   382: istore          21
        //   384: iload           17
        //   386: istore          22
        //   388: iload           18
        //   390: istore          16
        //   392: lload           10
        //   394: lstore          14
        //   396: goto            228
        //   399: aload           29
        //   401: ldc             "secure"
        //   403: invokevirtual   java/lang/String.equalsIgnoreCase:(Ljava/lang/String;)Z
        //   406: ifeq            439
        //   409: iconst_1       
        //   410: istore          21
        //   412: lload           8
        //   414: lstore          12
        //   416: aload           24
        //   418: astore          25
        //   420: aload           23
        //   422: astore          26
        //   424: iload           17
        //   426: istore          22
        //   428: iload           18
        //   430: istore          16
        //   432: lload           10
        //   434: lstore          14
        //   436: goto            228
        //   439: lload           8
        //   441: lstore          12
        //   443: aload           24
        //   445: astore          25
        //   447: aload           23
        //   449: astore          26
        //   451: iload           19
        //   453: istore          21
        //   455: iload           17
        //   457: istore          22
        //   459: iload           18
        //   461: istore          16
        //   463: lload           10
        //   465: lstore          14
        //   467: aload           29
        //   469: ldc             "httponly"
        //   471: invokevirtual   java/lang/String.equalsIgnoreCase:(Ljava/lang/String;)Z
        //   474: ifeq            228
        //   477: iconst_1       
        //   478: istore          20
        //   480: lload           8
        //   482: lstore          12
        //   484: aload           24
        //   486: astore          25
        //   488: aload           23
        //   490: astore          26
        //   492: iload           19
        //   494: istore          21
        //   496: iload           17
        //   498: istore          22
        //   500: iload           18
        //   502: istore          16
        //   504: lload           10
        //   506: lstore          14
        //   508: goto            228
        //   511: lload           10
        //   513: ldc2_w          -9223372036854775808
        //   516: lcmp           
        //   517: ifne            563
        //   520: ldc2_w          -9223372036854775808
        //   523: lstore          8
        //   525: aload_2        
        //   526: invokevirtual   okhttp3/HttpUrl.host:()Ljava/lang/String;
        //   529: astore_3       
        //   530: aload           24
        //   532: ifnonnull       631
        //   535: aload_3        
        //   536: astore          25
        //   538: aload_3        
        //   539: invokevirtual   java/lang/String.length:()I
        //   542: aload           25
        //   544: invokevirtual   java/lang/String.length:()I
        //   547: if_icmpeq       646
        //   550: invokestatic    okhttp3/internal/publicsuffix/PublicSuffixDatabase.get:()Lokhttp3/internal/publicsuffix/PublicSuffixDatabase;
        //   553: aload           25
        //   555: invokevirtual   okhttp3/internal/publicsuffix/PublicSuffixDatabase.getEffectiveTldPlusOne:(Ljava/lang/String;)Ljava/lang/String;
        //   558: ifnonnull       646
        //   561: aconst_null    
        //   562: areturn        
        //   563: lload           10
        //   565: ldc2_w          -1
        //   568: lcmp           
        //   569: ifeq            525
        //   572: lload           10
        //   574: ldc2_w          9223372036854775
        //   577: lcmp           
        //   578: ifgt            623
        //   581: lload           10
        //   583: ldc2_w          1000
        //   586: lmul           
        //   587: lstore          8
        //   589: lload_0        
        //   590: lload           8
        //   592: ladd           
        //   593: lstore          10
        //   595: lload           10
        //   597: lload_0        
        //   598: lcmp           
        //   599: iflt            615
        //   602: lload           10
        //   604: lstore          8
        //   606: lload           10
        //   608: ldc2_w          253402300799999
        //   611: lcmp           
        //   612: ifle            525
        //   615: ldc2_w          253402300799999
        //   618: lstore          8
        //   620: goto            525
        //   623: ldc2_w          9223372036854775807
        //   626: lstore          8
        //   628: goto            589
        //   631: aload           24
        //   633: astore          25
        //   635: aload_3        
        //   636: aload           24
        //   638: invokestatic    okhttp3/Cookie.domainMatch:(Ljava/lang/String;Ljava/lang/String;)Z
        //   641: ifne            538
        //   644: aconst_null    
        //   645: areturn        
        //   646: aload           23
        //   648: ifnull          664
        //   651: aload           23
        //   653: astore_3       
        //   654: aload           23
        //   656: ldc             "/"
        //   658: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   661: ifne            690
        //   664: aload_2        
        //   665: invokevirtual   okhttp3/HttpUrl.encodedPath:()Ljava/lang/String;
        //   668: astore_2       
        //   669: aload_2        
        //   670: bipush          47
        //   672: invokevirtual   java/lang/String.lastIndexOf:(I)I
        //   675: istore          4
        //   677: iload           4
        //   679: ifeq            715
        //   682: aload_2        
        //   683: iconst_0       
        //   684: iload           4
        //   686: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   689: astore_3       
        //   690: new             Lokhttp3/Cookie;
        //   693: dup            
        //   694: aload           27
        //   696: aload           28
        //   698: lload           8
        //   700: aload           25
        //   702: aload_3        
        //   703: iload           19
        //   705: iload           20
        //   707: iload           17
        //   709: iload           18
        //   711: invokespecial   okhttp3/Cookie.<init>:(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V
        //   714: areturn        
        //   715: ldc             "/"
        //   717: astore_3       
        //   718: goto            690
        //   721: astore          25
        //   723: lload           8
        //   725: lstore          12
        //   727: aload           24
        //   729: astore          25
        //   731: aload           23
        //   733: astore          26
        //   735: iload           19
        //   737: istore          21
        //   739: iload           17
        //   741: istore          22
        //   743: iload           18
        //   745: istore          16
        //   747: lload           10
        //   749: lstore          14
        //   751: goto            228
        //   754: astore          25
        //   756: lload           8
        //   758: lstore          12
        //   760: aload           24
        //   762: astore          25
        //   764: aload           23
        //   766: astore          26
        //   768: iload           19
        //   770: istore          21
        //   772: iload           17
        //   774: istore          22
        //   776: iload           18
        //   778: istore          16
        //   780: lload           10
        //   782: lstore          14
        //   784: goto            228
        //   787: astore          25
        //   789: lload           8
        //   791: lstore          12
        //   793: aload           24
        //   795: astore          25
        //   797: aload           23
        //   799: astore          26
        //   801: iload           19
        //   803: istore          21
        //   805: iload           17
        //   807: istore          22
        //   809: iload           18
        //   811: istore          16
        //   813: lload           10
        //   815: lstore          14
        //   817: goto            228
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  192    205    787    820    Ljava/lang/IllegalArgumentException;
        //  282    289    721    754    Ljava/lang/NumberFormatException;
        //  325    332    754    787    Ljava/lang/IllegalArgumentException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0358:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Nullable
    public static Cookie parse(final HttpUrl httpUrl, final String s) {
        return parse(System.currentTimeMillis(), httpUrl, s);
    }
    
    public static List<Cookie> parseAll(final HttpUrl httpUrl, final Headers headers) {
        final List<String> values = headers.values("Set-Cookie");
        List<? extends Cookie> list = null;
        for (int i = 0; i < values.size(); ++i) {
            final Cookie parse = parse(httpUrl, values.get(i));
            if (parse != null) {
                List<Cookie> list2;
                if ((list2 = (List<Cookie>)list) == null) {
                    list2 = new ArrayList<Cookie>();
                }
                list2.add(parse);
                list = list2;
            }
        }
        if (list != null) {
            return (List<Cookie>)Collections.unmodifiableList((List<?>)list);
        }
        return Collections.emptyList();
    }
    
    private static String parseDomain(String canonicalizeHost) {
        if (canonicalizeHost.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        String substring = canonicalizeHost;
        if (canonicalizeHost.startsWith(".")) {
            substring = canonicalizeHost.substring(1);
        }
        canonicalizeHost = Util.canonicalizeHost(substring);
        if (canonicalizeHost == null) {
            throw new IllegalArgumentException();
        }
        return canonicalizeHost;
    }
    
    private static long parseExpires(final String input, int value, int n) {
        int i = dateCharacterOffset(input, value, n, false);
        int value2 = -1;
        int value3 = -1;
        int value4 = -1;
        int value5 = -1;
        int n2 = -1;
        value = -1;
        final Matcher matcher = Cookie.TIME_PATTERN.matcher(input);
        while (i < n) {
            final int dateCharacterOffset = dateCharacterOffset(input, i + 1, n, true);
            matcher.region(i, dateCharacterOffset);
            int int1;
            int int2;
            int int3;
            int int4;
            int n3;
            int int5;
            if (value2 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                int1 = Integer.parseInt(matcher.group(1));
                int2 = Integer.parseInt(matcher.group(2));
                int3 = Integer.parseInt(matcher.group(3));
                int4 = value;
                n3 = n2;
                int5 = value5;
            }
            else if (value5 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                int5 = Integer.parseInt(matcher.group(1));
                int1 = value2;
                int2 = value3;
                n3 = n2;
                int3 = value4;
                int4 = value;
            }
            else if (n2 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                n3 = Cookie.MONTH_PATTERN.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                int5 = value5;
                int1 = value2;
                int2 = value3;
                int3 = value4;
                int4 = value;
            }
            else {
                int5 = value5;
                int1 = value2;
                int2 = value3;
                n3 = n2;
                int3 = value4;
                if ((int4 = value) == -1) {
                    int5 = value5;
                    int1 = value2;
                    int2 = value3;
                    n3 = n2;
                    int3 = value4;
                    int4 = value;
                    if (matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                        int4 = Integer.parseInt(matcher.group(1));
                        int5 = value5;
                        int1 = value2;
                        int2 = value3;
                        n3 = n2;
                        int3 = value4;
                    }
                }
            }
            final int dateCharacterOffset2 = dateCharacterOffset(input, dateCharacterOffset + 1, n, false);
            value5 = int5;
            value2 = int1;
            value3 = int2;
            n2 = n3;
            value4 = int3;
            value = int4;
            i = dateCharacterOffset2;
        }
        n = value;
        if (value >= 70 && (n = value) <= 99) {
            n = value + 1900;
        }
        if ((value = n) >= 0 && (value = n) <= 69) {
            value = n + 2000;
        }
        if (value < 1601) {
            throw new IllegalArgumentException();
        }
        if (n2 == -1) {
            throw new IllegalArgumentException();
        }
        if (value5 < 1 || value5 > 31) {
            throw new IllegalArgumentException();
        }
        if (value2 < 0 || value2 > 23) {
            throw new IllegalArgumentException();
        }
        if (value3 < 0 || value3 > 59) {
            throw new IllegalArgumentException();
        }
        if (value4 < 0 || value4 > 59) {
            throw new IllegalArgumentException();
        }
        final GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, value);
        gregorianCalendar.set(2, n2 - 1);
        gregorianCalendar.set(5, value5);
        gregorianCalendar.set(11, value2);
        gregorianCalendar.set(12, value3);
        gregorianCalendar.set(13, value4);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }
    
    private static long parseMaxAge(final String s) {
        long n = Long.MIN_VALUE;
        try {
            long long1;
            n = (long1 = Long.parseLong(s));
            if (n <= 0L) {
                long1 = Long.MIN_VALUE;
            }
            return long1;
        }
        catch (NumberFormatException ex) {
            if (s.matches("-?\\d+")) {
                if (!s.startsWith("-")) {
                    n = Long.MAX_VALUE;
                }
                return n;
            }
            throw ex;
        }
    }
    
    private static boolean pathMatch(final HttpUrl httpUrl, final String s) {
        final String encodedPath = httpUrl.encodedPath();
        return encodedPath.equals(s) || (encodedPath.startsWith(s) && (s.endsWith("/") || encodedPath.charAt(s.length()) == '/'));
    }
    
    public String domain() {
        return this.domain;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof Cookie) {
            final Cookie cookie = (Cookie)o;
            if (cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
        }
        return false;
    }
    
    public long expiresAt() {
        return this.expiresAt;
    }
    
    @Override
    public int hashCode() {
        int n = 0;
        final int hashCode = this.name.hashCode();
        final int hashCode2 = this.value.hashCode();
        final int hashCode3 = this.domain.hashCode();
        final int hashCode4 = this.path.hashCode();
        final int n2 = (int)(this.expiresAt ^ this.expiresAt >>> 32);
        int n3;
        if (this.secure) {
            n3 = 0;
        }
        else {
            n3 = 1;
        }
        int n4;
        if (this.httpOnly) {
            n4 = 0;
        }
        else {
            n4 = 1;
        }
        int n5;
        if (this.persistent) {
            n5 = 0;
        }
        else {
            n5 = 1;
        }
        if (!this.hostOnly) {
            n = 1;
        }
        return ((((((((hashCode + 527) * 31 + hashCode2) * 31 + hashCode3) * 31 + hashCode4) * 31 + n2) * 31 + n3) * 31 + n4) * 31 + n5) * 31 + n;
    }
    
    public boolean hostOnly() {
        return this.hostOnly;
    }
    
    public boolean httpOnly() {
        return this.httpOnly;
    }
    
    public boolean matches(final HttpUrl httpUrl) {
        boolean b;
        if (this.hostOnly) {
            b = httpUrl.host().equals(this.domain);
        }
        else {
            b = domainMatch(httpUrl.host(), this.domain);
        }
        return b && pathMatch(httpUrl, this.path) && (!this.secure || httpUrl.isHttps());
    }
    
    public String name() {
        return this.name;
    }
    
    public String path() {
        return this.path;
    }
    
    public boolean persistent() {
        return this.persistent;
    }
    
    public boolean secure() {
        return this.secure;
    }
    
    @Override
    public String toString() {
        return this.toString(false);
    }
    
    String toString(final boolean b) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            }
            else {
                sb.append("; expires=").append(HttpDate.format(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (b) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=").append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        return sb.toString();
    }
    
    public String value() {
        return this.value;
    }
}
