/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.transition.Transition
 *  android.transition.Transition$EpicenterCallback
 *  android.transition.Transition$TransitionListener
 *  android.transition.TransitionManager
 *  android.transition.TransitionSet
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.f.a;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.f.a.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class r
extends s {
    r() {
    }

    private static boolean a(Transition transition) {
        return !r.a(transition.getTargetIds()) || !r.a(transition.getTargetNames()) || !r.a(transition.getTargetTypes());
        {
        }
    }

    @Override
    public Object a(Object object, Object object2, Object object3) {
        TransitionSet transitionSet = new TransitionSet();
        if (object != null) {
            transitionSet.addTransition((Transition)object);
        }
        if (object2 != null) {
            transitionSet.addTransition((Transition)object2);
        }
        if (object3 != null) {
            transitionSet.addTransition((Transition)object3);
        }
        return transitionSet;
    }

    @Override
    public void a(ViewGroup viewGroup, Object object) {
        TransitionManager.beginDelayedTransition((ViewGroup)viewGroup, (Transition)((Transition)object));
    }

    @Override
    public void a(Object object, final Rect rect) {
        if (object != null) {
            ((Transition)object).setEpicenterCallback(new Transition.EpicenterCallback(){

                public Rect onGetEpicenter(Transition transition) {
                    if (rect != null && !rect.isEmpty()) {
                        return rect;
                    }
                    return null;
                }
            });
        }
    }

    @Override
    public void a(Object object, View view) {
        if (view != null) {
            object = (Transition)object;
            final Rect rect = new Rect();
            this.a(view, rect);
            object.setEpicenterCallback(new Transition.EpicenterCallback(){

                public Rect onGetEpicenter(Transition transition) {
                    return rect;
                }
            });
        }
    }

    @Override
    public void a(Object object, View view, ArrayList<View> arrayList) {
        object = (TransitionSet)object;
        List list = object.getTargets();
        list.clear();
        int n2 = arrayList.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            r.a(list, arrayList.get(i2));
        }
        list.add(view);
        arrayList.add(view);
        this.a(object, arrayList);
    }

    @Override
    public void a(Object object, final Object object2, final ArrayList<View> arrayList, final Object object3, final ArrayList<View> arrayList2, final Object object4, final ArrayList<View> arrayList3) {
        ((Transition)object).addListener(new Transition.TransitionListener(){

            public void onTransitionCancel(Transition transition) {
            }

            public void onTransitionEnd(Transition transition) {
            }

            public void onTransitionPause(Transition transition) {
            }

            public void onTransitionResume(Transition transition) {
            }

            public void onTransitionStart(Transition transition) {
                if (object2 != null) {
                    r.this.b(object2, arrayList, null);
                }
                if (object3 != null) {
                    r.this.b(object3, arrayList2, null);
                }
                if (object4 != null) {
                    r.this.b(object4, arrayList3, null);
                }
            }
        });
    }

    @Override
    public void a(Object object, ArrayList<View> arrayList) {
        block4 : {
            int n2;
            block3 : {
                if ((object = (Transition)object) == null) {
                    return;
                }
                boolean bl2 = object instanceof TransitionSet;
                int n3 = 0;
                if (!bl2) break block3;
                object = (TransitionSet)object;
                n3 = object.getTransitionCount();
                for (n2 = 0; n2 < n3; ++n2) {
                    this.a((Object)object.getTransitionAt(n2), arrayList);
                }
                break block4;
            }
            if (r.a((Transition)object) || !r.a(object.getTargets())) break block4;
            int n4 = arrayList.size();
            for (n2 = n3; n2 < n4; ++n2) {
                object.addTarget(arrayList.get(n2));
            }
        }
    }

    @Override
    public void a(Object object, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if ((object = (TransitionSet)object) != null) {
            object.getTargets().clear();
            object.getTargets().addAll(arrayList2);
            this.b(object, arrayList, arrayList2);
        }
    }

    @Override
    public boolean a(Object object) {
        return object instanceof Transition;
    }

    @Override
    public Object b(Object object) {
        if (object != null) {
            return ((Transition)object).clone();
        }
        return null;
    }

    @Override
    public Object b(Object object, Object object2, Object object3) {
        object = (Transition)object;
        object2 = (Transition)object2;
        object3 = (Transition)object3;
        if (object != null && object2 != null) {
            object = new TransitionSet().addTransition((Transition)object).addTransition((Transition)object2).setOrdering(1);
        } else if (object == null) {
            object = object2 != null ? object2 : null;
        }
        if (object3 != null) {
            object2 = new TransitionSet();
            if (object != null) {
                object2.addTransition((Transition)object);
            }
            object2.addTransition((Transition)object3);
            return object2;
        }
        return object;
    }

    @Override
    public void b(Object object, View view) {
        if (object != null) {
            ((Transition)object).addTarget(view);
        }
    }

    @Override
    public void b(Object object, final View view, final ArrayList<View> arrayList) {
        ((Transition)object).addListener(new Transition.TransitionListener(){

            public void onTransitionCancel(Transition transition) {
            }

            public void onTransitionEnd(Transition transition) {
                transition.removeListener((Transition.TransitionListener)this);
                view.setVisibility(8);
                int n2 = arrayList.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    ((View)arrayList.get(i2)).setVisibility(0);
                }
            }

            public void onTransitionPause(Transition transition) {
            }

            public void onTransitionResume(Transition transition) {
            }

            public void onTransitionStart(Transition transition) {
            }
        });
    }

    @Override
    public void b(Object object, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        block4 : {
            int n2;
            List list;
            int n3;
            block3 : {
                object = (Transition)object;
                boolean bl2 = object instanceof TransitionSet;
                if (!bl2) break block3;
                object = (TransitionSet)object;
                n3 = object.getTransitionCount();
                for (n2 = 0; n2 < n3; ++n2) {
                    this.b((Object)object.getTransitionAt(n2), arrayList, arrayList2);
                }
                break block4;
            }
            if (r.a((Transition)object) || (list = object.getTargets()) == null || list.size() != arrayList.size() || !list.containsAll(arrayList)) break block4;
            n2 = arrayList2 == null ? 0 : arrayList2.size();
            for (n3 = 0; n3 < n2; ++n3) {
                object.addTarget(arrayList2.get(n3));
            }
            for (n2 = arrayList.size() - 1; n2 >= 0; --n2) {
                object.removeTarget(arrayList.get(n2));
            }
        }
    }

    @Override
    public Object c(Object object) {
        if (object == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition)object);
        return transitionSet;
    }

    @Override
    public void c(Object object, View view) {
        if (object != null) {
            ((Transition)object).removeTarget(view);
        }
    }

}

