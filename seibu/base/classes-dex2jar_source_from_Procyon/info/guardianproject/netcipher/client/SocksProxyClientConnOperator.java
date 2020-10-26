// 
// Decompiled by Procyon v0.5.36
// 

package info.guardianproject.netcipher.client;

import java.net.UnknownHostException;
import java.io.IOException;
import ch.boye.httpclientandroidlib.params.HttpParams;
import ch.boye.httpclientandroidlib.protocol.HttpContext;
import java.net.InetAddress;
import ch.boye.httpclientandroidlib.HttpHost;
import ch.boye.httpclientandroidlib.conn.OperatedClientConnection;
import ch.boye.httpclientandroidlib.conn.scheme.SchemeRegistry;
import ch.boye.httpclientandroidlib.impl.conn.DefaultClientConnectionOperator;

public class SocksProxyClientConnOperator extends DefaultClientConnectionOperator
{
    private static final int CONNECT_TIMEOUT_MILLISECONDS = 60000;
    private static final int READ_TIMEOUT_MILLISECONDS = 60000;
    private String mProxyHost;
    private int mProxyPort;
    
    public SocksProxyClientConnOperator(final SchemeRegistry schemeRegistry, final String mProxyHost, final int mProxyPort) {
        super(schemeRegistry);
        this.mProxyHost = mProxyHost;
        this.mProxyPort = mProxyPort;
    }
    
    public void openConnection(final OperatedClientConnection p0, final HttpHost p1, final InetAddress p2, final HttpContext p3, final HttpParams p4) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          9
        //     3: aconst_null    
        //     4: astore          8
        //     6: aconst_null    
        //     7: astore_3       
        //     8: aload_1        
        //     9: ifnull          21
        //    12: aload_2        
        //    13: ifnull          21
        //    16: aload           5
        //    18: ifnonnull       53
        //    21: new             Ljava/lang/IllegalArgumentException;
        //    24: dup            
        //    25: ldc             "Required argument may not be null"
        //    27: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //    30: athrow         
        //    31: astore_1       
        //    32: aload           9
        //    34: astore_2       
        //    35: aload_3        
        //    36: ifnull          43
        //    39: aload_3        
        //    40: invokevirtual   java/net/Socket.close:()V
        //    43: aload_2        
        //    44: ifnull          51
        //    47: aload_2        
        //    48: invokevirtual   java/net/Socket.close:()V
        //    51: aload_1        
        //    52: athrow         
        //    53: aload_1        
        //    54: invokeinterface ch/boye/httpclientandroidlib/conn/OperatedClientConnection.isOpen:()Z
        //    59: ifeq            72
        //    62: new             Ljava/lang/IllegalStateException;
        //    65: dup            
        //    66: ldc             "Connection must not be open"
        //    68: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    71: athrow         
        //    72: aload_0        
        //    73: getfield        info/guardianproject/netcipher/client/SocksProxyClientConnOperator.schemeRegistry:Lch/boye/httpclientandroidlib/conn/scheme/SchemeRegistry;
        //    76: aload_2        
        //    77: invokevirtual   ch/boye/httpclientandroidlib/HttpHost.getSchemeName:()Ljava/lang/String;
        //    80: invokevirtual   ch/boye/httpclientandroidlib/conn/scheme/SchemeRegistry.getScheme:(Ljava/lang/String;)Lch/boye/httpclientandroidlib/conn/scheme/Scheme;
        //    83: astore          7
        //    85: aload           7
        //    87: invokevirtual   ch/boye/httpclientandroidlib/conn/scheme/Scheme.getSchemeSocketFactory:()Lch/boye/httpclientandroidlib/conn/scheme/SchemeSocketFactory;
        //    90: astore          10
        //    92: aload           7
        //    94: aload_2        
        //    95: invokevirtual   ch/boye/httpclientandroidlib/HttpHost.getPort:()I
        //    98: invokevirtual   ch/boye/httpclientandroidlib/conn/scheme/Scheme.resolvePort:(I)I
        //   101: istore          6
        //   103: aload_2        
        //   104: invokevirtual   ch/boye/httpclientandroidlib/HttpHost.getHostName:()Ljava/lang/String;
        //   107: astore          11
        //   109: new             Ljava/net/Socket;
        //   112: dup            
        //   113: invokespecial   java/net/Socket.<init>:()V
        //   116: astore          7
        //   118: aload           8
        //   120: astore_3       
        //   121: aload_1        
        //   122: aload           7
        //   124: aload_2        
        //   125: invokeinterface ch/boye/httpclientandroidlib/conn/OperatedClientConnection.opening:(Ljava/net/Socket;Lch/boye/httpclientandroidlib/HttpHost;)V
        //   130: aload           8
        //   132: astore_3       
        //   133: aload           7
        //   135: ldc             60000
        //   137: invokevirtual   java/net/Socket.setSoTimeout:(I)V
        //   140: aload           8
        //   142: astore_3       
        //   143: aload           7
        //   145: new             Ljava/net/InetSocketAddress;
        //   148: dup            
        //   149: aload_0        
        //   150: getfield        info/guardianproject/netcipher/client/SocksProxyClientConnOperator.mProxyHost:Ljava/lang/String;
        //   153: aload_0        
        //   154: getfield        info/guardianproject/netcipher/client/SocksProxyClientConnOperator.mProxyPort:I
        //   157: invokespecial   java/net/InetSocketAddress.<init>:(Ljava/lang/String;I)V
        //   160: ldc             60000
        //   162: invokevirtual   java/net/Socket.connect:(Ljava/net/SocketAddress;I)V
        //   165: aload           8
        //   167: astore_3       
        //   168: new             Ljava/io/DataOutputStream;
        //   171: dup            
        //   172: aload           7
        //   174: invokevirtual   java/net/Socket.getOutputStream:()Ljava/io/OutputStream;
        //   177: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //   180: astore          9
        //   182: aload           8
        //   184: astore_3       
        //   185: aload           9
        //   187: iconst_4       
        //   188: invokevirtual   java/io/DataOutputStream.write:(I)V
        //   191: aload           8
        //   193: astore_3       
        //   194: aload           9
        //   196: iconst_1       
        //   197: invokevirtual   java/io/DataOutputStream.write:(I)V
        //   200: aload           8
        //   202: astore_3       
        //   203: aload           9
        //   205: iload           6
        //   207: i2s            
        //   208: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   211: aload           8
        //   213: astore_3       
        //   214: aload           9
        //   216: iconst_1       
        //   217: invokevirtual   java/io/DataOutputStream.writeInt:(I)V
        //   220: aload           8
        //   222: astore_3       
        //   223: aload           9
        //   225: iconst_0       
        //   226: invokevirtual   java/io/DataOutputStream.write:(I)V
        //   229: aload           8
        //   231: astore_3       
        //   232: aload           9
        //   234: aload           11
        //   236: invokevirtual   java/lang/String.getBytes:()[B
        //   239: invokevirtual   java/io/DataOutputStream.write:([B)V
        //   242: aload           8
        //   244: astore_3       
        //   245: aload           9
        //   247: iconst_0       
        //   248: invokevirtual   java/io/DataOutputStream.write:(I)V
        //   251: aload           8
        //   253: astore_3       
        //   254: new             Ljava/io/DataInputStream;
        //   257: dup            
        //   258: aload           7
        //   260: invokevirtual   java/net/Socket.getInputStream:()Ljava/io/InputStream;
        //   263: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //   266: astore          9
        //   268: aload           8
        //   270: astore_3       
        //   271: aload           9
        //   273: invokevirtual   java/io/DataInputStream.readByte:()B
        //   276: ifne            292
        //   279: aload           8
        //   281: astore_3       
        //   282: aload           9
        //   284: invokevirtual   java/io/DataInputStream.readByte:()B
        //   287: bipush          90
        //   289: if_icmpeq       305
        //   292: aload           8
        //   294: astore_3       
        //   295: new             Ljava/io/IOException;
        //   298: dup            
        //   299: ldc             "SOCKS4a connect failed"
        //   301: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   304: athrow         
        //   305: aload           8
        //   307: astore_3       
        //   308: aload           9
        //   310: invokevirtual   java/io/DataInputStream.readShort:()S
        //   313: pop            
        //   314: aload           8
        //   316: astore_3       
        //   317: aload           9
        //   319: invokevirtual   java/io/DataInputStream.readInt:()I
        //   322: pop            
        //   323: aload           8
        //   325: astore_3       
        //   326: aload           10
        //   328: instanceof      Lch/boye/httpclientandroidlib/conn/ssl/SSLSocketFactory;
        //   331: ifeq            411
        //   334: aload           8
        //   336: astore_3       
        //   337: aload           10
        //   339: checkcast       Lch/boye/httpclientandroidlib/conn/ssl/SSLSocketFactory;
        //   342: aload           7
        //   344: aload           11
        //   346: iload           6
        //   348: aload           5
        //   350: invokevirtual   ch/boye/httpclientandroidlib/conn/ssl/SSLSocketFactory.createLayeredSocket:(Ljava/net/Socket;Ljava/lang/String;ILch/boye/httpclientandroidlib/params/HttpParams;)Ljava/net/Socket;
        //   353: astore          8
        //   355: aload           8
        //   357: astore_3       
        //   358: aload_1        
        //   359: aload           8
        //   361: aload_2        
        //   362: invokeinterface ch/boye/httpclientandroidlib/conn/OperatedClientConnection.opening:(Ljava/net/Socket;Lch/boye/httpclientandroidlib/HttpHost;)V
        //   367: aload           8
        //   369: astore_3       
        //   370: aload           8
        //   372: ldc             60000
        //   374: invokevirtual   java/net/Socket.setSoTimeout:(I)V
        //   377: aload           8
        //   379: astore_3       
        //   380: aload_0        
        //   381: aload           8
        //   383: aload           4
        //   385: aload           5
        //   387: invokevirtual   info/guardianproject/netcipher/client/SocksProxyClientConnOperator.prepareSocket:(Ljava/net/Socket;Lch/boye/httpclientandroidlib/protocol/HttpContext;Lch/boye/httpclientandroidlib/params/HttpParams;)V
        //   390: aload           8
        //   392: astore_3       
        //   393: aload_1        
        //   394: aload           10
        //   396: aload           8
        //   398: invokeinterface ch/boye/httpclientandroidlib/conn/scheme/SchemeSocketFactory.isSecure:(Ljava/net/Socket;)Z
        //   403: aload           5
        //   405: invokeinterface ch/boye/httpclientandroidlib/conn/OperatedClientConnection.openCompleted:(ZLch/boye/httpclientandroidlib/params/HttpParams;)V
        //   410: return         
        //   411: aload           8
        //   413: astore_3       
        //   414: aload_1        
        //   415: aload           7
        //   417: aload_2        
        //   418: invokeinterface ch/boye/httpclientandroidlib/conn/OperatedClientConnection.opening:(Ljava/net/Socket;Lch/boye/httpclientandroidlib/HttpHost;)V
        //   423: aload           8
        //   425: astore_3       
        //   426: aload           7
        //   428: ldc             60000
        //   430: invokevirtual   java/net/Socket.setSoTimeout:(I)V
        //   433: aload           8
        //   435: astore_3       
        //   436: aload_0        
        //   437: aload           7
        //   439: aload           4
        //   441: aload           5
        //   443: invokevirtual   info/guardianproject/netcipher/client/SocksProxyClientConnOperator.prepareSocket:(Ljava/net/Socket;Lch/boye/httpclientandroidlib/protocol/HttpContext;Lch/boye/httpclientandroidlib/params/HttpParams;)V
        //   446: aload           8
        //   448: astore_3       
        //   449: aload_1        
        //   450: aload           10
        //   452: aload           7
        //   454: invokeinterface ch/boye/httpclientandroidlib/conn/scheme/SchemeSocketFactory.isSecure:(Ljava/net/Socket;)Z
        //   459: aload           5
        //   461: invokeinterface ch/boye/httpclientandroidlib/conn/OperatedClientConnection.openCompleted:(ZLch/boye/httpclientandroidlib/params/HttpParams;)V
        //   466: return         
        //   467: astore_2       
        //   468: goto            51
        //   471: astore_1       
        //   472: aload           7
        //   474: astore_2       
        //   475: goto            35
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  21     31     31     35     Ljava/io/IOException;
        //  39     43     467    471    Ljava/io/IOException;
        //  47     51     467    471    Ljava/io/IOException;
        //  53     72     31     35     Ljava/io/IOException;
        //  72     118    31     35     Ljava/io/IOException;
        //  121    130    471    478    Ljava/io/IOException;
        //  133    140    471    478    Ljava/io/IOException;
        //  143    165    471    478    Ljava/io/IOException;
        //  168    182    471    478    Ljava/io/IOException;
        //  185    191    471    478    Ljava/io/IOException;
        //  194    200    471    478    Ljava/io/IOException;
        //  203    211    471    478    Ljava/io/IOException;
        //  214    220    471    478    Ljava/io/IOException;
        //  223    229    471    478    Ljava/io/IOException;
        //  232    242    471    478    Ljava/io/IOException;
        //  245    251    471    478    Ljava/io/IOException;
        //  254    268    471    478    Ljava/io/IOException;
        //  271    279    471    478    Ljava/io/IOException;
        //  282    292    471    478    Ljava/io/IOException;
        //  295    305    471    478    Ljava/io/IOException;
        //  308    314    471    478    Ljava/io/IOException;
        //  317    323    471    478    Ljava/io/IOException;
        //  326    334    471    478    Ljava/io/IOException;
        //  337    355    471    478    Ljava/io/IOException;
        //  358    367    471    478    Ljava/io/IOException;
        //  370    377    471    478    Ljava/io/IOException;
        //  380    390    471    478    Ljava/io/IOException;
        //  393    410    471    478    Ljava/io/IOException;
        //  414    423    471    478    Ljava/io/IOException;
        //  426    433    471    478    Ljava/io/IOException;
        //  436    446    471    478    Ljava/io/IOException;
        //  449    466    471    478    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0292:
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
    
    protected InetAddress[] resolveHostname(final String s) throws UnknownHostException {
        throw new RuntimeException("operation not supported");
    }
    
    public void updateSecureConnection(final OperatedClientConnection operatedClientConnection, final HttpHost httpHost, final HttpContext httpContext, final HttpParams httpParams) throws IOException {
        throw new RuntimeException("operation not supported");
    }
}
