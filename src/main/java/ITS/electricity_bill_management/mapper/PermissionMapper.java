package ITS.electricity_bill_management.mapper;

import ITS.electricity_bill_management.dto.request.permission.PermissionRequest;
import ITS.electricity_bill_management.dto.request.user.UserUpdateRequest;
import ITS.electricity_bill_management.dto.response.PermissionResponse;
import ITS.electricity_bill_management.model.Permission;
import ITS.electricity_bill_management.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    // Chuyển từ PermissionRequest sang Permission
    Permission toPermission(PermissionRequest request);

    // Chuyển từ Permission sang PermissionResponse
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    PermissionResponse toPermissionResponse(Permission permission);

    // Cập nhật đối tượng User từ UserUpdateRequest
    //void toUpdateUser(@MappingTarget User user, UserUpdateRequest request);

    // Có thể thêm các phương thức chuyển đổi liên quan đến vai trò hoặc quyền nếu cần
}
