package test.task.model;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inputed_values")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValueA() {
        return valueA;
    }

    public void setValueA(Double a) {
        this.valueA = a;
    }

    public Double getValueB() {
        return valueB;
    }

    public void setValueB(Double b) {
        this.valueB = b;
    }

    public Double getValueC() {
        return valueC;
    }

    public void setValueC(Double c) {
        this.valueC = c;
    }

    public Double getRoot1() {
        return root1;
    }

    public Double getRoot2() {
        return root2;
    }

    public void setRoot1(Double root1) {
        this.root1 = root1;
    }

    public void setRoot2(Double root2) {
        this.root2 = root2;
    }
}
