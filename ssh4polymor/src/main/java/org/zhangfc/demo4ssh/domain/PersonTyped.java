package org.zhangfc.demo4ssh.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="person")
@Inheritance(strategy=InheritanceType.JOINED)
//@Polymorphism(type=PolymorphismType.EXPLICIT)
@DynamicInsert
@DynamicUpdate
public class PersonTyped extends Person implements Serializable {

	private static final long serialVersionUID = 5957003840801385095L;
	
}
