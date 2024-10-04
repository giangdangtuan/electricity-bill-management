package ITS.electricity_bill_management.repository;

import ITS.electricity_bill_management.model.UsageHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageHistoryRepository extends JpaRepository<UsageHistory, Long> {

}
