package ITS.electricity_bill_management.repository;

import ITS.electricity_bill_management.model.InvalidatedToken;
import ITS.electricity_bill_management.model.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, String> {


}
