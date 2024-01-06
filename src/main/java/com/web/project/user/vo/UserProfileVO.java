package com.web.project.user.vo;

import java.util.List;

import com.web.project.rank.vo.RankInfoVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserProfileVO {
	//userInfo
	private int uiNum;
	private String uiName;
	private String credat;
	private String uiDesc;
	private String uiRoadaddr;

	//rankInfo
	private float riRank;
	private List<RankInfoVO> riComment;
}
