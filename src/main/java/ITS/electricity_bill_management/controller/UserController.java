package ITS.electricity_bill_management.controller;

import ITS.electricity_bill_management.dto.request.ApiResponse;
import ITS.electricity_bill_management.dto.request.user.UserCreationRequest;
import ITS.electricity_bill_management.dto.request.user.UserUpdateRequest;
import ITS.electricity_bill_management.dto.response.UserResponse;
import ITS.electricity_bill_management.model.User;
import ITS.electricity_bill_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    ApiResponse<User> createUser(@RequestBody UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult(userService.creationUser(request));

        return apiResponse;
    }

    @GetMapping()
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable("userId") long userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable("userId") long userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable("userId") long userId) {
        userService.deleteUser(userId);
        return "User deleted";
    }
}
