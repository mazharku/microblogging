/**
 * 
 */
package com.mazhar.microblog.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Vote extends Auditable<UUID>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vote_id", nullable = false)
	private UUID id;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "voter_id")
	private BlogUser voter;
	@ManyToOne
	@JoinColumn(name = "post_id")
	private BlogPost post;
	private boolean vote;
}
