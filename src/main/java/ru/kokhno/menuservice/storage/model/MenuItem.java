package ru.kokhno.menuservice.storage.model;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu_items")
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private Category category;
    @Column(name = "time_to_cook", nullable = false)
    private long timeToCook;
    @Column(name = "weight", nullable = false)
    private double weight;
    @Column(name = "image_url", nullable = false)
    private String imageUrl;
    @Type(JsonBinaryType.class)
    @Column(name = "ingredient_collection", columnDefinition = "jsonb")
    private IngredientCollection ingredientCollection;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Override
    public final boolean equals(Object o) {

        if (o == null) return false;
        if (this == o) return true;
        if (getEffectiveClass(this) != getEffectiveClass(o)) return false;
        return getId() != null && Objects.equals(getId(), ((MenuItem) o).getId());
    }

    @Override
    public final int hashCode() {

        return getEffectiveClass(this).hashCode();
    }

    private Class<?> getEffectiveClass(Object o) {

        return o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
                : o.getClass();
    }
}
