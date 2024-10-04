package ITS.electricity_bill_management.dto.request.configuration;

import jakarta.validation.constraints.Min;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfigurationUpdateRequest {
    @Min(value = 0, message = "CONFIGURATION_STARTKWH_INVALID")
    int startkWh;
    int endkWh;
    double price;
}
