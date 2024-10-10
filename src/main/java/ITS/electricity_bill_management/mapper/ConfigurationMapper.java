package ITS.electricity_bill_management.mapper;

import ITS.electricity_bill_management.dto.request.configuration.ConfigurationCreationRequest;
import ITS.electricity_bill_management.dto.request.configuration.ConfigurationUpdateRequest;
import ITS.electricity_bill_management.dto.response.ConfigurationResponse;
import ITS.electricity_bill_management.model.Configuration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ConfigurationMapper {

    //Phương thức này ánh xạ từ đối tượng ConfigurationCreationRequest (một DTO) sang đối tượng entity Configuration
    //Khi nhận được yêu cầu tạo mới cấu hình từ client, phương thức này sẽ chuyển đổi dữ liệu từ
    //DTO ConfigurationCreationRequest thành một thực thể Configuration để có thể lưu vào cơ sở dữ liệu
    Configuration toConfiguration(ConfigurationCreationRequest request);

    //Sau khi lấy dữ liệu từ cơ sở dữ liệu (entity Configuration), phương thức này chuyển đổi thành
    //DTO ConfigurationResponse để gửi lại phản hồi cho client.

    @Mapping(source = "id", target = "id")
    @Mapping(source = "startkWh", target = "startkWh")
    @Mapping(source = "endkWh", target = "endkWh")
    @Mapping(source = "price", target = "price")
    ConfigurationResponse toConfigurationResponse(Configuration configuration);

    //Phương thức này cập nhật dữ liệu từ đối tượng ConfigurationUpdateRequest vào một thực thể Configuration đã tồn tại
    //Annotation @MappingTarget cho biết rằng đối tượng configuration là
    //đối tượng mục tiêu cần được cập nhật (thay vì tạo mới một thực thể khác)
    void updateConfiguration(@MappingTarget Configuration configuration, ConfigurationUpdateRequest request);
}
