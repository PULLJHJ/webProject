package com.web.project.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.web.project.board.vo.BoardInfoVO;

public interface BoardInfoMapper {
	int selectUiNumByBiNum(int biNum);
	int insertBoardInfo(BoardInfoVO board); // 게시물 등록
	List<BoardInfoVO> selectBoardInfos(BoardInfoVO board); // 게시물 리스트
	int selectBoardInfoCnt(BoardInfoVO board); // 전체 게시물 개수
	BoardInfoVO selectBoardInfo(int biNum); // 게시물 뷰
	String selectBiTitleByBiNum(int biNum); // 게시물 이름
	int updateBoardInfo(BoardInfoVO board); // 게시물 수정
	int updateBiStat(int biNum);
	int updateBoardActive(int biNum); //게시글 active 변경 12.8
	int updateBoardPrice(@Param("biNum") int biNum, @Param("oiPrice") int oiPrice); //게시글 가격 변경
	int deleteBoardInfo(int biNum); // 게시물 삭제
	List<BoardInfoVO>selectBoardInfoList(BoardInfoVO board);
	int updateBoardInfoViewsCnt(int biNum); // 조회수 늘리기
}
