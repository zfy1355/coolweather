package org.sunny.coolweather;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import org.json.JSONObject;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by home on 2016/8/15.
 */

public class Test_json extends ApplicationTestCase<Application> {
    public Test_json(){
        super(Application.class);
    }

    @Test
    public void jsonDeal(){

        int expected = 1;
        int reality = 5;

        try {
            System.out.print(0);
            String json = " {\"desc\":\"OK\",\"status\":1000,\"data\":{\"wendu\":\"23\",\"ganmao\":\"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\",\"forecast\":[{\"fengxiang\":\"无持续风向\",\"fengli\":\"微风级\",\"high\":\"高温 29℃\",\"type\":\"阵雨\",\"low\":\"低温 20℃\",\"date\":\"15日星期一\"},{\"fengxiang\":\"无持续风向\",\"fengli\":\"微风级\",\"high\":\"高温 32℃\",\"type\":\"多云\",\"low\":\"低温 23℃\",\"date\":\"16日星期二\"},{\"fengxiang\":\"无持续风向\",\"fengli\":\"微风级\",\"high\":\"高温 27℃\",\"type\":\"阵雨\",\"low\":\"低温 22℃\",\"date\":\"17日星期三\"},{\"fengxiang\":\"无持续风向\",\"fengli\":\"微风级\",\"high\":\"高温 25℃\",\"type\":\"中到大雨\",\"low\":\"低温 22℃\",\"date\":\"18日星期四\"},{\"fengxiang\":\"无持续风向\",\"fengli\":\"微风级\",\"high\":\"高温 31℃\",\"type\":\"阴\",\"low\":\"低温 22℃\",\"date\":\"19日星期五\"}],\"yesterday\":{\"fl\":\"微风\",\"fx\":\"无持续风向\",\"high\":\"高温 34℃\",\"type\":\"多云\",\"low\":\"低温 24℃\",\"date\":\"14日星期日\"},\"city\":\"海淀\"}}";
            JSONObject jsonObject = new JSONObject(json);
            System.out.print(1);
            JSONObject weatherInfo = jsonObject.getJSONObject("data");
            System.out.print(2);
            String wendu = weatherInfo.getString("wendu");
            System.out.print(3);
            JSONObject forecast = weatherInfo.getJSONObject("forecast");
            System.out.print(4);
            String high = forecast.getString("high");
            System.out.print(5);
            String low = forecast.getString("low");
            System.out.print(6);
            String s = "ccc"+ wendu + "   " + high + "   " + low;
            System.out.print(s);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        assertEquals(expected, reality);
    }
}
