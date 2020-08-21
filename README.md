##API说明（在此说明下的接口已经部署到服务器上，前端可以直接调用）
###服务端地址
https://hypherd.com:443
###一、登录`/api/user/login`
数据格式为json数据，发送请求body{"code":"wkc520wkc520"}详见https://developers.weixin.qq.com/miniprogram/dev/api/open-api/login/wx.login.html




##数据库说明
###一、`post`表
####id 唯一标识符
#### userid 发布人的唯一标识符
####createtime 视频发布时间 字符串，格式为"yyyy-MM-dd HH:mm:ss"
####title 标题
#### coverUrl 视频封面url
#### playNum 点击量
#### commentNum 评论数
#### likes 点赞量
#### videoUrl 视频url
#### info 视频简介
#### class 板块分类
#### subClass 子版块分类

###二、`user`表
#### id 唯一标识符
####`openid` varchar(255) NOT NULL,
####`sessionkey` varchar(255) NOT NULL,
openid和sessionkey详见
前端：https://developers.weixin.qq.com/miniprogram/dev/api/open-api/login/wx.login.html和
后端：https://developers.weixin.qq.com/miniprogram/dev/api-backend/open-api/login/auth.code2Session.html
#### fans 粉丝数
#### focus 关注数

###三、`danmu`表
#### id 唯一标识符
#### postid 视频唯一标识符
#### userid 发弹幕的用户唯一标识符
#### text 弹幕内容
#### color 颜色，字符串
#### likes 弹幕喜爱数
#### time 弹幕在视频中出现的时间，整数，单位为s

###四、`collect`表
#### id 唯一标识符
#### userid 用户唯一标识符
#### postid 发布的唯一标识符
#### type 字符串，collect表示为收藏，watch表示为观看
#### time 上述type行为发生的时间，字符串，格式为"yyyy-MM-dd HH:mm:ss"



