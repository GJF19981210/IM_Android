package com.sk.weichat;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import androidx.multidex.BuildConfig;

import com.sk.weichat.bean.ConfigBean;
import com.sk.weichat.broadcast.MyBroadcastReceiver;
import com.sk.weichat.broadcast.ShakeReceiver;
import com.sk.weichat.helper.YeepayHelper;
import com.sk.weichat.util.Md5Util;
import com.sk.weichat.util.PreferenceUtils;

import java.util.Objects;

public class AppConfig {
    public static final String TAG = "roamer";
    public static final boolean DEBUG = true;
    /* 应用程序包名 */
    // 这个用于过滤广播，必须不同应用使用不同字符串，否则广播串线，
    public static final String sPackageName = BuildConfig.APPLICATION_ID;
    // 静态广播...
    public static final String myBroadcastReceiverClass = MyBroadcastReceiver.class.getName();
    public static final String shakeReceiverClass = ShakeReceiver.class.getName();

    /* 分页的Size */
    public static final int PAGE_SIZE = 50;

    public static final String apiKey = "";

//    public static String CONFIG_URL = "http://127.0.0.1:8092/config";
    public static String CONFIG_URL = "http://192.168.0.100:8094/config";

    /* 基本地址 */
    public String apiUrl;// Api的服务器地址
    public String uploadUrl;// 上传的服务器地址
    public String downloadAvatarUrl;// 头像下载地址
    public String downloadUrl;// 头像以外的东西的下载地址
    public String XMPPHost;// Xmpp服务器地址
    public int mXMPPPort = 5222;
    public String XMPPDomain;
    public int xmppPingTime;// 每隔xmppPingTime秒ping一次服务器
    public int XMPPTimeOut; // Xmpp超时时长(服务器针对客户端的超时时长)
    public String JitsiServer;// jitsi前缀地址
    /* Api地址--》衍生地址 */
    /* 注册登录 */
    public String USER_REGISTER;// 注册
    public String USER_THIRD_REGISTER;// 第三方注册
    public String USER_LOGIN;// 登陆
    public String USER_SMS_LOGIN;// 短信登陆
    public String USER_THIRD_LOGIN;// 第三方登陆
    public String USER_THIRD_BIND; // 第三方绑定，
    public String USER_THIRD_BIND_LOGIN; // 第三方绑定登录，
    public String USER_PASSWORD_UPDATE;// 修改登录密码
    public String USER_PASSWORD_RESET;// 重置登录密码
    public String USER_LOGIN_AUTO;// 检测Token是否过期 0未更换 1更换过
    public String USER_GETCODE_IMAGE; // 获取图形验证码
    public String SEND_AUTH_CODE;// 获取手机验证码
    public String VERIFY_TELEPHONE;// 验证手机号有没有被注册
    public String QR_CODE_LOGIN;// 扫码登录，
    // 老设备授权登录登录，
    public String ACCESS_AUTH_LOGIN;
    // 新设备确认已经授权，
    public String CHECK_AUTH_LOGIN;
    /* 登录加固 */
    public String LOGIN_SECURE_GET_PRIVATE_KEY;// 获取加密私钥
    public String LOGIN_SECURE_UPLOAD_KEY;// 上传RSA公私钥
    public String LOGIN_SECURE_GET_CODE;// 获取加固临时密码
    /* 支付加固 */
    public String PAY_SECURE_GET_PRIVATE_KEY;// 获取加密私钥
    public String PAY_SECURE_UPLOAD_KEY;// 上传RSA公私钥
    public String PAY_SECURE_GET_CODE;// 获取加固临时密码
    public String PAY_SECURE_RESET_PASSWORD;// 重置密码
    public String PAY_SECURE_GET_QR_KEY;// 获取生成付款码的key
    public String PAY_SECURE_VERIFY_QR_KEY;// 验证生成付款码的key
    public String CHECK_PAY_PASSWORD;  // 检查支付密码，
    public String UPDATE_PAY_PASSWORD;// 修改支付密码，
    // Secure Chat
    public String USER_VERIFY_PASSWORD;// 验证登录密码
    public String USER_GET_RANDOM_STR;//  获取校验码，修改登录密码验签用
    public String USER_PASSWORD_UPDATE_V1;//  修改登录密码 v1
    public String AUTHKEYS_IS_SUPPORT_SECURE_CHAT;// 判断当前telephone用户是否有dh公钥，忘记密码时调用，兼容老用户
    public String USER_PASSWORD_RESET_V1;// 重置登录密码 v1
    public String AUTHKEYS_GET_DHMSG_KEY_LIST;// 获取好友的dh公钥列表
    public String USER_FRIENDS_MODIFY_ENCRYPT_TYPE;// 修改针对好友的加密方式
    public String ROOM_UPDATE_ENCRYPT_TYPE;// 修改针对群组的加密方式
    public String ROOM_GET_MEMBER_RSA_PUBLIC_KEY;// 获取群成员rsa公钥
    public String ROOM_GET_ALL_MEMBER_RSA_PUBLIC_KEY;// 获取所有群成员rsa公钥
    public String ROOM_RESET_GROUP_CHAT_KEY;// 重置群组通信密钥
    public String UPDETE_GROUP_CHAT_KEY;// 群成员更新自己的chatKey

    /* 用户 */
    public String USER_UPDATE; // 用户资料修改
    public String USER_GET_URL;// 获取用户资料，更新本地数据的接口
    public String USER_GET_URL_ACCOUNT;// 获取用户资料，更新本地数据的接口，根据通讯号
    public String USER_PHOTO_LIST;// 获取相册列表
    public String USER_QUERY;// 查询用户列表
    public String USER_NEAR; // 查询搜索列表
    public String PUBLIC_SEARCH; // 公众号搜索列表
    public String USER_SET_PRIVACY_SETTING;// 设置用户隐私设置
    public String USER_GET_PRIVACY_SETTING;// 获取用户隐私设置
    public String USER_DESCRIPTION;// 获取用户签名

    public String USER_GET_BAND_ACCOUNT;// 获取用户绑定账号
    public String USER_UN_BAND_ACCOUNT;// 修改用户绑定账号
    public String AUTHOR_CHECK; // 授权登录弹窗url

    public String USER_GET_PUBLIC_MENU; // 获取公众号菜单
    public String USER_DEL_CHATMESSAGE; // 删除聊天记录

    /* 好友 */
    public String FRIENDS_ATTENTION_LIST;// 获取关注列表
    public String FRIENDS_BLACK_LIST;// 获取黑名单列表

    public String FRIENDS_ATTENTION_ADD;// 加关注 || 直接成为好友
    public String ADD_FRIENDS;// 同意成为好友
    public String FRIENDS_BLACKLIST_ADD;// 拉黑
    public String FRIENDS_BLACKLIST_DELETE;// 取消拉黑
    public String FRIENDS_ATTENTION_DELETE;// 取消关注
    public String FRIENDS_DELETE;// 删除好友

    public String FRIENDS_REMARK;// 备注好友
    public String FRIENDS_UPDATE; // 消息保存天数
    public String FRIENDS_NOPULL_MSG; // 消息免打扰/阅后即焚/置顶聊天
    /* 群聊 */
    public String ROOM_ADD;// 创建群组
    public String ROOM_JOIN;// 加入群组
    public String ROOM_MEMBER_UPDATE;// 添加成员
    public String ROOM_DELETE;// 删除群组
    public String ROOM_MEMBER_DELETE;// 删除成员 || 退出群组
    public String ROOM_TRANSFER;// 转让群组
    public String ROOM_COPY;//群复制

    public String ROOM_GET;// 获取群组
    public String ROOM_LIST;// 获取群组列表
    public String ROOM_MEMBER_GET;// 获取成员
    public String ROOM_MEMBER_LIST;// 获取成员列表
    public String ROOM_MEMBER_SEARCH;// 群成员模糊搜索
    public String ROOM_LIST_HIS;// 获取某个用户已经加入的房间列表
    public String ROOM_GET_ROOM;// 获取自己的成员信息以及群属性
    public String ROOM_UPDATE;// 设置群组
    public String ROOM_MANAGER;// 指定管理员
    public String ROOM_UPDATE_ROLE;// 指定隐身人，监控人，
    public String ROOM_EDIT_NOTICE;// 编辑群公告
    public String ROOM_DELETE_NOTICE;// 删除群公告
    public String ROOM_LOCATION_QUERY;// 面对面建群查询
    public String ROOM_LOCATION_JOIN;// 面对面建群加入
    public String ROOM_LOCATION_EXIT;// 面对面建群退出
    public String ROOM_DISTURB;// 消息免打扰/置顶聊天
    public String UPLOAD_MUC_FILE_ADD;// 上传群文件接口
    public String UPLOAD_MUC_FILE_FIND_ALL;// 查询所有文件
    public String UPLOAD_MUC_FILE_FIND;// 查询单个文件
    public String UPLOAD_MUC_FILE_DEL;//  删除单个群文件
    public String OPEN_GET_HELPER_LIST;// 获取所有群助手列表
    public String ROOM_ADD_GROUP_HELPER;// 添加群助手
    public String ROOM_DELETE_GROUP_HELPER;// 移除群助手
    public String ROOM_QUERY_GROUP_HELPER;// 查询群助手
    public String ROOM_ADD_AUTO_RESPONSE;//添加自动回复
    public String ROOM_UPDATE_AUTO_RESPONSE;//修改自动回复
    public String ROOM_DELETE_AUTO_RESPONSE;//删除自动回复
    /* 附近 */
    public String NEARBY_USER;// 获取附近的用户
    /* 商务圈 */
    public String USER_CIRCLE_MESSAGE;// 获取某个人的商务圈消息
    public String DOWNLOAD_CIRCLE_MESSAGE;// 下载商务圈消息
    public String MSG_ADD_URL;// 发布一条公共消息的接口
    public String MSG_LIST;// 获取公共消息的接口
    public String MSG_USER_LIST;// 获取某个用户的最新公共消息
    public String MSG_GETS;// 根据IDS批量获取公共消息的接口(我的商务圈使用)
    public String MSG_GET;// 根据ID获取公共消息
    public String CIRCLE_MSG_DELETE;// 删除一条商务圈消息
    public String MSG_PRAISE_ADD;// 赞
    public String MSG_PRAISE_DELETE;// 取消赞
    public String MSG_PRAISE_LIST;// 点赞分页加载的接口，
    public String MSG_COLLECT_DELETE;//  取消朋友圈收藏，
    public String CIRCLE_MSG_LATEST;// 获取人才榜最新消息
    public String CIRCLE_MSG_HOT;// 最热人才榜
    public String MSG_COMMENT_ADD;// 增加一条评论
    public String MSG_COMMENT_DELETE;// 删除一条评论
    public String MSG_COMMENT_LIST;// 获取评论列表
    public String FILTER_USER_CIRCLE;// 生活圈屏蔽某人
    /* 直播 */
    public String GET_LIVE_ROOM_LIST;// 获取直播间列表
    public String CREATE_LIVE_ROOM;// 创建直播间
    public String JOIN_LIVE_ROOM;// 加入直播间
    public String EXIT_LIVE_ROOM;// 退出直播间
    public String DELETE_LIVE_ROOM;// 删除直播间
    public String LIVE_ROOM_DETAIL;// 直播间详情
    public String LIVE_ROOM_MEMBER_LIST;// 直播间成员列表
    public String LIVE_ROOM_DANMU;// 发送弹幕
    public String GET_LIVE_GIFT_LIST;// 获取礼物列表
    public String LIVE_ROOM_GIFT;// 发送礼物
    public String LIVE_ROOM_PRAISE;// 发送爱心
    public String LIVE_ROOM_GET_IDENTITY;// 获取身份信息
    public String LIVE_ROOM_UPDATE;// 修改直播间
    public String LIVE_ROOM_SET_MANAGER;// 设置管理员
    public String LIVE_ROOM_SHUT_UP;// 禁言/取消禁言
    public String LIVE_ROOM_KICK;// 踢人
    public String LIVE_ROOM_STATE;// 正在直播 || 未开启直播
    public String LIVE_GET_LIVEROOM;// 获取自己的直播间

    public String EMPTY_SERVER_MESSAGE;// 清空服务端数据
    /* 抖音视频获取接口 */
    public String GET_TRILL_LIST;// 获取视频列表
    public String GET_MUSIC_LIST;// 获取音乐列表 http://47.91.232.3:8092/music/list?access_token=20bc3cbda93241a8903a999a5ad71625&pageIndex=0&pageSize=20&keyword=94
    public String TRILL_ADD_FORWARD;// 转发数量统计
    public String TRILL_ADD_PLAY;// 观看数量统计
    // yeepay
    public String YOP_OPEN_SEND_AUTH_CODE; // 用户开户时获取手机验证码
    public String YOP_OPEN_ACCOUNT; // 用户开户
    public String YOP_MONEY; // 查询钱包
    public String YOP_RECHARGE; // 发起充值
    public String YOP_WITHDRAW; // 发起提现
    public String YOP_BIND; // 绑定银行卡
    public String YOP_SECURE; // 安全设置
    public String YOP_TRANSFER; // 转账
    public String YOP_SEND_RED; // 发红包
    public String YOP_QUERY_RED; // 查红包支付成功情况
    public String YOP_QUERY_TRANSFER; // 查转账支付成功情况
    public String YOP_QUERY_RECHARGE; // 查充值成功情况
    public String YOP_QUERY_WITHDRAW; // 查提现成功情况
    public String YOP_ACCEPT_TRANSFER; // 收转账
    public String YOP_ACCEPT_RED; // 收红包
    public String YOP_RECORD_RED; // 获取消费记录列表
    /* 红包相关的URL变量*/
    public String RECHARGE_ADD; // 余额充值
    public String RECHARGE_GET; // 余额查询
    public String REDPACKET_SEND; // 发送红包
    public String RENDPACKET_GET; // 获取红包详情
    public String RENDPACKET_REPLY; // 回复红包
    public String REDPACKET_OPEN; // 打开红包
    public String SEND_REDPACKET_LIST_GET; // 获取发出的红包
    public String RECIVE_REDPACKET_LIST_GET; // 获取收到的红包
    public String SKTRANSFER_SEND_TRANSFER; // 转账
    public String SKTRANSFER_GET_TRANSFERINFO; // 获取转账信息
    public String SKTRANSFER_RECEIVE_TRANSFER; // 接受转账
    public String PAY_CODE_PAYMENT; // 向展示付款码的用户收钱
    public String PAY_CODE_RECEIPT;// 向展示收款码的用户付钱
    public String TRANSACTION_RECORD;
    public String CONSUMERECORD_GET; // 获取消费记录列表
    public String CONSUMERECORD_GET_NEW; // 获取消费记录列表[新]
    public String VX_RECHARGE;    // 微信/支付宝 充值
    public String VX_UPLOAD_CODE; // 微信 上传
    public String VX_GET_OPEN_ID; // 微信 上传
    public String VX_TRANSFER_PAY;// 微信 提现
    public String ALIPAY_AUTH;// 支付宝 授权
    public String ALIPAY_BIND;// 支付宝 绑定
    public String ALIPAY_TRANSFER;// 支付宝 提现

    public String PAY_GET_ORDER_INFO;// 获取订单信息
    public String PAY_PASSWORD_PAYMENT;// 输入密码后支付接口
    /* 扫码充值 */
    public String MANUAL_PAY_GET_RECEIVER_ACCOUNT;// 获取转账人信息
    public String MANUAL_PAY_RECHARGE;// 提交充值申请
    public String MANUAL_PAY_WITHDRAW;// 提交提现申请
    public String MANUAL_PAY_ADD_WITHDRAW_ACCOUNT;// 添加提现账号
    public String MANUAL_PAY_DELETE_WITHDRAW_ACCOUNT;// 删除提现账号列表
    public String MANUAL_PAY_UPDATE_WITHDRAW_ACCOUNT;// 修改提现账号列表
    public String MANUAL_PAY_GET_WITHDRAW_ACCOUNT_LIST;// 获取提现账号列表
    /* 组织架构 */
    public String AUTOMATIC_SEARCH_COMPANY;//自动查询公司
    public String CREATE_COMPANY; // 创建公司
    public String SET_COMPANY_MANAGER; // 指定管理者
    public String MODIFY_COMPANY_NAME; // 修改公司名称
    public String CHANGE_COMPANY_NOTIFICATION; // 更改公司公告
    public String SEARCH_COMPANY; // 查找公司
    public String DELETE_COMPANY; // 删除公司
    public String CREATE_DEPARTMENT; // 创建部门
    public String MODIFY_DEPARTMENT_NAME; // 修改部门名称
    public String DELETE_DEPARTMENT; // 删除部门
    public String ADD_EMPLOYEE; // 添加员工
    public String DELETE_EMPLOYEE; // 删除员工
    public String MODIFY_EMPLOYEE_DEPARTMENT; // 更改员工部门
    public String COMPANY_LIST; // 公司列表
    public String DEPARTMENT_LIST; // 部门列表
    public String EMPLOYEE_LIST; // 员工列表
    public String GET_COMPANY_DETAIL; // 获取公司详情
    public String GET_EMPLOYEE_DETAIL; // 获取员工详情
    public String GET_DEPARTMENT_DETAIL; // 获取部门详情
    public String GET_EMPLOYEE_NUMBER_OF_COMPANY; // 获取公司员工人数
    public String EXIT_COMPANY;// 退出公司
    public String CHANGE_EMPLOYEE_IDENTITY;// 修改身份公司
    /* 标签 */
    public String FRIENDGROUP_LIST;// 获取标签列表
    public String FRIENDGROUP_ADD;// 添加标签
    public String FRIENDGROUP_DELETE;// 删除标签
    public String FRIENDGROUP_UPDATE;// 修改标签名
    public String FRIENDGROUP_UPDATEGROUPUSERLIST;// 标签下的好友增、删
    public String FRIENDGROUP_UPDATEFRIEND;
    /* 消息漫游 */
    public String USER_OFFLINE_OPERATION; // 获取离线期间其他端调用的接口
    public String GET_LAST_CHAT_LIST; // 获取最近一条的聊天记录列表
    public String GET_CHAT_MSG; // 获取单聊漫游的消息
    public String GET_CHAT_MSG_MUC; // 获取群聊漫游的消息
    /* 讲课 */
    public String USER_ADD_COURSE; // 添加课程
    public String USER_QUERY_COURSE; // 查询课程
    public String USER_EDIT_COURSE;  // 修改课程
    public String USER_DEL_COURSE;   // 删除课程
    public String USER_COURSE_DATAILS; // 课程详情
    /* 收藏 */
    public String Collection_ADD; // 添加收藏
    public String Collection_REMOVE;// 删除收藏
    public String Collection_LIST;// 表情列表
    public String Collection_LIST_OTHER;// 收藏列表
    public String USER_REPORT;// 举报用户 || 群组 || 网站
    public String UPLOAD_COPY_FILE;// 服务端将文件拷贝一份，更换另外一个url地址返回
    public String ADDRESSBOOK_UPLOAD;// 上传本地联系人
    public String ADDRESSBOOK_GETALL;// 查询通讯录好友
    public String ADDENTION_BATCH_ADD;// 联系人内加好友 不需要验证

    /* 登出地址 */
    public String USER_LOGOUT;
    /* 保存最后一次在线时间地址 */
    public String USER_OUTTIME;

    // 集群 获取 meetUrl
    public String OPEN_MEET;
    // 登录分享sdk验证接口
    public String SDK_OPEN_AUTH_INTERFACE;
    // 获取服务器时间接口，用于校准时间，
    public String GET_CURRENT_TIME;
    public String URL_CHECK;

    /* 上传 的服务器地址--》衍生地址 */
    public String UPLOAD_URL;// 上传图片接口
    public String UPLOAD_AUDIO_URL;// 上传语音接口
    public String AVATAR_UPLOAD_URL;// 上传头像接口
    public String ROOM_UPDATE_PICTURE;// 上传群头像接口
    /* 头像下载地址--》衍生地址 */
    public String AVATAR_ORIGINAL_PREFIX;// 头像原图前缀地址
    public String AVATAR_THUMB_PREFIX;   // 头像缩略图前缀地址

    // 以下是所有推送上传推送ID的接口，
    // 最后调用的是哪个，服务器端就是用哪个推送，
    // 小米推送接口
    public String configMi;
    // 华为推送接口
    public String configHw;
    // 极光推送接口
    public String configJg;
    // vivo推送接口
    public String configVi;
    // oppo推送接口
    public String configOp;
    // firebase推送接口
    public String configFcm;
    // 魅族推送接口
    public String configMz;
    // 是否开放注册，默认开放，服务器没返回这条配置也是默认开放，
    public boolean isOpenRegister;
    // 注册时是否需要验证码，
    public boolean isOpenSMSCode;
    public String headBackgroundImg;
    /**
     * 注册邀请码   registerInviteCode
     * 0:关闭
     * 1:开启一对一邀请（一码一用，且必填）
     * <p>
     * 2:开启一对多邀请（一码多用，选填项），该模式下客户端需要把用户自己的邀请码显示出来
     */
    // 注册时是否需要邀请码，
    public int registerInviteCode;
    // 是否允许昵称搜索，
    public boolean cannotSearchByNickName;
    // 短视频限制时长，秒，
    public int videoLength;
    // 是否使用用户名注册，
    public boolean registerUsername;
    // 普通用户是否能搜索好友, true表示不可以，
    public boolean ordinaryUserCannotSearchFriend;
    // 普通用户是否能建群, true表示不可以，
    public boolean ordinaryUserCannotCreateGroup;
    // 关于页面的信息，
    public String companyName;
    public String copyright;
    // 隐私政策的地址前缀，
    public String privacyPolicyPrefix;
    // 是否隐藏好友搜索功能, true表示隐藏，
    public boolean isHideSearchFriend;
    // 是否禁用红包相关功能 true表示禁用，
    public boolean displayRedPacket;
    // 是否禁用位置相关功能，true表示禁用，
    public boolean disableLocationServer;
    // 是否启用谷歌推送，true表示启用，
    public boolean enableGoogleFcm;
    // 热门应用  lifeCircle  生活圈，  videoMeeting 视频会议，  liveVideo 视频直播，  shortVideo 短视频， peopleNearby 附近的人
    public ConfigBean.PopularApp popularAPP;
    // 是否开启群组搜索, true为开启，
    public boolean isOpenRoomSearch;
    //  是否在聊天界面显示好友在线/离线, true为开启，
    public boolean isOpenOnlineStatus;
    //  是否启用公众号功能  服务器可能没有公众号模块，不能搜索公众号，
    public boolean enableMpModule;
    // 是否启用端到端功能
    public int isSupportSecureChat;
    // 是否启用支付功能   服务器可能没有支付模块，不能进行收发红包以外的支付操作，
    public boolean enablePayModule;
    // 是否启用扫码充值、提现功能
    public boolean isOpenManualPay;
    // 是否启用微信充值提现
    public boolean enableWxPay;
    // 是否启用支付宝充值提现
    public boolean enableAliPay;
    // 单个红包限额
    public int maxRedpacktAmount;
    // 单笔群红包最大发送个数
    public int maxRedpacktNumber;
    // 是否开启旧设备登录授权
    public boolean enableAuthLogin;
    // 是否支持通讯录
    public boolean isSupportAddress;
    // 二维码地址，
    public String website;
    // 是否使用新ui界面，主要影响发现页面，旧UI直接是生活圈，
    public boolean newUi = false;
    // 是否启用第三方登录，比如微信登录，定制没配置微信appId的话就不用显示相关按钮了，
    public boolean thirdLogin = isShiku();
    public String androidAppUrl;// AndroidApp下载地址
    public String androidVersion;// 版本号
    public int isOpenUI;

    public static boolean isShiku() {
        return !TextUtils.isEmpty(apiKey)
                && Objects.equals(Md5Util.toMD5(apiKey), "a5fba1064f1d94d277e3dc31816319c7")
                && Objects.equals(BuildConfig.APPLICATION_ID, "com.kuxin.im");
    }

    public static String readConfigUrl(Context ctx) {
        String appUrl = PreferenceUtils.getString(ctx, "APP_SERVICE_CONFIG");
        if (TextUtils.isEmpty(appUrl)) {// 未手动输入过服务器配置，使用默认地址
            appUrl = AppConfig.CONFIG_URL;
            // 保存默认地址，下次使用，
            // 避免其他服务器新包覆盖时自动登录出现错乱，
            saveConfigUrl(ctx, appUrl);
        }
        return appUrl.replaceAll(" ", "");// 手动输入可能会有一些空格，替换掉
    }

    public static void saveConfigUrl(Context ctx, String str) {
        // 兼容服务器地址结尾多了一个/config的情况，
        str = removeSuffix(str, "/config");
        // 兼容服务器地址结尾多了一个斜杠/的情况，
        str = removeSuffix(str, "/");
        String url = str + "/config";
        PreferenceUtils.putString(ctx, "APP_SERVICE_CONFIG", url);
    }

    private static String removeSuffix(final String s, final String suffix) {
        if (s != null && suffix != null && s.endsWith(suffix)) {
            return s.substring(0, s.length() - suffix.length());
        }
        return s;
    }

    /**
     * 会改变的配置
     **/
    public static AppConfig initConfig(ConfigBean configBean) {
        AppConfig config = new AppConfig();
        /* 1、Api 的服务器地址 */
        config.apiUrl = configBean.getApiUrl();

        /* 2、上传的服务器地址 */
        config.uploadUrl = configBean.getUploadUrl();

        /* 3、头像下载地址 */
        config.downloadAvatarUrl = configBean.getDownloadAvatarUrl();
        config.downloadUrl = configBean.getDownloadUrl();

        // 是否请求回执 0 不请求 1 请求
        int isOpenReceipt = configBean.getIsOpenReceipt();
        MyApplication.IS_OPEN_RECEIPT = isOpenReceipt == 1;

        // 是否开放注册，
        String isOpenRegisterStr = configBean.getIsOpenRegister();
        boolean isOpenRegister = true;
        // 为0表示不开放注册，为1或者不存在表示开放注册，
        if ("0".equals(isOpenRegisterStr)) {
            isOpenRegister = false;
        }
        config.isOpenRegister = isOpenRegister;

        // 是否需要短信验证码，
        String isOpenSMSCodeStr = configBean.getIsOpenSMSCode();
        boolean isOpenSMSCode = false;
        // 为0表示不需要短信验证码，为1表示需要短信验证码，
        if ("1".equals(isOpenSMSCodeStr)) {
            isOpenSMSCode = true;
        }
        config.isOpenSMSCode = isOpenSMSCode;

        // 是否需要邀请码，
        config.registerInviteCode = configBean.getRegisterInviteCode();

        // 是否允许昵称搜索
        config.cannotSearchByNickName = configBean.getNicknameSearchUser() == 0;

        // 短视频限制时长，秒，
        config.videoLength = configBean.getVideoLength();

        // 是否使用用户名注册，
        config.registerUsername = configBean.getRegeditPhoneOrName() > 0;

        config.ordinaryUserCannotSearchFriend = configBean.getIsCommonFindFriends() > 0;
        config.ordinaryUserCannotCreateGroup = configBean.getIsCommonCreateGroup() > 0;

        config.companyName = configBean.getCompanyName();
        config.copyright = configBean.getCopyright();

        config.privacyPolicyPrefix = configBean.getPrivacyPolicyPrefix();

        String website = configBean.getWebsite();
        if (TextUtils.isEmpty(website)) {
            website = "https://example.com/";
        }
        config.website = website;
        config.headBackgroundImg = configBean.getHeadBackgroundImg();

        config.androidAppUrl = configBean.getAndroidAppUrl();
        config.androidVersion = configBean.getAndroidVersion();

        config.isHideSearchFriend = configBean.getHideSearchByFriends() == 0;

        config.displayRedPacket = configBean.getDisplayRedPacket() == 0;

        config.disableLocationServer = configBean.getIsOpenPositionService() > 0;

        config.enableGoogleFcm = configBean.getIsOpenGoogleFCM() > 0;

        config.popularAPP = configBean.getPopularAPPBean();

        // 是否开启群组搜索, true为开启，
        config.isOpenRoomSearch = configBean.getIsOpenRoomSearch() == 0;

        //  是否在聊天界面显示好友在线/离线, true为开启，
        config.isOpenOnlineStatus = configBean.getIsOpenOnlineStatus() == 1;

        //  是否启用公众号功能  服务器可能没有公众号模块，不能搜索公众号，
        config.enableMpModule = configBean.getEnableMpModule() == 1;
        // 是否启用端到端功能
        config.isSupportSecureChat = configBean.getIsOpenSecureChat();

        // 是否启用支付功能   服务器可能没有支付模块，不能进行支付操作，
        // displayRedPacket只管控红包相关，enablePayModule管控所有支付相关
        config.enablePayModule = configBean.getEnablePayModule() == 1;
        // 是否启用扫码充值、提现功能
        config.isOpenManualPay = configBean.getIsOpenManualPay() == 1;
        // 是否启用云钱包功能
        YeepayHelper.ENABLE = configBean.getIsOpenCloudWallet() == 1;
        // 是否启用微信充值提现
        config.enableWxPay = configBean.getEnableWxPay() == 1;
        // 是否启用支付宝充值提现
        config.enableAliPay = configBean.getEnableAliPay() == 1;
        // 单个红包限额
        config.maxRedpacktAmount = configBean.getMaxRedpacktAmount();
        // 单笔群红包最大发送个数
        config.maxRedpacktNumber = configBean.getMaxRedpacktNumber();
        // 是否开启旧设备登录授权
        config.enableAuthLogin = configBean.getIsOpenAuthSwitch() == 1;

        config.isSupportAddress = configBean.getShowContactsUser() == 1;

        config.XMPPHost = configBean.getXMPPHost();

        config.XMPPDomain = configBean.getXMPPDomain();

        config.xmppPingTime = configBean.getXmppPingTime();

        config.XMPPTimeOut = configBean.getXMPPTimeout();

        config.JitsiServer = configBean.getJitsiServer();
        config.isOpenUI = configBean.getIsOpenUI();
        // apiUrl
        initApiUrls(config);
        initOthersUrls(config);
        return config;
    }

    private static void initApiUrls(AppConfig config) {
        String apiUrl = config.apiUrl;
        /* 登陆注册 */
        config.USER_REGISTER = apiUrl + "user/register/v1";// 注册
        config.USER_THIRD_REGISTER = apiUrl + "user/registerSDK/v1";// 第三方注册
        config.USER_LOGIN = apiUrl + "user/login/v1";// 登陆
        config.USER_SMS_LOGIN = apiUrl + "user/smsLogin";// 短信登陆
        config.USER_THIRD_LOGIN = apiUrl + "user/sdkLogin/v1";// 第三方登陆
        config.USER_THIRD_BIND = apiUrl + "user/bindWxAccount";// 第三方绑定
        config.USER_THIRD_BIND_LOGIN = apiUrl + "user/bindingTelephone/v1";// 第三方绑定登录
        config.USER_PASSWORD_UPDATE = apiUrl + "user/password/update";//  修改登录密码
        config.USER_PASSWORD_RESET = apiUrl + "user/password/reset";// 重置登录密码
        config.USER_LOGIN_AUTO = apiUrl + "user/login/auto/v1";// 检测Token是否过期
        config.USER_GETCODE_IMAGE = apiUrl + "getImgCode";// 获取图形验证码
        config.SEND_AUTH_CODE = apiUrl + "basic/randcode/sendSms";// 获取手机验证码
        config.VERIFY_TELEPHONE = apiUrl + "verify/telephone";// 验证手机号有没有被注册
        config.QR_CODE_LOGIN = apiUrl + "user/qrCodeLogin";// 扫码登录
        // 老设备授权登录登录，
        config.ACCESS_AUTH_LOGIN = apiUrl + "user/affirmDeviceAuth";
        // 新设备确认已经授权，
        config.CHECK_AUTH_LOGIN = apiUrl + "user/deviceIsAuth";
        /* 登录加固 */
        config.LOGIN_SECURE_GET_PRIVATE_KEY = apiUrl + "authkeys/getLoginPrivateKey";// 获取加密私钥
        config.LOGIN_SECURE_UPLOAD_KEY = apiUrl + "authkeys/uploadLoginKey";// 上传RSA公私钥
        config.LOGIN_SECURE_GET_CODE = apiUrl + "auth/getLoginCode";// 获取加固临时密码
        /* 支付加固 */
        config.PAY_SECURE_GET_PRIVATE_KEY = apiUrl + "authkeys/getPayPrivateKey";// 获取加密私钥
        config.PAY_SECURE_UPLOAD_KEY = apiUrl + "authkeys/uploadPayKey";// 上传RSA公私钥
        config.PAY_SECURE_GET_CODE = apiUrl + "transaction/getCode";// 获取加固临时密码
        config.PAY_SECURE_RESET_PASSWORD = apiUrl + "authkeys/resetPayPassword";// 重置密码
        config.PAY_SECURE_GET_QR_KEY = apiUrl + "pay/getQrKey";// 获取生成付款码的key
        config.PAY_SECURE_VERIFY_QR_KEY = apiUrl + "pay/verifyQrKey";// 验证生成付款码的key
        config.CHECK_PAY_PASSWORD = apiUrl + "user/checkPayPassword"; // 检查支付密码，
        config.UPDATE_PAY_PASSWORD = apiUrl + "user/update/payPassword"; // 修改支付密码，
        // Secure Chat
        config.USER_VERIFY_PASSWORD = apiUrl + "user/verify/password"; // 验证登录密码
        config.USER_GET_RANDOM_STR = apiUrl + "user/getRandomStr"; // 获取校验码，修改登录密码验签用
        config.USER_PASSWORD_UPDATE_V1 = apiUrl + "user/password/update/v1"; // 修改登录密码 v1
        config.AUTHKEYS_IS_SUPPORT_SECURE_CHAT = apiUrl + "authkeys/isSupportSecureChat"; // 判断当前telephone用户是否有dh公钥，忘记密码时调用，兼容老用户
        config.USER_PASSWORD_RESET_V1 = apiUrl + "user/password/reset/v1"; // 重置登录密码 v1
        config.AUTHKEYS_GET_DHMSG_KEY_LIST = apiUrl + "authkeys/getDHMsgKeyList"; // 获取好友的dh公钥列表
        config.USER_FRIENDS_MODIFY_ENCRYPT_TYPE = apiUrl + "friends/modify/encryptType"; // 修改针对好友的加密方式
        config.ROOM_UPDATE_ENCRYPT_TYPE = apiUrl + "room/updateEncryptType"; // 修改针对群组的加密方式
        config.ROOM_GET_MEMBER_RSA_PUBLIC_KEY = apiUrl + "room/getMemberRsaPublicKey"; // 获取群成员rsa公钥
        config.ROOM_GET_ALL_MEMBER_RSA_PUBLIC_KEY = apiUrl + "room/getAllMemberRsaPublicKey"; // 获取所有群成员rsa公钥
        config.ROOM_RESET_GROUP_CHAT_KEY = apiUrl + "room/resetGroupChatKey"; // 重置群组通信密钥
        config.UPDETE_GROUP_CHAT_KEY = apiUrl + "room/updateGroupChatKey"; // 群成员更新自己的chatKey

        /* 用户 */
        config.USER_UPDATE = apiUrl + "user/update";// 用户资料修改
        config.USER_GET_URL = apiUrl + "user/get";  // 获取用户资料，更新本地数据的接口
        config.USER_GET_URL_ACCOUNT = apiUrl + "user/getByAccount";  // // 获取用户资料，更新本地数据的接口，根据通讯号
        config.USER_PHOTO_LIST = apiUrl + "user/photo/list";// 获取相册列表
        config.USER_QUERY = apiUrl + "user/query";// 查询用户列表
        config.USER_NEAR = apiUrl + "nearby/user";// 查询搜索列表
        config.PUBLIC_SEARCH = apiUrl + "public/search/list";// 公众号搜索列表
        config.USER_SET_PRIVACY_SETTING = apiUrl + "/user/settings/update";// 设置用户隐私设置
        config.USER_GET_PRIVACY_SETTING = apiUrl + "/user/settings";// 查询用户隐私设置
        config.USER_DESCRIPTION = apiUrl + "user/update";// 查询用户签名

        config.USER_GET_BAND_ACCOUNT = apiUrl + "/user/getBindInfo";// 查询用户绑定设置
        config.USER_UN_BAND_ACCOUNT = apiUrl + "/user/unbind";// 设置用户绑定设置
        config.AUTHOR_CHECK = apiUrl + "open/codeAuthorCheck";// 授权弹窗url

        config.USER_GET_PUBLIC_MENU = apiUrl + "public/menu/list";// 获取公众号菜单，需要userType = 2 才能获取
        config.USER_DEL_CHATMESSAGE = apiUrl + "tigase/deleteMsg";// 删除某条聊天记录

        /* 好友 */
        config.FRIENDS_ATTENTION_LIST = apiUrl + "friends/attention/list";// 获取关注列表
        config.FRIENDS_BLACK_LIST = apiUrl + "friends/blacklist";// 获取黑名单列表

        config.FRIENDS_ATTENTION_ADD = apiUrl + "friends/attention/add";// 加关注 || 直接成为好友
        config.ADD_FRIENDS = apiUrl + "friends/add";// 同意成为好友
        config.FRIENDS_BLACKLIST_ADD = apiUrl + "friends/blacklist/add";// 拉黑
        config.FRIENDS_BLACKLIST_DELETE = apiUrl + "friends/blacklist/delete";// 取消拉黑
        config.FRIENDS_ATTENTION_DELETE = apiUrl + "friends/attention/delete";// 取消关注
        config.FRIENDS_DELETE = apiUrl + "friends/delete";// 删除好友

        config.FRIENDS_REMARK = apiUrl + "friends/remark";// 备注好友
        config.FRIENDS_UPDATE = apiUrl + "friends/update";// 消息保存天数
        config.FRIENDS_NOPULL_MSG = apiUrl + "friends/update/OfflineNoPushMsg";// 消息免打扰/阅后即焚/置顶聊天

        /* 群聊 */
        config.ROOM_ADD = apiUrl + "room/add";// 创建群组
        config.ROOM_JOIN = apiUrl + "room/join";// 加入群组
        config.ROOM_MEMBER_UPDATE = apiUrl + "room/member/update";// 添加成员
        config.ROOM_DELETE = apiUrl + "room/delete";// 删除群组
        config.ROOM_MEMBER_DELETE = apiUrl + "room/member/delete";// 删除成员 || 退出群组
        config.ROOM_TRANSFER = apiUrl + "room/transfer";// 转让群组
        config.ROOM_COPY = apiUrl + "room/copyRoom";//群复制

        config.ROOM_GET = apiUrl + "room/get";// 获取群组
        config.ROOM_LIST = apiUrl + "room/list";// 获取群组列表
        config.ROOM_MEMBER_GET = apiUrl + "room/member/get";// 获取成员
        config.ROOM_MEMBER_LIST = apiUrl + "room/member/getMemberListByPage";// 获取成员列表
        config.ROOM_MEMBER_SEARCH = apiUrl + "room/member/list";// 群成员模糊搜索
        config.ROOM_LIST_HIS = apiUrl + "room/list/his";// 获取某个用户已加入的房间列表
        config.ROOM_GET_ROOM = apiUrl + "room/getRoom";// 获取自己的成员信息以及群属性
        config.ROOM_UPDATE = apiUrl + "room/update";// 设置群组
        config.ROOM_MANAGER = apiUrl + "room/set/admin";// 指定管理员
        config.ROOM_UPDATE_ROLE = apiUrl + "room/setInvisibleGuardian";// 指定隐身人，监控人，
        config.ROOM_EDIT_NOTICE = apiUrl + "room/updateNotice";// 编辑群公告
        config.ROOM_DELETE_NOTICE = apiUrl + "room/notice/delete";// 删除群公告
        config.ROOM_LOCATION_QUERY = apiUrl + "room/location/query";// 面对面建群查询
        config.ROOM_LOCATION_JOIN = apiUrl + "room/location/join";// 面对面建群加入
        config.ROOM_LOCATION_EXIT = apiUrl + "room/location/exit";// 面对面建群退出

        config.ROOM_DISTURB = apiUrl + "room/member/setOfflineNoPushMsg";// 消息免打扰/置顶聊天

        config.UPLOAD_MUC_FILE_ADD = apiUrl + "room/add/share";// 上传群文件
        config.UPLOAD_MUC_FILE_FIND_ALL = apiUrl + "room/share/find";// 查询所有群文件
        config.UPLOAD_MUC_FILE_FIND = apiUrl + "room/share/find";// 查询单个群文件
        config.UPLOAD_MUC_FILE_DEL = apiUrl + "room/share/delete";// 删除单个群文件

        config.OPEN_GET_HELPER_LIST = apiUrl + "open/getHelperList";// 添加群助手
        config.ROOM_ADD_GROUP_HELPER = apiUrl + "room/addGroupHelper";// 添加群助手
        config.ROOM_DELETE_GROUP_HELPER = apiUrl + "room/deleteGroupHelper";// 移除群助手
        config.ROOM_QUERY_GROUP_HELPER = apiUrl + "room/queryGroupHelper";// 查询群助手
        config.ROOM_ADD_AUTO_RESPONSE = apiUrl + "room/addAutoResponse";// 添加自动回复
        config.ROOM_UPDATE_AUTO_RESPONSE = apiUrl + "room/updateAutoResponse";// 修改自动回复
        config.ROOM_DELETE_AUTO_RESPONSE = apiUrl + "room/deleteAutoResponse";// 删除自动回复

        /* 附近 */
        config.NEARBY_USER = apiUrl + "nearby/user";// 获取附近的用户

        /* 商务圈 */
        config.USER_CIRCLE_MESSAGE = apiUrl + "b/circle/msg/user/ids";// 获取某个人的商务圈消息
        config.DOWNLOAD_CIRCLE_MESSAGE = apiUrl + "b/circle/msg/ids"; // 下载商务圈消息
        config.MSG_ADD_URL = apiUrl + "b/circle/msg/add";// 发布一条公共消息的接口
        config.MSG_LIST = apiUrl + "b/circle/msg/list";// 获取公共消息的接口
        config.MSG_USER_LIST = apiUrl + "b/circle/msg/user";// 获取某个用户的最新公共消息
        config.MSG_GETS = apiUrl + "b/circle/msg/gets";// 根据IDS批量获取公共消息的接口(我的商务圈使用)
        config.MSG_GET = apiUrl + "b/circle/msg/get";// 根据ID获取公共消息
        config.CIRCLE_MSG_DELETE = apiUrl + "b/circle/msg/delete";// 删除一条商务圈消息
        config.MSG_PRAISE_ADD = apiUrl + "b/circle/msg/praise/add";// 赞
        config.MSG_PRAISE_DELETE = apiUrl + "b/circle/msg/praise/delete";// 取消赞
        config.MSG_PRAISE_LIST = apiUrl + "b/circle/msg/praise/list";// 点赞分页加载的接口，
        config.MSG_COLLECT_DELETE = apiUrl + "/b/circle/msg/deleteCollect";// 删除收藏
        config.CIRCLE_MSG_LATEST = apiUrl + "b/circle/msg/latest";// 最新人才榜
        config.CIRCLE_MSG_HOT = apiUrl + "b/circle/msg/hot";// 最热人才榜
        config.MSG_COMMENT_ADD = apiUrl + "b/circle/msg/comment/add";// 增加一条评论
        config.MSG_COMMENT_DELETE = apiUrl + "b/circle/msg/comment/delete";// 删除一条评论
        config.MSG_COMMENT_LIST = apiUrl + "b/circle/msg/comment/list";//返回评论列表
        config.FILTER_USER_CIRCLE = apiUrl + "user/filterUserCircle";// 生活圈屏蔽某人

        /* 直播 */
        config.GET_LIVE_ROOM_LIST = apiUrl + "liveRoom/list";// 获取直播间列表
        config.CREATE_LIVE_ROOM = apiUrl + "liveRoom/create";// 创建直播间
        config.JOIN_LIVE_ROOM = apiUrl + "liveRoom/enterInto";// 加入直播间
        config.EXIT_LIVE_ROOM = apiUrl + "liveRoom/quit";// 退出直播间
        config.DELETE_LIVE_ROOM = apiUrl + "liveRoom/delete";// 删除直播间
        config.LIVE_ROOM_DETAIL = apiUrl + "liveRoom/get";// 直播间详情
        config.LIVE_ROOM_MEMBER_LIST = apiUrl + "liveRoom/memberList";// 获取直播间成员列表
        config.LIVE_ROOM_DANMU = apiUrl + "liveRoom/barrage";// 发送弹幕
        config.GET_LIVE_GIFT_LIST = apiUrl + "liveRoom/giftlist";// 得到礼物列表
        config.LIVE_ROOM_GIFT = apiUrl + "liveRoom/give";// 发送礼物

        config.LIVE_ROOM_PRAISE = apiUrl + "liveRoom/praise";// 发送点赞

        config.LIVE_ROOM_GET_IDENTITY = apiUrl + "liveRoom/get/member";// 获取身份信息
        config.LIVE_ROOM_UPDATE = apiUrl + "liveRoom/update";// 修改直播间
        config.LIVE_ROOM_SET_MANAGER = apiUrl + "liveRoom/setmanage";// 设置管理员
        config.LIVE_ROOM_SHUT_UP = apiUrl + "liveRoom/shutup";// 禁言/取消禁言
        config.LIVE_ROOM_KICK = apiUrl + "liveRoom/kick";// 踢人
        config.LIVE_ROOM_STATE = apiUrl + "liveRoom/start";// 正在直播 || 未开启直播
        config.LIVE_GET_LIVEROOM = apiUrl + "liveRoom/getLiveRoom";// 获取自己的直播间

        config.EMPTY_SERVER_MESSAGE = apiUrl + "tigase/emptyMyMsg";// 清空与某人的聊天记录

        /* 抖音 */
        config.GET_TRILL_LIST = apiUrl + "b/circle/msg/pureVideo";// 获取抖音视频列表
        config.GET_MUSIC_LIST = apiUrl + "music/list";// 获取抖音音乐列表
        config.TRILL_ADD_FORWARD = apiUrl + "b/circle/msg/forward/add";// 转发数量统计
        config.TRILL_ADD_PLAY = apiUrl + "b/circle/msg/playAmount/add";// 观看数量统计

        // yeepay
        config.YOP_OPEN_SEND_AUTH_CODE = apiUrl + "yopPay/randcode/sendSms";// 用户开户时获取手机验证码
        config.YOP_OPEN_ACCOUNT = apiUrl + "yopPay/openAccount";// 用户开户
        config.YOP_MONEY = apiUrl + "yopPay/queryAccountInfo";// 查询钱包
        config.YOP_RECHARGE = apiUrl + "yopPay/recharge";// 发起充值
        config.YOP_WITHDRAW = apiUrl + "yopPay/withdraw";// 发起提现
        config.YOP_BIND = apiUrl + "yopPay/queryCard";// 绑定银行卡
        config.YOP_SECURE = apiUrl + "yopPay/managePassword";// 安全设置
        config.YOP_TRANSFER = apiUrl + "yopPay/transfer";// 转账
        config.YOP_SEND_RED = apiUrl + "yopPay/sendRedPacket";// 发红包
        config.YOP_QUERY_RED = apiUrl + "yopPay/queryRedPacketPayment";// 查红包支付成功情况
        config.YOP_QUERY_TRANSFER = apiUrl + "yopPay/queryTransfer";// 查转账支付成功情况
        config.YOP_QUERY_RECHARGE = apiUrl + "yopPay/queryRecharge";// 查转账充值成功情况
        config.YOP_QUERY_WITHDRAW = apiUrl + "yopPay/queryWithdraw";// 查提现成功情况
        config.YOP_ACCEPT_TRANSFER = apiUrl + "yopPay/receiveTransfer";// 收转账
        config.YOP_ACCEPT_RED = apiUrl + "yopPay/openRedPacket";// 收红包
        config.YOP_RECORD_RED = apiUrl + "yopPay/getYopWalletBill";// 获取消费记录列表
        /* 红包相关的URL*/
        config.REDPACKET_SEND = apiUrl + "redPacket/sendRedPacket/v2"; // 发送红包
        config.REDPACKET_OPEN = apiUrl + "redPacket/openRedPacket"; // 打开红包
        config.RECIVE_REDPACKET_LIST_GET = apiUrl + "redPacket/getRedReceiveList"; // 获得接收的红包
        config.SEND_REDPACKET_LIST_GET = apiUrl + "redPacket/getSendRedPacketList";// 获得发送的红包
        config.RENDPACKET_GET = apiUrl + "redPacket/getRedPacket"; // 获得红包详情
        config.RENDPACKET_REPLY = apiUrl + "redPacket/reply"; // 回复红包
        config.TRANSACTION_RECORD = apiUrl + "friend/consumeRecordList";// 好友交易记录明细
        config.CONSUMERECORD_GET = apiUrl + "user/consumeRecord/list"; // 获取消费记录列表
        config.CONSUMERECORD_GET_NEW = apiUrl + "consumeRecord/queryConsumeRecordCount"; // 获取消费记录列表[新]
        config.RECHARGE_ADD = apiUrl + "user/Recharge";// 余额充值
        config.RECHARGE_GET = apiUrl + "user/getUserMoeny";// 余额查询

        config.SKTRANSFER_SEND_TRANSFER = apiUrl + "skTransfer/sendTransfer/v1";// 转账
        config.SKTRANSFER_GET_TRANSFERINFO = apiUrl + "skTransfer/getTransferInfo";// 获取转账信息
        config.SKTRANSFER_RECEIVE_TRANSFER = apiUrl + "skTransfer/receiveTransfer";// 接受转账
        config.PAY_CODE_PAYMENT = apiUrl + "pay/codePayment/v1";// 向展示付款码的用户收钱
        config.PAY_CODE_RECEIPT = apiUrl + "pay/codeReceipt/v1";// 向展示收款码的用户付钱

        config.VX_RECHARGE = apiUrl + "user/recharge/getSign";// 微信/支付宝充值
        config.VX_UPLOAD_CODE = apiUrl + "user/bind/wxcode/v1";  // 上传用户Code
        config.VX_GET_OPEN_ID = apiUrl + "user/getWxOpenId";  // 上传用户Code
        config.VX_TRANSFER_PAY = apiUrl + "transfer/wx/pay/v1";  // 微信取现
        config.ALIPAY_AUTH = apiUrl + "user/bind/getAliPayAuthInfo";  // 支付宝授权
        config.ALIPAY_BIND = apiUrl + "user/bind/aliPayUserId/v1";  // 支付宝绑定
        config.ALIPAY_TRANSFER = apiUrl + "alipay/transfer/v1";  // 支付宝取现

        config.PAY_GET_ORDER_INFO = apiUrl + "pay/getOrderInfo";  // 获取订单信息
        config.PAY_PASSWORD_PAYMENT = apiUrl + "pay/passwordPayment/v1";  // 输入密码后支付接口

        /* 扫码充值 */
        config.MANUAL_PAY_GET_RECEIVER_ACCOUNT = apiUrl + "manual/pay/getReceiveAccount";  // 获取转账人信息
        config.MANUAL_PAY_RECHARGE = apiUrl + "manual/pay/recharge";  // 提交充值申请
        config.MANUAL_PAY_WITHDRAW = apiUrl + "manual/pay/withdraw";// 提交提现申请
        config.MANUAL_PAY_ADD_WITHDRAW_ACCOUNT = apiUrl + "manual/pay/addWithdrawAccount";// 添加提现账号
        config.MANUAL_PAY_DELETE_WITHDRAW_ACCOUNT = apiUrl + "manual/pay/deleteWithdrawAccount";// 删除提现账号列表
        config.MANUAL_PAY_UPDATE_WITHDRAW_ACCOUNT = apiUrl + "manual/pay/updateWithdrawAccount";// 修改提现账号列表
        config.MANUAL_PAY_GET_WITHDRAW_ACCOUNT_LIST = apiUrl + "manual/pay/getWithdrawAccountList";// 获取提现账号列表

        /* 组织架构相关 */
        config.AUTOMATIC_SEARCH_COMPANY = apiUrl + "org/company/getByUserId";// 自动查找公司
        config.CREATE_COMPANY = apiUrl + "org/company/create";// 创建公司
        config.SET_COMPANY_MANAGER = apiUrl + "org/company/setManager";// 指定管理者
        config.MODIFY_COMPANY_NAME = apiUrl + "org/company/modify";// 修改公司名称
        config.CHANGE_COMPANY_NOTIFICATION = apiUrl + "org/company/changeNotice";// 更改公司公告
        config.SEARCH_COMPANY = apiUrl + "org/company/search";// 查找公司
        config.DELETE_COMPANY = apiUrl + "org/company/delete";// 删除公司
        config.CREATE_DEPARTMENT = apiUrl + "org/department/create";// 创建部门
        config.MODIFY_DEPARTMENT_NAME = apiUrl + "org/department/modify";// 修改部门名称
        config.DELETE_DEPARTMENT = apiUrl + "org/department/delete";// 删除部门
        config.ADD_EMPLOYEE = apiUrl + "org/employee/add";// 添加员工
        config.DELETE_EMPLOYEE = apiUrl + "org/employee/delete"; // 删除员工
        config.MODIFY_EMPLOYEE_DEPARTMENT = apiUrl + "org/employee/modifyDpart";// 更改员工部门
        config.COMPANY_LIST = apiUrl + "org/company/list";// 公司列表
        config.DEPARTMENT_LIST = apiUrl + "org/department/list"; // 部门列表
        config.EMPLOYEE_LIST = apiUrl + "org/employee/list";// 员工列表
        config.GET_COMPANY_DETAIL = apiUrl + "org/company/get";// 获取公司详情
        config.GET_DEPARTMENT_DETAIL = apiUrl + "org/employee/get";// 获取员工详情
        config.GET_EMPLOYEE_DETAIL = apiUrl + "org/dpartment/get"; // 获取部门详情
        config.GET_EMPLOYEE_NUMBER_OF_COMPANY = apiUrl + "org/company/empNum"; // 获取公司员工人数
        config.EXIT_COMPANY = apiUrl + "org/company/quit";// 获取部门员工人数
        config.CHANGE_EMPLOYEE_IDENTITY = apiUrl + "org/employee/modifyPosition";// 修改职位

        /* 标签相关 */
        config.FRIENDGROUP_LIST = apiUrl + "friendGroup/list";
        config.FRIENDGROUP_ADD = apiUrl + "friendGroup/add";
        config.FRIENDGROUP_DELETE = apiUrl + "friendGroup/delete";
        config.FRIENDGROUP_UPDATE = apiUrl + "friendGroup/update";
        config.FRIENDGROUP_UPDATEGROUPUSERLIST = apiUrl + "friendGroup/updateGroupUserList";
        config.FRIENDGROUP_UPDATEFRIEND = apiUrl + "friendGroup/updateFriend";

        /* 漫游 */
        config.USER_OFFLINE_OPERATION = apiUrl + "user/offlineOperation";
        config.GET_LAST_CHAT_LIST = apiUrl + "tigase/getLastChatList";
        config.GET_CHAT_MSG = apiUrl + "tigase/shiku_msgs";
        config.GET_CHAT_MSG_MUC = apiUrl + "tigase/shiku_muc_msgs";

        /* 讲课 */
        config.USER_ADD_COURSE = apiUrl + "user/course/add";     // 添加课程
        config.USER_QUERY_COURSE = apiUrl + "user/course/list";  // 查询课程
        config.USER_EDIT_COURSE = apiUrl + "user/course/update"; // 修改课程
        config.USER_DEL_COURSE = apiUrl + "user/course/delete";  // 删除课程
        config.USER_COURSE_DATAILS = apiUrl + "user/course/get"; // 获取课程

        /* 收藏相关 */
        config.Collection_ADD = apiUrl + "user/emoji/add"; // 添加收藏
        config.Collection_REMOVE = apiUrl + "user/emoji/delete"; // 删除收藏
        config.Collection_LIST = apiUrl + "user/emoji/list"; // 表情列表
        config.Collection_LIST_OTHER = apiUrl + "user/collection/list"; // 收藏列表

        config.USER_REPORT = apiUrl + "user/report";// 举报用户 || 群组
        config.UPLOAD_COPY_FILE = apiUrl + "upload/copyFile";// 服务端将文件拷贝一份，更换另外一个url地址返回
        config.ADDRESSBOOK_UPLOAD = apiUrl + "addressBook/upload";// 上传本地联系人
        config.ADDRESSBOOK_GETALL = apiUrl + "addressBook/getAll";// 查询通讯录好友
        config.ADDENTION_BATCH_ADD = apiUrl + "friends/attention/batchAdd";// 联系人内加好友 不需要验证

        /* 登出 */
        config.USER_LOGOUT = apiUrl + "user/logout";
        config.USER_OUTTIME = apiUrl + "user/outtime";

        // 集群 获取meetUrl
        config.OPEN_MEET = apiUrl + "user/openMeet";

        // 小米推送
        config.configMi = apiUrl + "user/xmpush/setRegId";
        // 华为推送
        config.configHw = apiUrl + "user/hwpush/setToken";
        // 极光推送
        config.configJg = apiUrl + "user/jPush/setRegId";
        // vivo推送接口
        config.configVi = apiUrl + "user/VIVOPush/setPushId";
        // oppo推送接口
        config.configOp = apiUrl + "user/OPPOPush/setPushId";
        // firebase推送接口
        config.configFcm = apiUrl + "user/fcmPush/setToken";
        config.configFcm = apiUrl + "user/fcmPush/setToken";
        // 魅族推送接口
        config.configMz = apiUrl + "user/MZPush/setPushId";

        config.SDK_OPEN_AUTH_INTERFACE = apiUrl + "open/authInterface";
        // 获取服务器时间接口，用于校准时间，
        config.GET_CURRENT_TIME = apiUrl + "getCurrentTime";
        config.URL_CHECK = apiUrl + "user/checkReportUrl";
    }

    private static void initOthersUrls(AppConfig config) {
        String uploadUrl = config.uploadUrl;
        String dowmLoadUrl = config.downloadAvatarUrl;
        Log.e("dowmLoadUrl", "initOthersUrls: " + dowmLoadUrl);

        config.UPLOAD_URL = uploadUrl + "upload/UploadServlet";// 上传图片接口
        config.UPLOAD_AUDIO_URL = uploadUrl + "upload/UploadServlet";// 上传语音接口
        config.AVATAR_UPLOAD_URL = uploadUrl + "upload/UploadAvatarServlet";// 上传头像接口
        config.ROOM_UPDATE_PICTURE = uploadUrl + "upload/GroupAvatarServlet";
        // downloadAvatarUrl
        config.AVATAR_ORIGINAL_PREFIX = dowmLoadUrl + "avatar/o";// 头像原图前缀地址
        config.AVATAR_THUMB_PREFIX = dowmLoadUrl + "avatar/t";// 头像缩略图前缀地址
    }
}
