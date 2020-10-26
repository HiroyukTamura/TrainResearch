// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.util;

import android.content.DialogInterface;
import com.feilang.mvpproject.exception.ParameterCountMismatchException;
import com.feilang.mvpproject.base.annotations.OnApiSuccess;
import com.feilang.mvpproject.remote.errorhandler.AppNoResultErrorEvent;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import com.feilang.mvpproject.exception.DuplicatedApiDataHandleMethodException;
import java.lang.annotation.Annotation;
import com.feilang.mvpproject.base.annotations.OnApiFailed;
import com.feilang.mvpproject.data.models.ErrorData;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;

public class ApiEventDispatchUtils
{
    private static void dispatchFailedEvent(final Object obj, final DataNotifyEvent.ApiEventType apiEventType, final ErrorData errorData) {
        if (obj == null || apiEventType == null) {
            LogUtils.v("dispatchFailedEvent(2) : can not dispatch failedEvent because parameter error.");
        }
        else {
            Method method = null;
            final Method[] declaredMethods = obj.getClass().getDeclaredMethods();
            Method method3;
            for (int length = declaredMethods.length, i = 0; i < length; ++i, method = method3) {
                final Method method2 = declaredMethods[i];
                if (!method2.isAnnotationPresent(OnApiFailed.class)) {
                    method3 = method;
                }
                else {
                    method3 = method;
                    if (method2.getAnnotation(OnApiFailed.class).value() == apiEventType) {
                        if (method != null) {
                            throw new RuntimeException(new DuplicatedApiDataHandleMethodException(apiEventType, obj.getClass().getName()));
                        }
                        method3 = method2;
                    }
                }
            }
            if (method != null) {
                try {
                    method.setAccessible(true);
                    if (method.getParameterTypes().length == 0) {
                        method.invoke(obj, new Object[0]);
                        return;
                    }
                    goto Label_0194;
                }
                catch (IllegalAccessException ex) {}
                catch (InvocationTargetException obj) {
                    goto Label_0161;
                }
            }
        }
    }
    
    public static void dispatchFailedEvent(final Object o, final DataNotifyEvent dataNotifyEvent) {
        if (o == null || dataNotifyEvent == null) {
            LogUtils.v("dispatchFailedEvent(1) : can not dispatch failedEvent because parameter error.");
            return;
        }
        dispatchFailedEvent(o, dataNotifyEvent.getType(), dataNotifyEvent.getErrorData());
    }
    
    public static void dispatchNoResultEvent(final Object o, final DataNotifyEvent.ApiEventType apiEventType) {
        if (o == null || apiEventType == null) {
            LogUtils.v("dispatchNoResultEvent : can not dispatch noResultEvent because parameter error.");
            return;
        }
        AppEventBus.getInstance().post(new AppNoResultErrorEvent(ApiEventDispatchUtils$$Lambda$1.lambdaFactory$(o, new DataNotifyEvent(o, apiEventType, new ErrorData("", "")))));
    }
    
    public static void dispatchSuccessEvent(final Object obj, final DataNotifyEvent dataNotifyEvent) {
        final int n = 0;
        if (obj == null || dataNotifyEvent == null) {
            LogUtils.v("dispatchSuccessEvent : can not dispatch successEvent because parameter error.");
            return;
        }
        Method method = null;
        final Method[] declaredMethods = obj.getClass().getDeclaredMethods();
        Method method3;
        for (int length = declaredMethods.length, i = 0; i < length; ++i, method = method3) {
            final Method method2 = declaredMethods[i];
            if (!method2.isAnnotationPresent(OnApiSuccess.class)) {
                method3 = method;
            }
            else {
                method3 = method;
                if (method2.getAnnotation(OnApiSuccess.class).value() == dataNotifyEvent.getType()) {
                    if (method != null) {
                        throw new RuntimeException(new DuplicatedApiDataHandleMethodException(dataNotifyEvent.getType(), obj.getClass().getName()));
                    }
                    method3 = method2;
                }
            }
        }
        if (method == null) {
            LogUtils.v("No handle method for API type " + dataNotifyEvent.getType() + " in class " + obj.getClass().getName());
            return;
        }
        int n2;
        if (dataNotifyEvent.getApiParams() == null) {
            n2 = n;
        }
        else {
            n2 = 1;
        }
        if (method.getParameterTypes().length - n2 != dataNotifyEvent.getData().length) {
            throw new IllegalArgumentException(new ParameterCountMismatchException(obj.getClass().getName() + " : " + method.getName(), method.getParameterTypes().length - n2, dataNotifyEvent.getData().length));
        }
        try {
            if (dataNotifyEvent.getApiParams() != null) {
                final Object[] array = new Object[dataNotifyEvent.getData().length + 1];
                array[0] = dataNotifyEvent.getApiParams();
                System.arraycopy(dataNotifyEvent.getData(), 0, array, 1, dataNotifyEvent.getData().length);
                final Object[] args = array;
                method.setAccessible(true);
                method.invoke(obj, args);
                return;
            }
            goto Label_0368;
        }
        catch (IllegalAccessException ex) {}
        catch (InvocationTargetException obj) {
            goto Label_0335;
        }
    }
}
