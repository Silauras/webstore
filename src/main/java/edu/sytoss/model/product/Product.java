package edu.sytoss.model.product;

import edu.sytoss.model.order.Order;
import edu.sytoss.model.shop.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "product")
@Entity
public class Product implements Purchase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Long id;

    @Column(name = "serial_number", nullable = false)
    private Long serialNumber;

    @Column(name = "price", precision = 10)
    private BigDecimal price;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse", nullable = false)
    Warehouse warehouse;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_card", nullable = false)
    private ProductCard productCard;

    @ManyToOne()
    @JoinColumn(name = "`order`")
    private Order order;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @ManyToOne
    @JoinColumn(name = "kit")
    private Kit kit;

    @Column(name = "serial_number_kit")
    private String serialNumberKit;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", status=" + status +
                ", serialNumberKit=" + serialNumberKit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}