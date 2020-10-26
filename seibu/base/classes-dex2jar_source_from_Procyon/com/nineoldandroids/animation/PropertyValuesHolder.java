// 
// Decompiled by Procyon v0.5.36
// 

package com.nineoldandroids.animation;

import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.FloatProperty;
import java.util.Iterator;
import java.lang.reflect.InvocationTargetException;
import android.util.Log;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import com.nineoldandroids.util.Property;
import java.lang.reflect.Method;
import java.util.HashMap;

public class PropertyValuesHolder implements Cloneable
{
    private static Class[] DOUBLE_VARIANTS;
    private static Class[] FLOAT_VARIANTS;
    private static Class[] INTEGER_VARIANTS;
    private static final TypeEvaluator sFloatEvaluator;
    private static final HashMap<Class, HashMap<String, Method>> sGetterPropertyMap;
    private static final TypeEvaluator sIntEvaluator;
    private static final HashMap<Class, HashMap<String, Method>> sSetterPropertyMap;
    private Object mAnimatedValue;
    private TypeEvaluator mEvaluator;
    private Method mGetter;
    KeyframeSet mKeyframeSet;
    protected Property mProperty;
    final ReentrantReadWriteLock mPropertyMapLock;
    String mPropertyName;
    Method mSetter;
    final Object[] mTmpValueArray;
    Class mValueType;
    
    static {
        sIntEvaluator = new IntEvaluator();
        sFloatEvaluator = new FloatEvaluator();
        PropertyValuesHolder.FLOAT_VARIANTS = new Class[] { Float.TYPE, Float.class, Double.TYPE, Integer.TYPE, Double.class, Integer.class };
        PropertyValuesHolder.INTEGER_VARIANTS = new Class[] { Integer.TYPE, Integer.class, Float.TYPE, Double.TYPE, Float.class, Double.class };
        PropertyValuesHolder.DOUBLE_VARIANTS = new Class[] { Double.TYPE, Double.class, Float.TYPE, Integer.TYPE, Float.class, Integer.class };
        sSetterPropertyMap = new HashMap<Class, HashMap<String, Method>>();
        sGetterPropertyMap = new HashMap<Class, HashMap<String, Method>>();
    }
    
    private PropertyValuesHolder(final Property mProperty) {
        this.mSetter = null;
        this.mGetter = null;
        this.mKeyframeSet = null;
        this.mPropertyMapLock = new ReentrantReadWriteLock();
        this.mTmpValueArray = new Object[1];
        this.mProperty = mProperty;
        if (mProperty != null) {
            this.mPropertyName = mProperty.getName();
        }
    }
    
    private PropertyValuesHolder(final String mPropertyName) {
        this.mSetter = null;
        this.mGetter = null;
        this.mKeyframeSet = null;
        this.mPropertyMapLock = new ReentrantReadWriteLock();
        this.mTmpValueArray = new Object[1];
        this.mPropertyName = mPropertyName;
    }
    
    static String getMethodName(final String str, String substring) {
        if (substring == null || substring.length() == 0) {
            return str;
        }
        final char upperCase = Character.toUpperCase(substring.charAt(0));
        substring = substring.substring(1);
        return str + upperCase + substring;
    }
    
    private Method getPropertyFunction(final Class p0, final String p1, final Class p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          6
        //     3: aconst_null    
        //     4: astore          7
        //     6: aload_2        
        //     7: aload_0        
        //     8: getfield        com/nineoldandroids/animation/PropertyValuesHolder.mPropertyName:Ljava/lang/String;
        //    11: invokestatic    com/nineoldandroids/animation/PropertyValuesHolder.getMethodName:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    14: astore          8
        //    16: aload_3        
        //    17: ifnonnull       95
        //    20: aload_1        
        //    21: aload           8
        //    23: aconst_null    
        //    24: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    27: astore_3       
        //    28: aload_3        
        //    29: areturn        
        //    30: astore_2       
        //    31: aload           7
        //    33: astore_3       
        //    34: aload_1        
        //    35: aload           8
        //    37: aconst_null    
        //    38: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //    41: astore_1       
        //    42: aload_1        
        //    43: astore_3       
        //    44: aload_1        
        //    45: iconst_1       
        //    46: invokevirtual   java/lang/reflect/Method.setAccessible:(Z)V
        //    49: aload_1        
        //    50: astore_3       
        //    51: goto            28
        //    54: astore_1       
        //    55: ldc             "PropertyValuesHolder"
        //    57: new             Ljava/lang/StringBuilder;
        //    60: dup            
        //    61: invokespecial   java/lang/StringBuilder.<init>:()V
        //    64: ldc             "Couldn't find no-arg method for property "
        //    66: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    69: aload_0        
        //    70: getfield        com/nineoldandroids/animation/PropertyValuesHolder.mPropertyName:Ljava/lang/String;
        //    73: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    76: ldc             ": "
        //    78: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    81: aload_2        
        //    82: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    85: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    88: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //    91: pop            
        //    92: goto            28
        //    95: iconst_1       
        //    96: anewarray       Ljava/lang/Class;
        //    99: astore          7
        //   101: aload_0        
        //   102: getfield        com/nineoldandroids/animation/PropertyValuesHolder.mValueType:Ljava/lang/Class;
        //   105: ldc             Ljava/lang/Float;.class
        //   107: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   110: ifeq            168
        //   113: getstatic       com/nineoldandroids/animation/PropertyValuesHolder.FLOAT_VARIANTS:[Ljava/lang/Class;
        //   116: astore_2       
        //   117: aload_2        
        //   118: arraylength    
        //   119: istore          5
        //   121: iconst_0       
        //   122: istore          4
        //   124: aload           6
        //   126: astore_3       
        //   127: iload           4
        //   129: iload           5
        //   131: if_icmpge       265
        //   134: aload_2        
        //   135: iload           4
        //   137: aaload         
        //   138: astore          9
        //   140: aload           7
        //   142: iconst_0       
        //   143: aload           9
        //   145: aastore        
        //   146: aload_1        
        //   147: aload           8
        //   149: aload           7
        //   151: invokevirtual   java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   154: astore          6
        //   156: aload           6
        //   158: astore_3       
        //   159: aload_0        
        //   160: aload           9
        //   162: putfield        com/nineoldandroids/animation/PropertyValuesHolder.mValueType:Ljava/lang/Class;
        //   165: aload           6
        //   167: areturn        
        //   168: aload_0        
        //   169: getfield        com/nineoldandroids/animation/PropertyValuesHolder.mValueType:Ljava/lang/Class;
        //   172: ldc             Ljava/lang/Integer;.class
        //   174: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   177: ifeq            187
        //   180: getstatic       com/nineoldandroids/animation/PropertyValuesHolder.INTEGER_VARIANTS:[Ljava/lang/Class;
        //   183: astore_2       
        //   184: goto            117
        //   187: aload_0        
        //   188: getfield        com/nineoldandroids/animation/PropertyValuesHolder.mValueType:Ljava/lang/Class;
        //   191: ldc             Ljava/lang/Double;.class
        //   193: invokevirtual   java/lang/Object.equals:(Ljava/lang/Object;)Z
        //   196: ifeq            206
        //   199: getstatic       com/nineoldandroids/animation/PropertyValuesHolder.DOUBLE_VARIANTS:[Ljava/lang/Class;
        //   202: astore_2       
        //   203: goto            117
        //   206: iconst_1       
        //   207: anewarray       Ljava/lang/Class;
        //   210: astore_2       
        //   211: aload_2        
        //   212: iconst_0       
        //   213: aload_0        
        //   214: getfield        com/nineoldandroids/animation/PropertyValuesHolder.mValueType:Ljava/lang/Class;
        //   217: aastore        
        //   218: goto            117
        //   221: astore          6
        //   223: aload_1        
        //   224: aload           8
        //   226: aload           7
        //   228: invokevirtual   java/lang/Class.getDeclaredMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        //   231: astore          6
        //   233: aload           6
        //   235: astore_3       
        //   236: aload           6
        //   238: iconst_1       
        //   239: invokevirtual   java/lang/reflect/Method.setAccessible:(Z)V
        //   242: aload           6
        //   244: astore_3       
        //   245: aload_0        
        //   246: aload           9
        //   248: putfield        com/nineoldandroids/animation/PropertyValuesHolder.mValueType:Ljava/lang/Class;
        //   251: aload           6
        //   253: areturn        
        //   254: astore          6
        //   256: iload           4
        //   258: iconst_1       
        //   259: iadd           
        //   260: istore          4
        //   262: goto            127
        //   265: ldc             "PropertyValuesHolder"
        //   267: new             Ljava/lang/StringBuilder;
        //   270: dup            
        //   271: invokespecial   java/lang/StringBuilder.<init>:()V
        //   274: ldc             "Couldn't find setter/getter for property "
        //   276: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   279: aload_0        
        //   280: getfield        com/nineoldandroids/animation/PropertyValuesHolder.mPropertyName:Ljava/lang/String;
        //   283: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   286: ldc             " with value type "
        //   288: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   291: aload_0        
        //   292: getfield        com/nineoldandroids/animation/PropertyValuesHolder.mValueType:Ljava/lang/Class;
        //   295: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   298: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   301: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   304: pop            
        //   305: goto            28
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  20     28     30     95     Ljava/lang/NoSuchMethodException;
        //  34     42     54     95     Ljava/lang/NoSuchMethodException;
        //  44     49     54     95     Ljava/lang/NoSuchMethodException;
        //  146    156    221    265    Ljava/lang/NoSuchMethodException;
        //  159    165    221    265    Ljava/lang/NoSuchMethodException;
        //  223    233    254    265    Ljava/lang/NoSuchMethodException;
        //  236    242    254    265    Ljava/lang/NoSuchMethodException;
        //  245    251    254    265    Ljava/lang/NoSuchMethodException;
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
    
    public static PropertyValuesHolder ofFloat(final Property<?, Float> property, final float... array) {
        return new FloatPropertyValuesHolder(property, array);
    }
    
    public static PropertyValuesHolder ofFloat(final String s, final float... array) {
        return new FloatPropertyValuesHolder(s, array);
    }
    
    public static PropertyValuesHolder ofInt(final Property<?, Integer> property, final int... array) {
        return new IntPropertyValuesHolder(property, array);
    }
    
    public static PropertyValuesHolder ofInt(final String s, final int... array) {
        return new IntPropertyValuesHolder(s, array);
    }
    
    public static PropertyValuesHolder ofKeyframe(final Property property, final Keyframe... array) {
        final KeyframeSet ofKeyframe = KeyframeSet.ofKeyframe(array);
        if (ofKeyframe instanceof IntKeyframeSet) {
            return new IntPropertyValuesHolder(property, (IntKeyframeSet)ofKeyframe);
        }
        if (ofKeyframe instanceof FloatKeyframeSet) {
            return new FloatPropertyValuesHolder(property, (FloatKeyframeSet)ofKeyframe);
        }
        final PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(property);
        propertyValuesHolder.mKeyframeSet = ofKeyframe;
        propertyValuesHolder.mValueType = array[0].getType();
        return propertyValuesHolder;
    }
    
    public static PropertyValuesHolder ofKeyframe(final String s, final Keyframe... array) {
        final KeyframeSet ofKeyframe = KeyframeSet.ofKeyframe(array);
        if (ofKeyframe instanceof IntKeyframeSet) {
            return new IntPropertyValuesHolder(s, (IntKeyframeSet)ofKeyframe);
        }
        if (ofKeyframe instanceof FloatKeyframeSet) {
            return new FloatPropertyValuesHolder(s, (FloatKeyframeSet)ofKeyframe);
        }
        final PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(s);
        propertyValuesHolder.mKeyframeSet = ofKeyframe;
        propertyValuesHolder.mValueType = array[0].getType();
        return propertyValuesHolder;
    }
    
    public static <V> PropertyValuesHolder ofObject(final Property property, final TypeEvaluator<V> evaluator, final V... objectValues) {
        final PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(property);
        propertyValuesHolder.setObjectValues((Object[])objectValues);
        propertyValuesHolder.setEvaluator(evaluator);
        return propertyValuesHolder;
    }
    
    public static PropertyValuesHolder ofObject(final String s, final TypeEvaluator evaluator, final Object... objectValues) {
        final PropertyValuesHolder propertyValuesHolder = new PropertyValuesHolder(s);
        propertyValuesHolder.setObjectValues(objectValues);
        propertyValuesHolder.setEvaluator(evaluator);
        return propertyValuesHolder;
    }
    
    private void setupGetter(final Class clazz) {
        this.mGetter = this.setupSetterOrGetter(clazz, PropertyValuesHolder.sGetterPropertyMap, "get", null);
    }
    
    private Method setupSetterOrGetter(final Class clazz, final HashMap<Class, HashMap<String, Method>> hashMap, final String s, final Class clazz2) {
        Method method = null;
        try {
            this.mPropertyMapLock.writeLock().lock();
            final HashMap<String, Method> hashMap2 = hashMap.get(clazz);
            if (hashMap2 != null) {
                method = hashMap2.get(this.mPropertyName);
            }
            Method propertyFunction;
            if ((propertyFunction = method) == null) {
                propertyFunction = this.getPropertyFunction(clazz, s, clazz2);
                HashMap<String, Method> value;
                if ((value = hashMap2) == null) {
                    value = new HashMap<String, Method>();
                    hashMap.put(clazz, value);
                }
                value.put(this.mPropertyName, propertyFunction);
            }
            return propertyFunction;
        }
        finally {
            this.mPropertyMapLock.writeLock().unlock();
        }
    }
    
    private void setupValue(final Object obj, final Keyframe keyframe) {
        if (this.mProperty != null) {
            keyframe.setValue(this.mProperty.get(obj));
        }
        try {
            if (this.mGetter == null) {
                this.setupGetter(obj.getClass());
            }
            keyframe.setValue(this.mGetter.invoke(obj, new Object[0]));
        }
        catch (InvocationTargetException ex) {
            Log.e("PropertyValuesHolder", ex.toString());
        }
        catch (IllegalAccessException ex2) {
            Log.e("PropertyValuesHolder", ex2.toString());
        }
    }
    
    void calculateValue(final float n) {
        this.mAnimatedValue = this.mKeyframeSet.getValue(n);
    }
    
    public PropertyValuesHolder clone() {
        try {
            final PropertyValuesHolder propertyValuesHolder = (PropertyValuesHolder)super.clone();
            propertyValuesHolder.mPropertyName = this.mPropertyName;
            propertyValuesHolder.mProperty = this.mProperty;
            propertyValuesHolder.mKeyframeSet = this.mKeyframeSet.clone();
            propertyValuesHolder.mEvaluator = this.mEvaluator;
            return propertyValuesHolder;
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
    
    Object getAnimatedValue() {
        return this.mAnimatedValue;
    }
    
    public String getPropertyName() {
        return this.mPropertyName;
    }
    
    void init() {
        if (this.mEvaluator == null) {
            TypeEvaluator mEvaluator;
            if (this.mValueType == Integer.class) {
                mEvaluator = PropertyValuesHolder.sIntEvaluator;
            }
            else if (this.mValueType == Float.class) {
                mEvaluator = PropertyValuesHolder.sFloatEvaluator;
            }
            else {
                mEvaluator = null;
            }
            this.mEvaluator = mEvaluator;
        }
        if (this.mEvaluator != null) {
            this.mKeyframeSet.setEvaluator(this.mEvaluator);
        }
    }
    
    void setAnimatedValue(final Object obj) {
        if (this.mProperty != null) {
            this.mProperty.set(obj, this.getAnimatedValue());
        }
        if (this.mSetter == null) {
            return;
        }
        try {
            this.mTmpValueArray[0] = this.getAnimatedValue();
            this.mSetter.invoke(obj, this.mTmpValueArray);
        }
        catch (InvocationTargetException ex) {
            Log.e("PropertyValuesHolder", ex.toString());
        }
        catch (IllegalAccessException ex2) {
            Log.e("PropertyValuesHolder", ex2.toString());
        }
    }
    
    public void setEvaluator(final TypeEvaluator typeEvaluator) {
        this.mEvaluator = typeEvaluator;
        this.mKeyframeSet.setEvaluator(typeEvaluator);
    }
    
    public void setFloatValues(final float... array) {
        this.mValueType = Float.TYPE;
        this.mKeyframeSet = KeyframeSet.ofFloat(array);
    }
    
    public void setIntValues(final int... array) {
        this.mValueType = Integer.TYPE;
        this.mKeyframeSet = KeyframeSet.ofInt(array);
    }
    
    public void setKeyframes(final Keyframe... array) {
        final int length = array.length;
        final Keyframe[] array2 = new Keyframe[Math.max(length, 2)];
        this.mValueType = array[0].getType();
        for (int i = 0; i < length; ++i) {
            array2[i] = array[i];
        }
        this.mKeyframeSet = new KeyframeSet(array2);
    }
    
    public void setObjectValues(final Object... array) {
        this.mValueType = array[0].getClass();
        this.mKeyframeSet = KeyframeSet.ofObject(array);
    }
    
    public void setProperty(final Property mProperty) {
        this.mProperty = mProperty;
    }
    
    public void setPropertyName(final String mPropertyName) {
        this.mPropertyName = mPropertyName;
    }
    
    void setupEndValue(final Object o) {
        this.setupValue(o, this.mKeyframeSet.mKeyframes.get(this.mKeyframeSet.mKeyframes.size() - 1));
    }
    
    void setupSetter(final Class clazz) {
        this.mSetter = this.setupSetterOrGetter(clazz, PropertyValuesHolder.sSetterPropertyMap, "set", this.mValueType);
    }
    
    void setupSetterAndGetter(final Object o) {
        if (this.mProperty != null) {
            try {
                this.mProperty.get(o);
                for (final Keyframe keyframe : this.mKeyframeSet.mKeyframes) {
                    if (!keyframe.hasValue()) {
                        keyframe.setValue(this.mProperty.get(o));
                    }
                }
                return;
            }
            catch (ClassCastException ex3) {
                Log.e("PropertyValuesHolder", "No such property (" + this.mProperty.getName() + ") on target object " + o + ". Trying reflection instead");
                this.mProperty = null;
            }
        }
        final Class<?> class1 = o.getClass();
        if (this.mSetter == null) {
            this.setupSetter(class1);
        }
        for (final Keyframe keyframe2 : this.mKeyframeSet.mKeyframes) {
            if (!keyframe2.hasValue()) {
                if (this.mGetter == null) {
                    this.setupGetter(class1);
                }
                try {
                    keyframe2.setValue(this.mGetter.invoke(o, new Object[0]));
                }
                catch (InvocationTargetException ex) {
                    Log.e("PropertyValuesHolder", ex.toString());
                }
                catch (IllegalAccessException ex2) {
                    Log.e("PropertyValuesHolder", ex2.toString());
                }
            }
        }
    }
    
    void setupStartValue(final Object o) {
        this.setupValue(o, this.mKeyframeSet.mKeyframes.get(0));
    }
    
    @Override
    public String toString() {
        return this.mPropertyName + ": " + this.mKeyframeSet.toString();
    }
    
    static class FloatPropertyValuesHolder extends PropertyValuesHolder
    {
        float mFloatAnimatedValue;
        FloatKeyframeSet mFloatKeyframeSet;
        private FloatProperty mFloatProperty;
        
        public FloatPropertyValuesHolder(final Property property, final FloatKeyframeSet mKeyframeSet) {
            super(property, null);
            this.mValueType = Float.TYPE;
            this.mKeyframeSet = mKeyframeSet;
            this.mFloatKeyframeSet = (FloatKeyframeSet)this.mKeyframeSet;
            if (property instanceof FloatProperty) {
                this.mFloatProperty = (FloatProperty)this.mProperty;
            }
        }
        
        public FloatPropertyValuesHolder(final Property property, final float... floatValues) {
            super(property, null);
            this.setFloatValues(floatValues);
            if (property instanceof FloatProperty) {
                this.mFloatProperty = (FloatProperty)this.mProperty;
            }
        }
        
        public FloatPropertyValuesHolder(final String s, final FloatKeyframeSet mKeyframeSet) {
            super(s, null);
            this.mValueType = Float.TYPE;
            this.mKeyframeSet = mKeyframeSet;
            this.mFloatKeyframeSet = (FloatKeyframeSet)this.mKeyframeSet;
        }
        
        public FloatPropertyValuesHolder(final String s, final float... floatValues) {
            super(s, null);
            this.setFloatValues(floatValues);
        }
        
        @Override
        void calculateValue(final float n) {
            this.mFloatAnimatedValue = this.mFloatKeyframeSet.getFloatValue(n);
        }
        
        @Override
        public FloatPropertyValuesHolder clone() {
            final FloatPropertyValuesHolder floatPropertyValuesHolder = (FloatPropertyValuesHolder)super.clone();
            floatPropertyValuesHolder.mFloatKeyframeSet = (FloatKeyframeSet)floatPropertyValuesHolder.mKeyframeSet;
            return floatPropertyValuesHolder;
        }
        
        @Override
        Object getAnimatedValue() {
            return this.mFloatAnimatedValue;
        }
        
        @Override
        void setAnimatedValue(final Object obj) {
            if (this.mFloatProperty != null) {
                this.mFloatProperty.setValue(obj, this.mFloatAnimatedValue);
            }
            else {
                if (this.mProperty != null) {
                    this.mProperty.set(obj, this.mFloatAnimatedValue);
                    return;
                }
                if (this.mSetter != null) {
                    try {
                        this.mTmpValueArray[0] = this.mFloatAnimatedValue;
                        this.mSetter.invoke(obj, this.mTmpValueArray);
                    }
                    catch (InvocationTargetException ex) {
                        Log.e("PropertyValuesHolder", ex.toString());
                    }
                    catch (IllegalAccessException ex2) {
                        Log.e("PropertyValuesHolder", ex2.toString());
                    }
                }
            }
        }
        
        @Override
        public void setFloatValues(final float... floatValues) {
            super.setFloatValues(floatValues);
            this.mFloatKeyframeSet = (FloatKeyframeSet)this.mKeyframeSet;
        }
        
        @Override
        void setupSetter(final Class clazz) {
            if (this.mProperty != null) {
                return;
            }
            super.setupSetter(clazz);
        }
    }
    
    static class IntPropertyValuesHolder extends PropertyValuesHolder
    {
        int mIntAnimatedValue;
        IntKeyframeSet mIntKeyframeSet;
        private IntProperty mIntProperty;
        
        public IntPropertyValuesHolder(final Property property, final IntKeyframeSet mKeyframeSet) {
            super(property, null);
            this.mValueType = Integer.TYPE;
            this.mKeyframeSet = mKeyframeSet;
            this.mIntKeyframeSet = (IntKeyframeSet)this.mKeyframeSet;
            if (property instanceof IntProperty) {
                this.mIntProperty = (IntProperty)this.mProperty;
            }
        }
        
        public IntPropertyValuesHolder(final Property property, final int... intValues) {
            super(property, null);
            this.setIntValues(intValues);
            if (property instanceof IntProperty) {
                this.mIntProperty = (IntProperty)this.mProperty;
            }
        }
        
        public IntPropertyValuesHolder(final String s, final IntKeyframeSet mKeyframeSet) {
            super(s, null);
            this.mValueType = Integer.TYPE;
            this.mKeyframeSet = mKeyframeSet;
            this.mIntKeyframeSet = (IntKeyframeSet)this.mKeyframeSet;
        }
        
        public IntPropertyValuesHolder(final String s, final int... intValues) {
            super(s, null);
            this.setIntValues(intValues);
        }
        
        @Override
        void calculateValue(final float n) {
            this.mIntAnimatedValue = this.mIntKeyframeSet.getIntValue(n);
        }
        
        @Override
        public IntPropertyValuesHolder clone() {
            final IntPropertyValuesHolder intPropertyValuesHolder = (IntPropertyValuesHolder)super.clone();
            intPropertyValuesHolder.mIntKeyframeSet = (IntKeyframeSet)intPropertyValuesHolder.mKeyframeSet;
            return intPropertyValuesHolder;
        }
        
        @Override
        Object getAnimatedValue() {
            return this.mIntAnimatedValue;
        }
        
        @Override
        void setAnimatedValue(final Object obj) {
            if (this.mIntProperty != null) {
                this.mIntProperty.setValue(obj, this.mIntAnimatedValue);
            }
            else {
                if (this.mProperty != null) {
                    this.mProperty.set(obj, this.mIntAnimatedValue);
                    return;
                }
                if (this.mSetter != null) {
                    try {
                        this.mTmpValueArray[0] = this.mIntAnimatedValue;
                        this.mSetter.invoke(obj, this.mTmpValueArray);
                    }
                    catch (InvocationTargetException ex) {
                        Log.e("PropertyValuesHolder", ex.toString());
                    }
                    catch (IllegalAccessException ex2) {
                        Log.e("PropertyValuesHolder", ex2.toString());
                    }
                }
            }
        }
        
        @Override
        public void setIntValues(final int... intValues) {
            super.setIntValues(intValues);
            this.mIntKeyframeSet = (IntKeyframeSet)this.mKeyframeSet;
        }
        
        @Override
        void setupSetter(final Class clazz) {
            if (this.mProperty != null) {
                return;
            }
            super.setupSetter(clazz);
        }
    }
}
