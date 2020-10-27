package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.C0264R;
import p009e.p010a.p011a.p012a.C0681a;

class FragmentLayoutInflaterFactory implements LayoutInflater.Factory2 {
    private static final String TAG = "FragmentManager";
    private final FragmentManager mFragmentManager;

    FragmentLayoutInflaterFactory(FragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    @Nullable
    public View onCreateView(@Nullable View view, @NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.mFragmentManager);
        }
        Fragment fragment = null;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue((String) null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0264R.styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = obtainStyledAttributes.getString(C0264R.styleable.Fragment_android_name);
        }
        int resourceId = obtainStyledAttributes.getResourceId(C0264R.styleable.Fragment_android_id, -1);
        String string = obtainStyledAttributes.getString(C0264R.styleable.Fragment_android_tag);
        obtainStyledAttributes.recycle();
        if (attributeValue == null || !FragmentFactory.isFragmentClass(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        if (resourceId != -1) {
            fragment = this.mFragmentManager.findFragmentById(resourceId);
        }
        if (fragment == null && string != null) {
            fragment = this.mFragmentManager.findFragmentByTag(string);
        }
        if (fragment == null && id != -1) {
            fragment = this.mFragmentManager.findFragmentById(id);
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            StringBuilder a = C0681a.m330a("onCreateView: id=0x");
            a.append(Integer.toHexString(resourceId));
            a.append(" fname=");
            a.append(attributeValue);
            a.append(" existing=");
            a.append(fragment);
            Log.v(TAG, a.toString());
        }
        if (fragment == null) {
            fragment = this.mFragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), attributeValue);
            fragment.mFromLayout = true;
            fragment.mFragmentId = resourceId != 0 ? resourceId : id;
            fragment.mContainerId = id;
            fragment.mTag = string;
            fragment.mInLayout = true;
            FragmentManager fragmentManager = this.mFragmentManager;
            fragment.mFragmentManager = fragmentManager;
            FragmentHostCallback<?> fragmentHostCallback = fragmentManager.mHost;
            fragment.mHost = fragmentHostCallback;
            fragment.onInflate(fragmentHostCallback.getContext(), attributeSet, fragment.mSavedFragmentState);
            this.mFragmentManager.addFragment(fragment);
            this.mFragmentManager.moveToState(fragment);
        } else if (!fragment.mInLayout) {
            fragment.mInLayout = true;
            FragmentHostCallback<?> fragmentHostCallback2 = this.mFragmentManager.mHost;
            fragment.mHost = fragmentHostCallback2;
            fragment.onInflate(fragmentHostCallback2.getContext(), attributeSet, fragment.mSavedFragmentState);
        } else {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
        }
        FragmentManager fragmentManager2 = this.mFragmentManager;
        if (fragmentManager2.mCurState >= 1 || !fragment.mFromLayout) {
            this.mFragmentManager.moveToState(fragment);
        } else {
            fragmentManager2.moveToState(fragment, 1);
        }
        View view2 = fragment.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragment.mView.getTag() == null) {
                fragment.mView.setTag(string);
            }
            return fragment.mView;
        }
        throw new IllegalStateException(C0681a.m321a("Fragment ", attributeValue, " did not create a view."));
    }

    @Nullable
    public View onCreateView(@NonNull String str, @NonNull Context context, @NonNull AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }
}
