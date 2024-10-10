package ITS.electricity_bill_management.mapper;

import ITS.electricity_bill_management.dto.request.role.RoleRequest;
import ITS.electricity_bill_management.dto.response.RoleResponse;
import ITS.electricity_bill_management.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel =  "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
