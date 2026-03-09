package enset.sdiaensetspringmvc.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Products {
    @Id @GeneratedValue
    private Long id;
    @NotEmpty
    @Size(min = 1, max = 50)
    private String name;
    @Min(1)
    private double price;
    private int quantity;

}
