package com.web.project.chat.mapper;

import com.web.project.chat.vo.ChatRoomInfoVO;
import com.web.project.chat.vo.CheckedTimeInfoVO;
import com.web.project.chat.vo.LmotimCretimMapVO;

public interface CheckedTimeInfoMapper {
	CheckedTimeInfoVO selectCheckedTimeInfo(CheckedTimeInfoVO checkTime);
	LmotimCretimMapVO selectChatRoomList(ChatRoomInfoVO chatRoom);
	int insertCheckedTimeInfo(CheckedTimeInfoVO checkTime);
	int updateCheckedTimeInfo(CheckedTimeInfoVO checkTime);
	int countNewMessage(CheckedTimeInfoVO checkTime);
}
