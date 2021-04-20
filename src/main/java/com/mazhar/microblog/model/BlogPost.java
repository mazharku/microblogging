/**
 * 
 */
package com.mazhar.microblog.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "blog_user_id")
	private BlogUser user;
	@OneToMany(mappedBy="post", fetch = FetchType.EAGER)
	private Set<Comment> comments;
	@OneToMany(mappedBy="post", fetch = FetchType.EAGER)
	private Set<Vote> votes;
}
