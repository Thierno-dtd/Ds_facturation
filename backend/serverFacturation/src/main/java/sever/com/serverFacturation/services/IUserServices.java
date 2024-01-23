package sever.com.serverFacturation.services;

import sever.com.serverFacturation.dtos.UserDto;

import java.math.BigDecimal;
import java.util.List;

public interface IUserServices {
    public List<UserDto> getAllUsers();
    public UserDto getOneUser(int id);
    public void deleteUser(int id);

    UserDto updateUser(UserDto userDto, int id);
    UserDto rechargeSolde(int id, BigDecimal somme);
}
