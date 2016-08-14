package org.sunny.coolweather.util;

import java.net.ProtocolException;

/**
 * Created by home on 2016/8/4.
 */
public interface HttpCallbackListener {

    public void onFinish(String s);

    public void onError(Exception e);
}
