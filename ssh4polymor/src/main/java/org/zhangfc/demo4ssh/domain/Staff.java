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
public class Staff extends PersonTyped {

	private static final long serialVersionUID = -5121064427769857118L;
	
	private Integer salary;

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

}
