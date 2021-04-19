/**
 * 
 */
package com.mazhar.microblog.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * @author mazhar
 *
 */
@Getter
@Setter
@Entity
public class Comment extends Auditable<UUID> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "comment_id", nullable = false)
	private UUID id;
	@Column(name = "comment")
	private String commentText;
	private BlogUser commenter;
	private BlogPost post;
	
}
