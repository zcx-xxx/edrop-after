package com.edrop.jpush.examples;

import cn.jiguang.common.ClientConfig;
//import cn.jiguang.common.ServiceHelper;
//import cn.jiguang.common.connection.NativeHttpClient;
//import cn.jiguang.common.connection.NettyHttpClient;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import com.edrop.jpush.push.model.audience.Audience;

import com.edrop.jpush.push.model.Platform;

import com.edrop.jpush.push.model.PushPayload;

//import cn.jpush.api.JPushClient;
import com.edrop.jpush.*;

//import cn.jiguang.common.resp.ResponseWrapper;
//import cn.jpush.api.JPushClient;
//import cn.jpush.api.push.CIDResult;
//import cn.jpush.api.push.GroupPushClient;
import com.edrop.jpush.push.PushResult;
import com.edrop.jpush.push.model.Message;
//import cn.jpush.api.push.model.Platform;
//import cn.jpush.api.push.model.PushPayload;
//import cn.jpush.api.push.model.*;
//import cn.jpush.api.push.model.audience.Audience;
//import cn.jpush.api.push.model.audience.AudienceTarget;
//import cn.jpush.api.push.model.notification.*;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonPrimitive;
//import io.netty.handler.codec.http.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.net.URI;
//import java.net.URISyntaxException;
import java.util.*;

public class PushExample {
    protected static final Logger LOG = LoggerFactory.getLogger(PushExample.class);

    // demo App defined in resources/jpush-api.conf 
    protected static final String APP_KEY = "8d0195a1db15b66cf5302fe4";
    protected static final String MASTER_SECRET = "7a03f945e22b0c7fb094fccb";
    protected static final String GROUP_PUSH_KEY = "2c88a01e073a0fe4fc7b167c";
    protected static final String GROUP_MASTER_SECRET = "b11314807507e2bcfdeebe2e";

    public static final String TITLE = "Test from API example";
    public static final String ALERT = "Test from API Example - alert";
    public static final String MSG_CONTENT = "update";
    public static final String REGISTRATION_ID = "0900e8d85ef";
    public static final String TAG = "tag_api";
    public static long sendCount = 0;

//    public static void main(String[] args) {
//
//        testSendPush_fromJSON();
//    }
    
    public static void testSendPush_fromJSON() {
        ClientConfig clientConfig = ClientConfig.getInstance();
        JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);
        PushPayload payload = buildPushObject_android_and_ios();

        try {
        	PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
        }
    }

    //不删
    public static PushPayload buildPushObject_android_and_ios() {
        Map<String, String> extras = new HashMap<String, String>();
        extras.put("test", "https://community.jiguang.cn/push");
        return PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.all())
                .setMessage(Message.content(MSG_CONTENT))
                .build();
    }
}

