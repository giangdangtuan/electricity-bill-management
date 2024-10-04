package ITS.electricity_bill_management.repository;

import ITS.electricity_bill_management.model.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {
    boolean existsByStartkWh(int startkWh);
    boolean existsByEndkWh(int endkWh);


}
