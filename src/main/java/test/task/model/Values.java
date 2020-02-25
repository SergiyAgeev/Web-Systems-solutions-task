package test.task.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "inputed_values")
@Data
public class Values {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Double valueA;
    @NotNull
    private Double valueB;
    @NotNull
    private Double valueC;

    private Double root1;
    private Double root2;

}
