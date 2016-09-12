package com.tunnel.web.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tunnel.config.AppProperties;
import com.tunnel.util.WebUtils;
import com.tunnel.vo.FileUploadReturnVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping
public class FileUploadController extends BaseController {

	@Autowired
	private AppProperties appProperties;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public FileUploadReturnVo upload(@RequestParam("file") MultipartFile file) throws Exception {
		log.info("uploading file ... ");
		file.getContentType();

		String relvDir = "/" + WebUtils.loggedInUser().getLoginId() + "/";
		File absoluteDir = new File(appProperties.getFileUploadBasePath() + relvDir);
		if (!absoluteDir.exists()) {
			absoluteDir.mkdirs();
		}

		String fileRelvPath = relvDir + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())
				+ file.getOriginalFilename();
		File dest = new File(appProperties.getFileUploadBasePath() + fileRelvPath);
		file.transferTo(dest);
		return FileUploadReturnVo.builder().success(true).path(fileRelvPath).build();
	}

}
