package ITS.electricity_bill_management.dto.request.usagehistory;


import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UsageHistoryUpdateRequest {
    LocalDate date;
    @Min(value = 0, message = "USAGEHISTORY_COMSUMPTION_INVALID")
    int consumption;
}
