package com.web.project.deal.mapper;

import com.web.project.deal.vo.DealInfoVO;

public interface DealInfoMapper {
	DealInfoVO SelectDealInfoBySeller(int sellerUiNum); // 판매자 번호로 거래정보 조회

	DealInfoVO SelectDealInfoByBuyer(int buyerUiNum); // 구매자 번호로 거래정보 조회
	
	DealInfoVO selectBiNumByDiNum(int diNum);

	int countDealInfoByDiStat(int buyerUiNum);

	int insertDealInfoWithChatInfo(DealInfoVO deal); // 거래정보 입력

	int updateBuyerDiStat(int diNum);
}
