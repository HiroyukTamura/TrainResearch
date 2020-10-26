// 
// Decompiled by Procyon v0.5.36
// 

package android.support.v4.app;

import java.util.ArrayList;
import android.util.SparseArray;
import java.util.Collections;
import java.util.List;
import java.lang.reflect.Field;

public class FragmentationHack
{
    private static boolean sSupportLessThan25dot4;
    
    static {
        int i = 0;
        FragmentationHack.sSupportLessThan25dot4 = false;
        for (Field[] declaredFields = FragmentManagerImpl.class.getDeclaredFields(); i < declaredFields.length; ++i) {
            if (declaredFields[i].getName().equals("mAvailIndices")) {
                FragmentationHack.sSupportLessThan25dot4 = true;
                break;
            }
        }
    }
    
    public static List<Fragment> getActiveFragments(final FragmentManager fragmentManager) {
        if (!(fragmentManager instanceof FragmentManagerImpl)) {
            return (List<Fragment>)Collections.EMPTY_LIST;
        }
        if (FragmentationHack.sSupportLessThan25dot4) {
            return fragmentManager.getFragments();
        }
        try {
            return getActiveList((SparseArray<Fragment>)((FragmentManagerImpl)fragmentManager).mActive);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return fragmentManager.getFragments();
        }
    }
    
    private static List<Fragment> getActiveList(final SparseArray<Fragment> sparseArray) {
        List empty_LIST;
        if (sparseArray == null) {
            empty_LIST = Collections.EMPTY_LIST;
        }
        else {
            final int size = sparseArray.size();
            final ArrayList list = new ArrayList<Fragment>(size);
            int n = 0;
            while (true) {
                empty_LIST = list;
                if (n >= size) {
                    break;
                }
                list.add((Fragment)sparseArray.valueAt(n));
                ++n;
            }
        }
        return (List<Fragment>)empty_LIST;
    }
    
    private static Object getValue(Object value, final String name) throws Exception {
        final Class<?> class1 = value.getClass();
        try {
            final Field declaredField = class1.getDeclaredField(name);
            declaredField.setAccessible(true);
            value = declaredField.get(value);
            return value;
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public static boolean isExecutingActions(final FragmentManager fragmentManager) {
        if (!(fragmentManager instanceof FragmentManagerImpl)) {
            return false;
        }
        try {
            return ((FragmentManagerImpl)fragmentManager).mExecutingActions;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static boolean isStateSaved(final FragmentManager fragmentManager) {
        if (!(fragmentManager instanceof FragmentManagerImpl)) {
            return false;
        }
        try {
            return ((FragmentManagerImpl)fragmentManager).mStateSaved;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static void reorderIndices(final FragmentManager fragmentManager) {
        if (FragmentationHack.sSupportLessThan25dot4 && fragmentManager instanceof FragmentManagerImpl) {
            try {
                final Object value = getValue(fragmentManager, "mAvailIndices");
                if (value != null) {
                    final ArrayList<Object> list = (ArrayList<Object>)value;
                    if (list.size() > 1) {
                        Collections.sort(list, Collections.reverseOrder());
                    }
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
