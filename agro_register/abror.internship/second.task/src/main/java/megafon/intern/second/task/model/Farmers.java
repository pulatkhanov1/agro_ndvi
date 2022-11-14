package megafon.intern.second.task.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "farmers")

public class Farmers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column
	private Long uid;
	@Column
	private String first_name;
	@Column
	private String last_name;
	@Column
	private int phone_number;


}