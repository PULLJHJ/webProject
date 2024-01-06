package com.web.project.rank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.project.board.service.BoardInfoService;
import com.web.project.deal.service.DealInfoService;
import com.web.project.rank.mapper.RankInfoMapper;
import com.web.project.rank.vo.RankInfoVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RankInfoService {

	private final RankInfoMapper rankInfoMapper;
	private final BoardInfoService boardService;
	private final DealInfoService dealInfoService;

	public int insertSellerRankInfo(RankInfoVO rank) {
		return rankInfoMapper.insertSellerRankInfo(rank);
	}

	public int insertBuyerRankInfo(RankInfoVO rank) {
		return rankInfoMapper.insertBuyerRankInfo(rank);
	}


	public float selectAverageRankInfo(int uiNum) {
		return rankInfoMapper.selectAverageRankInfo(uiNum);
	}


	public int selectCountRankInfo(int uiNum) {
		return rankInfoMapper.selectCountRankInfo(uiNum);
	}

	 public List<RankInfoVO> getReviewInfo(int uiNum){
	        return rankInfoMapper.selectCountRivewInfo(uiNum);
	    }

	}
