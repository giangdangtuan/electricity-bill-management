package ITS.electricity_bill_management.repository;

import ITS.electricity_bill_management.model.UsageHistory;
import ITS.electricity_bill_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsageHistoryRepository extends JpaRepository<UsageHistory, Long> {
    List<UsageHistory> findByUser(User user);
}
