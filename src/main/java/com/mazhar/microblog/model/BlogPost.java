/**
 * 
 */
package com.mazhar.microblog.model;

import java.util.Set;
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
public class BlogPost extends Auditable<UUID>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "post_id", nullable = false)
	private UUID id;
	private String title;
	private String post;
	private BlogUser user;
	private Set<Comment> comments;
	private Set<Vote> votes;
}
