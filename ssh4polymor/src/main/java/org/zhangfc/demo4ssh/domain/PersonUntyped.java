package org.zhangfc.demo4ssh.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="person")
//@Polymorphism(type=PolymorphismType.EXPLICIT)
public class PersonUntyped extends Person implements Serializable {

	private static final long serialVersionUID = -6721886634278991423L;
	
}
