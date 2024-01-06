package com.web.project.file.vo;

import org.springframework.web.multipart.MultipartFile;

import com.web.project.type.Status;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileInfoVO {
	private int fiNum;
	private int biNum;
	private String fiPath;
	private String fiName;
	private int fiSeq;
	private MultipartFile file;
	private Status status;
}