package tw.com.hitrust.hello.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data	//@Data = @Getter/@Setter+@ToString+@EqualsAndHashCode+@RequiredArgsConstructo
public class HelloEntity {

	@Id		//設為PK
	@GeneratedValue	//自動產生值
	 Integer id;
	
	 String empNumber;
	
	 String empName;
}
