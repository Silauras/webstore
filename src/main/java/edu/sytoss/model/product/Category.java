package edu.sytoss.model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Table(name = "category")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_category")
    private Category parentCategory;

    @OneToMany(fetch =  FetchType.LAZY)
    private Set<Category> subCategory;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "category")
    Set<ProductTemplate> productTemplates;
}