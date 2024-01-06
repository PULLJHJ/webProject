package com.web.project.chat.mapper;

import java.util.List;

import com.web.project.chat.vo.ChatInfoVO;
import com.web.project.chat.vo.ChatRoomInfoVO;

public interface ChatInfoMapper {
	List<ChatInfoVO> getChatInfoListByUiNum(int uiNum);
	ChatInfoVO getChatInfoByCiId(int ciNum);
	ChatInfoVO selectChatInfo(ChatInfoVO chatInfo);
	ChatInfoVO selectChatInfoByCiNum(int ciNum);
	List<ChatRoomInfoVO> selectChatRoomList(int uiNum);
	int insertChatInfo(ChatInfoVO chatInfo);
	int selectChatInfoCntByBiNum(int biNum); // 해당 게시물의 채팅방 개수
}
