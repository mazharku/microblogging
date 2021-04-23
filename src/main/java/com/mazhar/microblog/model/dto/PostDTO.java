/**
 * 
 */
package com.mazhar.microblog.model.dto;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mazhar
 *
 */
@Getter
@Setter
public class PostDTO {

	private UUID id;
	private String userName;
	private String title;
	private String post;
	private List<CommentDTO> comments;
}
