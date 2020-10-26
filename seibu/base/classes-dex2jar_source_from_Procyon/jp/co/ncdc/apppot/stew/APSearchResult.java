// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

import java.util.Collection;
import java.util.ArrayList;
import jp.co.ncdc.apppot.stew.dto.APObject;
import java.util.List;

public class APSearchResult
{
    public int counter;
    private List<APObject> mSearchList;
    public int pageIndex;
    public int totalPage;
    
    protected APSearchResult() {
        this.mSearchList = null;
        this.mSearchList = new ArrayList<APObject>();
    }
    
    protected void add(final APObject apObject) {
        this.mSearchList.add(apObject);
    }
    
    public List<APObject> getSearchResuls() {
        return this.mSearchList;
    }
    
    protected void setSearchResuls(final List<APObject> list) {
        this.mSearchList.addAll(list);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("counter=" + this.counter);
        sb.append(", ");
        sb.append("totalPage=" + this.totalPage);
        sb.append(", ");
        sb.append("pageIndex=" + this.pageIndex);
        return sb.toString();
    }
}
