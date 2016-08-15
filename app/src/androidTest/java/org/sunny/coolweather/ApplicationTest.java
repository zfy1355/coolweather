package org.sunny.coolweather;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

/*    public void test() {
        int expected = 1;
        int reality = 5;
        assertEquals(expected, reality);
    }*/

   public void jsonDeal(){
       try {
           String json = " {\"desc\":\"OK\",\"status\":1000,\"data\":{\"wendu\":\"23\",\"ganmao\":\"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\",\"forecast\":[{\"fengxiang\":\"无持续风向\",\"fengli\":\"微风级\",\"high\":\"高温 29℃\",\"type\":\"阵雨\",\"low\":\"低温 20℃\",\"date\":\"15日星期一\"},{\"fengxiang\":\"无持续风向\",\"fengli\":\"微风级\",\"high\":\"高温 32℃\",\"type\":\"多云\",\"low\":\"低温 23℃\",\"date\":\"16日星期二\"},{\"fengxiang\":\"无持续风向\",\"fengli\":\"微风级\",\"high\":\"高温 27℃\",\"type\":\"阵雨\",\"low\":\"低温 22℃\",\"date\":\"17日星期三\"},{\"fengxiang\":\"无持续风向\",\"fengli\":\"微风级\",\"high\":\"高温 25℃\",\"type\":\"中到大雨\",\"low\":\"低温 22℃\",\"date\":\"18日星期四\"},{\"fengxiang\":\"无持续风向\",\"fengli\":\"微风级\",\"high\":\"高温 31℃\",\"type\":\"阴\",\"low\":\"低温 22℃\",\"date\":\"19日星期五\"}],\"yesterday\":{\"fl\":\"微风\",\"fx\":\"无持续风向\",\"high\":\"高温 34℃\",\"type\":\"多云\",\"low\":\"低温 24℃\",\"date\":\"14日星期日\"},\"city\":\"海淀\"}}";
           JSONObject jsonObject = new JSONObject(json);
           JSONObject weatherInfo = jsonObject.getJSONObject("data");
           String wendu = weatherInfo.getString("wendu");
           JSONObject forecast = weatherInfo.getJSONObject("forecast");
           String high = forecast.getString("high");
           String low = forecast.getString("low");

           Log.i("ccc", wendu + "   " + high + "   " + low);
           assertEquals(1, 2);
       }catch (Exception ex){

       }

    }
}