//
// IFelicaEventListener.aidl
//
// Copyright 2009 FeliCa Networks, Inc.
// All Rights Reserved.
// FeliCa Networks, Inc. Proprietary/Confidential.
//
package com.felicanetworks.mfc;

import com.felicanetworks.mfc.AppInfo;

/**
 * FeliCaチップ利用開始処理に関するイベントのAIDL用リスナインタフェースです。
 * <p>
 */
oneway interface IFelicaEventListener {
    /**
     * FeliCaチップ利用開始処理が正常終了した場合に呼び出されます。<br>
     * 詳細は以下を参照<br>
     * @see com.felicanetworks.mfc.FelicaEventListener#finished(()
     */
    void finished();

    /**
     * FeliCaチップ利用開始処理でエラーが発生した場合に呼び出されます。
     * 詳細は以下を参照<br>
     * @see com.felicanetworks.mfc.FelicaEventListener#errorOccurred(int, java.lang.String, com.felicanetworks.mfc.AppInfo)
     */
    void errorOccurred(int id, in String msg, in AppInfo otherAppInfo);
}
