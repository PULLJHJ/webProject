package com.web.project.file.mapper;

import java.util.List;

import com.web.project.file.vo.FileInfoVO;

public interface FileInfoMapper {
	int insertFileInfo(FileInfoVO file); // 파일 등록
	int updateFileInfos(FileInfoVO file); // 파일 수정
	int deleteFileInfo(int fiNum); // 파일 삭제
	List<FileInfoVO> selectFileInfos(int biNum); // 파일 리스트
}