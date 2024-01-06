package com.web.project.like.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.project.common.vo.ResponsePageVO;
import com.web.project.file.service.FileInfoService;
import com.web.project.like.mapper.LikeInfoMapper;
import com.web.project.like.vo.LikeInfoVO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class LikeInfoService {

	private final LikeInfoMapper likeInfoMapper;
	private final FileInfoService fileInfoService;

	// 관심 등록
	public int insertLikeInfo(LikeInfoVO like) {
		log.info("like=>{}", like);
		return likeInfoMapper.insertLikeInfo(like);
	}

	// 관심 취소
	public int deleteLikeInfo(LikeInfoVO like) {
		log.info("like=>{}", like);
		return likeInfoMapper.deleteLikeInfo(like);
	}

	// 관심 목록 리스트
	public ResponsePageVO<LikeInfoVO> selectLikeInfos(LikeInfoVO like){
		like.setEnd(like.getPageSize());
		int start = (like.getPage()-1) * like.getPageSize();
		like.setStart(start);
		List<LikeInfoVO> likes = likeInfoMapper.selectLikeInfos(like);
		for(LikeInfoVO l : likes) {
			l.setFiles(fileInfoService.selectFileInfos(l.getBiNum()));
		}
		ResponsePageVO<LikeInfoVO> resVO = new ResponsePageVO<>();
		resVO.setList(likes);
		resVO.setTotalCnt(likeInfoMapper.selectLikeInfoCnt(like));
		return resVO;
	}

	// 게시글이 관심 목록에 있는지 확인
	public int SelectLikeInfoByBiNum(LikeInfoVO like) {
		return likeInfoMapper.selectLikeInfoByBiNum(like);
	}
	
	// 해당 게시물의 관심 목록 개수
	public int getLikeInfoCntByBiNum(int biNum) {
		return likeInfoMapper.selectLikeInfoCntByBiNum(biNum);
	}
}