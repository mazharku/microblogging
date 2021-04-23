package com.mazhar.microblog.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VoteDTO {
    private int total;
    private boolean currentUser;
}
