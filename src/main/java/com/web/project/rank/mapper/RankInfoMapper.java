package com.web.project.rank.mapper;

import java.util.List;

import com.web.project.rank.vo.RankInfoVO;

public interface RankInfoMapper {

	int insertSellerRankInfo(RankInfoVO rank);
	int insertBuyerRankInfo(RankInfoVO rank);
	float selectAverageRankInfo(int uiNum);
	int selectCountRankInfo(int uiNum);
	List<RankInfoVO> selectCountRivewInfo(int uiNum);
}
