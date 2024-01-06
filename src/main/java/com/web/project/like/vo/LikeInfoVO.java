package com.web.project.like.vo;

import java.util.List;

import com.web.project.file.vo.FileInfoVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LikeInfoVO {
	private int liNum;
	private int uiNum;
	private int biNum;
	private String credat;
	private String cretim;
	private String biTitle;
	private String biAddr;
	private String biStat;
	private String biPrice;
	private List<FileInfoVO> files;
	private int page; // 현재 페이지
	private int start; // 시작 번호
	private int end; // 끝 번호
	private int pageSize; // 보여질 게시물의 개수 (한페이지 크기)
}
