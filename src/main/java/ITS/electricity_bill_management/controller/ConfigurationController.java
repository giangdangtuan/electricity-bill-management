package ITS.electricity_bill_management.controller;

import ITS.electricity_bill_management.dto.request.ApiResponse;
import ITS.electricity_bill_management.dto.request.configuration.ConfigurationCreationRequest;
import ITS.electricity_bill_management.dto.request.configuration.ConfigurationUpdateRequest;
import ITS.electricity_bill_management.dto.response.ConfigurationResponse;
import ITS.electricity_bill_management.model.Configuration;
import ITS.electricity_bill_management.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

    //gọi xuống layer service
    //layer controller chỉ được gọi xuống layer service
    @Autowired
    private ConfigurationService configurationService;

    @PostMapping()
    ApiResponse<Configuration> createConfiguration(@RequestBody ConfigurationCreationRequest request) {
        ApiResponse<Configuration> apiResponse = new ApiResponse<>();

        apiResponse.setResult(configurationService.createConfiguration(request));

        return apiResponse;

    }

    @GetMapping()
    List<Configuration> getConfigurations() {
        return configurationService.getAllConfigurations();
    }

    @GetMapping("/{configurationId}")
    ConfigurationResponse getConfiguration(@PathVariable("configurationId") Long configurationId) {
        return configurationService.getConfiguration(configurationId);
    }

    @PutMapping("/{configurationId}")
    ConfigurationResponse updateConfiguration(@PathVariable("configurationId") Long configurationId ,@RequestBody ConfigurationUpdateRequest request) {
        return configurationService.updateConfiguration(configurationId, request);
    }

    @DeleteMapping("/{configurationId}")
    String deleteConfiguration(@PathVariable("configurationId") Long configurationId) {
        configurationService.deleteConfiguration(configurationId);
        return "Deleted configuration";
    }
}
