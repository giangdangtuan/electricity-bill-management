package ITS.electricity_bill_management.controller;

import ITS.electricity_bill_management.dto.request.usagehistory.UsageHistoryCreationRequest;
import ITS.electricity_bill_management.dto.request.usagehistory.UsageHistoryUpdateRequest;
import ITS.electricity_bill_management.dto.response.UsageHistoryResponse;
import ITS.electricity_bill_management.model.UsageHistory;
import ITS.electricity_bill_management.service.UsageHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usagehistory")
public class UsageHistoryController {

    @Autowired
    private UsageHistoryService usageHistoryService;

    @PostMapping ()
    UsageHistory createUsageHistory(@RequestBody UsageHistoryCreationRequest request) {
        return usageHistoryService.createUsageHistory(request);
    }

    @GetMapping()
    List<UsageHistory> getAllUsageHistory() {
        return usageHistoryService.getAllUsageHistory();
    }

    @GetMapping("/{usagehistoryId}")
    UsageHistoryResponse getUsageHistory(@PathVariable("usagehistoryId") long usageHistoryId) {
        return usageHistoryService.getUsageHistory(usageHistoryId);
    }

    @PutMapping("/{usagehistoryId}")
    UsageHistoryResponse updateUsageHistory(@PathVariable("usagehistoryId") Long usageHistoryId ,@RequestBody UsageHistoryUpdateRequest request) {
        return usageHistoryService.updateUsageHistory(usageHistoryId, request);
    }

    @DeleteMapping("/{usagehistoryId}")
    String deleteUsageHistory(@PathVariable("usagehistoryId") Long usageHistoryId) {
        usageHistoryService.deleteUsageHistory(usageHistoryId);
        return "Deleted usagehistory";
    }
}
