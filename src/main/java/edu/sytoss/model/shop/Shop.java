package edu.sytoss.model.shop;

import edu.sytoss.model.user.Subsciptable;
import edu.sytoss.model.user.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "shop")
@Entity
@Embeddable// Определяет класс, экземпляры которого хранятся как неотъемлемая часть исходного объекта
public class Shop implements Subsciptable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner", nullable = false)
    private UserAccount owner;

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", owner=" + owner +
                '}';
    }
}