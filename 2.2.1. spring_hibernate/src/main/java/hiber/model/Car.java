package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column ( name = "model")
    private String model;

    @Column ( name = "series")
    private int series;


    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {

    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public Car setId(Long id) {
        this.id = id;
        return this;
    }

    public Car setModel(String model) {
        this.model = model;
        return this;
    }

    public Car setSeries(int series) {
        this.series = series;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }

}