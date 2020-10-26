// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.manager;

import android.util.Log;
import android.os.Message;
import android.content.ContextWrapper;
import android.support.v4.app.FragmentActivity;
import android.app.Application;
import android.app.Fragment;
import com.bumptech.glide.util.Util;
import android.content.Context;
import android.annotation.TargetApi;
import android.os.Build$VERSION;
import android.app.Activity;
import android.os.Looper;
import java.util.HashMap;
import android.app.FragmentManager;
import java.util.Map;
import android.os.Handler;
import com.bumptech.glide.RequestManager;
import android.os.Handler$Callback;

public class RequestManagerRetriever implements Handler$Callback
{
    static final String FRAGMENT_TAG = "com.bumptech.glide.manager";
    private static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    private static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    private static final RequestManagerRetriever INSTANCE;
    private static final String TAG = "RMRetriever";
    private volatile RequestManager applicationManager;
    private final Handler handler;
    final Map<FragmentManager, RequestManagerFragment> pendingRequestManagerFragments;
    final Map<android.support.v4.app.FragmentManager, SupportRequestManagerFragment> pendingSupportRequestManagerFragments;
    
    static {
        INSTANCE = new RequestManagerRetriever();
    }
    
    RequestManagerRetriever() {
        this.pendingRequestManagerFragments = new HashMap<FragmentManager, RequestManagerFragment>();
        this.pendingSupportRequestManagerFragments = new HashMap<android.support.v4.app.FragmentManager, SupportRequestManagerFragment>();
        this.handler = new Handler(Looper.getMainLooper(), (Handler$Callback)this);
    }
    
    @TargetApi(17)
    private static void assertNotDestroyed(final Activity activity) {
        if (Build$VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }
    
    public static RequestManagerRetriever get() {
        return RequestManagerRetriever.INSTANCE;
    }
    
    private RequestManager getApplicationManager(final Context context) {
        Label_0047: {
            if (this.applicationManager != null) {
                break Label_0047;
            }
            synchronized (this) {
                if (this.applicationManager == null) {
                    this.applicationManager = new RequestManager(context.getApplicationContext(), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode());
                }
                // monitorexit(this)
                return this.applicationManager;
            }
        }
    }
    
    @TargetApi(11)
    RequestManager fragmentGet(final Context context, final FragmentManager fragmentManager) {
        final RequestManagerFragment requestManagerFragment = this.getRequestManagerFragment(fragmentManager);
        RequestManager requestManager;
        if ((requestManager = requestManagerFragment.getRequestManager()) == null) {
            requestManager = new RequestManager(context, requestManagerFragment.getLifecycle(), requestManagerFragment.getRequestManagerTreeNode());
            requestManagerFragment.setRequestManager(requestManager);
        }
        return requestManager;
    }
    
    @TargetApi(11)
    public RequestManager get(final Activity activity) {
        if (Util.isOnBackgroundThread() || Build$VERSION.SDK_INT < 11) {
            return this.get(activity.getApplicationContext());
        }
        assertNotDestroyed(activity);
        return this.fragmentGet((Context)activity, activity.getFragmentManager());
    }
    
    @TargetApi(17)
    public RequestManager get(final Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        if (Util.isOnBackgroundThread() || Build$VERSION.SDK_INT < 17) {
            return this.get(fragment.getActivity().getApplicationContext());
        }
        return this.fragmentGet((Context)fragment.getActivity(), fragment.getChildFragmentManager());
    }
    
    public RequestManager get(final Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (Util.isOnMainThread() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return this.get((FragmentActivity)context);
            }
            if (context instanceof Activity) {
                return this.get((Activity)context);
            }
            if (context instanceof ContextWrapper) {
                return this.get(((ContextWrapper)context).getBaseContext());
            }
        }
        return this.getApplicationManager(context);
    }
    
    public RequestManager get(final android.support.v4.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        if (Util.isOnBackgroundThread()) {
            return this.get(fragment.getActivity().getApplicationContext());
        }
        return this.supportFragmentGet((Context)fragment.getActivity(), fragment.getChildFragmentManager());
    }
    
    public RequestManager get(final FragmentActivity fragmentActivity) {
        if (Util.isOnBackgroundThread()) {
            return this.get(fragmentActivity.getApplicationContext());
        }
        assertNotDestroyed(fragmentActivity);
        return this.supportFragmentGet((Context)fragmentActivity, fragmentActivity.getSupportFragmentManager());
    }
    
    @TargetApi(17)
    RequestManagerFragment getRequestManagerFragment(final FragmentManager fragmentManager) {
        RequestManagerFragment requestManagerFragment;
        if ((requestManagerFragment = (RequestManagerFragment)fragmentManager.findFragmentByTag("com.bumptech.glide.manager")) == null && (requestManagerFragment = this.pendingRequestManagerFragments.get(fragmentManager)) == null) {
            requestManagerFragment = new RequestManagerFragment();
            this.pendingRequestManagerFragments.put(fragmentManager, requestManagerFragment);
            fragmentManager.beginTransaction().add((Fragment)requestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.handler.obtainMessage(1, (Object)fragmentManager).sendToTarget();
        }
        return requestManagerFragment;
    }
    
    SupportRequestManagerFragment getSupportRequestManagerFragment(final android.support.v4.app.FragmentManager fragmentManager) {
        SupportRequestManagerFragment supportRequestManagerFragment;
        if ((supportRequestManagerFragment = (SupportRequestManagerFragment)fragmentManager.findFragmentByTag("com.bumptech.glide.manager")) == null && (supportRequestManagerFragment = this.pendingSupportRequestManagerFragments.get(fragmentManager)) == null) {
            supportRequestManagerFragment = new SupportRequestManagerFragment();
            this.pendingSupportRequestManagerFragments.put(fragmentManager, supportRequestManagerFragment);
            fragmentManager.beginTransaction().add(supportRequestManagerFragment, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.handler.obtainMessage(2, (Object)fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment;
    }
    
    public boolean handleMessage(final Message message) {
        boolean b = true;
        Object o = null;
        final Object o2 = null;
        Object obj = null;
        switch (message.what) {
            default: {
                b = false;
                obj = o2;
                break;
            }
            case 1: {
                o = this.pendingRequestManagerFragments.remove(obj = message.obj);
                break;
            }
            case 2: {
                o = this.pendingSupportRequestManagerFragments.remove(obj = message.obj);
                break;
            }
        }
        if (b && o == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return b;
    }
    
    RequestManager supportFragmentGet(final Context context, final android.support.v4.app.FragmentManager fragmentManager) {
        final SupportRequestManagerFragment supportRequestManagerFragment = this.getSupportRequestManagerFragment(fragmentManager);
        RequestManager requestManager;
        if ((requestManager = supportRequestManagerFragment.getRequestManager()) == null) {
            requestManager = new RequestManager(context, supportRequestManagerFragment.getLifecycle(), supportRequestManagerFragment.getRequestManagerTreeNode());
            supportRequestManagerFragment.setRequestManager(requestManager);
        }
        return requestManager;
    }
}
