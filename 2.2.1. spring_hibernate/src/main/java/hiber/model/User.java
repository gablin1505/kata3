package hiber.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String name;

   @Column(name = "lastname")
   private String lastName;

   @Column(name = "email")
   private String email;

   @OneToOne(mappedBy = "user")
   @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
   private Car car;

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
   }

   public User() {}
   
   public User(String name, String lastName, String email) {
      this.name = name;
      this.lastName = lastName;
      this.email = email;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setFirstName(String name) {
      this.name = name;
   }

   public String getLastName() {
      return lastName;
   }
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }
   public String getEmail() {
      return email;
   }

   @Override
   public String toString() {
      return "User{" +
              "name='" + name + '\'' +
              ", lastName='" + lastName + '\'' +
              ", email='" + email + '\'' +
              '}';
   }

   public void setEmail(String email) {
      this.email = email;
   }
}
