package com.tunnel.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tunnel.vo.FileUploadReturnVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping
public class FileUploadController extends BaseController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public FileUploadReturnVo upload(@RequestParam("file_base64") MultipartFile file) throws Exception {
		log.info("uploading file ... ");
		file.getContentType();
		return FileUploadReturnVo.builder().success(true).path("").build();
	}
}
