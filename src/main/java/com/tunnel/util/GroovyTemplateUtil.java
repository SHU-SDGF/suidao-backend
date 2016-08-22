package com.tunnel.util;

import groovy.text.SimpleTemplateEngine;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.codehaus.groovy.control.CompilationFailedException;

import com.tunnel.enums.EmailTemplateTypeEnum;

public class GroovyTemplateUtil {
	
	private static String TEMPLATE_FOLDER_NAME = "emailTemplates";

	public static String parseTemplate(EmailTemplateTypeEnum templateType, Map<String, Object> binding)
			throws CompilationFailedException, ClassNotFoundException, IOException {
		URL tpl = templateType.getClass().getClassLoader()
				.getResource(TEMPLATE_FOLDER_NAME + File.separator + templateType.getTemplateFileName());
		return new SimpleTemplateEngine().createTemplate(tpl).make(binding).toString();
	}
}
