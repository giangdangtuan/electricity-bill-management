package ITS.electricity_bill_management.service;

import ITS.electricity_bill_management.dto.request.usagehistory.UsageHistoryCreationRequest;
import ITS.electricity_bill_management.dto.request.usagehistory.UsageHistoryUpdateRequest;
import ITS.electricity_bill_management.dto.response.UsageHistoryResponse;
import ITS.electricity_bill_management.mapper.UsageHistoryMapper;
import ITS.electricity_bill_management.model.Configuration;
import ITS.electricity_bill_management.model.UsageHistory;
import ITS.electricity_bill_management.repository.ConfigurationRepository;
import ITS.electricity_bill_management.repository.UsageHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class UsageHistoryService {
    @Autowired
    private UsageHistoryRepository usageHistoryRepository;

    @Autowired
    private UsageHistoryMapper usageHistoryMapper;

    @Autowired
    private ConfigurationRepository configurationRepository;

    public UsageHistory createUsageHistory(UsageHistoryCreationRequest request) {
        double totalAmount = calculateAmount(request.getConsumption());

        // Tạo mới UsageHistory
        UsageHistory usageHistory = new UsageHistory();
        usageHistory.setDate(request.getDate());
        usageHistory.setConsumption(request.getConsumption());
        usageHistory.setTotalAmount(totalAmount);

        // Lưu lại thông tin UsageHistory
        return usageHistoryRepository.save(usageHistory);
    }

    public UsageHistoryResponse updateUsageHistory(Long usageHistoryId, UsageHistoryUpdateRequest request) {
        UsageHistory usageHistory = usageHistoryRepository.findById(usageHistoryId)
                .orElseThrow(() -> new RuntimeException("UsageHistory not found !"));

        usageHistory.setDate(request.getDate());
        usageHistory.setConsumption(request.getConsumption());

        double totalAmount = calculateAmount(request.getConsumption());
        usageHistory.setTotalAmount(totalAmount);

        return usageHistoryMapper.toUsageHistoryResponse(usageHistoryRepository.save(usageHistory));
    }

    public void deleteUsageHistory(Long usageHistoryId) {
        usageHistoryRepository.deleteById(usageHistoryId);
    }

    public List<UsageHistory> getAllUsageHistory() {
        return usageHistoryRepository.findAll();
    }

    public UsageHistoryResponse getUsageHistory(Long id) {
        return usageHistoryMapper.toUsageHistoryResponse(usageHistoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UsageHistory not found !")));
    }

    // Hàm tính tiền điện
    private double calculateAmount(int usage) {
        List<Configuration> configurations = configurationRepository.findAll();

        configurations.sort(Comparator.comparingInt(Configuration::getStartkWh));
        double amount = 0;
        for (Configuration config : configurations) {
            if (usage > config.getEndkWh()) {
                amount += (config.getEndkWh() - config.getStartkWh() + 1) * config.getPrice();
            } else {
                amount += (usage - config.getStartkWh() + 1) * config.getPrice();
                break;
            }
        }
        return amount;
    }
}
