// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.manager;

import android.app.Activity;
import java.util.Iterator;
import android.os.Build$VERSION;
import java.util.Collections;
import java.util.Set;
import android.annotation.SuppressLint;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;
import android.annotation.TargetApi;
import android.app.Fragment;

@TargetApi(11)
public class RequestManagerFragment extends Fragment
{
    private final HashSet<RequestManagerFragment> childRequestManagerFragments;
    private final ActivityFragmentLifecycle lifecycle;
    private RequestManager requestManager;
    private final RequestManagerTreeNode requestManagerTreeNode;
    private RequestManagerFragment rootRequestManagerFragment;
    
    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }
    
    @SuppressLint({ "ValidFragment" })
    RequestManagerFragment(final ActivityFragmentLifecycle lifecycle) {
        this.requestManagerTreeNode = new FragmentRequestManagerTreeNode();
        this.childRequestManagerFragments = new HashSet<RequestManagerFragment>();
        this.lifecycle = lifecycle;
    }
    
    private void addChildRequestManagerFragment(final RequestManagerFragment e) {
        this.childRequestManagerFragments.add(e);
    }
    
    @TargetApi(17)
    private boolean isDescendant(Fragment parentFragment) {
        final Fragment parentFragment2 = this.getParentFragment();
        while (parentFragment.getParentFragment() != null) {
            if (parentFragment.getParentFragment() == parentFragment2) {
                return true;
            }
            parentFragment = parentFragment.getParentFragment();
        }
        return false;
    }
    
    private void removeChildRequestManagerFragment(final RequestManagerFragment o) {
        this.childRequestManagerFragments.remove(o);
    }
    
    @TargetApi(17)
    public Set<RequestManagerFragment> getDescendantRequestManagerFragments() {
        if (this.rootRequestManagerFragment == this) {
            return Collections.unmodifiableSet((Set<? extends RequestManagerFragment>)this.childRequestManagerFragments);
        }
        if (this.rootRequestManagerFragment == null || Build$VERSION.SDK_INT < 17) {
            return Collections.emptySet();
        }
        final HashSet<RequestManagerFragment> s = new HashSet<RequestManagerFragment>();
        for (final RequestManagerFragment e : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            if (this.isDescendant(e.getParentFragment())) {
                s.add(e);
            }
        }
        return (Set<RequestManagerFragment>)Collections.unmodifiableSet((Set<?>)s);
    }
    
    ActivityFragmentLifecycle getLifecycle() {
        return this.lifecycle;
    }
    
    public RequestManager getRequestManager() {
        return this.requestManager;
    }
    
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }
    
    public void onAttach(final Activity activity) {
        super.onAttach(activity);
        this.rootRequestManagerFragment = RequestManagerRetriever.get().getRequestManagerFragment(this.getActivity().getFragmentManager());
        if (this.rootRequestManagerFragment != this) {
            this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
        }
    }
    
    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
    }
    
    public void onDetach() {
        super.onDetach();
        if (this.rootRequestManagerFragment != null) {
            this.rootRequestManagerFragment.removeChildRequestManagerFragment(this);
            this.rootRequestManagerFragment = null;
        }
    }
    
    public void onLowMemory() {
        if (this.requestManager != null) {
            this.requestManager.onLowMemory();
        }
    }
    
    public void onStart() {
        super.onStart();
        this.lifecycle.onStart();
    }
    
    public void onStop() {
        super.onStop();
        this.lifecycle.onStop();
    }
    
    public void onTrimMemory(final int n) {
        if (this.requestManager != null) {
            this.requestManager.onTrimMemory(n);
        }
    }
    
    public void setRequestManager(final RequestManager requestManager) {
        this.requestManager = requestManager;
    }
    
    private class FragmentRequestManagerTreeNode implements RequestManagerTreeNode
    {
        @Override
        public Set<RequestManager> getDescendants() {
            final Set<RequestManagerFragment> descendantRequestManagerFragments = RequestManagerFragment.this.getDescendantRequestManagerFragments();
            final HashSet set = new HashSet<RequestManager>(descendantRequestManagerFragments.size());
            for (final RequestManagerFragment requestManagerFragment : descendantRequestManagerFragments) {
                if (requestManagerFragment.getRequestManager() != null) {
                    set.add(requestManagerFragment.getRequestManager());
                }
            }
            return (Set<RequestManager>)set;
        }
    }
}
