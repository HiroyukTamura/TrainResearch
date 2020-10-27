package p043jp.reifrontier.gym.p044ui.widget.autocompleted;

import android.content.Context;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\"\u0010\u0016\u001a\u00020\u00152\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0002X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/widget/autocompleted/RFGAutoCompletedAdapter;", "Landroid/widget/ArrayAdapter;", "", "context", "Landroid/content/Context;", "resource", "", "(Landroid/content/Context;I)V", "alwaysShowList", "", "filterText", "hintList", "Ljp/reifrontier/gym/ui/widget/autocompleted/RFGAutoCompletedAdapter$RFGHintData;", "getAllDisplayHintData", "", "getHintData", "position", "isAlwaysShow", "", "value", "refreshListData", "", "setListData", "updateFilterText", "filter", "RFGHintData", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.ui.widget.autocompleted.RFGAutoCompletedAdapter */
public final class RFGAutoCompletedAdapter extends ArrayAdapter<String> {
    private final List<String> alwaysShowList = new ArrayList();
    private String filterText = "";
    private final List<RFGHintData> hintList = new ArrayList();

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo21739d2 = {"Ljp/reifrontier/gym/ui/widget/autocompleted/RFGAutoCompletedAdapter$RFGHintData;", "", "displayValue", "", "searchWord", "", "(Ljava/lang/String;Ljava/util/List;)V", "getDisplayValue", "()Ljava/lang/String;", "getSearchWord", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.ui.widget.autocompleted.RFGAutoCompletedAdapter$RFGHintData */
    public static final class RFGHintData {
        private final String displayValue;
        private final List<String> searchWord;

        public RFGHintData(String str, List<String> list) {
            Intrinsics.checkParameterIsNotNull(str, "displayValue");
            Intrinsics.checkParameterIsNotNull(list, "searchWord");
            this.displayValue = str;
            this.searchWord = list;
        }

        public static /* synthetic */ RFGHintData copy$default(RFGHintData rFGHintData, String str, List<String> list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = rFGHintData.displayValue;
            }
            if ((i & 2) != 0) {
                list = rFGHintData.searchWord;
            }
            return rFGHintData.copy(str, list);
        }

        public final String component1() {
            return this.displayValue;
        }

        public final List<String> component2() {
            return this.searchWord;
        }

        public final RFGHintData copy(String str, List<String> list) {
            Intrinsics.checkParameterIsNotNull(str, "displayValue");
            Intrinsics.checkParameterIsNotNull(list, "searchWord");
            return new RFGHintData(str, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RFGHintData)) {
                return false;
            }
            RFGHintData rFGHintData = (RFGHintData) obj;
            return Intrinsics.areEqual((Object) this.displayValue, (Object) rFGHintData.displayValue) && Intrinsics.areEqual((Object) this.searchWord, (Object) rFGHintData.searchWord);
        }

        public final String getDisplayValue() {
            return this.displayValue;
        }

        public final List<String> getSearchWord() {
            return this.searchWord;
        }

        public int hashCode() {
            String str = this.displayValue;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<String> list = this.searchWord;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("RFGHintData(displayValue=");
            a.append(this.displayValue);
            a.append(", searchWord=");
            return C0681a.m325a(a, (List) this.searchWord, ")");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFGAutoCompletedAdapter(Context context, int i) {
        super(context, i, new ArrayList());
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    private final void refreshListData() {
        ArrayList arrayList = new ArrayList();
        if (this.filterText.length() > 0) {
            for (RFGHintData rFGHintData : this.hintList) {
                Iterator<T> it = rFGHintData.getSearchWord().iterator();
                while (true) {
                    if (it.hasNext()) {
                        String str = (String) it.next();
                        Locale locale = Locale.ENGLISH;
                        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.ENGLISH");
                        if (str != null) {
                            String lowerCase = str.toLowerCase(locale);
                            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                            String str2 = this.filterText;
                            Locale locale2 = Locale.ENGLISH;
                            Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.ENGLISH");
                            if (str2 != null) {
                                String lowerCase2 = str2.toLowerCase(locale2);
                                Intrinsics.checkExpressionValueIsNotNull(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                                    arrayList.add(rFGHintData.getDisplayValue());
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                }
            }
        }
        arrayList.addAll(this.alwaysShowList);
        clear();
        addAll(arrayList);
        notifyDataSetChanged();
    }

    public final List<RFGHintData> getAllDisplayHintData() {
        ArrayList arrayList = new ArrayList();
        int count = getCount();
        for (int i = 0; i < count; i++) {
            RFGHintData hintData = getHintData(i);
            if (hintData != null && !isAlwaysShow(hintData.getDisplayValue())) {
                arrayList.add(hintData);
            }
        }
        return arrayList;
    }

    public final RFGHintData getHintData(int i) {
        String str = (String) getItem(i);
        T t = null;
        if (str == null) {
            return null;
        }
        Intrinsics.checkExpressionValueIsNotNull(str, "getItem(position) ?: return null");
        Iterator<T> it = this.hintList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (Intrinsics.areEqual((Object) ((RFGHintData) next).getDisplayValue(), (Object) str)) {
                t = next;
                break;
            }
        }
        return (RFGHintData) t;
    }

    public final boolean isAlwaysShow(String str) {
        T t;
        Intrinsics.checkParameterIsNotNull(str, "value");
        Iterator<T> it = this.alwaysShowList.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual((Object) (String) t, (Object) str)) {
                break;
            }
        }
        return t != null;
    }

    public final void setListData(List<RFGHintData> list, List<String> list2) {
        Intrinsics.checkParameterIsNotNull(list, "hintList");
        Intrinsics.checkParameterIsNotNull(list2, "alwaysShowList");
        this.hintList.clear();
        this.hintList.addAll(list);
        this.alwaysShowList.clear();
        this.alwaysShowList.addAll(list2);
        refreshListData();
    }

    public final void updateFilterText(String str) {
        Intrinsics.checkParameterIsNotNull(str, "filter");
        this.filterText = str;
        refreshListData();
    }
}
