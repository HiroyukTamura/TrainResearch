// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.data.repository;

import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.OnlineTrains;
import org.androidannotations.annotations.AfterInject;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainList;
import com.annimon.stream.Optional;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.TimeTable;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.StationDeparture;
import com.annimon.stream.function.Consumer;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseStation;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.Departure;
import com.google.common.collect.Lists;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.DepartureWrapper;
import java.util.ArrayList;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.RunStatusHistoryWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.RunStatusDataWrapper;
import android.support.annotation.Nullable;
import android.location.Location;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.DestinationsInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.BaseballModel;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseRoute;
import jp.seibugroup.seiburailway.seibuapp.client.remote.AppDeviceRestManager_;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.ResultTimeTableTrainWrapper;
import com.feilang.mvpproject.util.If;
import com.annimon.stream.Collector;
import com.annimon.stream.Collectors;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.Stream;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.ResultStationLine;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationInfoList;
import com.feilang.mvpproject.data.models.ResultData;
import android.support.annotation.NonNull;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationDetailInfo;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;
import com.feilang.mvpproject.data.datasource.DataNotifyEvent;
import android.text.TextUtils;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.ResultTimeTableListStation;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.ResultTimeTableTrain;
import java.util.Date;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.ResultTimeTableListStationWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.TimeTableKeyModel;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.LineStationInfoWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationInfo;
import jp.seibugroup.seiburailway.seibuapp.client.remote.AppRestManager;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TransferData;
import java.util.List;
import android.support.v4.util.LruCache;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.RootContext;
import android.content.Context;
import org.androidannotations.annotations.EBean;

@EBean(scope = EBean.Scope.Singleton)
public class StationsRepository
{
    public static final String API_STATION_ALL = "1";
    public static final String API_STATION_CHANGE_LINE = "2";
    @RootContext
    Context mContext;
    @Bean
    MasterDataRepository mMaster;
    private LruCache<String, List<TransferData>> mOtherCompanyLineCache;
    @Bean
    AppRestManager mRest;
    private LruCache<String, StationInfo> mStationCache;
    private LruCache<String, List<LineStationInfoWrapper>> mStationLineCache;
    private LruCache<TimeTableKeyModel, ResultTimeTableListStationWrapper> mStationTimeTableCache;
    private Date mTrainPositionUpdateDate;
    private LruCache<String, ResultTimeTableTrain> mTrainTimeTableCache;
    
    private static String makeTrainCacheKey(final String str, final String str2, final String str3) {
        return str + str2 + str3;
    }
    
    private void requestStationDetailInfo(final Object o, final String s) {
        this.mRest.getStationDetailInfo(s, (DataCallWrapper)new DataCallWrapper<StationDetailInfo>(o, DataNotifyEvent.ApiEventType.API_STATION_DETAIL_INFO, true, false, new Object[] { s }) {
            @NonNull
            public ResultType checkBusinessError(final StationDetailInfo stationDetailInfo) {
                if (stationDetailInfo == null || stationDetailInfo.getStation() == null) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final StationDetailInfo stationDetailInfo) {
                if (stationDetailInfo != null && stationDetailInfo.getStation() != null) {
                    StationsRepository.this.mStationCache.put(s, stationDetailInfo.getStation());
                    if (stationDetailInfo.getStation().getTransfer() != null) {
                        StationsRepository.this.mOtherCompanyLineCache.put(s, stationDetailInfo.getStation().getTransfer());
                    }
                }
                return ResultData.createNew(stationDetailInfo);
            }
        });
    }
    
    private void requestStationInfo(final Object o, final String s, final String s2) {
        this.mRest.getStationInfo(s, (DataCallWrapper)new DataCallWrapper<StationInfoList>(o, DataNotifyEvent.ApiEventType.API_STATION_INFO, true, false, new Object[] { s, s2 }) {
            @NonNull
            public ResultType checkBusinessError(final StationInfoList list) {
                if (list == null || list.getStation() == null || list.getStation().size() == 0) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final StationInfoList list) {
                StationInfo stationInfo2;
                final StationInfo stationInfo = stationInfo2 = null;
                if (list != null) {
                    stationInfo2 = stationInfo;
                    if (list.getStation() != null) {
                        stationInfo2 = stationInfo;
                        if (list.getStation().size() > 0) {
                            stationInfo2 = list.getStation().get(0);
                        }
                    }
                }
                if (stationInfo2 != null) {
                    StationsRepository.this.mStationCache.put(s, stationInfo2);
                    if (stationInfo2.getTransfer() != null) {
                        StationsRepository.this.mOtherCompanyLineCache.put(s, stationInfo2.getTransfer());
                    }
                }
                return ResultData.createNew(stationInfo2);
            }
        });
    }
    
    private void requestStationLines(final Object o, final String s) {
        this.mRest.getStationLineDirection(s, (DataCallWrapper)new DataCallWrapper<ResultStationLine>(o, DataNotifyEvent.ApiEventType.API_STATION_LINE_DIRECTION, true, false, new Object[] { s }) {
            @NonNull
            public ResultType checkBusinessError(final ResultStationLine resultStationLine) {
                if (resultStationLine == null || resultStationLine.getLines() == null || resultStationLine.getLines().size() == 0) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final ResultStationLine resultStationLine) {
                If.of(resultStationLine.getLines()).present(StationsRepository$23$$Lambda$1.lambdaFactory$(this, s));
                return ResultData.createNew(resultStationLine);
            }
        });
    }
    
    private void requestStationTimeTable(final Object o, final String s, final String s2, final String s3, final String s4) {
        this.mRest.getTimeTableById(s, s3, s4, (DataCallWrapper)new DataCallWrapper<ResultTimeTableListStationWrapper>(o, DataNotifyEvent.ApiEventType.API_STATION_TIME_TABLE, true, false, new Object[] { s, s3, s2 }) {
            @NonNull
            public ResultType checkBusinessError(final ResultTimeTableListStationWrapper resultTimeTableListStationWrapper) {
                if (resultTimeTableListStationWrapper == null) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final ResultTimeTableListStationWrapper resultTimeTableListStationWrapper) {
                StationsRepository.this.mStationTimeTableCache.put(new TimeTableKeyModel(s4, s, s3), resultTimeTableListStationWrapper);
                return ResultData.createNew(resultTimeTableListStationWrapper);
            }
        });
    }
    
    private void requestTrainTimeTable(final Object o, final String s, final String s2, final String s3, final String s4, final String s5, final String s6) {
        this.mRest.getTimeTableTrain(s, s2, s4, s3, s6, (DataCallWrapper)new DataCallWrapper<ResultTimeTableTrainWrapper>(o, DataNotifyEvent.ApiEventType.API_TRAIN_TIME_TABLE, true, false, new Object[] { s, s4, s5 }) {
            @NonNull
            public ResultType checkBusinessError(final ResultTimeTableTrainWrapper resultTimeTableTrainWrapper) {
                if (resultTimeTableTrainWrapper == null) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final ResultTimeTableTrainWrapper resultTimeTableTrainWrapper) {
                StationsRepository.this.mTrainTimeTableCache.put(makeTrainCacheKey(s, s4, s5), resultTimeTableTrainWrapper.getTrainTimetable());
                return ResultData.createNew(resultTimeTableTrainWrapper);
            }
        });
    }
    
    public void clearCache() {
        this.init();
        this.mRest.setLanguageHeader();
        AppDeviceRestManager_.getInstance_(this.mContext).setLanguageHeader();
    }
    
    public void clearTimeTableCache() {
        this.mStationTimeTableCache = new LruCache<TimeTableKeyModel, ResultTimeTableListStationWrapper>(1) {
            @Override
            protected int sizeOf(final TimeTableKeyModel timeTableKeyModel, final ResultTimeTableListStationWrapper resultTimeTableListStationWrapper) {
                return 1;
            }
        };
    }
    
    public BaseRoute getBaseRoute(final String s) {
        return this.mMaster.getRoute(s);
    }
    
    public BaseRoute getBaseRouteById(final String s) {
        return this.mMaster.getRouteById(s);
    }
    
    public void getBaseballGames(final Object o) {
        this.mRest.getBaseballGames((DataCallWrapper)new DataCallWrapper<List<BaseballModel>>(o, DataNotifyEvent.ApiEventType.API_BASEBALL_GAMES, false, true) {
            @NonNull
            @Override
            public ResultData handleData(final List<BaseballModel> list) {
                return ResultData.createNew("success", list);
            }
        });
    }
    
    public void getDestinationsInfo(final Object o, final String s, final String s2, final String s3, final boolean b) {
        this.mRest.getDestinations(s, s2, s3, (DataCallWrapper)new DataCallWrapper<DestinationsInfo>(o, DataNotifyEvent.ApiEventType.API_DESTINATIONSINfO, b, false) {
            @NonNull
            public ResultType checkBusinessError(final DestinationsInfo destinationsInfo) {
                if (destinationsInfo == null) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final DestinationsInfo destinationsInfo) {
                if (destinationsInfo != null) {
                    return ResultData.createNew(destinationsInfo);
                }
                return ResultData.createNew(null);
            }
        });
    }
    
    public void getNearbyStations(final Object o, final Location location) {
        this.mRest.getNearbyStations(Double.toString(location.getLatitude()), Double.toString(location.getLongitude()), (DataCallWrapper)new DataCallWrapper<StationInfoList>(o, DataNotifyEvent.ApiEventType.API_STATION_NEARBY) {
            @NonNull
            @Override
            public ResultData handleData(final StationInfoList list) {
                return ResultData.createNew("stations_nearby succeed", list);
            }
        });
    }
    
    public void getOtherCompanyLineInfo(final Object o, final String s) {
        this.requestStationInfo(o, s, "2");
    }
    
    @Nullable
    public String getRouteId(final String s) {
        final BaseRoute baseRoute = this.getBaseRoute(s);
        if (baseRoute == null) {
            return null;
        }
        return baseRoute.getId();
    }
    
    public void getRunStatusData(final Object o) {
        this.getRunStatusData(o, true, false, false);
    }
    
    public void getRunStatusData(final Object o, final Boolean b, final boolean b2, final boolean b3) {
        this.mRest.getRunStatus((DataCallWrapper)new DataCallWrapper<RunStatusDataWrapper>(o, DataNotifyEvent.ApiEventType.API_RUN_STATUS_MESSAGE, (boolean)b, false, new Object[] { b2, b3 }) {
            @NonNull
            public ResultType checkBusinessError(final RunStatusDataWrapper runStatusDataWrapper) {
                if (runStatusDataWrapper == null) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final RunStatusDataWrapper runStatusDataWrapper) {
                return ResultData.createNew(runStatusDataWrapper);
            }
        });
    }
    
    public void getRunStatusHistory(final Object o, final String s) {
        this.mRest.getRunStatusHistroy(s, (DataCallWrapper)new DataCallWrapper<RunStatusHistoryWrapper>(o, DataNotifyEvent.ApiEventType.API_RUN_STATUS_HISTORY, true, false) {
            @NonNull
            public ResultType checkBusinessError(final RunStatusHistoryWrapper runStatusHistoryWrapper) {
                if (runStatusHistoryWrapper == null) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final RunStatusHistoryWrapper runStatusHistoryWrapper) {
                return ResultData.createNew(runStatusHistoryWrapper);
            }
        });
    }
    
    public void getStationDepartures(final Object o, final String s) {
        final ArrayList<String> list = new ArrayList<String>();
        list.add(s);
        this.mRest.getStationDepartures((List)list, (DataCallWrapper)new DataCallWrapper<DepartureWrapper>(o, DataNotifyEvent.ApiEventType.API_STATION_DEPARTURES, true, false) {
            @NonNull
            public ResultType checkBusinessError(final DepartureWrapper departureWrapper) {
                if (departureWrapper == null || departureWrapper.getDepartures() == null || departureWrapper.getDepartures().size() == 0) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final DepartureWrapper departureWrapper) {
                if (departureWrapper == null || departureWrapper.getDepartures() == null) {
                    return ResultData.createNew(Lists.newArrayList());
                }
                return ResultData.createNew(departureWrapper.getDepartures());
            }
        });
    }
    
    public void getStationDepartures(final Object o, final List<String> list, final boolean b) {
        this.mRest.getStationDepartures((List)list, (DataCallWrapper)new DataCallWrapper<DepartureWrapper>(o, DataNotifyEvent.ApiEventType.API_STATION_DEPARTURES, b, false) {
            @NonNull
            public ResultType checkBusinessError(final DepartureWrapper departureWrapper) {
                if (departureWrapper == null || departureWrapper.getDepartures() == null || departureWrapper.getDepartures().size() == 0) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final DepartureWrapper departureWrapper) {
                final ArrayList list = new ArrayList();
                if (departureWrapper == null || departureWrapper.getDepartures() == null) {
                    return ResultData.createNew(list);
                }
                final List<Departure> departures = departureWrapper.getDepartures();
                Stream.of((Iterable<?>)departures).forEach(StationsRepository$12$$Lambda$1.lambdaFactory$(this));
                return ResultData.createNew("success", departures);
            }
        });
    }
    
    public void getStationDeparturesForHome(final Object o, final String s, final boolean b) {
        final ArrayList<String> list = new ArrayList<String>();
        list.add(s);
        this.mRest.getStationDetailInfos((List)list, (DataCallWrapper)new DataCallWrapper<List<StationDeparture>>(o, DataNotifyEvent.ApiEventType.API_STATION_DEPARTURES_MY, b, false, new Object[] { o.hashCode() }) {
            @NonNull
            public ResultType checkBusinessError(final List<StationDeparture> list) {
                if (list == null || list.size() == 0) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final List<StationDeparture> list) {
                return ResultData.createNew(list);
            }
        });
    }
    
    public void getStationDeparturesForHome(final Object o, final List<String> list, final boolean b) {
        this.mRest.getStationDetailInfos((List)list, (DataCallWrapper)new DataCallWrapper<List<StationDeparture>>(o, DataNotifyEvent.ApiEventType.API_STATION_DEPARTURES_HOME, b, false, new Object[] { o.hashCode() }) {
            @NonNull
            public ResultType checkBusinessError(final List<StationDeparture> list) {
                if (list == null || list.size() == 0) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final List<StationDeparture> list) {
                return ResultData.createNew(list);
            }
        });
    }
    
    public void getStationDeparturesForHome(final Object o, final List<String> list, final boolean b, final boolean b2) {
        this.mRest.getStationDetailInfos((List)list, (DataCallWrapper)new DataCallWrapper<List<StationDeparture>>(o, DataNotifyEvent.ApiEventType.API_STATION_DEPARTURES_HOME, b, false, new Object[] { o.hashCode(), b2 }) {
            @NonNull
            public ResultType checkBusinessError(final List<StationDeparture> list) {
                if (list == null || list.size() == 0) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final List<StationDeparture> list) {
                return ResultData.createNew(list);
            }
        });
    }
    
    public StationInfo getStationDetailInfo(final Object o, final String s) {
        final StationInfo stationInfo = this.mStationCache.get(s);
        this.requestStationDetailInfo(o, s);
        return stationInfo;
    }
    
    public StationInfo getStationInfo(final Object o, final String s) {
        final StationInfo stationInfo = this.mStationCache.get(s);
        if (stationInfo == null) {
            this.requestStationDetailInfo(o, s);
        }
        return stationInfo;
    }
    
    @Nullable
    public List<LineStationInfoWrapper> getStationLines(final Object o, final String s) {
        final List<LineStationInfoWrapper> list = this.mStationLineCache.get(s);
        if (list == null) {
            this.requestStationLines(o, s);
        }
        return list;
    }
    
    @Nullable
    public ResultTimeTableListStationWrapper getStationTimeTable(final Object o, final String s, final String s2, final String s3, final String s4) {
        final ResultTimeTableListStationWrapper resultTimeTableListStationWrapper = this.mStationTimeTableCache.get(new TimeTableKeyModel(s4, s, s3));
        if (resultTimeTableListStationWrapper == null) {
            this.requestStationTimeTable(o, s, s2, s3, s4);
        }
        return resultTimeTableListStationWrapper;
    }
    
    @Nullable
    public TimeTable getStationTimeTableNormal(final Object o, final String s, final String s2, final String s3, final String s4, final String s5) {
        final ResultTimeTableListStationWrapper resultTimeTableListStationWrapper = this.mStationTimeTableCache.get(new TimeTableKeyModel(s4, s, s3));
        if (resultTimeTableListStationWrapper == null) {
            this.requestStationTimeTable(o, s, s2, s3, s4);
        }
        else {
            final Optional<ResultTimeTableListStation> first = Stream.of((Iterable<? extends ResultTimeTableListStation>)resultTimeTableListStationWrapper.getTimetableList()).filter(StationsRepository$$Lambda$1.lambdaFactory$(s5, s3, s4)).findFirst();
            if (first.isPresent()) {
                return first.get().getMeta();
            }
        }
        return null;
    }
    
    public Date getTrainPositionUpdateDate() {
        return this.mTrainPositionUpdateDate;
    }
    
    public ResultTimeTableTrain getTrainTimeTable(final Object o, final String s, final String s2, final String s3, final int n, final String s4, final String s5) {
        ResultTimeTableTrain resultTimeTableTrain;
        if ((resultTimeTableTrain = this.mTrainTimeTableCache.get(makeTrainCacheKey(s, String.valueOf(n), s4))) == null) {
            this.requestTrainTimeTable(o, s, s2, s3, String.valueOf(n), s4, s5);
            resultTimeTableTrain = null;
        }
        return resultTimeTableTrain;
    }
    
    public void getTrainWrappingMessage(final Object o) {
        this.mRest.getTrainWrappingMessage((DataCallWrapper)new DataCallWrapper<TrainList>(o, DataNotifyEvent.ApiEventType.API_TRAIN_WRAPPING_MESSAGE) {
            @NonNull
            public ResultType checkBusinessError(final TrainList list) {
                if (list == null || list.getCar() == null || list.getCar().size() == 0) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final TrainList list) {
                return ResultData.createNew("message_data succeed", list);
            }
        });
    }
    
    @AfterInject
    void init() {
        this.mStationLineCache = new LruCache<String, List<LineStationInfoWrapper>>(100) {
            @Override
            protected int sizeOf(final String s, final List<LineStationInfoWrapper> list) {
                return list.size();
            }
        };
        this.mStationTimeTableCache = new LruCache<TimeTableKeyModel, ResultTimeTableListStationWrapper>(32) {
            @Override
            protected int sizeOf(final TimeTableKeyModel timeTableKeyModel, final ResultTimeTableListStationWrapper resultTimeTableListStationWrapper) {
                return 1;
            }
        };
        this.mTrainTimeTableCache = new LruCache<String, ResultTimeTableTrain>(16) {
            @Override
            protected int sizeOf(final String s, final ResultTimeTableTrain resultTimeTableTrain) {
                return 1;
            }
        };
        this.mStationCache = new LruCache<String, StationInfo>(32) {
            @Override
            protected int sizeOf(final String s, final StationInfo stationInfo) {
                return 1;
            }
        };
        this.mOtherCompanyLineCache = new LruCache<String, List<TransferData>>(64) {
            @Override
            protected int sizeOf(final String s, final List<TransferData> list) {
                return 1;
            }
        };
    }
    
    public void requestAllTrains(final Object o, final String s) {
        this.requestAllTrains(o, s, true);
    }
    
    public void requestAllTrains(final Object o, final String s, final boolean b) {
        this.mRest.getOnlineTrains(s, (DataCallWrapper)new DataCallWrapper<OnlineTrains>(o, DataNotifyEvent.ApiEventType.API_TRAIN_LIST, b, false, new Object[] { s, o.hashCode() }) {
            @NonNull
            @Override
            public ResultData handleData(final OnlineTrains onlineTrains) {
                Object o;
                if (onlineTrains == null) {
                    o = Lists.newArrayList();
                }
                else if (onlineTrains.getTrains() != null && onlineTrains.getTotal() < onlineTrains.getTrains().size()) {
                    o = Stream.of((Iterable<?>)onlineTrains.getTrains()).limit(onlineTrains.getTotal()).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList());
                }
                else {
                    o = onlineTrains.getTrains();
                }
                StationsRepository.this.mTrainPositionUpdateDate = new Date();
                return ResultData.createNew(o);
            }
        });
    }
    
    public void requestStationDepartures(final Object o, final String s) {
        this.mRest.getStationDepartures(s, (DataCallWrapper)new DataCallWrapper<StationDetailInfo>(o, DataNotifyEvent.ApiEventType.API_STATION_DETAIL_INFO, true, false, new Object[] { s }) {
            @NonNull
            public ResultType checkBusinessError(final StationDetailInfo stationDetailInfo) {
                if (stationDetailInfo == null || stationDetailInfo.getDepartures() == null || stationDetailInfo.getDepartures().size() == 0) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final StationDetailInfo stationDetailInfo) {
                if (stationDetailInfo != null) {
                    stationDetailInfo.setStation(StationsRepository.this.mStationCache.get(s));
                    if (stationDetailInfo.getDepartures() != null) {
                        Stream.of((Iterable<?>)stationDetailInfo.getDepartures()).forEach(StationsRepository$14$$Lambda$1.lambdaFactory$(this));
                    }
                }
                return ResultData.createNew(stationDetailInfo);
            }
        });
    }
    
    public void requestTrainsById(final Object o, final String s, final List<String> list) {
        this.requestTrainsById(o, s, list, false, true, false);
    }
    
    public void requestTrainsById(final Object o, final String s, final List<String> list, final boolean b, final boolean b2, final boolean b3) {
        this.mRest.getOnlineTrains(s, (List)list, (DataCallWrapper)new DataCallWrapper<OnlineTrains>(o, DataNotifyEvent.ApiEventType.API_TRAIN_INFO, b2, b3, new Object[] { s, list, o.hashCode(), b, b3 }) {
            @NonNull
            public ResultType checkBusinessError(final OnlineTrains onlineTrains) {
                if (onlineTrains == null || onlineTrains.getTrains() == null || onlineTrains.getTrains().size() == 0) {
                    return ResultType.NO_RESULT;
                }
                return ResultType.UN_KNOW;
            }
            
            @NonNull
            @Override
            public ResultData handleData(final OnlineTrains onlineTrains) {
                if (onlineTrains == null || onlineTrains.getTrains() == null) {
                    return ResultData.createNew(Lists.newArrayList());
                }
                return ResultData.createNew(onlineTrains.getTrains());
            }
        });
    }
}
