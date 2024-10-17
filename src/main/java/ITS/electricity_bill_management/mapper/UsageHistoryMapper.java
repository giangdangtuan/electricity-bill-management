package ITS.electricity_bill_management.mapper;

import ITS.electricity_bill_management.dto.request.usagehistory.UsageHistoryCreationRequest;
import ITS.electricity_bill_management.dto.request.usagehistory.UsageHistoryUpdateRequest;
import ITS.electricity_bill_management.dto.response.UsageHistoryResponse;
import ITS.electricity_bill_management.model.UsageHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UsageHistoryMapper {

    UsageHistory toUsageHistory(UsageHistoryCreationRequest request);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "consumption", target = "consumption")
    @Mapping(source = "totalAmount", target = "totalAmount")
    UsageHistoryResponse toUsageHistoryResponse(UsageHistory usageHistory);

    void updateUsageHistory(@MappingTarget UsageHistory usageHistory, UsageHistoryUpdateRequest request);
}
