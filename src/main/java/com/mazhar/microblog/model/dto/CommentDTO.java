/**
 * 
 */
package com.mazhar.microblog.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mazhar
 *
 */
@Getter
@Setter
public class CommentDTO {
	private String comment;
	private String commenterName;
}
