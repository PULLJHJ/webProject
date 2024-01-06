package com.web.project.chat.mapper;

import java.util.List;

import com.web.project.chat.vo.MessageInfoVO;

public interface MessageInfoMapper {
	MessageInfoVO getMessageInfoById(int miNum);
	List<MessageInfoVO> getMessageListByCiNum(int ciNum);
	int insertMessageInfo(MessageInfoVO messageInfo);
	MessageInfoVO selectMessageTime(int ciNum);
}
