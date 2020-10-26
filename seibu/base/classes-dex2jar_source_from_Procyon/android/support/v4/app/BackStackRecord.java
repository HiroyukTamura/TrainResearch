// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.app;

import java.io.FileDescriptor;
import java.io.Writer;
import java.io.PrintWriter;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.support.v4.view.ViewCompat;
import android.view.View;
import java.lang.reflect.Modifier;
import android.os.Build$VERSION;
import java.util.ArrayList;

final class BackStackRecord extends FragmentTransaction implements BackStackEntry, OpGenerator
{
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SHOW = 5;
    static final boolean SUPPORTS_TRANSITIONS;
    static final String TAG = "FragmentManager";
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack;
    boolean mAllowOptimization;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    boolean mCommitted;
    int mEnterAnim;
    int mExitAnim;
    int mIndex;
    final FragmentManagerImpl mManager;
    String mName;
    ArrayList<Op> mOps;
    int mPopEnterAnim;
    int mPopExitAnim;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    int mTransition;
    int mTransitionStyle;
    
    static {
        SUPPORTS_TRANSITIONS = (Build$VERSION.SDK_INT >= 21);
    }
    
    public BackStackRecord(final FragmentManagerImpl mManager) {
        this.mOps = new ArrayList<Op>();
        this.mAllowAddToBackStack = true;
        this.mIndex = -1;
        this.mAllowOptimization = false;
        this.mManager = mManager;
    }
    
    private void doAddOp(final int mContainerId, final Fragment fragment, final String str, final int cmd) {
        final Class<? extends Fragment> class1 = fragment.getClass();
        final int modifiers = class1.getModifiers();
        if (class1.isAnonymousClass() || !Modifier.isPublic(modifiers) || (class1.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + class1.getCanonicalName() + " must be a public static class to be  properly recreated from" + " instance state.");
        }
        fragment.mFragmentManager = this.mManager;
        if (str != null) {
            if (fragment.mTag != null && !str.equals(fragment.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
            fragment.mTag = str;
        }
        if (mContainerId != 0) {
            if (mContainerId == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            if (fragment.mFragmentId != 0 && fragment.mFragmentId != mContainerId) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + mContainerId);
            }
            fragment.mFragmentId = mContainerId;
            fragment.mContainerId = mContainerId;
        }
        final Op op = new Op();
        op.cmd = cmd;
        op.fragment = fragment;
        this.addOp(op);
    }
    
    private static boolean isFragmentPostponed(final Op op) {
        final Fragment fragment = op.fragment;
        return fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }
    
    @Override
    public FragmentTransaction add(final int n, final Fragment fragment) {
        this.doAddOp(n, fragment, null, 1);
        return this;
    }
    
    @Override
    public FragmentTransaction add(final int n, final Fragment fragment, final String s) {
        this.doAddOp(n, fragment, s, 1);
        return this;
    }
    
    @Override
    public FragmentTransaction add(final Fragment fragment, final String s) {
        this.doAddOp(0, fragment, s, 1);
        return this;
    }
    
    void addOp(final Op e) {
        this.mOps.add(e);
        e.enterAnim = this.mEnterAnim;
        e.exitAnim = this.mExitAnim;
        e.popEnterAnim = this.mPopEnterAnim;
        e.popExitAnim = this.mPopExitAnim;
    }
    
    @Override
    public FragmentTransaction addSharedElement(final View view, final String e) {
        if (BackStackRecord.SUPPORTS_TRANSITIONS) {
            final String transitionName = ViewCompat.getTransitionName(view);
            if (transitionName == null) {
                throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
            }
            if (this.mSharedElementSourceNames == null) {
                this.mSharedElementSourceNames = new ArrayList<String>();
                this.mSharedElementTargetNames = new ArrayList<String>();
            }
            else {
                if (this.mSharedElementTargetNames.contains(e)) {
                    throw new IllegalArgumentException("A shared element with the target name '" + e + "' has already been added to the transaction.");
                }
                if (this.mSharedElementSourceNames.contains(transitionName)) {
                    throw new IllegalArgumentException("A shared element with the source name '" + transitionName + " has already been added to the transaction.");
                }
            }
            this.mSharedElementSourceNames.add(transitionName);
            this.mSharedElementTargetNames.add(e);
        }
        return this;
    }
    
    @Override
    public FragmentTransaction addToBackStack(final String mName) {
        if (!this.mAllowAddToBackStack) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.mAddToBackStack = true;
        this.mName = mName;
        return this;
    }
    
    @Override
    public FragmentTransaction attach(final Fragment fragment) {
        final Op op = new Op();
        op.cmd = 7;
        op.fragment = fragment;
        this.addOp(op);
        return this;
    }
    
    void bumpBackStackNesting(final int i) {
        if (this.mAddToBackStack) {
            if (FragmentManagerImpl.DEBUG) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (int size = this.mOps.size(), j = 0; j < size; ++j) {
                final Op op = this.mOps.get(j);
                if (op.fragment != null) {
                    final Fragment fragment = op.fragment;
                    fragment.mBackStackNesting += i;
                    if (FragmentManagerImpl.DEBUG) {
                        Log.v("FragmentManager", "Bump nesting of " + op.fragment + " to " + op.fragment.mBackStackNesting);
                    }
                }
            }
        }
    }
    
    @Override
    public int commit() {
        return this.commitInternal(false);
    }
    
    @Override
    public int commitAllowingStateLoss() {
        return this.commitInternal(true);
    }
    
    int commitInternal(final boolean b) {
        if (this.mCommitted) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Commit: " + this);
            final PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
            this.dump("  ", null, printWriter, null);
            printWriter.close();
        }
        this.mCommitted = true;
        if (this.mAddToBackStack) {
            this.mIndex = this.mManager.allocBackStackIndex(this);
        }
        else {
            this.mIndex = -1;
        }
        this.mManager.enqueueAction((FragmentManagerImpl.OpGenerator)this, b);
        return this.mIndex;
    }
    
    @Override
    public void commitNow() {
        this.disallowAddToBackStack();
        this.mManager.execSingleAction((FragmentManagerImpl.OpGenerator)this, false);
    }
    
    @Override
    public void commitNowAllowingStateLoss() {
        this.disallowAddToBackStack();
        this.mManager.execSingleAction((FragmentManagerImpl.OpGenerator)this, true);
    }
    
    @Override
    public FragmentTransaction detach(final Fragment fragment) {
        final Op op = new Op();
        op.cmd = 6;
        op.fragment = fragment;
        this.addOp(op);
        return this;
    }
    
    @Override
    public FragmentTransaction disallowAddToBackStack() {
        if (this.mAddToBackStack) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.mAllowAddToBackStack = false;
        return this;
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        this.dump(s, printWriter, true);
    }
    
    public void dump(final String s, final PrintWriter printWriter, final boolean b) {
        if (b) {
            printWriter.print(s);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.mCommitted);
            if (this.mTransition != 0) {
                printWriter.print(s);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.mTransition));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.mTransitionStyle));
            }
            if (this.mEnterAnim != 0 || this.mExitAnim != 0) {
                printWriter.print(s);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mEnterAnim));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.mExitAnim));
            }
            if (this.mPopEnterAnim != 0 || this.mPopExitAnim != 0) {
                printWriter.print(s);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.mPopEnterAnim));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.mPopExitAnim));
            }
            if (this.mBreadCrumbTitleRes != 0 || this.mBreadCrumbTitleText != null) {
                printWriter.print(s);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbTitleRes));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.mBreadCrumbTitleText);
            }
            if (this.mBreadCrumbShortTitleRes != 0 || this.mBreadCrumbShortTitleText != null) {
                printWriter.print(s);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.mBreadCrumbShortTitleText);
            }
        }
        if (!this.mOps.isEmpty()) {
            printWriter.print(s);
            printWriter.println("Operations:");
            new StringBuilder().append(s).append("    ").toString();
            for (int size = this.mOps.size(), i = 0; i < size; ++i) {
                final Op op = this.mOps.get(i);
                String string = null;
                switch (op.cmd) {
                    default: {
                        string = "cmd=" + op.cmd;
                        break;
                    }
                    case 0: {
                        string = "NULL";
                        break;
                    }
                    case 1: {
                        string = "ADD";
                        break;
                    }
                    case 2: {
                        string = "REPLACE";
                        break;
                    }
                    case 3: {
                        string = "REMOVE";
                        break;
                    }
                    case 4: {
                        string = "HIDE";
                        break;
                    }
                    case 5: {
                        string = "SHOW";
                        break;
                    }
                    case 6: {
                        string = "DETACH";
                        break;
                    }
                    case 7: {
                        string = "ATTACH";
                        break;
                    }
                }
                printWriter.print(s);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(string);
                printWriter.print(" ");
                printWriter.println(op.fragment);
                if (b) {
                    if (op.enterAnim != 0 || op.exitAnim != 0) {
                        printWriter.print(s);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(op.enterAnim));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(op.exitAnim));
                    }
                    if (op.popEnterAnim != 0 || op.popExitAnim != 0) {
                        printWriter.print(s);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(op.popEnterAnim));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(op.popExitAnim));
                    }
                }
            }
        }
    }
    
    void executeOps() {
        for (int size = this.mOps.size(), i = 0; i < size; ++i) {
            final Op op = this.mOps.get(i);
            final Fragment fragment = op.fragment;
            fragment.setNextTransition(this.mTransition, this.mTransitionStyle);
            switch (op.cmd) {
                default: {
                    throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
                }
                case 1: {
                    fragment.setNextAnim(op.enterAnim);
                    this.mManager.addFragment(fragment, false);
                    break;
                }
                case 3: {
                    fragment.setNextAnim(op.exitAnim);
                    this.mManager.removeFragment(fragment);
                    break;
                }
                case 4: {
                    fragment.setNextAnim(op.exitAnim);
                    this.mManager.hideFragment(fragment);
                    break;
                }
                case 5: {
                    fragment.setNextAnim(op.enterAnim);
                    this.mManager.showFragment(fragment);
                    break;
                }
                case 6: {
                    fragment.setNextAnim(op.exitAnim);
                    this.mManager.detachFragment(fragment);
                    break;
                }
                case 7: {
                    fragment.setNextAnim(op.enterAnim);
                    this.mManager.attachFragment(fragment);
                    break;
                }
            }
            if (!this.mAllowOptimization && op.cmd != 1) {
                this.mManager.moveFragmentToExpectedState(fragment);
            }
        }
        if (!this.mAllowOptimization) {
            this.mManager.moveToState(this.mManager.mCurState, true);
        }
    }
    
    void executePopOps(final boolean b) {
        for (int i = this.mOps.size() - 1; i >= 0; --i) {
            final Op op = this.mOps.get(i);
            final Fragment fragment = op.fragment;
            fragment.setNextTransition(FragmentManagerImpl.reverseTransit(this.mTransition), this.mTransitionStyle);
            switch (op.cmd) {
                default: {
                    throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
                }
                case 1: {
                    fragment.setNextAnim(op.popExitAnim);
                    this.mManager.removeFragment(fragment);
                    break;
                }
                case 3: {
                    fragment.setNextAnim(op.popEnterAnim);
                    this.mManager.addFragment(fragment, false);
                    break;
                }
                case 4: {
                    fragment.setNextAnim(op.popEnterAnim);
                    this.mManager.showFragment(fragment);
                    break;
                }
                case 5: {
                    fragment.setNextAnim(op.popExitAnim);
                    this.mManager.hideFragment(fragment);
                    break;
                }
                case 6: {
                    fragment.setNextAnim(op.popEnterAnim);
                    this.mManager.attachFragment(fragment);
                    break;
                }
                case 7: {
                    fragment.setNextAnim(op.popExitAnim);
                    this.mManager.detachFragment(fragment);
                    break;
                }
            }
            if (!this.mAllowOptimization && op.cmd != 3) {
                this.mManager.moveFragmentToExpectedState(fragment);
            }
        }
        if (!this.mAllowOptimization && b) {
            this.mManager.moveToState(this.mManager.mCurState, true);
        }
    }
    
    void expandReplaceOps(final ArrayList<Fragment> list) {
        int i = 0;
    Label_0078_Outer:
        while (i < this.mOps.size()) {
            final Op op = this.mOps.get(i);
            int n = i;
            while (true) {
                switch (op.cmd) {
                    default: {
                        n = i;
                        break Label_0078;
                    }
                    case 3:
                    case 6: {
                        list.remove(op.fragment);
                        n = i;
                        break Label_0078;
                    }
                    case 1:
                    case 7: {
                        list.add(op.fragment);
                        n = i;
                    }
                    case 4:
                    case 5: {
                        i = n + 1;
                        continue Label_0078_Outer;
                    }
                    case 2: {
                        final Fragment fragment = op.fragment;
                        final int mContainerId = fragment.mContainerId;
                        int n2 = 0;
                        int n3;
                        int n4;
                        for (int j = list.size() - 1; j >= 0; --j, n2 = n3, i = n4) {
                            final Fragment fragment2 = list.get(j);
                            n3 = n2;
                            n4 = i;
                            if (fragment2.mContainerId == mContainerId) {
                                if (fragment2 == fragment) {
                                    n3 = 1;
                                    n4 = i;
                                }
                                else {
                                    final Op element = new Op();
                                    element.cmd = 3;
                                    element.fragment = fragment2;
                                    element.enterAnim = op.enterAnim;
                                    element.popEnterAnim = op.popEnterAnim;
                                    element.exitAnim = op.exitAnim;
                                    element.popExitAnim = op.popExitAnim;
                                    this.mOps.add(i, element);
                                    list.remove(fragment2);
                                    n4 = i + 1;
                                    n3 = n2;
                                }
                            }
                        }
                        if (n2 != 0) {
                            this.mOps.remove(i);
                            n = i - 1;
                            continue;
                        }
                        op.cmd = 1;
                        list.add(fragment);
                        n = i;
                        continue;
                    }
                }
                break;
            }
        }
    }
    
    @Override
    public boolean generateOps(final ArrayList<BackStackRecord> list, final ArrayList<Boolean> list2) {
        if (FragmentManagerImpl.DEBUG) {
            Log.v("FragmentManager", "Run: " + this);
        }
        list.add(this);
        list2.add(false);
        if (this.mAddToBackStack) {
            this.mManager.addBackStackState(this);
        }
        return true;
    }
    
    @Override
    public CharSequence getBreadCrumbShortTitle() {
        if (this.mBreadCrumbShortTitleRes != 0) {
            return this.mManager.mHost.getContext().getText(this.mBreadCrumbShortTitleRes);
        }
        return this.mBreadCrumbShortTitleText;
    }
    
    @Override
    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }
    
    @Override
    public CharSequence getBreadCrumbTitle() {
        if (this.mBreadCrumbTitleRes != 0) {
            return this.mManager.mHost.getContext().getText(this.mBreadCrumbTitleRes);
        }
        return this.mBreadCrumbTitleText;
    }
    
    @Override
    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }
    
    @Override
    public int getId() {
        return this.mIndex;
    }
    
    @Override
    public String getName() {
        return this.mName;
    }
    
    public int getTransition() {
        return this.mTransition;
    }
    
    public int getTransitionStyle() {
        return this.mTransitionStyle;
    }
    
    @Override
    public FragmentTransaction hide(final Fragment fragment) {
        final Op op = new Op();
        op.cmd = 4;
        op.fragment = fragment;
        this.addOp(op);
        return this;
    }
    
    boolean interactsWith(final int n) {
        for (int size = this.mOps.size(), i = 0; i < size; ++i) {
            if (this.mOps.get(i).fragment.mContainerId == n) {
                return true;
            }
        }
        return false;
    }
    
    boolean interactsWith(final ArrayList<BackStackRecord> list, final int n, final int n2) {
        if (n2 != n) {
            final int size = this.mOps.size();
            int n3 = -1;
            int n4;
            for (int i = 0; i < size; ++i, n3 = n4) {
                final int mContainerId = this.mOps.get(i).fragment.mContainerId;
                n4 = n3;
                if (mContainerId != 0 && mContainerId != (n4 = n3)) {
                    final int n5 = mContainerId;
                    int index = n;
                    while (true) {
                        n4 = n5;
                        if (index >= n2) {
                            break;
                        }
                        final BackStackRecord backStackRecord = list.get(index);
                        for (int size2 = backStackRecord.mOps.size(), j = 0; j < size2; ++j) {
                            if (backStackRecord.mOps.get(j).fragment.mContainerId == mContainerId) {
                                return true;
                            }
                        }
                        ++index;
                    }
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }
    
    @Override
    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }
    
    boolean isPostponed() {
        for (int i = 0; i < this.mOps.size(); ++i) {
            if (isFragmentPostponed(this.mOps.get(i))) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public FragmentTransaction remove(final Fragment fragment) {
        final Op op = new Op();
        op.cmd = 3;
        op.fragment = fragment;
        this.addOp(op);
        return this;
    }
    
    @Override
    public FragmentTransaction replace(final int n, final Fragment fragment) {
        return this.replace(n, fragment, null);
    }
    
    @Override
    public FragmentTransaction replace(final int n, final Fragment fragment, final String s) {
        if (n == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        this.doAddOp(n, fragment, s, 2);
        return this;
    }
    
    @Override
    public FragmentTransaction setAllowOptimization(final boolean mAllowOptimization) {
        this.mAllowOptimization = mAllowOptimization;
        return this;
    }
    
    @Override
    public FragmentTransaction setBreadCrumbShortTitle(final int mBreadCrumbShortTitleRes) {
        this.mBreadCrumbShortTitleRes = mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }
    
    @Override
    public FragmentTransaction setBreadCrumbShortTitle(final CharSequence mBreadCrumbShortTitleText) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = mBreadCrumbShortTitleText;
        return this;
    }
    
    @Override
    public FragmentTransaction setBreadCrumbTitle(final int mBreadCrumbTitleRes) {
        this.mBreadCrumbTitleRes = mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = null;
        return this;
    }
    
    @Override
    public FragmentTransaction setBreadCrumbTitle(final CharSequence mBreadCrumbTitleText) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = mBreadCrumbTitleText;
        return this;
    }
    
    @Override
    public FragmentTransaction setCustomAnimations(final int n, final int n2) {
        return this.setCustomAnimations(n, n2, 0, 0);
    }
    
    @Override
    public FragmentTransaction setCustomAnimations(final int mEnterAnim, final int mExitAnim, final int mPopEnterAnim, final int mPopExitAnim) {
        this.mEnterAnim = mEnterAnim;
        this.mExitAnim = mExitAnim;
        this.mPopEnterAnim = mPopEnterAnim;
        this.mPopExitAnim = mPopExitAnim;
        return this;
    }
    
    void setOnStartPostponedListener(final Fragment.OnStartEnterTransitionListener onStartEnterTransitionListener) {
        for (int i = 0; i < this.mOps.size(); ++i) {
            final Op op = this.mOps.get(i);
            if (isFragmentPostponed(op)) {
                op.fragment.setOnStartEnterTransitionListener(onStartEnterTransitionListener);
            }
        }
    }
    
    @Override
    public FragmentTransaction setTransition(final int mTransition) {
        this.mTransition = mTransition;
        return this;
    }
    
    @Override
    public FragmentTransaction setTransitionStyle(final int mTransitionStyle) {
        this.mTransitionStyle = mTransitionStyle;
        return this;
    }
    
    @Override
    public FragmentTransaction show(final Fragment fragment) {
        final Op op = new Op();
        op.cmd = 5;
        op.fragment = fragment;
        this.addOp(op);
        return this;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mName != null) {
            sb.append(" ");
            sb.append(this.mName);
        }
        sb.append("}");
        return sb.toString();
    }
    
    void trackAddedFragmentsInPop(final ArrayList<Fragment> list) {
        for (int i = 0; i < this.mOps.size(); ++i) {
            final Op op = this.mOps.get(i);
            switch (op.cmd) {
                case 1:
                case 7: {
                    list.remove(op.fragment);
                    break;
                }
                case 3:
                case 6: {
                    list.add(op.fragment);
                    break;
                }
            }
        }
    }
    
    static final class Op
    {
        int cmd;
        int enterAnim;
        int exitAnim;
        Fragment fragment;
        int popEnterAnim;
        int popExitAnim;
    }
}
