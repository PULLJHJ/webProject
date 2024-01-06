package com.web.project.rank.vo;

import com.web.project.deal.vo.DealInfoVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RankInfoVO {

	private int riNum;
	private int diNum;
	private int oiNum;
	private String sellerUiNum;
	private String buyerUiNum;
	private String riRank;
	private String riComment;
	private String credat;
	private int uiNum;
	private DealInfoVO dealInfos;
}
