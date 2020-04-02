package com.example.course.user;

import com.example.course.order.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	@OneToMany(mappedBy = "client")
	//@JoinColumn(name="")
	private List<Order> orders = new ArrayList<>();


	public User(Long id,String name,String email,String phone, String password) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.phone=phone;
		this.password=password;
	}
}
