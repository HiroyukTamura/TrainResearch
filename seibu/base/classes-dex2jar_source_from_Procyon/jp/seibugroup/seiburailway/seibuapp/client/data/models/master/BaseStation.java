// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.models.master;

import jp.seibugroup.seiburailway.seibuapp.client.util.ChangeRomajiNameUtils;
import jp.seibugroup.seiburailway.seibuapp.client.util.FirstKanaLetterFromRomaji;
import org.greenrobot.greendao.DaoException;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.gen.BaseStationDao;
import com.google.gson.annotations.SerializedName;
import jp.seibugroup.seiburailway.seibuapp.client.data.db.gen.DaoSession;
import java.util.List;
import java.io.Serializable;
import me.yokeyword.indexablerv.IndexableEntity;

public class BaseStation implements IndexableEntity, Serializable
{
    static final long serialVersionUID = 234135753481L;
    private List<BaseStationLine> baseStationLine;
    private transient DaoSession daoSession;
    @SerializedName("stationNameHira")
    private String hiraganaName;
    @SerializedName("stationId")
    private String id;
    private boolean inService;
    private boolean isTransfer;
    @SerializedName("stationNameKanji")
    private String kanjiName;
    @SerializedName("stationNameKata")
    private String kataganaName;
    private transient BaseStationDao myDao;
    private boolean onSeibuLine;
    @SerializedName("stationNameRoma")
    private String romajiName;
    
    public BaseStation() {
    }
    
    public BaseStation(final String id, final String kanjiName, final String hiraganaName, final String kataganaName, final String romajiName, final boolean onSeibuLine, final boolean inService, final boolean isTransfer) {
        this.id = id;
        this.kanjiName = kanjiName;
        this.hiraganaName = hiraganaName;
        this.kataganaName = kataganaName;
        this.romajiName = romajiName;
        this.onSeibuLine = onSeibuLine;
        this.inService = inService;
        this.isTransfer = isTransfer;
    }
    
    public void __setDaoSession(final DaoSession daoSession) {
        this.daoSession = daoSession;
        BaseStationDao baseStationDao;
        if (daoSession != null) {
            baseStationDao = daoSession.getBaseStationDao();
        }
        else {
            baseStationDao = null;
        }
        this.myDao = baseStationDao;
    }
    
    public void delete() {
        if (this.myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        this.myDao.delete((Object)this);
    }
    
    public List<BaseStationLine> getBaseStationLine() {
        Label_0054: {
            if (this.baseStationLine != null) {
                break Label_0054;
            }
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            final List<BaseStationLine> queryBaseStation_BaseStationLine = daoSession.getBaseStationLineDao()._queryBaseStation_BaseStationLine(this.id);
            synchronized (this) {
                if (this.baseStationLine == null) {
                    this.baseStationLine = queryBaseStation_BaseStationLine;
                }
                // monitorexit(this)
                return this.baseStationLine;
            }
        }
    }
    
    public String getFieldIndexBy() {
        return FirstKanaLetterFromRomaji.getFirstKanaLetter(this.romajiName);
    }
    
    public String getHiraganaName() {
        return this.hiraganaName;
    }
    
    public String getId() {
        return this.id;
    }
    
    public boolean getInService() {
        return this.inService;
    }
    
    public boolean getIsTransfer() {
        return this.isTransfer;
    }
    
    public String getKanjiName() {
        return this.kanjiName;
    }
    
    public String getKataganaName() {
        return this.kataganaName;
    }
    
    public boolean getOnSeibuLine() {
        return this.onSeibuLine;
    }
    
    public String getRomajiName() {
        return this.romajiName;
    }
    
    public String getRomajiNameAfterChange() {
        return ChangeRomajiNameUtils.changeRomajiName(this.romajiName);
    }
    
    public boolean isTransfer() {
        return this.isTransfer;
    }
    
    public void refresh() {
        if (this.myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        this.myDao.refresh((Object)this);
    }
    
    public void resetBaseStationLine() {
        synchronized (this) {
            this.baseStationLine = null;
        }
    }
    
    public void setBaseStationLine(final List<BaseStationLine> baseStationLine) {
        this.baseStationLine = baseStationLine;
    }
    
    public void setFieldIndexBy(final String s) {
    }
    
    public void setFieldPinyinIndexBy(final String s) {
    }
    
    public void setHiraganaName(final String hiraganaName) {
        this.hiraganaName = hiraganaName;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public void setInService(final boolean inService) {
        this.inService = inService;
    }
    
    public void setIsTransfer(final boolean isTransfer) {
        this.isTransfer = isTransfer;
    }
    
    public void setKanjiName(final String kanjiName) {
        this.kanjiName = kanjiName;
    }
    
    public void setKataganaName(final String kataganaName) {
        this.kataganaName = kataganaName;
    }
    
    public void setOnSeibuLine(final boolean onSeibuLine) {
        this.onSeibuLine = onSeibuLine;
    }
    
    public void setRomajiName(final String romajiName) {
        this.romajiName = romajiName;
    }
    
    public void setTransfer(final boolean isTransfer) {
        this.isTransfer = isTransfer;
    }
    
    public void update() {
        if (this.myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        this.myDao.update((Object)this);
    }
}
