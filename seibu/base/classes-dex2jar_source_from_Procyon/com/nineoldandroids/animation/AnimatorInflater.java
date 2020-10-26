// 
// Decompiled by Procyon v0.5.36
// 

package com.nineoldandroids.animation;

import android.view.animation.AnimationUtils;
import android.content.res.XmlResourceParser;
import android.content.res.Resources$NotFoundException;
import android.content.res.TypedArray;
import java.util.Iterator;
import java.util.ArrayList;
import android.util.TypedValue;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;
import android.content.Context;

public class AnimatorInflater
{
    private static final int[] Animator;
    private static final int[] AnimatorSet;
    private static final int AnimatorSet_ordering = 0;
    private static final int Animator_duration = 1;
    private static final int Animator_interpolator = 0;
    private static final int Animator_repeatCount = 3;
    private static final int Animator_repeatMode = 4;
    private static final int Animator_startOffset = 2;
    private static final int Animator_valueFrom = 5;
    private static final int Animator_valueTo = 6;
    private static final int Animator_valueType = 7;
    private static final int[] PropertyAnimator;
    private static final int PropertyAnimator_propertyName = 0;
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_FLOAT = 0;
    
    static {
        AnimatorSet = new int[] { 16843490 };
        PropertyAnimator = new int[] { 16843489 };
        Animator = new int[] { 16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488 };
    }
    
    private static Animator createAnimatorFromXml(final Context context, final XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0);
    }
    
    private static Animator createAnimatorFromXml(final Context context, final XmlPullParser xmlPullParser, final AttributeSet set, final AnimatorSet set2, final int n) throws XmlPullParserException, IOException {
        Animator animator = null;
        ArrayList<AnimatorSet> list = null;
        final int depth = xmlPullParser.getDepth();
        while (true) {
            final int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                if (set2 != null && list != null) {
                    final Animator[] array = new Animator[list.size()];
                    int n2 = 0;
                    final Iterator<AnimatorSet> iterator = list.iterator();
                    while (iterator.hasNext()) {
                        array[n2] = iterator.next();
                        ++n2;
                    }
                    if (n != 0) {
                        set2.playSequentially(array);
                        return animator;
                    }
                    set2.playTogether(array);
                }
                return animator;
            }
            if (next != 2) {
                continue;
            }
            final String name = xmlPullParser.getName();
            Animator e;
            if (name.equals("objectAnimator")) {
                e = loadObjectAnimator(context, set);
            }
            else if (name.equals("animator")) {
                e = loadAnimator(context, set, null);
            }
            else {
                if (!name.equals("set")) {
                    throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                }
                e = new AnimatorSet();
                final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, AnimatorInflater.AnimatorSet);
                final TypedValue typedValue = new TypedValue();
                obtainStyledAttributes.getValue(0, typedValue);
                int data;
                if (typedValue.type == 16) {
                    data = typedValue.data;
                }
                else {
                    data = 0;
                }
                createAnimatorFromXml(context, xmlPullParser, set, (AnimatorSet)e, data);
                obtainStyledAttributes.recycle();
            }
            animator = e;
            if (set2 == null) {
                continue;
            }
            ArrayList<AnimatorSet> list2;
            if ((list2 = list) == null) {
                list2 = new ArrayList<AnimatorSet>();
            }
            list2.add((AnimatorSet)e);
            animator = e;
            list = list2;
        }
    }
    
    public static Animator loadAnimator(final Context context, final int n) throws Resources$NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        XmlResourceParser xmlResourceParser2 = null;
        XmlResourceParser animation = null;
        try {
            return createAnimatorFromXml(context, (XmlPullParser)(xmlResourceParser2 = (xmlResourceParser = (animation = context.getResources().getAnimation(n)))));
        }
        catch (XmlPullParserException ex2) {
            xmlResourceParser = animation;
            final Resources$NotFoundException ex = new Resources$NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(n));
            xmlResourceParser = animation;
            ex.initCause((Throwable)ex2);
            xmlResourceParser = animation;
            throw ex;
        }
        catch (IOException ex4) {
            xmlResourceParser = xmlResourceParser2;
            final Resources$NotFoundException ex3 = new Resources$NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(n));
            xmlResourceParser = xmlResourceParser2;
            ex3.initCause((Throwable)ex4);
            xmlResourceParser = xmlResourceParser2;
            throw ex3;
        }
        finally {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        }
    }
    
    private static ValueAnimator loadAnimator(final Context context, final AttributeSet set, final ValueAnimator valueAnimator) throws Resources$NotFoundException {
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, AnimatorInflater.Animator);
        final long duration = obtainStyledAttributes.getInt(1, 0);
        final long startDelay = obtainStyledAttributes.getInt(2, 0);
        final int int1 = obtainStyledAttributes.getInt(7, 0);
        ValueAnimator valueAnimator2 = valueAnimator;
        if (valueAnimator == null) {
            valueAnimator2 = new ValueAnimator();
        }
        boolean b;
        if (int1 == 0) {
            b = true;
        }
        else {
            b = false;
        }
        final TypedValue peekValue = obtainStyledAttributes.peekValue(5);
        boolean b2;
        if (peekValue != null) {
            b2 = true;
        }
        else {
            b2 = false;
        }
        int type;
        if (b2) {
            type = peekValue.type;
        }
        else {
            type = 0;
        }
        final TypedValue peekValue2 = obtainStyledAttributes.peekValue(6);
        boolean b3;
        if (peekValue2 != null) {
            b3 = true;
        }
        else {
            b3 = false;
        }
        int type2;
        if (b3) {
            type2 = peekValue2.type;
        }
        else {
            type2 = 0;
        }
        int n = 0;
        Label_0177: {
            if (!b2 || type < 28 || type > 31) {
                n = (b ? 1 : 0);
                if (!b3) {
                    break Label_0177;
                }
                n = (b ? 1 : 0);
                if (type2 < 28) {
                    break Label_0177;
                }
                n = (b ? 1 : 0);
                if (type2 > 31) {
                    break Label_0177;
                }
            }
            n = 0;
            valueAnimator2.setEvaluator(new ArgbEvaluator());
        }
        if (n != 0) {
            if (b2) {
                float n2;
                if (type == 5) {
                    n2 = obtainStyledAttributes.getDimension(5, 0.0f);
                }
                else {
                    n2 = obtainStyledAttributes.getFloat(5, 0.0f);
                }
                if (b3) {
                    float n3;
                    if (type2 == 5) {
                        n3 = obtainStyledAttributes.getDimension(6, 0.0f);
                    }
                    else {
                        n3 = obtainStyledAttributes.getFloat(6, 0.0f);
                    }
                    valueAnimator2.setFloatValues(n2, n3);
                }
                else {
                    valueAnimator2.setFloatValues(n2);
                }
            }
            else {
                float n4;
                if (type2 == 5) {
                    n4 = obtainStyledAttributes.getDimension(6, 0.0f);
                }
                else {
                    n4 = obtainStyledAttributes.getFloat(6, 0.0f);
                }
                valueAnimator2.setFloatValues(n4);
            }
        }
        else if (b2) {
            int n5;
            if (type == 5) {
                n5 = (int)obtainStyledAttributes.getDimension(5, 0.0f);
            }
            else if (type >= 28 && type <= 31) {
                n5 = obtainStyledAttributes.getColor(5, 0);
            }
            else {
                n5 = obtainStyledAttributes.getInt(5, 0);
            }
            if (b3) {
                int n6;
                if (type2 == 5) {
                    n6 = (int)obtainStyledAttributes.getDimension(6, 0.0f);
                }
                else if (type2 >= 28 && type2 <= 31) {
                    n6 = obtainStyledAttributes.getColor(6, 0);
                }
                else {
                    n6 = obtainStyledAttributes.getInt(6, 0);
                }
                valueAnimator2.setIntValues(n5, n6);
            }
            else {
                valueAnimator2.setIntValues(n5);
            }
        }
        else if (b3) {
            int n7;
            if (type2 == 5) {
                n7 = (int)obtainStyledAttributes.getDimension(6, 0.0f);
            }
            else if (type2 >= 28 && type2 <= 31) {
                n7 = obtainStyledAttributes.getColor(6, 0);
            }
            else {
                n7 = obtainStyledAttributes.getInt(6, 0);
            }
            valueAnimator2.setIntValues(n7);
        }
        valueAnimator2.setDuration(duration);
        valueAnimator2.setStartDelay(startDelay);
        if (obtainStyledAttributes.hasValue(3)) {
            valueAnimator2.setRepeatCount(obtainStyledAttributes.getInt(3, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            valueAnimator2.setRepeatMode(obtainStyledAttributes.getInt(4, 1));
        }
        final int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId > 0) {
            valueAnimator2.setInterpolator(AnimationUtils.loadInterpolator(context, resourceId));
        }
        obtainStyledAttributes.recycle();
        return valueAnimator2;
    }
    
    private static ObjectAnimator loadObjectAnimator(final Context context, final AttributeSet set) throws Resources$NotFoundException {
        final ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, set, objectAnimator);
        final TypedArray obtainStyledAttributes = context.obtainStyledAttributes(set, AnimatorInflater.PropertyAnimator);
        objectAnimator.setPropertyName(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
        return objectAnimator;
    }
}
