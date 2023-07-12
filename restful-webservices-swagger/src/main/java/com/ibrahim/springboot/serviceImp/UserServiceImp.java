package com.ibrahim.springboot.serviceImp;

import com.ibrahim.springboot.dto.UserDto;
import com.ibrahim.springboot.dtoimp.AutoUserMapper;
import com.ibrahim.springboot.dtoimp.UserMapper;
import com.ibrahim.springboot.entity.User;
import com.ibrahim.springboot.exception.EmailAlreadyExists;
import com.ibrahim.springboot.exception.ResourceNotFoundException;
import com.ibrahim.springboot.repository.UserRepository;
import com.ibrahim.springboot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {


        Optional<User>userEmail=userRepository.findByEmail(userDto.getEmail());

        if(userEmail.isPresent())
        {
            throw new EmailAlreadyExists("Choose an Unique email");
        }
         // User user= UserMapper.userDtoToUser(userDto);
       // User user= modelMapper.map(userDto,User.class);
        User user= AutoUserMapper.Mapper.dtoToUser(userDto);
          userRepository.save(user);
         // UserDto newUserDto=UserMapper.userToUserDto(user);
        //UserDto newUserDto=modelMapper.map(user,UserDto.class);
        UserDto newUserDto=AutoUserMapper.Mapper.userToDto(user);
          return  newUserDto;
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user =userRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("User","id",id)
        );
       // return modelMapper.map(optionalUser.get(),UserDto.class);
        return AutoUserMapper.Mapper.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User>all=userRepository.findAll();
        Iterator i1= all.iterator();
        List<UserDto>oldUsers=new ArrayList<>();
        while (i1.hasNext())
        {
            oldUsers.add(AutoUserMapper.Mapper.userToDto((User) i1.next()));
        }
        return oldUsers;
    }

    @Override
    public void deleteUser(UserDto userDto) {
        User user=UserMapper.userDtoToUser(userDto);
        userRepository.delete(user);
    }
}
