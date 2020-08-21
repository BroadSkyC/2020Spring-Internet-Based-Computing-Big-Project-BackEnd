package com.example.rickymysql.util;


import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONException;
import org.json.JSONStringer;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginCheck {
    public static String[] getIdAndKey(String code){
        String urlhead="https://api.weixin.qq.com/sns/jscode2session?appid=wx8d4ecb0adaaa3fdb&secret=af9686f20ea423390f75a0ebfa7f3318&js_code=";
        String urltail="&grant_type=authorization_code";
        String result=getJSON(urlhead,urltail,code);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(result);
            String openid=jsonNode.get("openid").toString();
            String session_key=jsonNode.get("session_key").toString();
            String[] answer=new String[2];
            answer[0]=openid;
            answer[1]=session_key;
            return answer;
        }catch (Exception e){
            return null;
        }
    }
    public static String getJSON(String urlhead,String urltail,String param){
        String result="";
        BufferedReader in=null;
        try {
            String urlNameString = urlhead+param+urltail;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
    public static String post(String strURL, String params) {
        BufferedReader reader = null;
        try {
            URL url = new URL(strURL);// 创建连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestMethod("POST"); // 设置请求方式
            // connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式<br data-filtered="filtered">、　　　　　　//因为要登陆才可以执行请求，所以这里要带cookie的header
            connection.setRequestProperty("Cookie", "geli-session=41b6d86db1e97df5:-60813064:16d0571e3e8:-3a58377431669b192d08; c=58ydwry; u=58zqg8z; pcsuv=1482230765738.a.46958170; u4ad=4031lfgby; UM_distinctid=16be539fa796b9-099f04a8a5445d-4144032b-1fa400-16be539fa7a7d3; visitedfid=22035D16260D14152; gr_user_id=b2a6251c-dddb-4502-91f9-0b6f10ccb260; favCar=%E5%A5%A5%E8%BF%AAA3_9550%7C%E5%A5%A5%E8%BF%AAA8L_7%7C%E7%A6%8F%E5%85%8B%E6%96%AFActive_25101%7C%E8%BD%A9%E9%80%B8_3996%7C%E5%88%9B%E7%95%8C_24483; locationWap=%7B%22expires%22%3A1568884707863%2C%22city%22%3A%22%E5%93%88%E5%B0%94%E6%BB%A8%E5%B8%82%22%2C%22cityUser%22%3A%22%E5%93%88%E5%B0%94%E6%BB%A8%E5%B8%82%22%2C%22cityCode%22%3A%22230100%22%2C%22proCode%22%3A%22230000%22%2C%22cityCodeUser%22%3A%22230100%22%2C%22proCodeUser%22%3A%22230000%22%7D; AplocationWap=%7B%22regionId%22%3A187%2C%20%22regionName%22%3A%22%E5%93%88%E5%B0%94%E6%BB%A8%22%7D; pcLocate=%7B%22proCode%22%3A%22440000%22%2C%22pro%22%3A%22%E5%B9%BF%E4%B8%9C%E7%9C%81%22%2C%22cityCode%22%3A%22441900%22%2C%22city%22%3A%22%E4%B8%9C%E8%8E%9E%E5%B8%82%22%2C%22dataType%22%3A%22user%22%2C%22expires%22%3A1571888929008%7D; pcautoLocate=%7B%22proId%22%3A5%2C%22cityId%22%3A6%2C%22url%22%3A%22%2F%2Fwww.pcauto.com.cn%2Fqcbj%2Fdg%2F%22%2C%22dataTypeAuto%22%3A%22user%22%7D; PClocation=6; pcuvdata=lastAccessTime=1570869719999|visits=289; channel=9396");
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
            connection.connect();
            //一定要用BufferedReader 来接收响应， 使用字节来接收响应的方法是接收不到内容的
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
            out.append(params);
            out.flush();
            out.close();
            // 读取响应
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            String res = "";
            while ((line = reader.readLine()) != null) {
                res += line;
            }
            reader.close();
            return res;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error"; // 自定义错误信息
    }






}
