/**
 * @Title: IndentifyGarbageUtil.java
 * @Package com.edrop.util
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 * @version V1.0
 */
package com.edrop.utils;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import static org.apache.commons.codec.binary.Base64.encodeBase64;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * @ClassName: IndentifyGarbageUtil
 * @Description: 
 * @author 13071
 * @date 2019年11月28日
 *
 */
public class IndentifyGarbageUtil {
	
	public static String indentifyGarbage(File file) {
		String res = "";
		//API产品路径
//      String host = "http://rubbish.market.alicloudapi.com";
      String host = "http://api.tianapi.com";
//      String path = "/ai_market/ai_image_universal/rubbish/v1";
      String path = "/txapi/imglajifenlei/";
      String method = "POST";
      //阿里云APPCODE
//      String appcode = "4aa700a0352045e9a00932de2d27ded0";
      Map<String, String> headers = new HashMap<String, String>();
//      headers.put("Authorization", "APPCODE " + appcode);
      //UUID采用当前程序运行时间，用于防止重放攻击，开发者可根据自己需求，自定义字符串
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String UUID = df.format(new Date());
      headers.put("X-Ca-Nonce", UUID);
      //根据API的要求，定义相对应的Content-Type
      headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
      Map<String, String> querys = new HashMap<String, String>();
      Map<String, String> bodys = new HashMap<String, String>();

      //内容数据类型，如：0，则表示BASE64编码；1，则表示图像文件URL链接        
      //启用BASE64编码方式进行识别
      //内容数据类型是BASE64编码
//      String imgFile = "C:\\Users\\13071\\Desktop\\test6.png";
      String imgBase64 = "";
      try {
//    	  byte[] content = picInfo.getBytes();
//          File file = new File(img);
          byte[] content = new byte[(int) file.length()];
          FileInputStream finputstream = new FileInputStream(file);
          finputstream.read(content);
          finputstream.close();
          imgBase64 = new String(encodeBase64(content));
      } catch (IOException e) {
          e.printStackTrace();
          return null;
      }
      bodys.put("key", "db3c29cafd55293212b9ae152416a120");
      bodys.put("img", imgBase64);
      bodys.put("mode", "1");
      
      //启用URL方式进行识别
      //内容数据类型是图像文件URL链接
//      bodys.put("IMAGE", "图片URL链接");
//      bodys.put("IMAGE_TYPE", "1");
      
      try {
          /**
          * 重要提示如下:
          * HttpUtils请从
          * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
          * 下载
          *
          * 相应的依赖请参照
          * https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
          */
          HttpResponse response = HttpUtil.doPost(host, path, method, headers, querys, bodys);
//          System.out.println(response.toString());
          //获取response的body
//          System.out.println(EntityUtils.toString(response.getEntity()));
          res = EntityUtils.toString(response.getEntity());
         } catch (Exception e) {
              e.printStackTrace();
         }
      
      	return res;
	}
}
