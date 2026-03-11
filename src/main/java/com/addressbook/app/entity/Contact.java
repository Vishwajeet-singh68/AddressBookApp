package com.addressbook.app.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("contact")
public class Contact {
	@Id
	private Long id;
	
	@Column("first_name")
	private String firstName;
	
	@Column("last_name")
	private String lastName;
	
	private String address;
	private String city;
	private String state;
	private Integer zip;
	private Long phone;
	private String email;
}
