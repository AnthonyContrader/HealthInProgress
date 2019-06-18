package it.contrader.model;



import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;

import javax.persistence.Id;

import javax.persistence.NamedQuery;

import javax.validation.constraints.NotNull;



import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;


@Data

@AllArgsConstructor

@NoArgsConstructor

@Entity

//@NamedQuery(name="User.findAll", query="SELECT u FROM User u")

public class User {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")

	private int id;



	@Column(name = "username")

	@NotNull

	private String username;



	@Column(name = "password")

	@NotNull

	private String password;



	@Column(name = "usertype")

	@NotNull

	private String usertype;







}
