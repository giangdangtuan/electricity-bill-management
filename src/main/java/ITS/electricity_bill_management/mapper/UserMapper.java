package ITS.electricity_bill_management.mapper;

import ITS.electricity_bill_management.dto.request.user.UserCreationRequest;
import ITS.electricity_bill_management.dto.request.user.UserUpdateRequest;
import ITS.electricity_bill_management.dto.response.UserResponse;
import ITS.electricity_bill_management.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;



@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "roles", target = "roles")
    UserResponse toUserResponse(User user);

    @Mapping(target = "roles", ignore = true)
    void toUpdateUser(@MappingTarget User user, UserUpdateRequest request);

}

