// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.load.resource.file;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;
import com.bumptech.glide.load.engine.Resource;
import java.io.InputStream;
import java.io.File;
import com.bumptech.glide.load.ResourceDecoder;

public class FileToStreamDecoder<T> implements ResourceDecoder<File, T>
{
    private static final FileOpener DEFAULT_FILE_OPENER;
    private final FileOpener fileOpener;
    private ResourceDecoder<InputStream, T> streamDecoder;
    
    static {
        DEFAULT_FILE_OPENER = new FileOpener();
    }
    
    public FileToStreamDecoder(final ResourceDecoder<InputStream, T> resourceDecoder) {
        this(resourceDecoder, FileToStreamDecoder.DEFAULT_FILE_OPENER);
    }
    
    FileToStreamDecoder(final ResourceDecoder<InputStream, T> streamDecoder, final FileOpener fileOpener) {
        this.streamDecoder = streamDecoder;
        this.fileOpener = fileOpener;
    }
    
    @Override
    public Resource<T> decode(final File p0, final int p1, final int p2) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          4
        //     3: aload_0        
        //     4: getfield        com/bumptech/glide/load/resource/file/FileToStreamDecoder.fileOpener:Lcom/bumptech/glide/load/resource/file/FileToStreamDecoder$FileOpener;
        //     7: aload_1        
        //     8: invokevirtual   com/bumptech/glide/load/resource/file/FileToStreamDecoder$FileOpener.open:(Ljava/io/File;)Ljava/io/InputStream;
        //    11: astore_1       
        //    12: aload_1        
        //    13: astore          4
        //    15: aload_0        
        //    16: getfield        com/bumptech/glide/load/resource/file/FileToStreamDecoder.streamDecoder:Lcom/bumptech/glide/load/ResourceDecoder;
        //    19: aload_1        
        //    20: iload_2        
        //    21: iload_3        
        //    22: invokeinterface com/bumptech/glide/load/ResourceDecoder.decode:(Ljava/lang/Object;II)Lcom/bumptech/glide/load/engine/Resource;
        //    27: astore          5
        //    29: aload_1        
        //    30: ifnull          37
        //    33: aload_1        
        //    34: invokevirtual   java/io/InputStream.close:()V
        //    37: aload           5
        //    39: areturn        
        //    40: astore_1       
        //    41: aload           4
        //    43: ifnull          51
        //    46: aload           4
        //    48: invokevirtual   java/io/InputStream.close:()V
        //    51: aload_1        
        //    52: athrow         
        //    53: astore_1       
        //    54: aload           5
        //    56: areturn        
        //    57: astore          4
        //    59: goto            51
        //    Exceptions:
        //  throws java.io.IOException
        //    Signature:
        //  (Ljava/io/File;II)Lcom/bumptech/glide/load/engine/Resource<TT;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  3      12     40     53     Any
        //  15     29     40     53     Any
        //  33     37     53     57     Ljava/io/IOException;
        //  46     51     57     62     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index 34 out of bounds for length 34
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.get(ArrayList.java:458)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
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
    
    @Override
    public String getId() {
        return "";
    }
    
    static class FileOpener
    {
        public InputStream open(final File file) throws FileNotFoundException {
            return new FileInputStream(file);
        }
    }
}
