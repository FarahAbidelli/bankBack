package com.pfe.Bank.controller;

import com.pfe.Bank.dto.UserDto;
import com.pfe.Bank.exception.MissingEntity;
import com.pfe.Bank.form.UserForm;
import com.pfe.Bank.model.Role;
import com.pfe.Bank.model.User;
import com.pfe.Bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("api/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    UserService userService;
    //@PreAuthorize("hasRole('ROLE_ADMIN')")

    @GetMapping("/users")
    List<UserDto> getAll(){
        List<User> users = userService.getAllUsers();
        return UserDto.of(users);
    }

    @GetMapping("/getByUserId/{id}")
    public UserDto getUserId(@PathVariable Long id) throws MissingEntity {
        User user = userService.getUserById(id);
        return UserDto.of(user);
    }
    @PutMapping("/{userId}/roles")
    public void assignRolesToUser(@PathVariable long userId, @RequestBody Set<Role> roles) {
        userService.assignRolesToUser(userId, roles);
    }

    @GetMapping("/userRole/{userId}")
    public ResponseEntity<UserDto> getUserWithRoles(@PathVariable Long userId) {
        UserDto userDto = userService.getUserWithRoles(userId);
        if (userDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }
    @DeleteMapping("/user/{userId}/roles/{roleId}")
    public ResponseEntity<?> removeRoleFromUser(@PathVariable Long userId, @PathVariable Long roleId) {
        userService.removeRoleFromUser(userId, roleId);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/search")
    public List<User> searchByUsername(@RequestParam(name = "name") String name){
        List<User> users = userService.searchByUsername(name);
        return users;
    }
    @PutMapping("/updateUser/{userId}")
    public UserDto updateUser(@PathVariable Long userId, @Valid @RequestBody UserForm form) throws MissingEntity{
        User user = userService.updateUser(userId,form);
        return UserDto.of(user);

    }
    @DeleteMapping("/deleteUser/{userId}")
    public Map<String,Boolean> deleteUser(@PathVariable Long userId) throws MissingEntity{
        return userService.deleteUser(userId);
    }
}
