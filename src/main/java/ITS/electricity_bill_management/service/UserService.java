package ITS.electricity_bill_management.service;

import ITS.electricity_bill_management.dto.request.user.UserCreationRequest;
import ITS.electricity_bill_management.dto.request.user.UserUpdateRequest;
import ITS.electricity_bill_management.dto.response.UserResponse;
import ITS.electricity_bill_management.exception.AppException;
import ITS.electricity_bill_management.exception.ErrorCode;
import ITS.electricity_bill_management.mapper.UserMapper;
import ITS.electricity_bill_management.model.User;
import ITS.electricity_bill_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User creationUser(UserCreationRequest request){

        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USERNAME_EXITSED);
        }

        User user = userMapper.toUser(request);

        return userRepository.save(user);
    }

    public UserResponse updateUser(Long userId, UserUpdateRequest request){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with id " + userId + " not found"));

        if(userRepository.existsByUsername(request.getUsername())){
            throw new AppException(ErrorCode.USERNAME_EXITSED);
        }

        userMapper.toUpdateUser(user, request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public UserResponse getUser(Long id){

        return userMapper.toUserResponse(
                userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found !"))
        );

    }
}
