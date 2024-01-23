package sever.com.serverFacturation.mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import sever.com.serverFacturation.dtos.UserDto;
import sever.com.serverFacturation.entities.User;

@Service
public class ApplicationMappers {

    public UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();

        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    public User convertDtoToEntity(UserDto userDto){
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }


}
