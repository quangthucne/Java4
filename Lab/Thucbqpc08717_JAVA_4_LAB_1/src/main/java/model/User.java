package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users", schema = "dbo")
public class User {
    @Id
    @Size(max = 20)
    @Nationalized
    @Column(name = "id", nullable = false, length = 20)
    private String id;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "fullname", nullable = false, length = 50)
    private String fullname;

    @Size(max = 50)
    @NotNull
    @Nationalized
    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @NotNull
    @Column(name = "admin", nullable = false)
    private Boolean admin = false;

}