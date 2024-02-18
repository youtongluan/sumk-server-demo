package org.test.web;

import java.io.IOException;

import org.yx.annotation.Bean;
import org.yx.annotation.http.Upload;
import org.yx.annotation.http.Web;
import org.yx.conf.AppInfo;
import org.yx.http.WebUtil;
import org.yx.http.handler.MultipartItem;
import org.yx.util.IOUtil;

@Bean
public class UploadAction {

	/*
	 * 添加Upload就表示支持文件上传。它的类型必须是multipart/form-data。
	 * 其中名为param的part会被解析成参数。
	 * 其它的需要通过WebUtil来获取.
	 * aa.postman_collection.json文件是postman的测试文件
	 * http://localhost:8081/upload/uploadFile
	 */
	@Web
	@Upload
	public String uploadFile(String name, Integer age) throws IOException {
//		List<MultipartItem> parts=WebUtil.getMultiParts();
		System.out.println(name);
		MultipartItem part=WebUtil.getPart("file");
		byte[] bs=IOUtil.readAllBytes(part.getInputStream(), true);
		System.out.println(new String(bs,AppInfo.UTF8));
		return "上传成功";
	}
	
	
}
