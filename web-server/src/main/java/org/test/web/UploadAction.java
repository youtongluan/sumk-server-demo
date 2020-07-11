package org.test.web;

import org.yx.annotation.Bean;
import org.yx.annotation.http.Upload;
import org.yx.annotation.http.Web;

@Bean
public class UploadAction {

	/*
	 * 添加Upload就表示支持文件上传。它的类型必须是multipart/form-data。
	 * 其中名为param的part会被解析成参数。
	 * 其它的需要通过WebUtil来获取
	 */
	@Web
	@Upload
	public void upload(String name, Integer age) {
//		List<MultipartItem> parts=WebUtil.getMultiParts();
//		MultipartItem part=WebUtil.getPart("file");
	}
	
	
}
