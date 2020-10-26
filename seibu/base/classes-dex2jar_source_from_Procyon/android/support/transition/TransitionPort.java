// 
// Decompiled by Procyon v0.5.36
// 

package android.support.transition;

import java.util.List;
import java.util.Iterator;
import android.support.v4.util.LongSparseArray;
import android.util.SparseArray;
import android.support.v4.util.SimpleArrayMap;
import android.support.annotation.RestrictTo;
import android.animation.Animator$AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.widget.ListView;
import android.view.View;
import android.view.ViewGroup;
import android.animation.TimeInterpolator;
import java.util.ArrayList;
import android.animation.Animator;
import android.support.v4.util.ArrayMap;
import android.support.annotation.RequiresApi;
import android.annotation.TargetApi;

@TargetApi(14)
@RequiresApi(14)
abstract class TransitionPort implements Cloneable
{
    static final boolean DBG = false;
    private static final String LOG_TAG = "Transition";
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators;
    ArrayList<Animator> mAnimators;
    boolean mCanRemoveViews;
    ArrayList<Animator> mCurrentAnimators;
    long mDuration;
    private TransitionValuesMaps mEndValues;
    private boolean mEnded;
    TimeInterpolator mInterpolator;
    ArrayList<TransitionListener> mListeners;
    private String mName;
    int mNumInstances;
    TransitionSetPort mParent;
    boolean mPaused;
    ViewGroup mSceneRoot;
    long mStartDelay;
    private TransitionValuesMaps mStartValues;
    ArrayList<View> mTargetChildExcludes;
    ArrayList<View> mTargetExcludes;
    ArrayList<Integer> mTargetIdChildExcludes;
    ArrayList<Integer> mTargetIdExcludes;
    ArrayList<Integer> mTargetIds;
    ArrayList<Class> mTargetTypeChildExcludes;
    ArrayList<Class> mTargetTypeExcludes;
    ArrayList<View> mTargets;
    
    static {
        TransitionPort.sRunningAnimators = new ThreadLocal<ArrayMap<Animator, AnimationInfo>>();
    }
    
    public TransitionPort() {
        this.mStartDelay = -1L;
        this.mDuration = -1L;
        this.mInterpolator = null;
        this.mTargetIds = new ArrayList<Integer>();
        this.mTargets = new ArrayList<View>();
        this.mTargetIdExcludes = null;
        this.mTargetExcludes = null;
        this.mTargetTypeExcludes = null;
        this.mTargetIdChildExcludes = null;
        this.mTargetChildExcludes = null;
        this.mTargetTypeChildExcludes = null;
        this.mParent = null;
        this.mSceneRoot = null;
        this.mCanRemoveViews = false;
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mListeners = null;
        this.mAnimators = new ArrayList<Animator>();
        this.mName = this.getClass().getName();
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mCurrentAnimators = new ArrayList<Animator>();
        this.mEnded = false;
    }
    
    private void captureHierarchy(final View o, final boolean b) {
        if (o != null) {
            boolean b2 = false;
            if (o.getParent() instanceof ListView) {
                b2 = true;
            }
            if (!b2 || ((ListView)o.getParent()).getAdapter().hasStableIds()) {
                int id = -1;
                long itemIdAtPosition = -1L;
                if (!b2) {
                    id = o.getId();
                }
                else {
                    final ListView listView = (ListView)o.getParent();
                    itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(o));
                }
                if ((this.mTargetIdExcludes == null || !this.mTargetIdExcludes.contains(id)) && (this.mTargetExcludes == null || !this.mTargetExcludes.contains(o))) {
                    if (this.mTargetTypeExcludes != null && o != null) {
                        for (int size = this.mTargetTypeExcludes.size(), i = 0; i < size; ++i) {
                            if (this.mTargetTypeExcludes.get(i).isInstance(o)) {
                                return;
                            }
                        }
                    }
                    final TransitionValues transitionValues = new TransitionValues();
                    transitionValues.view = o;
                    if (b) {
                        this.captureStartValues(transitionValues);
                    }
                    else {
                        this.captureEndValues(transitionValues);
                    }
                    if (b) {
                        if (!b2) {
                            this.mStartValues.viewValues.put(o, transitionValues);
                            if (id >= 0) {
                                this.mStartValues.idValues.put(id, (Object)transitionValues);
                            }
                        }
                        else {
                            this.mStartValues.itemIdValues.put(itemIdAtPosition, transitionValues);
                        }
                    }
                    else if (!b2) {
                        this.mEndValues.viewValues.put(o, transitionValues);
                        if (id >= 0) {
                            this.mEndValues.idValues.put(id, (Object)transitionValues);
                        }
                    }
                    else {
                        this.mEndValues.itemIdValues.put(itemIdAtPosition, transitionValues);
                    }
                    if (o instanceof ViewGroup && (this.mTargetIdChildExcludes == null || !this.mTargetIdChildExcludes.contains(id)) && (this.mTargetChildExcludes == null || !this.mTargetChildExcludes.contains(o))) {
                        if (this.mTargetTypeChildExcludes != null && o != null) {
                            for (int size2 = this.mTargetTypeChildExcludes.size(), j = 0; j < size2; ++j) {
                                if (this.mTargetTypeChildExcludes.get(j).isInstance(o)) {
                                    return;
                                }
                            }
                        }
                        final ViewGroup viewGroup = (ViewGroup)o;
                        for (int k = 0; k < viewGroup.getChildCount(); ++k) {
                            this.captureHierarchy(viewGroup.getChildAt(k), b);
                        }
                    }
                }
            }
        }
    }
    
    private ArrayList<Integer> excludeId(final ArrayList<Integer> list, final int n, final boolean b) {
        ArrayList<Integer> add = list;
        if (n > 0) {
            if (!b) {
                return ArrayListManager.remove(list, n);
            }
            add = ArrayListManager.add(list, n);
        }
        return add;
    }
    
    private ArrayList<Class> excludeType(final ArrayList<Class> list, final Class clazz, final boolean b) {
        ArrayList<Class> add = list;
        if (clazz != null) {
            if (!b) {
                return (ArrayList<Class>)ArrayListManager.remove(list, clazz);
            }
            add = ArrayListManager.add(list, clazz);
        }
        return (ArrayList<Class>)add;
    }
    
    private ArrayList<View> excludeView(final ArrayList<View> list, final View view, final boolean b) {
        ArrayList<View> add = list;
        if (view != null) {
            if (!b) {
                return ArrayListManager.remove(list, view);
            }
            add = ArrayListManager.add(list, view);
        }
        return add;
    }
    
    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap<Animator, AnimationInfo> value;
        if ((value = TransitionPort.sRunningAnimators.get()) == null) {
            value = new ArrayMap<Animator, AnimationInfo>();
            TransitionPort.sRunningAnimators.set(value);
        }
        return value;
    }
    
    private void runAnimator(final Animator animator, final ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator != null) {
            animator.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter() {
                public void onAnimationEnd(final Animator o) {
                    arrayMap.remove(o);
                    TransitionPort.this.mCurrentAnimators.remove(o);
                }
                
                public void onAnimationStart(final Animator e) {
                    TransitionPort.this.mCurrentAnimators.add(e);
                }
            });
            this.animate(animator);
        }
    }
    
    public TransitionPort addListener(final TransitionListener e) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<TransitionListener>();
        }
        this.mListeners.add(e);
        return this;
    }
    
    public TransitionPort addTarget(final int i) {
        if (i > 0) {
            this.mTargetIds.add(i);
        }
        return this;
    }
    
    public TransitionPort addTarget(final View e) {
        this.mTargets.add(e);
        return this;
    }
    
    @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
    protected void animate(final Animator animator) {
        if (animator == null) {
            this.end();
            return;
        }
        if (this.getDuration() >= 0L) {
            animator.setDuration(this.getDuration());
        }
        if (this.getStartDelay() >= 0L) {
            animator.setStartDelay(this.getStartDelay());
        }
        if (this.getInterpolator() != null) {
            animator.setInterpolator(this.getInterpolator());
        }
        animator.addListener((Animator$AnimatorListener)new AnimatorListenerAdapter() {
            public void onAnimationEnd(final Animator animator) {
                TransitionPort.this.end();
                animator.removeListener((Animator$AnimatorListener)this);
            }
        });
        animator.start();
    }
    
    @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
    protected void cancel() {
        for (int i = this.mCurrentAnimators.size() - 1; i >= 0; --i) {
            this.mCurrentAnimators.get(i).cancel();
        }
        if (this.mListeners != null && this.mListeners.size() > 0) {
            final ArrayList list = (ArrayList)this.mListeners.clone();
            for (int size = list.size(), j = 0; j < size; ++j) {
                list.get(j).onTransitionCancel(this);
            }
        }
    }
    
    public abstract void captureEndValues(final TransitionValues p0);
    
    public abstract void captureStartValues(final TransitionValues p0);
    
    void captureValues(final ViewGroup viewGroup, final boolean b) {
        this.clearValues(b);
        if (this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
            if (this.mTargetIds.size() > 0) {
                for (int i = 0; i < this.mTargetIds.size(); ++i) {
                    final int intValue = this.mTargetIds.get(i);
                    final View viewById = viewGroup.findViewById(intValue);
                    if (viewById != null) {
                        final TransitionValues transitionValues = new TransitionValues();
                        transitionValues.view = viewById;
                        if (b) {
                            this.captureStartValues(transitionValues);
                        }
                        else {
                            this.captureEndValues(transitionValues);
                        }
                        if (b) {
                            this.mStartValues.viewValues.put(viewById, transitionValues);
                            if (intValue >= 0) {
                                this.mStartValues.idValues.put(intValue, (Object)transitionValues);
                            }
                        }
                        else {
                            this.mEndValues.viewValues.put(viewById, transitionValues);
                            if (intValue >= 0) {
                                this.mEndValues.idValues.put(intValue, (Object)transitionValues);
                            }
                        }
                    }
                }
            }
            if (this.mTargets.size() > 0) {
                for (int j = 0; j < this.mTargets.size(); ++j) {
                    final View view = this.mTargets.get(j);
                    if (view != null) {
                        final TransitionValues transitionValues2 = new TransitionValues();
                        transitionValues2.view = view;
                        if (b) {
                            this.captureStartValues(transitionValues2);
                        }
                        else {
                            this.captureEndValues(transitionValues2);
                        }
                        if (b) {
                            this.mStartValues.viewValues.put(view, transitionValues2);
                        }
                        else {
                            this.mEndValues.viewValues.put(view, transitionValues2);
                        }
                    }
                }
            }
        }
        else {
            this.captureHierarchy((View)viewGroup, b);
        }
    }
    
    void clearValues(final boolean b) {
        if (b) {
            this.mStartValues.viewValues.clear();
            this.mStartValues.idValues.clear();
            this.mStartValues.itemIdValues.clear();
            return;
        }
        this.mEndValues.viewValues.clear();
        this.mEndValues.idValues.clear();
        this.mEndValues.itemIdValues.clear();
    }
    
    public TransitionPort clone() {
        TransitionPort transitionPort = null;
        try {
            final TransitionPort transitionPort2 = transitionPort = (TransitionPort)super.clone();
            transitionPort2.mAnimators = new ArrayList<Animator>();
            transitionPort = transitionPort2;
            transitionPort2.mStartValues = new TransitionValuesMaps();
            transitionPort = transitionPort2;
            transitionPort2.mEndValues = new TransitionValuesMaps();
            return transitionPort2;
        }
        catch (CloneNotSupportedException ex) {
            return transitionPort;
        }
    }
    
    public Animator createAnimator(final ViewGroup viewGroup, final TransitionValues transitionValues, final TransitionValues transitionValues2) {
        return null;
    }
    
    @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
    protected void createAnimators(final ViewGroup viewGroup, final TransitionValuesMaps transitionValuesMaps, final TransitionValuesMaps transitionValuesMaps2) {
        final ArrayMap<View, TransitionValues> arrayMap = new ArrayMap<View, TransitionValues>(transitionValuesMaps2.viewValues);
        final SparseArray sparseArray = new SparseArray(transitionValuesMaps2.idValues.size());
        for (int i = 0; i < transitionValuesMaps2.idValues.size(); ++i) {
            sparseArray.put(transitionValuesMaps2.idValues.keyAt(i), transitionValuesMaps2.idValues.valueAt(i));
        }
        final LongSparseArray<TransitionValues> longSparseArray = new LongSparseArray<TransitionValues>(transitionValuesMaps2.itemIdValues.size());
        for (int j = 0; j < transitionValuesMaps2.itemIdValues.size(); ++j) {
            longSparseArray.put(transitionValuesMaps2.itemIdValues.keyAt(j), transitionValuesMaps2.itemIdValues.valueAt(j));
        }
        final ArrayList<TransitionValues> list = new ArrayList<TransitionValues>();
        final ArrayList<TransitionValues> list2 = new ArrayList<TransitionValues>();
        for (final View view : transitionValuesMaps.viewValues.keySet()) {
            TransitionValues e = null;
            boolean b = false;
            if (view.getParent() instanceof ListView) {
                b = true;
            }
            if (!b) {
                final int id = view.getId();
                TransitionValues e2;
                if (transitionValuesMaps.viewValues.get(view) != null) {
                    e2 = transitionValuesMaps.viewValues.get(view);
                }
                else {
                    e2 = (TransitionValues)transitionValuesMaps.idValues.get(id);
                }
                if (transitionValuesMaps2.viewValues.get(view) != null) {
                    e = transitionValuesMaps2.viewValues.get(view);
                    arrayMap.remove(view);
                }
                else if (id != -1) {
                    final TransitionValues transitionValues = (TransitionValues)transitionValuesMaps2.idValues.get(id);
                    Object o = null;
                    for (final View view2 : arrayMap.keySet()) {
                        if (view2.getId() == id) {
                            o = view2;
                        }
                    }
                    e = transitionValues;
                    if (o != null) {
                        arrayMap.remove(o);
                        e = transitionValues;
                    }
                }
                sparseArray.remove(id);
                if (!this.isValidTarget(view, id)) {
                    continue;
                }
                list.add(e2);
                list2.add(e);
            }
            else {
                final ListView listView = (ListView)view.getParent();
                if (!listView.getAdapter().hasStableIds()) {
                    continue;
                }
                final long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                final TransitionValues e3 = transitionValuesMaps.itemIdValues.get(itemIdAtPosition);
                longSparseArray.remove(itemIdAtPosition);
                list.add(e3);
                list2.add(null);
            }
        }
        for (int size = transitionValuesMaps.itemIdValues.size(), k = 0; k < size; ++k) {
            final long key = transitionValuesMaps.itemIdValues.keyAt(k);
            if (this.isValidTarget(null, key)) {
                final TransitionValues e4 = transitionValuesMaps.itemIdValues.get(key);
                final TransitionValues e5 = transitionValuesMaps2.itemIdValues.get(key);
                longSparseArray.remove(key);
                list.add(e4);
                list2.add(e5);
            }
        }
        for (final View view3 : arrayMap.keySet()) {
            final int id2 = view3.getId();
            if (this.isValidTarget(view3, id2)) {
                TransitionValues e6;
                if (transitionValuesMaps.viewValues.get(view3) != null) {
                    e6 = transitionValuesMaps.viewValues.get(view3);
                }
                else {
                    e6 = (TransitionValues)transitionValuesMaps.idValues.get(id2);
                }
                final TransitionValues e7 = arrayMap.get(view3);
                sparseArray.remove(id2);
                list.add(e6);
                list2.add(e7);
            }
        }
        for (int size2 = sparseArray.size(), l = 0; l < size2; ++l) {
            final int key2 = sparseArray.keyAt(l);
            if (this.isValidTarget(null, key2)) {
                final TransitionValues e8 = (TransitionValues)transitionValuesMaps.idValues.get(key2);
                final TransitionValues e9 = (TransitionValues)sparseArray.get(key2);
                list.add(e8);
                list2.add(e9);
            }
        }
        for (int size3 = longSparseArray.size(), n = 0; n < size3; ++n) {
            final long key3 = longSparseArray.keyAt(n);
            final TransitionValues e10 = transitionValuesMaps.itemIdValues.get(key3);
            final TransitionValues e11 = longSparseArray.get(key3);
            list.add(e10);
            list2.add(e11);
        }
        final ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        for (int n2 = 0; n2 < list.size(); ++n2) {
            final TransitionValues transitionValues2 = list.get(n2);
            final TransitionValues transitionValues3 = list2.get(n2);
            if ((transitionValues2 != null || transitionValues3 != null) && (transitionValues2 == null || !transitionValues2.equals(transitionValues3))) {
                final Animator animator = this.createAnimator(viewGroup, transitionValues2, transitionValues3);
                if (animator != null) {
                    final TransitionValues transitionValues4 = null;
                    Animator e12;
                    TransitionValues transitionValues5;
                    View view5;
                    if (transitionValues3 != null) {
                        final View view4 = transitionValues3.view;
                        final String[] transitionProperties = this.getTransitionProperties();
                        e12 = animator;
                        transitionValues5 = transitionValues4;
                        if ((view5 = view4) != null) {
                            e12 = animator;
                            transitionValues5 = transitionValues4;
                            view5 = view4;
                            if (transitionProperties != null) {
                                e12 = animator;
                                transitionValues5 = transitionValues4;
                                view5 = view4;
                                if (transitionProperties.length > 0) {
                                    final TransitionValues transitionValues6 = new TransitionValues();
                                    transitionValues6.view = view4;
                                    final TransitionValues transitionValues7 = transitionValuesMaps2.viewValues.get(view4);
                                    if (transitionValues7 != null) {
                                        for (int n3 = 0; n3 < transitionProperties.length; ++n3) {
                                            transitionValues6.values.put(transitionProperties[n3], transitionValues7.values.get(transitionProperties[n3]));
                                        }
                                    }
                                    final int size4 = runningAnimators.size();
                                    int n4 = 0;
                                    while (true) {
                                        e12 = animator;
                                        transitionValues5 = transitionValues6;
                                        view5 = view4;
                                        if (n4 >= size4) {
                                            break;
                                        }
                                        final AnimationInfo animationInfo = runningAnimators.get(runningAnimators.keyAt(n4));
                                        if (animationInfo.values != null && animationInfo.view == view4 && ((animationInfo.name == null && this.getName() == null) || animationInfo.name.equals(this.getName())) && animationInfo.values.equals(transitionValues6)) {
                                            e12 = null;
                                            view5 = view4;
                                            transitionValues5 = transitionValues6;
                                            break;
                                        }
                                        ++n4;
                                    }
                                }
                            }
                        }
                    }
                    else {
                        view5 = transitionValues2.view;
                        e12 = animator;
                        transitionValues5 = transitionValues4;
                    }
                    if (e12 != null) {
                        runningAnimators.put(e12, new AnimationInfo(view5, this.getName(), WindowIdPort.getWindowId((View)viewGroup), transitionValues5));
                        this.mAnimators.add(e12);
                    }
                }
            }
        }
    }
    
    @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
    protected void end() {
        --this.mNumInstances;
        if (this.mNumInstances == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                final ArrayList list = (ArrayList)this.mListeners.clone();
                for (int size = list.size(), i = 0; i < size; ++i) {
                    list.get(i).onTransitionEnd(this);
                }
            }
            for (int j = 0; j < this.mStartValues.itemIdValues.size(); ++j) {
                final View view = this.mStartValues.itemIdValues.valueAt(j).view;
            }
            for (int k = 0; k < this.mEndValues.itemIdValues.size(); ++k) {
                final View view2 = this.mEndValues.itemIdValues.valueAt(k).view;
            }
            this.mEnded = true;
        }
    }
    
    public TransitionPort excludeChildren(final int n, final boolean b) {
        this.mTargetIdChildExcludes = this.excludeId(this.mTargetIdChildExcludes, n, b);
        return this;
    }
    
    public TransitionPort excludeChildren(final View view, final boolean b) {
        this.mTargetChildExcludes = this.excludeView(this.mTargetChildExcludes, view, b);
        return this;
    }
    
    public TransitionPort excludeChildren(final Class clazz, final boolean b) {
        this.mTargetTypeChildExcludes = this.excludeType(this.mTargetTypeChildExcludes, clazz, b);
        return this;
    }
    
    public TransitionPort excludeTarget(final int n, final boolean b) {
        this.mTargetIdExcludes = this.excludeId(this.mTargetIdExcludes, n, b);
        return this;
    }
    
    public TransitionPort excludeTarget(final View view, final boolean b) {
        this.mTargetExcludes = this.excludeView(this.mTargetExcludes, view, b);
        return this;
    }
    
    public TransitionPort excludeTarget(final Class clazz, final boolean b) {
        this.mTargetTypeExcludes = this.excludeType(this.mTargetTypeExcludes, clazz, b);
        return this;
    }
    
    public long getDuration() {
        return this.mDuration;
    }
    
    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }
    
    public String getName() {
        return this.mName;
    }
    
    public long getStartDelay() {
        return this.mStartDelay;
    }
    
    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }
    
    public List<View> getTargets() {
        return this.mTargets;
    }
    
    public String[] getTransitionProperties() {
        return null;
    }
    
    public TransitionValues getTransitionValues(final View view, final boolean b) {
        TransitionValues transitionValues;
        if (this.mParent != null) {
            transitionValues = this.mParent.getTransitionValues(view, b);
        }
        else {
            TransitionValuesMaps transitionValuesMaps;
            if (b) {
                transitionValuesMaps = this.mStartValues;
            }
            else {
                transitionValuesMaps = this.mEndValues;
            }
            TransitionValues transitionValues2 = transitionValues = (TransitionValues)transitionValuesMaps.viewValues.get(view);
            if (transitionValues2 == null) {
                final int id = view.getId();
                if (id >= 0) {
                    transitionValues2 = (TransitionValues)transitionValuesMaps.idValues.get(id);
                }
                if ((transitionValues = transitionValues2) == null) {
                    transitionValues = transitionValues2;
                    if (view.getParent() instanceof ListView) {
                        final ListView listView = (ListView)view.getParent();
                        return transitionValuesMaps.itemIdValues.get(listView.getItemIdAtPosition(listView.getPositionForView(view)));
                    }
                }
            }
        }
        return transitionValues;
    }
    
    boolean isValidTarget(final View o, final long n) {
        if (this.mTargetIdExcludes != null && this.mTargetIdExcludes.contains((int)n)) {
            return false;
        }
        if (this.mTargetExcludes != null && this.mTargetExcludes.contains(o)) {
            return false;
        }
        if (this.mTargetTypeExcludes != null && o != null) {
            for (int size = this.mTargetTypeExcludes.size(), i = 0; i < size; ++i) {
                if (this.mTargetTypeExcludes.get(i).isInstance(o)) {
                    return false;
                }
            }
        }
        if (this.mTargetIds.size() == 0 && this.mTargets.size() == 0) {
            return true;
        }
        if (this.mTargetIds.size() > 0) {
            for (int j = 0; j < this.mTargetIds.size(); ++j) {
                if (this.mTargetIds.get(j) == n) {
                    return true;
                }
            }
        }
        if (o != null && this.mTargets.size() > 0) {
            for (int k = 0; k < this.mTargets.size(); ++k) {
                if (this.mTargets.get(k) == o) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
    public void pause(final View view) {
        if (!this.mEnded) {
            final ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
            final int size = runningAnimators.size();
            final WindowIdPort windowId = WindowIdPort.getWindowId(view);
            for (int i = size - 1; i >= 0; --i) {
                final AnimationInfo animationInfo = runningAnimators.valueAt(i);
                if (animationInfo.view != null && windowId.equals(animationInfo.windowId)) {
                    runningAnimators.keyAt(i).cancel();
                }
            }
            if (this.mListeners != null && this.mListeners.size() > 0) {
                final ArrayList list = (ArrayList)this.mListeners.clone();
                for (int size2 = list.size(), j = 0; j < size2; ++j) {
                    list.get(j).onTransitionPause(this);
                }
            }
            this.mPaused = true;
        }
    }
    
    void playTransition(final ViewGroup viewGroup) {
        final ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        for (int i = runningAnimators.size() - 1; i >= 0; --i) {
            final Animator animator = runningAnimators.keyAt(i);
            if (animator != null) {
                final AnimationInfo animationInfo = runningAnimators.get(animator);
                if (animationInfo != null && animationInfo.view != null && animationInfo.view.getContext() == viewGroup.getContext()) {
                    final boolean b = false;
                    final TransitionValues values = animationInfo.values;
                    final View view = animationInfo.view;
                    TransitionValues transitionValues;
                    if (this.mEndValues.viewValues != null) {
                        transitionValues = this.mEndValues.viewValues.get(view);
                    }
                    else {
                        transitionValues = null;
                    }
                    TransitionValues transitionValues2 = transitionValues;
                    if (transitionValues == null) {
                        transitionValues2 = (TransitionValues)this.mEndValues.idValues.get(view.getId());
                    }
                    int n = b ? 1 : 0;
                    Label_0254: {
                        if (values != null) {
                            n = (b ? 1 : 0);
                            if (transitionValues2 != null) {
                                final Iterator<String> iterator = values.values.keySet().iterator();
                                Object value;
                                Object value2;
                                do {
                                    n = (b ? 1 : 0);
                                    if (!iterator.hasNext()) {
                                        break Label_0254;
                                    }
                                    final String s = iterator.next();
                                    value = values.values.get(s);
                                    value2 = transitionValues2.values.get(s);
                                } while (value == null || value2 == null || value.equals(value2));
                                n = 1;
                            }
                        }
                    }
                    if (n != 0) {
                        if (animator.isRunning() || animator.isStarted()) {
                            animator.cancel();
                        }
                        else {
                            runningAnimators.remove(animator);
                        }
                    }
                }
            }
        }
        this.createAnimators(viewGroup, this.mStartValues, this.mEndValues);
        this.runAnimators();
    }
    
    public TransitionPort removeListener(final TransitionListener o) {
        if (this.mListeners != null) {
            this.mListeners.remove(o);
            if (this.mListeners.size() == 0) {
                this.mListeners = null;
                return this;
            }
        }
        return this;
    }
    
    public TransitionPort removeTarget(final int i) {
        if (i > 0) {
            this.mTargetIds.remove((Object)i);
        }
        return this;
    }
    
    public TransitionPort removeTarget(final View o) {
        if (o != null) {
            this.mTargets.remove(o);
        }
        return this;
    }
    
    @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
    public void resume(final View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                final ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
                final int size = runningAnimators.size();
                final WindowIdPort windowId = WindowIdPort.getWindowId(view);
                for (int i = size - 1; i >= 0; --i) {
                    final AnimationInfo animationInfo = runningAnimators.valueAt(i);
                    if (animationInfo.view != null && windowId.equals(animationInfo.windowId)) {
                        runningAnimators.keyAt(i).end();
                    }
                }
                if (this.mListeners != null && this.mListeners.size() > 0) {
                    final ArrayList list = (ArrayList)this.mListeners.clone();
                    for (int size2 = list.size(), j = 0; j < size2; ++j) {
                        list.get(j).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }
    
    @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
    protected void runAnimators() {
        this.start();
        final ArrayMap<Animator, AnimationInfo> runningAnimators = getRunningAnimators();
        for (final Animator animator : this.mAnimators) {
            if (runningAnimators.containsKey(animator)) {
                this.start();
                this.runAnimator(animator, runningAnimators);
            }
        }
        this.mAnimators.clear();
        this.end();
    }
    
    void setCanRemoveViews(final boolean mCanRemoveViews) {
        this.mCanRemoveViews = mCanRemoveViews;
    }
    
    public TransitionPort setDuration(final long mDuration) {
        this.mDuration = mDuration;
        return this;
    }
    
    public TransitionPort setInterpolator(final TimeInterpolator mInterpolator) {
        this.mInterpolator = mInterpolator;
        return this;
    }
    
    TransitionPort setSceneRoot(final ViewGroup mSceneRoot) {
        this.mSceneRoot = mSceneRoot;
        return this;
    }
    
    public TransitionPort setStartDelay(final long mStartDelay) {
        this.mStartDelay = mStartDelay;
        return this;
    }
    
    @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
    protected void start() {
        if (this.mNumInstances == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                final ArrayList list = (ArrayList)this.mListeners.clone();
                for (int size = list.size(), i = 0; i < size; ++i) {
                    list.get(i).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        ++this.mNumInstances;
    }
    
    @Override
    public String toString() {
        return this.toString("");
    }
    
    String toString(String str) {
        final String str2 = str = str + this.getClass().getSimpleName() + "@" + Integer.toHexString(this.hashCode()) + ": ";
        if (this.mDuration != -1L) {
            str = str2 + "dur(" + this.mDuration + ") ";
        }
        String string = str;
        if (this.mStartDelay != -1L) {
            string = str + "dly(" + this.mStartDelay + ") ";
        }
        str = string;
        if (this.mInterpolator != null) {
            str = string + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() <= 0) {
            final String string2 = str;
            if (this.mTargets.size() <= 0) {
                return string2;
            }
        }
        String string3 = str += "tgts(";
        if (this.mTargetIds.size() > 0) {
            int index = 0;
            while (true) {
                str = string3;
                if (index >= this.mTargetIds.size()) {
                    break;
                }
                str = string3;
                if (index > 0) {
                    str = string3 + ", ";
                }
                string3 = str + this.mTargetIds.get(index);
                ++index;
            }
        }
        String str3 = str;
        if (this.mTargets.size() > 0) {
            int index2 = 0;
            while (true) {
                str3 = str;
                if (index2 >= this.mTargets.size()) {
                    break;
                }
                String string4 = str;
                if (index2 > 0) {
                    string4 = str + ", ";
                }
                str = string4 + this.mTargets.get(index2);
                ++index2;
            }
        }
        return str3 + ")";
    }
    
    private static class AnimationInfo
    {
        String name;
        TransitionValues values;
        View view;
        WindowIdPort windowId;
        
        AnimationInfo(final View view, final String name, final WindowIdPort windowId, final TransitionValues values) {
            this.view = view;
            this.name = name;
            this.values = values;
            this.windowId = windowId;
        }
    }
    
    private static class ArrayListManager
    {
        static <T> ArrayList<T> add(final ArrayList<T> list, final T t) {
            ArrayList<T> list2 = list;
            if (list == null) {
                list2 = new ArrayList<T>();
            }
            if (!list2.contains(t)) {
                list2.add(t);
            }
            return list2;
        }
        
        static <T> ArrayList<T> remove(final ArrayList<T> list, final T o) {
            ArrayList<T> list2 = list;
            if (list != null) {
                list.remove(o);
                list2 = list;
                if (list.isEmpty()) {
                    list2 = null;
                }
            }
            return list2;
        }
    }
    
    public interface TransitionListener
    {
        void onTransitionCancel(final TransitionPort p0);
        
        void onTransitionEnd(final TransitionPort p0);
        
        void onTransitionPause(final TransitionPort p0);
        
        void onTransitionResume(final TransitionPort p0);
        
        void onTransitionStart(final TransitionPort p0);
    }
    
    @RestrictTo({ RestrictTo.Scope.LIBRARY_GROUP })
    public static class TransitionListenerAdapter implements TransitionListener
    {
        @Override
        public void onTransitionCancel(final TransitionPort transitionPort) {
        }
        
        @Override
        public void onTransitionEnd(final TransitionPort transitionPort) {
        }
        
        @Override
        public void onTransitionPause(final TransitionPort transitionPort) {
        }
        
        @Override
        public void onTransitionResume(final TransitionPort transitionPort) {
        }
        
        @Override
        public void onTransitionStart(final TransitionPort transitionPort) {
        }
    }
}
