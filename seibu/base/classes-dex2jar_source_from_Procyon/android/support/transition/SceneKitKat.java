// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import android.transition.Scene;
import android.view.ViewGroup;
import android.view.View;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(19)
@RequiresApi(19)
class SceneKitKat extends SceneWrapper
{
    private static Field sEnterAction;
    private static Method sSetCurrentScene;
    private View mLayout;
    
    private void invokeEnterAction() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: ifnonnull       23
        //     6: ldc             Landroid/transition/Scene;.class
        //     8: ldc             "mEnterAction"
        //    10: invokevirtual   java/lang/Class.getDeclaredField:(Ljava/lang/String;)Ljava/lang/reflect/Field;
        //    13: putstatic       android/support/transition/SceneKitKat.sEnterAction:Ljava/lang/reflect/Field;
        //    16: getstatic       android/support/transition/SceneKitKat.sEnterAction:Ljava/lang/reflect/Field;
        //    19: iconst_1       
        //    20: invokevirtual   java/lang/reflect/Field.setAccessible:(Z)V
        //    23: getstatic       android/support/transition/SceneKitKat.sEnterAction:Ljava/lang/reflect/Field;
        //    26: aload_0        
        //    27: getfield        android/support/transition/SceneKitKat.mScene:Landroid/transition/Scene;
        //    30: invokevirtual   java/lang/reflect/Field.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    33: checkcast       Ljava/lang/Runnable;
        //    36: astore_1       
        //    37: aload_1        
        //    38: ifnull          47
        //    41: aload_1        
        //    42: invokeinterface java/lang/Runnable.run:()V
        //    47: return         
        //    48: astore_1       
        //    49: new             Ljava/lang/RuntimeException;
        //    52: dup            
        //    53: aload_1        
        //    54: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    57: athrow         
        //    58: astore_1       
        //    59: new             Ljava/lang/RuntimeException;
        //    62: dup            
        //    63: aload_1        
        //    64: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    67: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                              
        //  -----  -----  -----  -----  ----------------------------------
        //  6      23     48     58     Ljava/lang/NoSuchFieldException;
        //  23     37     58     68     Ljava/lang/IllegalAccessException;
        //  41     47     58     68     Ljava/lang/IllegalAccessException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0023:
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
    
    private void updateCurrentScene(final View p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: ifnonnull       37
        //     6: ldc             Landroid/transition/Scene;.class
        //     8: ldc             "setCurrentScene"
        //    10: iconst_2       
        //    11: anewarray       Ljava/lang/Class;
        //    14: dup            
        //    15: iconst_0       
        //    16: ldc             Landroid/view/View;.class
        //    18: aastore        
        //    19: dup            
        //    20: iconst_1       
        //    21: ldc             Landroid/transition/Scene;.class
        //    23: aastore        
        //    24: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    27: putstatic       android/support/transition/SceneKitKat.sSetCurrentScene:Ljava/lang/reflect/Method;
        //    30: getstatic       android/support/transition/SceneKitKat.sSetCurrentScene:Ljava/lang/reflect/Method;
        //    33: iconst_1       
        //    34: invokevirtual   java/lang/reflect/Method.setAccessible:(Z)V
        //    37: getstatic       android/support/transition/SceneKitKat.sSetCurrentScene:Ljava/lang/reflect/Method;
        //    40: aconst_null    
        //    41: iconst_2       
        //    42: anewarray       Ljava/lang/Object;
        //    45: dup            
        //    46: iconst_0       
        //    47: aload_1        
        //    48: aastore        
        //    49: dup            
        //    50: iconst_1       
        //    51: aload_0        
        //    52: getfield        android/support/transition/SceneKitKat.mScene:Landroid/transition/Scene;
        //    55: aastore        
        //    56: invokevirtual   java/lang/reflect/Method.invoke:(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
        //    59: pop            
        //    60: return         
        //    61: astore_1       
        //    62: new             Ljava/lang/RuntimeException;
        //    65: dup            
        //    66: aload_1        
        //    67: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    70: athrow         
        //    71: astore_1       
        //    72: new             Ljava/lang/RuntimeException;
        //    75: dup            
        //    76: aload_1        
        //    77: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/Throwable;)V
        //    80: athrow         
        //    81: astore_1       
        //    82: goto            72
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                         
        //  -----  -----  -----  -----  ---------------------------------------------
        //  6      37     61     71     Ljava/lang/NoSuchMethodException;
        //  37     60     71     72     Ljava/lang/IllegalAccessException;
        //  37     60     81     85     Ljava/lang/reflect/InvocationTargetException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0037:
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
    
    @Override
    public void enter() {
        if (this.mLayout != null) {
            final ViewGroup sceneRoot = this.getSceneRoot();
            sceneRoot.removeAllViews();
            sceneRoot.addView(this.mLayout);
            this.invokeEnterAction();
            this.updateCurrentScene((View)sceneRoot);
            return;
        }
        this.mScene.enter();
    }
    
    @Override
    public void init(final ViewGroup viewGroup) {
        this.mScene = new Scene(viewGroup);
    }
    
    @Override
    public void init(final ViewGroup viewGroup, final View mLayout) {
        if (mLayout instanceof ViewGroup) {
            this.mScene = new Scene(viewGroup, (ViewGroup)mLayout);
            return;
        }
        this.mScene = new Scene(viewGroup);
        this.mLayout = mLayout;
    }
}
