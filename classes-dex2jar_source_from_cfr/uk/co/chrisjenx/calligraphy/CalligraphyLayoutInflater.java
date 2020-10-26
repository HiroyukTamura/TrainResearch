/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory
 *  android.view.LayoutInflater$Factory2
 *  android.view.View
 *  android.view.ViewGroup
 *  org.xmlpull.v1.XmlPullParser
 */
package uk.co.chrisjenx.calligraphy;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import uk.co.chrisjenx.calligraphy.CalligraphyActivityFactory;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyFactory;
import uk.co.chrisjenx.calligraphy.ReflectionUtils;

class CalligraphyLayoutInflater
extends LayoutInflater
implements CalligraphyActivityFactory {
    private static final String[] sClassPrefixList = new String[]{"android.widget.", "android.webkit."};
    private final int mAttributeId;
    private final CalligraphyFactory mCalligraphyFactory;
    private Field mConstructorArgs = null;
    private boolean mSetPrivateFactory = false;

    protected CalligraphyLayoutInflater(Context context, int n2) {
        super(context);
        this.mAttributeId = n2;
        this.mCalligraphyFactory = new CalligraphyFactory(n2);
        this.setUpLayoutFactories(false);
    }

    protected CalligraphyLayoutInflater(LayoutInflater layoutInflater, Context context, int n2, boolean bl2) {
        super(layoutInflater, context);
        this.mAttributeId = n2;
        this.mCalligraphyFactory = new CalligraphyFactory(n2);
        this.setUpLayoutFactories(bl2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private View createCustomViewInternal(View arrobject, View view, String string2, Context context, AttributeSet attributeSet) {
        if (!CalligraphyConfig.get().isCustomViewCreation()) {
            return view;
        }
        if (view == null && string2.indexOf(46) > -1) {
            if (this.mConstructorArgs == null) {
                this.mConstructorArgs = ReflectionUtils.getField(LayoutInflater.class, "mConstructorArgs");
            }
            arrobject = (Object[])ReflectionUtils.getValue(this.mConstructorArgs, this);
            Object object = arrobject[0];
            arrobject[0] = context;
            ReflectionUtils.setValue(this.mConstructorArgs, this, arrobject);
            try {
                string2 = this.createView(string2, null, attributeSet);
                arrobject[0] = object;
            }
            catch (Throwable throwable) {
                arrobject[0] = object;
                ReflectionUtils.setValue(this.mConstructorArgs, this, arrobject);
                throw throwable;
            }
            catch (ClassNotFoundException classNotFoundException) {}
            ReflectionUtils.setValue(this.mConstructorArgs, this, arrobject);
            return string2;
            arrobject[0] = object;
            ReflectionUtils.setValue(this.mConstructorArgs, this, arrobject);
        }
        return view;
    }

    private void setPrivateFactoryInternal() {
        if (this.mSetPrivateFactory) {
            return;
        }
        if (!CalligraphyConfig.get().isReflection()) {
            return;
        }
        if (!(this.getContext() instanceof LayoutInflater.Factory2)) {
            this.mSetPrivateFactory = true;
            return;
        }
        Method method = ReflectionUtils.getMethod(LayoutInflater.class, "setPrivateFactory");
        if (method != null) {
            ReflectionUtils.invokeMethod(this, method, new PrivateWrapperFactory2((LayoutInflater.Factory2)this.getContext(), this, this.mCalligraphyFactory));
        }
        this.mSetPrivateFactory = true;
    }

    private void setUpLayoutFactories(boolean bl2) {
        if (bl2) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 11 && this.getFactory2() != null && !(this.getFactory2() instanceof WrapperFactory2)) {
            this.setFactory2(this.getFactory2());
        }
        if (this.getFactory() != null && !(this.getFactory() instanceof WrapperFactory)) {
            this.setFactory(this.getFactory());
        }
    }

    public LayoutInflater cloneInContext(Context context) {
        return new CalligraphyLayoutInflater(this, context, this.mAttributeId, true);
    }

    public View inflate(XmlPullParser xmlPullParser, ViewGroup viewGroup, boolean bl2) {
        this.setPrivateFactoryInternal();
        return super.inflate(xmlPullParser, viewGroup, bl2);
    }

    @TargetApi(value=11)
    @Override
    public View onActivityCreateView(View view, View view2, String string2, Context context, AttributeSet attributeSet) {
        return this.mCalligraphyFactory.onViewCreated(this.createCustomViewInternal(view, view2, string2, context, attributeSet), context, attributeSet);
    }

    @TargetApi(value=11)
    protected View onCreateView(View view, String string2, AttributeSet attributeSet) {
        return this.mCalligraphyFactory.onViewCreated(super.onCreateView(view, string2, attributeSet), this.getContext(), attributeSet);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected View onCreateView(String string2, AttributeSet attributeSet) {
        String[] arrstring = sClassPrefixList;
        int n2 = arrstring.length;
        String string3 = null;
        int n3 = 0;
        do {
            String string4;
            if (n3 >= n2) {
                string4 = string3;
                if (string3 != null) return this.mCalligraphyFactory.onViewCreated((View)string4, string4.getContext(), attributeSet);
                string4 = super.onCreateView(string2, attributeSet);
                return this.mCalligraphyFactory.onViewCreated((View)string4, string4.getContext(), attributeSet);
            }
            string4 = arrstring[n3];
            try {
                string3 = string4 = this.createView(string2, string4, attributeSet);
            }
            catch (ClassNotFoundException classNotFoundException) {}
            ++n3;
        } while (true);
    }

    public void setFactory(LayoutInflater.Factory factory) {
        if (!(factory instanceof WrapperFactory)) {
            super.setFactory((LayoutInflater.Factory)new WrapperFactory(factory, this, this.mCalligraphyFactory));
            return;
        }
        super.setFactory(factory);
    }

    @TargetApi(value=11)
    public void setFactory2(LayoutInflater.Factory2 factory2) {
        if (!(factory2 instanceof WrapperFactory2)) {
            super.setFactory2((LayoutInflater.Factory2)new WrapperFactory2(factory2, this.mCalligraphyFactory));
            return;
        }
        super.setFactory2(factory2);
    }

    @TargetApi(value=11)
    private static class PrivateWrapperFactory2
    extends WrapperFactory2 {
        private final CalligraphyLayoutInflater mInflater;

        public PrivateWrapperFactory2(LayoutInflater.Factory2 factory2, CalligraphyLayoutInflater calligraphyLayoutInflater, CalligraphyFactory calligraphyFactory) {
            super(factory2, calligraphyFactory);
            this.mInflater = calligraphyLayoutInflater;
        }

        @Override
        public View onCreateView(View view, String string2, Context context, AttributeSet attributeSet) {
            return this.mCalligraphyFactory.onViewCreated(this.mInflater.createCustomViewInternal(view, this.mFactory2.onCreateView(view, string2, context, attributeSet), string2, context, attributeSet), context, attributeSet);
        }
    }

    private static class WrapperFactory
    implements LayoutInflater.Factory {
        private final CalligraphyFactory mCalligraphyFactory;
        private final LayoutInflater.Factory mFactory;
        private final CalligraphyLayoutInflater mInflater;

        public WrapperFactory(LayoutInflater.Factory factory, CalligraphyLayoutInflater calligraphyLayoutInflater, CalligraphyFactory calligraphyFactory) {
            this.mFactory = factory;
            this.mInflater = calligraphyLayoutInflater;
            this.mCalligraphyFactory = calligraphyFactory;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public View onCreateView(String object, Context context, AttributeSet attributeSet) {
            CalligraphyFactory calligraphyFactory;
            if (Build.VERSION.SDK_INT < 11) {
                CalligraphyFactory calligraphyFactory2 = this.mCalligraphyFactory;
                calligraphyFactory = this.mInflater.createCustomViewInternal(null, this.mFactory.onCreateView((String)object, context, attributeSet), (String)object, context, attributeSet);
                object = calligraphyFactory2;
                do {
                    return ((CalligraphyFactory)object).onViewCreated((View)calligraphyFactory, context, attributeSet);
                    break;
                } while (true);
            }
            calligraphyFactory = this.mCalligraphyFactory;
            View view = this.mFactory.onCreateView((String)object, context, attributeSet);
            object = calligraphyFactory;
            calligraphyFactory = view;
            return ((CalligraphyFactory)object).onViewCreated((View)calligraphyFactory, context, attributeSet);
        }
    }

    @TargetApi(value=11)
    private static class WrapperFactory2
    implements LayoutInflater.Factory2 {
        protected final CalligraphyFactory mCalligraphyFactory;
        protected final LayoutInflater.Factory2 mFactory2;

        public WrapperFactory2(LayoutInflater.Factory2 factory2, CalligraphyFactory calligraphyFactory) {
            this.mFactory2 = factory2;
            this.mCalligraphyFactory = calligraphyFactory;
        }

        public View onCreateView(View view, String string2, Context context, AttributeSet attributeSet) {
            return this.mCalligraphyFactory.onViewCreated(this.mFactory2.onCreateView(view, string2, context, attributeSet), context, attributeSet);
        }

        public View onCreateView(String string2, Context context, AttributeSet attributeSet) {
            return this.mCalligraphyFactory.onViewCreated(this.mFactory2.onCreateView(string2, context, attributeSet), context, attributeSet);
        }
    }

}

