package ITS.electricity_bill_management.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String email;
    String username;
    String password;

    @OneToMany(mappedBy = "user") // Quan hệ một User có nhiều UsageHistory
    private List<UsageHistory> usageHistories;

    @ManyToMany
    Set<Role> roles;

}
