package com.xuan.xuanhttplibrary.okhttp.builder;import android.text.TextUtils;import android.util.Log;import com.sk.weichat.Reporter;import com.xuan.xuanhttplibrary.okhttp.HttpUtils;import java.net.URLEncoder;import java.util.Map;import okhttp3.Request;/** * @author Administrator * @time 2017/3/30 0:11 * @des ${TODO} */public class GetBuilder extends BaseBuilder {    @Override    public GetBuilder url(String url) {        if (!TextUtils.isEmpty(url)) {            this.url = url;        }        return this;    }    @Override    public GetBuilder tag(Object tag) {        return this;    }    @Override    public BaseCall abstractBuild() {        url = appenParams();        build = new Request.Builder()                .header("User-Agent", getUserAgent())                .url(url).build();        Log.i(HttpUtils.TAG, "网络请求参数：" + url);        return new BaseCall();    }    /**     * 主要用于获取图形验证码，所以默认验参并按登录前添加验参，     */    public String buildUrl() {        return buildUrl(true, true);    }    public String buildUrl(boolean mac, boolean beforeLogin) {        build(mac, beforeLogin);        return url;    }    private String appenParams() {        StringBuffer sb = new StringBuffer();        sb.append(url);        if (!params.isEmpty()) {            sb.append("?");            for (String key : params.keySet()) {                String v = params.get(key);                if (!TextUtils.isEmpty(v)) {                    try {                        // url安全，部分字符不能直接放进url, 要改成百分号开头%的，                        v = URLEncoder.encode(v, "UTF-8");                    } catch (Exception e) {                        // 不可到达，UTF-8不可能不支持，                        Reporter.unreachable(e);                    }                }                sb.append(key).append("=").append(v).append("&");            }            sb = sb.deleteCharAt(sb.length() - 1); // 去掉后面的&        }        return sb.toString();    }    @Override    public GetBuilder params(String k, String v) {        params.put(k, v);        return this;    }    public GetBuilder params(Map<String, String> params) {        this.params.putAll(params);        return this;    }}