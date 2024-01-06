package com.web.project.board.service;

import java.util.List;

import com.web.project.board.mapper.BoardInfoMapper;
import com.web.project.board.vo.BoardInfoVO;
import com.web.project.chat.service.ChatInfoService;
import com.web.project.common.vo.ResponsePageVO;
import com.web.project.file.service.FileInfoService;
import com.web.project.file.vo.FileInfoVO;
import com.web.project.like.service.LikeInfoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RequiredArgsConstructor
@Slf4j
public class BoardInfoService {

	private final BoardInfoMapper boardInfoMapper;
	private final FileInfoService fileInfoService;
	private final ChatInfoService chatInfoService;
	private final LikeInfoService likeInfoService;

	// 게시글 등록
	public int insertBoardInfo(BoardInfoVO board) {
		int result = boardInfoMapper.insertBoardInfo(board);
		log.info("biNum=>{}", board.getBiNum());
		result += fileInfoService.insertFileInfos(board.getBiNum(), board.getFiles());
		return result;
	}

	// 게시글 리스트
	public ResponsePageVO<BoardInfoVO> selectBoardInfos(BoardInfoVO board){
		if(board.getPage() == 0 && board.getPageSize() == 0) {
			board.setEnd(12);
			board.setStart(0);
		}else {
			board.setEnd(board.getPageSize());
			int start = (board.getPage()-1) * board.getPageSize();
			board.setStart(start);
		}
		log.info("board=>{}", board);
		List<BoardInfoVO> boards = boardInfoMapper.selectBoardInfos(board);
		for(BoardInfoVO b : boards) {
			b.setFiles(fileInfoService.selectFileInfos(b.getBiNum()));
		}
		log.info("boards=>{}", boards);
		ResponsePageVO<BoardInfoVO> resVO = new ResponsePageVO<>();
		resVO.setList(boards);
		resVO.setTotalCnt(boardInfoMapper.selectBoardInfoCnt(board));
		return resVO;
	}

	// 게시글 뷰
	public BoardInfoVO selectBoardInfo(int biNum) {
		BoardInfoVO board = boardInfoMapper.selectBoardInfo(biNum);
		// 파일 가져오기
		List<FileInfoVO> files = fileInfoService.selectFileInfos(biNum);
		board.setFiles(files);
		
		// 채팅 개수, 관심목록 개수 가져오기
		board.setChatCnt(chatInfoService.getChatInfoCntByBiNum(biNum));
		board.setLikeCnt(likeInfoService.getLikeInfoCntByBiNum(biNum));
		
		// 조회수 늘리기
		boardInfoMapper.updateBoardInfoViewsCnt(biNum);
		return board;
	}

	// 게시글 수정
	public int updateBoardInfo(BoardInfoVO board) {
		int result = boardInfoMapper.updateBoardInfo(board);
		result += fileInfoService.updateFileInfos(board.getBiNum(), board.getFiles());
		return result;
	}

	// 게시글 상태 업데이트
    public int updateBiStat(int biNum) {
        return boardInfoMapper.updateBiStat(biNum);
    }

	// 게시글 삭제
	public int deleteBoardInfo(int biNum) {
		BoardInfoVO board = boardInfoMapper.selectBoardInfo(biNum);
		List<FileInfoVO> files = fileInfoService.selectFileInfos(biNum);
		board.setFiles(files);
		log.info("board=>{}", board);
		int result = fileInfoService.deleteFileInfos(biNum, board.getFiles());
		result += boardInfoMapper.deleteBoardInfo(biNum);
		return result;
	}

	// 게시글 active 변경 12.8
	public int updateBoardActive(int biNum) {
		return boardInfoMapper.updateBoardActive(biNum);
	}
	
	public int updateBoardPrice(int biNum, int oiPrice) {
        return boardInfoMapper.updateBoardPrice(biNum, oiPrice);
    }

	public int getSellerUiNumByBiNum(int biNum) {
        return boardInfoMapper.selectUiNumByBiNum(biNum);
    }

	// 관리자페이지에서 보드 리스트가져오기
	public List<BoardInfoVO> selectBoardInfoList(BoardInfoVO board){
		return boardInfoMapper.selectBoardInfoList(board);
	}
}
