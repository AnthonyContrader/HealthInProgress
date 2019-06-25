  package it.contrader.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the parameters database table.
 * 
 */
@Entity
@Table(name="Users")
//@NamedQuery(name="User.findAll", query="SELECT u FROM user u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password ;
	
	@Column(name="usertype")
	private String usertype ;
	
		//bi-directional many-to-one association to Parameter
		@OneToMany(mappedBy="user")
		private List<Parameter> parameters;

		//bi-directional many-to-one association to Device
		@OneToMany(mappedBy="user")
		private List<Device>devices;

		//bi-directional many-to-one association to Sport
		@OneToMany(mappedBy="user")
		private List<Sport> sports;

		//bi-directional many-to-one association to Meal
		@OneToMany(mappedBy="user")
		private List<Meal> meals;


	public User() {
		super();
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsertype() {
		return usertype;
	}


	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}


	///////////////////////////////////////////////
	public List<Meal> getMeals() {
		return this.meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	public Meal addMeal(Meal meal) {
		getMeals().add(meal);
		meal.setUser(this);

		return meal;
	}

	

	public Meal removeMeal(Meal meal) {
		getMeals().remove(meal);
		meal.setUser(null);

		return meal;
		
	}
		/////////////////////////////////////////////
		
		public List<Sport> getSports() {
			return this.sports;
		}

		public void setSports(List<Sport> sports) {
			this.sports = sports;
		}

		public Sport addSport(Sport sport) {
			getSports().add(sport);
			sport.setUser(this);

			return sport;
		}

		public Sport removeSport(Sport sport) {
			getSports().remove(sport);
			sport.setUser(null);

			return sport;
	}
	 
		/////////////////////////////////////////////////////
		public List<Device> getDevices() {
			return this.devices;
		}

		public void setDevices(List<Device> devices) {
			this.devices = devices;
		}

		public Device addDevice(Device device) {
			getDevices().add(device);
			device.setUser(this);

			return device;
		}

		public Device removeDevice(Device device) {
			getDevices().remove(device);
			device.setUser(null);

			return device;
			}
	///////////////////////////////////////////////////////////

		public List<Parameter> getParameters() {
			return this.parameters;
		}

		public void setParameters(List<Parameter> parameters) {
			this.parameters = parameters;
		}

		public Parameter addParameter(Parameter parameter) {
			getParameters().add(parameter);
			parameter.setUser(this);

			return parameter;
		}

		public Parameter removeParameter(Parameter parameter) {
			getParameters().remove(parameter);
			parameter.setUser(null);

			return parameter;
			}
	
}
