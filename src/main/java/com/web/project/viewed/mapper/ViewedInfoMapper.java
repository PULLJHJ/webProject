package com.web.project.viewed.mapper;

import java.util.List;

import com.web.project.viewed.vo.ViewedInfoVO;

public interface ViewedInfoMapper {
	int InsertViewedInfo(ViewedInfoVO viewed); // 최근 방문 게시물 추가
	List<ViewedInfoVO> SelectViewedInfos(ViewedInfoVO viewed); // 최근 방문 게시물 리스트
}
