package ITS.electricity_bill_management.dto.request.usagehistory;

import ITS.electricity_bill_management.model.User;
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
public class UsageHistoryCreationRequest {
    LocalDate date;
    @Min(value = 0, message = "USAGEHISTORY_COMSUMPTION_INVALID")
    int consumption;

    @Min(value = 1, message = "USER_ID_INVALID")
    Long userId;  // Thêm trường userId để xác định người dùng
}
