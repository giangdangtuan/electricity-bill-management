package ITS.electricity_bill_management.service;

import ITS.electricity_bill_management.dto.request.configuration.ConfigurationCreationRequest;
import ITS.electricity_bill_management.dto.request.configuration.ConfigurationUpdateRequest;
import ITS.electricity_bill_management.dto.response.ConfigurationResponse;
import ITS.electricity_bill_management.exception.AppException;
import ITS.electricity_bill_management.exception.ErrorCode;
import ITS.electricity_bill_management.mapper.ConfigurationMapper;
import ITS.electricity_bill_management.model.Configuration;
import ITS.electricity_bill_management.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationService {
    @Autowired
    private ConfigurationRepository configurationRepository;

    @Autowired
    private ConfigurationMapper configurationMapper;

    public Configuration createConfiguration(ConfigurationCreationRequest request) {

        if(configurationRepository.existsByStartkWh(request.getStartkWh())) {
            throw new AppException(ErrorCode.CONFIGURATION_STARTKWH_EXISTED);
        }
        else if(configurationRepository.existsByEndkWh(request.getEndkWh())) {
            throw new AppException(ErrorCode.CONFIGURATION_ENDKWH_EXISTED);
        }else if(request.getStartkWh() > request.getEndkWh()) {
            throw new AppException(ErrorCode.CONFIGURATION_STARTKWH_EXISTED);
        }

        Configuration configuration = new Configuration();
        configuration.setStartkWh(request.getStartkWh());
        configuration.setEndkWh(request.getEndkWh());
        configuration.setPrice(request.getPrice());

        return configurationRepository.save(configuration);
    }

    public ConfigurationResponse updateConfiguration(Long configurationId, ConfigurationUpdateRequest request) {
        Configuration config = configurationRepository.findById(configurationId)
                .orElseThrow(() -> new RuntimeException("Configuration not found !"));

        if(request.getStartkWh() > request.getEndkWh()) {
            throw new AppException(ErrorCode.CONFIGURATION_STARTKWH_EXISTED);
        }

        config.setStartkWh(request.getStartkWh());
        config.setEndkWh(request.getEndkWh());
        config.setPrice(request.getPrice());

        return configurationMapper.toConfigurationResponse(configurationRepository.save(config));
    }

    public void deleteConfiguration(Long configurationId) {
        configurationRepository.deleteById(configurationId);
    }

    public List<Configuration> getAllConfigurations() {
        return configurationRepository.findAll();
    }

    public ConfigurationResponse getConfiguration(Long id) {
//        return configurationRepository.findById(id).orElseThrow(() -> new RuntimeException("Configuration not found !"));
        return configurationMapper.toConfigurationResponse(
                configurationRepository.findById(id).orElseThrow(() -> new RuntimeException("Configuration not found !"))
        );
    }

}
