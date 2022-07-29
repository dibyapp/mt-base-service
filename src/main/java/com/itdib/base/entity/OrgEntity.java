package com.itdib.base.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author @dibyapp, Name : Dibyaprakash, Email : dibyapp@geekyants.com
 * @Project : mt-base-service
 */

@Getter
@Setter
@ToString
@Entity
@Table(name="org")
public class OrgEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="email")
    private String email;

	@Column(name="orgName")
    private String orgName;

	@Column(name="firstName")
    private String firstName;

	@Column(name="lastName")
    private String lastName;

	@Column(name="instanceName")
    private String instanceName;


}