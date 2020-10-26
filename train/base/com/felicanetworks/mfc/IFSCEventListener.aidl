//
// IFSCEventListener.aidl
//
// Copyright 2009 FeliCa Networks, Inc.
// All Rights Reserved.
// FeliCa Networks, Inc. Proprietary/Confidential.
//
package com.felicanetworks.mfc;

/**
 * FeliCaサーバとのオンライン処理に関するイベントのAIDL用リスナインタフェースです。
 * <p>
 */
oneway interface IFSCEventListener {
    /**
     * FeliCaサーバとのオンライン処理でエラーが発生した場合に呼び出されます。
     * <p>
     * このメソッドに渡されるパラメータの内容は以下の通りです:
     * <p>
     * <table style="vertical-align: middle;" border="1" cellpadding="2"
     * cellspacing="2"> <tbody>
     * <tr>
     * <th style="text-align: center;">原因</th>
     * <th style="text-align: center;">タイプ</th>
     * <th style="text-align: center;">メッセージ</th>
     * </tr>
     * <tr>
     * <td>FeliCaサーバからエラーメッセージを受信した場合</td>
     * <td colspan="1" rowspan="4">{@link #TYPE_PROTOCOL_ERROR}</td>
     * <td>エラーメッセージの内容</td>
     * </tr>
     * <tr>
     * <td>FeliCaサーバから受信したメッセージのフォーマットが正しくない場合</td>
     * <td>"Packet format error."</td>
     * </tr>
     * <tr>
     * <td>FeliCaサーバから受信したメッセージが状態と適合しない場合</td>
     * <td>"Illegal state error."</td>
     * </tr>
     * <tr>
     * <td>FeliCaサーバから受信した通信パラメータが正しくない場合</td>
     * <td>"Communication initiation error."</td>
     * </tr>
     * <tr>
     * <td>HTTPレスポンスコードが200以外の場合</td>
     * <td colspan="1" rowspan="4">{@link #TYPE_HTTP_ERROR}</td>
     * <td>"Invalid response code: <span style="font-style: italic;">レスポンスコード
     * </span>"</td>
     * </tr>
     * <tr>
     * <td>HTTPレスポンスのコンテントタイプが正しくない場合</td>
     * <td>"Invalid content-type: <span style="font-style: italic;">コンテントタイプ
     * </span>"</td>
     * </tr>
     * <tr>
     * <td>HTTPレスポンスのコンテントタイプが設定されていない場合</td>
     * <td>"Invalid content-type: null"</td>
     * </tr>
     * <tr>
     * <td>上記以外のHTTP通信エラーが発生した場合</td>
     * <td>"HTTP communication error."</td>
     * </tr>
     * <tr>
     * <td>{@link FSC#stop()}の呼び出しによりFeliCaサーバとのオンライン処理が中断した場合</td>
     * <td colspan="1" rowspan="2">{@link #TYPE_INTERRUPTED_ERROR}</td>
     * <td colspan="1" rowspan="2">"Interrupted."</td>
     * </tr>
     * <tr>
     * <td>{@link Felica#close()}の呼び出しによりFeliCaサーバとのオンライン処理が強制終了した場合</td>
     * </tr>
     * <tr>
     * <td>{@link #operationRequested(int, String, byte[])}が例外をスローした場合</td>
     * <td colspan="1" rowspan="2">{@link #TYPE_UNKNOWN_ERROR}</td>
     * <td colspan="1" rowspan="2">スローされた例外のメッセージ</td>
     * </tr>
     * <tr>
     * <td><code>FSC</code> 内部で例外が発生した場合</td>
     * </tr>
     * </tbody> </table>
     *
     * @param type エラー種別
     * @param message エラーメッセージ(メッセージがない場合は <code>null</code>)
     */
    void errorOccurred(int type, java.lang.String message);

    /**
     * FeliCaサーバとのオンライン処理が正常終了した場合に呼び出されます。
     * <p>
     *
     * @param status ステータスコード
     */
    void finished(int status);

    /**
     * FeliCaサーバからデバイス操作要求を受信した場合に呼び出されます。操作対象のデバイスはデバイスIDで指定されます。
     * <p>
     * このメソッドが正常にリターンした場合、FeliCaサーバにはデバイス操作処理結果が渡され、処理が正常に行われたことが通知されます。
     * このメソッドから例外がスローされた場合、FeliCaサーバにはデバイス操作処理が正常に行われなかったことが通知されます。
     * <p>
     *
     * @param deviceID デバイスID
     * @param param 操作用パラメータ(パラメータがない場合は <code>null</code>)
     * @param data 操作用データ(データがない場合は <code>null</code>)
     * @return デバイス操作処理結果
     */
    void operationRequested(int deviceID, java.lang.String param, in byte[] data);
}
