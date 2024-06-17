package bg.softuni.phatfinder.model.entities;

import bg.softuni.phatfinder.model.enums.CategoryEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category{
    dasdas

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String description;



    public Category() {
    }
}
