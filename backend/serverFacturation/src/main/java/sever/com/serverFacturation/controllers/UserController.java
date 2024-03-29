package sever.com.serverFacturation.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sever.com.serverFacturation.dtos.UserDto;
import sever.com.serverFacturation.services.serviceImpl.UserService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getOneUsers(@PathVariable int id){
        return ResponseEntity.ok(userService.getOneUser(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> ModifyUser(@PathVariable int id,@Valid @RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.updateUser(userDto, id));
    }
    @PostMapping("/{id}/{somme}")
    public  ResponseEntity <UserDto> RechargeSolde(@PathVariable("id") int id,@PathVariable("somme") Double somme){
        return ResponseEntity.ok(userService.rechargeSolde(id, somme));
    }
}
