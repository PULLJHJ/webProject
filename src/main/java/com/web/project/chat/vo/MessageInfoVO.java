package com.web.project.chat.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageInfoVO {
    private int miNum;
    private int ciNum;
    private int senderUiNum;
    private String miContent;
    private String credat;
    private String cretim;
}
