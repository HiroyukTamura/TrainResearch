// 
// Decompiled by Procyon v0.5.36
// 

package com.google.common.reflect;

import java.lang.reflect.WildcardType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.GenericArrayType;
import com.google.common.collect.Sets;
import java.lang.reflect.Type;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
abstract class TypeVisitor
{
    private final Set<Type> visited;
    
    TypeVisitor() {
        this.visited = (Set<Type>)Sets.newHashSet();
    }
    
    public final void visit(final Type... p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: arraylength    
        //     2: istore_3       
        //     3: iconst_0       
        //     4: istore_2       
        //     5: iload_2        
        //     6: iload_3        
        //     7: if_icmpge       219
        //    10: aload_1        
        //    11: iload_2        
        //    12: aaload         
        //    13: astore          4
        //    15: aload           4
        //    17: ifnull          34
        //    20: aload_0        
        //    21: getfield        com/google/common/reflect/TypeVisitor.visited:Ljava/util/Set;
        //    24: aload           4
        //    26: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //    31: ifne            41
        //    34: iload_2        
        //    35: iconst_1       
        //    36: iadd           
        //    37: istore_2       
        //    38: goto            5
        //    41: aload           4
        //    43: instanceof      Ljava/lang/reflect/TypeVariable;
        //    46: ifeq            77
        //    49: aload_0        
        //    50: aload           4
        //    52: checkcast       Ljava/lang/reflect/TypeVariable;
        //    55: invokevirtual   com/google/common/reflect/TypeVisitor.visitTypeVariable:(Ljava/lang/reflect/TypeVariable;)V
        //    58: iconst_1       
        //    59: ifne            34
        //    62: aload_0        
        //    63: getfield        com/google/common/reflect/TypeVisitor.visited:Ljava/util/Set;
        //    66: aload           4
        //    68: invokeinterface java/util/Set.remove:(Ljava/lang/Object;)Z
        //    73: pop            
        //    74: goto            34
        //    77: aload           4
        //    79: instanceof      Ljava/lang/reflect/WildcardType;
        //    82: ifeq            116
        //    85: aload_0        
        //    86: aload           4
        //    88: checkcast       Ljava/lang/reflect/WildcardType;
        //    91: invokevirtual   com/google/common/reflect/TypeVisitor.visitWildcardType:(Ljava/lang/reflect/WildcardType;)V
        //    94: goto            58
        //    97: astore_1       
        //    98: iconst_0       
        //    99: ifne            114
        //   102: aload_0        
        //   103: getfield        com/google/common/reflect/TypeVisitor.visited:Ljava/util/Set;
        //   106: aload           4
        //   108: invokeinterface java/util/Set.remove:(Ljava/lang/Object;)Z
        //   113: pop            
        //   114: aload_1        
        //   115: athrow         
        //   116: aload           4
        //   118: instanceof      Ljava/lang/reflect/ParameterizedType;
        //   121: ifeq            136
        //   124: aload_0        
        //   125: aload           4
        //   127: checkcast       Ljava/lang/reflect/ParameterizedType;
        //   130: invokevirtual   com/google/common/reflect/TypeVisitor.visitParameterizedType:(Ljava/lang/reflect/ParameterizedType;)V
        //   133: goto            58
        //   136: aload           4
        //   138: instanceof      Ljava/lang/Class;
        //   141: ifeq            156
        //   144: aload_0        
        //   145: aload           4
        //   147: checkcast       Ljava/lang/Class;
        //   150: invokevirtual   com/google/common/reflect/TypeVisitor.visitClass:(Ljava/lang/Class;)V
        //   153: goto            58
        //   156: aload           4
        //   158: instanceof      Ljava/lang/reflect/GenericArrayType;
        //   161: ifeq            176
        //   164: aload_0        
        //   165: aload           4
        //   167: checkcast       Ljava/lang/reflect/GenericArrayType;
        //   170: invokevirtual   com/google/common/reflect/TypeVisitor.visitGenericArrayType:(Ljava/lang/reflect/GenericArrayType;)V
        //   173: goto            58
        //   176: aload           4
        //   178: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   181: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   184: astore_1       
        //   185: new             Ljava/lang/AssertionError;
        //   188: dup            
        //   189: new             Ljava/lang/StringBuilder;
        //   192: dup            
        //   193: aload_1        
        //   194: invokevirtual   java/lang/String.length:()I
        //   197: bipush          14
        //   199: iadd           
        //   200: invokespecial   java/lang/StringBuilder.<init>:(I)V
        //   203: ldc             "Unknown type: "
        //   205: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   208: aload_1        
        //   209: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   212: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   215: invokespecial   java/lang/AssertionError.<init>:(Ljava/lang/Object;)V
        //   218: athrow         
        //   219: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  41     58     97     116    Any
        //  77     94     97     116    Any
        //  116    133    97     116    Any
        //  136    153    97     116    Any
        //  156    173    97     116    Any
        //  176    219    97     116    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.assembler.ir.StackMappingVisitor.push(StackMappingVisitor.java:290)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:833)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
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
    
    void visitClass(final Class<?> clazz) {
    }
    
    void visitGenericArrayType(final GenericArrayType genericArrayType) {
    }
    
    void visitParameterizedType(final ParameterizedType parameterizedType) {
    }
    
    void visitTypeVariable(final TypeVariable<?> typeVariable) {
    }
    
    void visitWildcardType(final WildcardType wildcardType) {
    }
}
