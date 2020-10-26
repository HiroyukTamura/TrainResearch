// 
// Decompiled by Procyon v0.5.36
// 

package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.List;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;

public final class AnimatorSet extends Animator
{
    private ValueAnimator mDelayAnim;
    private long mDuration;
    private boolean mNeedsSort;
    private HashMap<Animator, Node> mNodeMap;
    private ArrayList<Node> mNodes;
    private ArrayList<Animator> mPlayingSet;
    private AnimatorSetListener mSetListener;
    private ArrayList<Node> mSortedNodes;
    private long mStartDelay;
    private boolean mStarted;
    boolean mTerminated;
    
    public AnimatorSet() {
        this.mPlayingSet = new ArrayList<Animator>();
        this.mNodeMap = new HashMap<Animator, Node>();
        this.mNodes = new ArrayList<Node>();
        this.mSortedNodes = new ArrayList<Node>();
        this.mNeedsSort = true;
        this.mSetListener = null;
        this.mTerminated = false;
        this.mStarted = false;
        this.mStartDelay = 0L;
        this.mDelayAnim = null;
        this.mDuration = -1L;
    }
    
    private void sortNodes() {
        if (this.mNeedsSort) {
            this.mSortedNodes.clear();
            final ArrayList<Node> list = new ArrayList<Node>();
            for (int size = this.mNodes.size(), i = 0; i < size; ++i) {
                final Node e = this.mNodes.get(i);
                if (e.dependencies == null || e.dependencies.size() == 0) {
                    list.add(e);
                }
            }
            final ArrayList<Node> c = new ArrayList<Node>();
            while (list.size() > 0) {
                for (int size2 = list.size(), j = 0; j < size2; ++j) {
                    final Node node = list.get(j);
                    this.mSortedNodes.add(node);
                    if (node.nodeDependents != null) {
                        for (int size3 = node.nodeDependents.size(), k = 0; k < size3; ++k) {
                            final Node e2 = node.nodeDependents.get(k);
                            e2.nodeDependencies.remove(node);
                            if (e2.nodeDependencies.size() == 0) {
                                c.add(e2);
                            }
                        }
                    }
                }
                list.clear();
                list.addAll(c);
                c.clear();
            }
            this.mNeedsSort = false;
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
        }
        else {
            for (int size4 = this.mNodes.size(), l = 0; l < size4; ++l) {
                final Node node2 = this.mNodes.get(l);
                if (node2.dependencies != null && node2.dependencies.size() > 0) {
                    for (int size5 = node2.dependencies.size(), index = 0; index < size5; ++index) {
                        final Dependency dependency = node2.dependencies.get(index);
                        if (node2.nodeDependencies == null) {
                            node2.nodeDependencies = new ArrayList<Node>();
                        }
                        if (!node2.nodeDependencies.contains(dependency.node)) {
                            node2.nodeDependencies.add(dependency.node);
                        }
                    }
                }
                node2.done = false;
            }
        }
    }
    
    @Override
    public void cancel() {
        this.mTerminated = true;
        if (this.isStarted()) {
            ArrayList<AnimatorListener> list = null;
            if (this.mListeners != null) {
                final ArrayList list2 = (ArrayList)this.mListeners.clone();
                final Iterator<AnimatorListener> iterator = list2.iterator();
                while (true) {
                    list = (ArrayList<AnimatorListener>)list2;
                    if (!iterator.hasNext()) {
                        break;
                    }
                    iterator.next().onAnimationCancel(this);
                }
            }
            if (this.mDelayAnim != null && this.mDelayAnim.isRunning()) {
                this.mDelayAnim.cancel();
            }
            else if (this.mSortedNodes.size() > 0) {
                final Iterator<Node> iterator2 = this.mSortedNodes.iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().animation.cancel();
                }
            }
            if (list != null) {
                final Iterator<AnimatorListener> iterator3 = list.iterator();
                while (iterator3.hasNext()) {
                    iterator3.next().onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }
    
    @Override
    public AnimatorSet clone() {
        final AnimatorSet set = (AnimatorSet)super.clone();
        set.mNeedsSort = true;
        set.mTerminated = false;
        set.mStarted = false;
        set.mPlayingSet = new ArrayList<Animator>();
        set.mNodeMap = new HashMap<Animator, Node>();
        set.mNodes = new ArrayList<Node>();
        set.mSortedNodes = new ArrayList<Node>();
        final HashMap<Node, Node> hashMap = new HashMap<Node, Node>();
        for (final Node key : this.mNodes) {
            final Node clone = key.clone();
            hashMap.put(key, clone);
            set.mNodes.add(clone);
            set.mNodeMap.put(clone.animation, clone);
            clone.dependencies = null;
            clone.tmpDependencies = null;
            clone.nodeDependents = null;
            clone.nodeDependencies = null;
            final ArrayList<AnimatorListener> listeners = clone.animation.getListeners();
            if (listeners != null) {
                ArrayList<AnimatorListener> list = null;
                for (final AnimatorListener e : listeners) {
                    if (e instanceof AnimatorSetListener) {
                        ArrayList<AnimatorListener> list2;
                        if ((list2 = list) == null) {
                            list2 = new ArrayList<AnimatorListener>();
                        }
                        list2.add(e);
                        list = list2;
                    }
                }
                if (list == null) {
                    continue;
                }
                final Iterator<AnimatorListener> iterator3 = list.iterator();
                while (iterator3.hasNext()) {
                    listeners.remove(iterator3.next());
                }
            }
        }
        for (final Node key2 : this.mNodes) {
            final Node node = hashMap.get(key2);
            if (key2.dependencies != null) {
                for (final Dependency dependency : key2.dependencies) {
                    node.addDependency(new Dependency((Node)hashMap.get(dependency.node), dependency.rule));
                }
            }
        }
        return set;
    }
    
    @Override
    public void end() {
        this.mTerminated = true;
        if (this.isStarted()) {
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                this.sortNodes();
                for (final Node node : this.mSortedNodes) {
                    if (this.mSetListener == null) {
                        this.mSetListener = new AnimatorSetListener(this);
                    }
                    node.animation.addListener((AnimatorListener)this.mSetListener);
                }
            }
            if (this.mDelayAnim != null) {
                this.mDelayAnim.cancel();
            }
            if (this.mSortedNodes.size() > 0) {
                final Iterator<Node> iterator2 = this.mSortedNodes.iterator();
                while (iterator2.hasNext()) {
                    iterator2.next().animation.end();
                }
            }
            if (this.mListeners != null) {
                final Iterator<AnimatorListener> iterator3 = ((ArrayList)this.mListeners.clone()).iterator();
                while (iterator3.hasNext()) {
                    iterator3.next().onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }
    
    public ArrayList<Animator> getChildAnimations() {
        final ArrayList<Animator> list = new ArrayList<Animator>();
        final Iterator<Node> iterator = this.mNodes.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().animation);
        }
        return list;
    }
    
    @Override
    public long getDuration() {
        return this.mDuration;
    }
    
    @Override
    public long getStartDelay() {
        return this.mStartDelay;
    }
    
    @Override
    public boolean isRunning() {
        final Iterator<Node> iterator = this.mNodes.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().animation.isRunning()) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean isStarted() {
        return this.mStarted;
    }
    
    public Builder play(final Animator animator) {
        if (animator != null) {
            this.mNeedsSort = true;
            return new Builder(animator);
        }
        return null;
    }
    
    public void playSequentially(final List<Animator> list) {
        if (list != null && list.size() > 0) {
            this.mNeedsSort = true;
            if (list.size() == 1) {
                this.play(list.get(0));
            }
            else {
                for (int i = 0; i < list.size() - 1; ++i) {
                    this.play(list.get(i)).before(list.get(i + 1));
                }
            }
        }
    }
    
    public void playSequentially(final Animator... array) {
        if (array != null) {
            this.mNeedsSort = true;
            if (array.length == 1) {
                this.play(array[0]);
            }
            else {
                for (int i = 0; i < array.length - 1; ++i) {
                    this.play(array[i]).before(array[i + 1]);
                }
            }
        }
    }
    
    public void playTogether(final Collection<Animator> collection) {
        if (collection != null && collection.size() > 0) {
            this.mNeedsSort = true;
            final Builder builder = null;
            final Iterator<Animator> iterator = collection.iterator();
            Builder play = builder;
            while (iterator.hasNext()) {
                final Animator animator = iterator.next();
                if (play == null) {
                    play = this.play(animator);
                }
                else {
                    play.with(animator);
                }
            }
        }
    }
    
    public void playTogether(final Animator... array) {
        if (array != null) {
            this.mNeedsSort = true;
            final Builder play = this.play(array[0]);
            for (int i = 1; i < array.length; ++i) {
                play.with(array[i]);
            }
        }
    }
    
    @Override
    public AnimatorSet setDuration(final long n) {
        if (n < 0L) {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        }
        final Iterator<Node> iterator = this.mNodes.iterator();
        while (iterator.hasNext()) {
            iterator.next().animation.setDuration(n);
        }
        this.mDuration = n;
        return this;
    }
    
    @Override
    public void setInterpolator(final Interpolator interpolator) {
        final Iterator<Node> iterator = this.mNodes.iterator();
        while (iterator.hasNext()) {
            iterator.next().animation.setInterpolator(interpolator);
        }
    }
    
    @Override
    public void setStartDelay(final long mStartDelay) {
        this.mStartDelay = mStartDelay;
    }
    
    @Override
    public void setTarget(final Object o) {
        final Iterator<Node> iterator = this.mNodes.iterator();
        while (iterator.hasNext()) {
            final Animator animation = iterator.next().animation;
            if (animation instanceof AnimatorSet) {
                ((AnimatorSet)animation).setTarget(o);
            }
            else {
                if (!(animation instanceof ObjectAnimator)) {
                    continue;
                }
                ((ObjectAnimator)animation).setTarget(o);
            }
        }
    }
    
    @Override
    public void setupEndValues() {
        final Iterator<Node> iterator = this.mNodes.iterator();
        while (iterator.hasNext()) {
            iterator.next().animation.setupEndValues();
        }
    }
    
    @Override
    public void setupStartValues() {
        final Iterator<Node> iterator = this.mNodes.iterator();
        while (iterator.hasNext()) {
            iterator.next().animation.setupStartValues();
        }
    }
    
    @Override
    public void start() {
        this.mTerminated = false;
        this.mStarted = true;
        this.sortNodes();
        final int size = this.mSortedNodes.size();
        for (int i = 0; i < size; ++i) {
            final Node node = this.mSortedNodes.get(i);
            final ArrayList<AnimatorListener> listeners = node.animation.getListeners();
            if (listeners != null && listeners.size() > 0) {
                for (final AnimatorListener animatorListener : new ArrayList<AnimatorListener>((Collection<? extends AnimatorListener>)listeners)) {
                    if (animatorListener instanceof DependencyListener || animatorListener instanceof AnimatorSetListener) {
                        node.animation.removeListener(animatorListener);
                    }
                }
            }
        }
        final ArrayList<Node> list = new ArrayList<Node>();
        for (int j = 0; j < size; ++j) {
            final Node e = this.mSortedNodes.get(j);
            if (this.mSetListener == null) {
                this.mSetListener = new AnimatorSetListener(this);
            }
            if (e.dependencies == null || e.dependencies.size() == 0) {
                list.add(e);
            }
            else {
                for (int size2 = e.dependencies.size(), k = 0; k < size2; ++k) {
                    final Dependency dependency = e.dependencies.get(k);
                    dependency.node.animation.addListener((AnimatorListener)new DependencyListener(this, e, dependency.rule));
                }
                e.tmpDependencies = (ArrayList<Dependency>)e.dependencies.clone();
            }
            e.animation.addListener((AnimatorListener)this.mSetListener);
        }
        if (this.mStartDelay <= 0L) {
            for (final Node node2 : list) {
                node2.animation.start();
                this.mPlayingSet.add(node2.animation);
            }
        }
        else {
            (this.mDelayAnim = ValueAnimator.ofFloat(0.0f, 1.0f)).setDuration(this.mStartDelay);
            this.mDelayAnim.addListener((AnimatorListener)new AnimatorListenerAdapter() {
                boolean canceled = false;
                
                @Override
                public void onAnimationCancel(final Animator animator) {
                    this.canceled = true;
                }
                
                @Override
                public void onAnimationEnd(final Animator animator) {
                    if (!this.canceled) {
                        for (int size = list.size(), i = 0; i < size; ++i) {
                            final Node node = list.get(i);
                            node.animation.start();
                            AnimatorSet.this.mPlayingSet.add(node.animation);
                        }
                    }
                }
            });
            this.mDelayAnim.start();
        }
        if (this.mListeners != null) {
            final ArrayList list2 = (ArrayList)this.mListeners.clone();
            for (int size3 = list2.size(), l = 0; l < size3; ++l) {
                list2.get(l).onAnimationStart(this);
            }
        }
        if (this.mNodes.size() == 0 && this.mStartDelay == 0L) {
            this.mStarted = false;
            if (this.mListeners != null) {
                final ArrayList list3 = (ArrayList)this.mListeners.clone();
                for (int size4 = list3.size(), index = 0; index < size4; ++index) {
                    list3.get(index).onAnimationEnd(this);
                }
            }
        }
    }
    
    private class AnimatorSetListener implements AnimatorListener
    {
        private AnimatorSet mAnimatorSet;
        
        AnimatorSetListener(final AnimatorSet mAnimatorSet) {
            this.mAnimatorSet = mAnimatorSet;
        }
        
        @Override
        public void onAnimationCancel(final Animator animator) {
            if (!AnimatorSet.this.mTerminated && AnimatorSet.this.mPlayingSet.size() == 0 && AnimatorSet.this.mListeners != null) {
                for (int size = AnimatorSet.this.mListeners.size(), i = 0; i < size; ++i) {
                    ((AnimatorListener)AnimatorSet.this.mListeners.get(i)).onAnimationCancel(this.mAnimatorSet);
                }
            }
        }
        
        @Override
        public void onAnimationEnd(final Animator animator) {
            animator.removeListener((AnimatorListener)this);
            AnimatorSet.this.mPlayingSet.remove(animator);
            this.mAnimatorSet.mNodeMap.get(animator).done = true;
            if (!AnimatorSet.this.mTerminated) {
                final ArrayList access$200 = this.mAnimatorSet.mSortedNodes;
                final int n = 1;
                final int size = access$200.size();
                int index = 0;
                int n2;
                while (true) {
                    n2 = n;
                    if (index >= size) {
                        break;
                    }
                    if (!access$200.get(index).done) {
                        n2 = 0;
                        break;
                    }
                    ++index;
                }
                if (n2 != 0) {
                    if (AnimatorSet.this.mListeners != null) {
                        final ArrayList list = (ArrayList)AnimatorSet.this.mListeners.clone();
                        for (int size2 = list.size(), i = 0; i < size2; ++i) {
                            list.get(i).onAnimationEnd(this.mAnimatorSet);
                        }
                    }
                    this.mAnimatorSet.mStarted = false;
                }
            }
        }
        
        @Override
        public void onAnimationRepeat(final Animator animator) {
        }
        
        @Override
        public void onAnimationStart(final Animator animator) {
        }
    }
    
    public class Builder
    {
        private Node mCurrentNode;
        
        Builder(final Animator animator) {
            this.mCurrentNode = AnimatorSet.this.mNodeMap.get(animator);
            if (this.mCurrentNode == null) {
                this.mCurrentNode = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, this.mCurrentNode);
                AnimatorSet.this.mNodes.add(this.mCurrentNode);
            }
        }
        
        public Builder after(final long duration) {
            final ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(duration);
            this.after(ofFloat);
            return this;
        }
        
        public Builder after(final Animator animator) {
            Node node;
            if ((node = AnimatorSet.this.mNodeMap.get(animator)) == null) {
                node = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node);
                AnimatorSet.this.mNodes.add(node);
            }
            this.mCurrentNode.addDependency(new Dependency(node, 1));
            return this;
        }
        
        public Builder before(final Animator animator) {
            Node node;
            if ((node = AnimatorSet.this.mNodeMap.get(animator)) == null) {
                node = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node);
                AnimatorSet.this.mNodes.add(node);
            }
            node.addDependency(new Dependency(this.mCurrentNode, 1));
            return this;
        }
        
        public Builder with(final Animator animator) {
            Node node;
            if ((node = AnimatorSet.this.mNodeMap.get(animator)) == null) {
                node = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node);
                AnimatorSet.this.mNodes.add(node);
            }
            node.addDependency(new Dependency(this.mCurrentNode, 0));
            return this;
        }
    }
    
    private static class Dependency
    {
        static final int AFTER = 1;
        static final int WITH = 0;
        public Node node;
        public int rule;
        
        public Dependency(final Node node, final int rule) {
            this.node = node;
            this.rule = rule;
        }
    }
    
    private static class DependencyListener implements AnimatorListener
    {
        private AnimatorSet mAnimatorSet;
        private Node mNode;
        private int mRule;
        
        public DependencyListener(final AnimatorSet mAnimatorSet, final Node mNode, final int mRule) {
            this.mAnimatorSet = mAnimatorSet;
            this.mNode = mNode;
            this.mRule = mRule;
        }
        
        private void startIfReady(final Animator animator) {
            if (!this.mAnimatorSet.mTerminated) {
                final Dependency dependency = null;
                final int size = this.mNode.tmpDependencies.size();
                int index = 0;
                Dependency o;
                while (true) {
                    o = dependency;
                    if (index >= size) {
                        break;
                    }
                    o = this.mNode.tmpDependencies.get(index);
                    if (o.rule == this.mRule && o.node.animation == animator) {
                        animator.removeListener((AnimatorListener)this);
                        break;
                    }
                    ++index;
                }
                this.mNode.tmpDependencies.remove(o);
                if (this.mNode.tmpDependencies.size() == 0) {
                    this.mNode.animation.start();
                    this.mAnimatorSet.mPlayingSet.add(this.mNode.animation);
                }
            }
        }
        
        @Override
        public void onAnimationCancel(final Animator animator) {
        }
        
        @Override
        public void onAnimationEnd(final Animator animator) {
            if (this.mRule == 1) {
                this.startIfReady(animator);
            }
        }
        
        @Override
        public void onAnimationRepeat(final Animator animator) {
        }
        
        @Override
        public void onAnimationStart(final Animator animator) {
            if (this.mRule == 0) {
                this.startIfReady(animator);
            }
        }
    }
    
    private static class Node implements Cloneable
    {
        public Animator animation;
        public ArrayList<Dependency> dependencies;
        public boolean done;
        public ArrayList<Node> nodeDependencies;
        public ArrayList<Node> nodeDependents;
        public ArrayList<Dependency> tmpDependencies;
        
        public Node(final Animator animation) {
            this.dependencies = null;
            this.tmpDependencies = null;
            this.nodeDependencies = null;
            this.nodeDependents = null;
            this.done = false;
            this.animation = animation;
        }
        
        public void addDependency(final Dependency e) {
            if (this.dependencies == null) {
                this.dependencies = new ArrayList<Dependency>();
                this.nodeDependencies = new ArrayList<Node>();
            }
            this.dependencies.add(e);
            if (!this.nodeDependencies.contains(e.node)) {
                this.nodeDependencies.add(e.node);
            }
            final Node node = e.node;
            if (node.nodeDependents == null) {
                node.nodeDependents = new ArrayList<Node>();
            }
            node.nodeDependents.add(this);
        }
        
        public Node clone() {
            try {
                final Node node = (Node)super.clone();
                node.animation = this.animation.clone();
                return node;
            }
            catch (CloneNotSupportedException ex) {
                throw new AssertionError();
            }
        }
    }
}
