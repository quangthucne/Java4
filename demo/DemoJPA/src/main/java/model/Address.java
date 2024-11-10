package model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private Integer id;

    @NotNull
    @Lob
    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Size(max = 14)
    @NotNull
    @Column(name = "phone_number", nullable = false, length = 14)
    private String phoneNumber;

    @NotNull
    @Lob
    @Column(name = "address", nullable = false)
    private String address;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private model.User user;

    @OneToMany(mappedBy = "address")
    private Set<model.Order> orders = new LinkedHashSet<>();

}