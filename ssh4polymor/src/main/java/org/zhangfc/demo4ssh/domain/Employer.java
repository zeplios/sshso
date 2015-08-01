package org.zhangfc.demo4ssh.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table
@PrimaryKeyJoinColumn(name="id")
@DynamicInsert
@DynamicUpdate
public class Employer extends PersonTyped {

	private static final long serialVersionUID = -6921861721217086381L;
	
	private String motto;

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}
	
}
