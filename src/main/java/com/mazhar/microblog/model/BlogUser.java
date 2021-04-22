/**
 * 
 */
package com.mazhar.microblog.model;

import java.util.Date;
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
public class BlogUser extends Auditable<UUID>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "blog_user_id", nullable = false)
	private UUID id;
	private String email;
	@Column(name = "blog_user_name")
	private String userName;
	private String password;
	private String gender;
	private Date dob;
	private boolean isActive;
	
}
