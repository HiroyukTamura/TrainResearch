// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.manager;

import android.app.Activity;
import java.util.Iterator;
import java.util.Collections;
import java.util.Set;
import android.annotation.SuppressLint;
import com.bumptech.glide.RequestManager;
import java.util.HashSet;
import android.support.v4.app.Fragment;

public class SupportRequestManagerFragment extends Fragment
{
    private final HashSet<SupportRequestManagerFragment> childRequestManagerFragments;
    private final ActivityFragmentLifecycle lifecycle;
    private RequestManager requestManager;
    private final RequestManagerTreeNode requestManagerTreeNode;
    private SupportRequestManagerFragment rootRequestManagerFragment;
    
    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }
    
    @SuppressLint({ "ValidFragment" })
    public SupportRequestManagerFragment(final ActivityFragmentLifecycle lifecycle) {
        this.requestManagerTreeNode = new SupportFragmentRequestManagerTreeNode();
        this.childRequestManagerFragments = new HashSet<SupportRequestManagerFragment>();
        this.lifecycle = lifecycle;
    }
    
    private void addChildRequestManagerFragment(final SupportRequestManagerFragment e) {
        this.childRequestManagerFragments.add(e);
    }
    
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
    
    private void removeChildRequestManagerFragment(final SupportRequestManagerFragment o) {
        this.childRequestManagerFragments.remove(o);
    }
    
    public Set<SupportRequestManagerFragment> getDescendantRequestManagerFragments() {
        if (this.rootRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (this.rootRequestManagerFragment == this) {
            return Collections.unmodifiableSet((Set<? extends SupportRequestManagerFragment>)this.childRequestManagerFragments);
        }
        final HashSet<SupportRequestManagerFragment> s = new HashSet<SupportRequestManagerFragment>();
        for (final SupportRequestManagerFragment e : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            if (this.isDescendant(e.getParentFragment())) {
                s.add(e);
            }
        }
        return (Set<SupportRequestManagerFragment>)Collections.unmodifiableSet((Set<?>)s);
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
    
    @Override
    public void onAttach(final Activity activity) {
        super.onAttach(activity);
        this.rootRequestManagerFragment = RequestManagerRetriever.get().getSupportRequestManagerFragment(this.getActivity().getSupportFragmentManager());
        if (this.rootRequestManagerFragment != this) {
            this.rootRequestManagerFragment.addChildRequestManagerFragment(this);
        }
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
    }
    
    @Override
    public void onDetach() {
        super.onDetach();
        if (this.rootRequestManagerFragment != null) {
            this.rootRequestManagerFragment.removeChildRequestManagerFragment(this);
            this.rootRequestManagerFragment = null;
        }
    }
    
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        if (this.requestManager != null) {
            this.requestManager.onLowMemory();
        }
    }
    
    @Override
    public void onStart() {
        super.onStart();
        this.lifecycle.onStart();
    }
    
    @Override
    public void onStop() {
        super.onStop();
        this.lifecycle.onStop();
    }
    
    public void setRequestManager(final RequestManager requestManager) {
        this.requestManager = requestManager;
    }
    
    private class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode
    {
        @Override
        public Set<RequestManager> getDescendants() {
            final Set<SupportRequestManagerFragment> descendantRequestManagerFragments = SupportRequestManagerFragment.this.getDescendantRequestManagerFragments();
            final HashSet set = new HashSet<RequestManager>(descendantRequestManagerFragments.size());
            for (final SupportRequestManagerFragment supportRequestManagerFragment : descendantRequestManagerFragments) {
                if (supportRequestManagerFragment.getRequestManager() != null) {
                    set.add(supportRequestManagerFragment.getRequestManager());
                }
            }
            return (Set<RequestManager>)set;
        }
    }
}
