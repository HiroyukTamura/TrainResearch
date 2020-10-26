//
// IFSC.aidl
//
// Copyright 2009 FeliCa Networks, Inc.
// All Rights Reserved.
// FeliCa Networks, Inc. Proprietary/Confidential.
//
package com.felicanetworks.mfc;

import com.felicanetworks.mfc.DeviceList;
import com.felicanetworks.mfc.IFSCEventListener;
import com.felicanetworks.mfc.IFelica;
import com.felicanetworks.mfc.FelicaResultInfo;

/**
 * FSC APIを実行するためのAIDLインターフェースです。
 * <p>
 */
interface IFSC {

    /**
     * FeliCaサーバとのオンライン処理を開始します。
     * <p>
     *
     * @param url FeliCaサーバのURL
     * @param deviceList <code>DeviceList</code>
     * @param fscEventListener <code>FSC</code> イベントリスナ
     * @param felica IFelicaブジェクト
     * @return 例外発生時、以下の例外情報を返します。例外種別は{@link ResultInfo#getExceptionType}で取得します。
     * <p>
     * {@link ResultInfo#EXCEPTION_TYPE_ILLEGAL_ARGUMENT} 指定されたURLが <code>null</code> の場合
     *             <p>
     * {@link ResultInfo#EXCEPTION_TYPE_FELICA} FeliCaサーバとのオンライン処理の開始が失敗した場合（詳細は下表を参照）
     *             <p>
     *             <table style="vertical-align: middle;" border="1" cellpadding="2" * cellspacing="2">
     *             <tbody>
     *             <tr>
     *             <th style="text-align: center;">種別</th> <th
     *             style="text-align: center;">タイプ</th>
     *             </tr>
     *             <tr>
     *             <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     *             <td>{@link FelicaException#TYPE_CURRENTLY_ONLINE}</td>
     *             </tr>
     *             <tr>
     *             <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     *             <td>{@link FelicaException#TYPE_FELICA_NOT_SET}</td>
     *             </tr>
     *             <tr>
     *             <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     *             <td>{@link FelicaException#TYPE_DEVICELIST_NOT_SET}</td>
     *             </tr>
     *             <tr>
     *             <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     *             <td>{@link FelicaException#TYPE_LISTENER_NOT_SET}</td>
     *             </tr>
     *             <tr>
     *             <td>{@link FelicaException#ID_ILLEGAL_STATE_ERROR}</td>
     *             <td>{@link FelicaException#TYPE_NOT_OPENED}</td>
     *             </tr>
     *             <tr>
     *             <td>{@link FelicaException#ID_UNKNOWN_ERROR}</td>
     *             <td>{@link FelicaException#TYPE_COMMUNICATION_START_FAILED}</td>
     *             </tr>
     *             </tbody>
     *             </table>
     */
    FelicaResultInfo start(String url, in DeviceList deviceList, IFSCEventListener fscEventListener, IFelica felica);

    /**
     * FeliCaサーバとのオンライン処理を中断します。
     * <p>
     * <code>FSC</code> がオンライン処理中ではない場合、何も行いません。
     * <p>
     */
    void stop();

    /**
     * デバイス操作要求の結果が正常終了だった場合に通知します。
     * <p>
     * @param result 操作処理結果
     */
    void notifyResult(in byte[] result);

    /**
     * デバイス操作要求中にExceptionが発生した場合に通知します。
     * <p>
     * @param msg エラーメッセージ
     */
    void notifyError(in String msg );

}
