//
// IFelicaPushAppNotificationListener.aidl
//
// Copyright 2009 FeliCa Networks, Inc.
// All Rights Reserved.
// FeliCa Networks, Inc. Proprietary/Confidential.
//
package com.felicanetworks.mfc;

import com.felicanetworks.mfc.PushNotifyAppSegment;

/**
 * Push受信機能のアプリケーション通知に関するAIDL用リスナインタフェースです。
 * <p>
 */
oneway interface IFelicaPushAppNotificationListener {
    /**
     * Pushによるアプリケーション通知を受信した場合に呼び出されます。<p>
     * 受信したデータの個別部パラメータサイズが0の場合、アプリ通知の個別部パラメータ内のそれぞれの値にはnullが設定されます。
     * @param pushNotificationAppSegment アプリ通知の個別部パラメータ
     */
    void pushAppNotified(in PushNotifyAppSegment pushNotificationAppSegment);
}
