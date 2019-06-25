package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * The persistent class for the parameters database table.
 * 
 */
@Data

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sport {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String nome;
	
	private String tipo;
	
	private int durata;
	
	private int calorie;

}
