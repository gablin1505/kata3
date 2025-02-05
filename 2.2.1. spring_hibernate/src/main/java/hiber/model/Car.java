package hiber.model;

import javax.persistence.*;


@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Car(User user, String model, int series) {
        this.user = user;
        this.model = model;
        this.series = series;
    }

    @OneToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User user;

    @Column(name = "model")
    private String model;

    @Override
    public String toString() {
        return "Car{" +
                "series=" + series +
                ", model='" + model + '\'' +
                '}';
    }

    @Column(name = "series")
    private int series;

    public Car() {}

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}