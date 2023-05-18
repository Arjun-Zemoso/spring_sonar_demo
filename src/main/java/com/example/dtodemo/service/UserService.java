package com.example.dtodemo.service;

import com.example.dtodemo.dto.UserLocationDTO;
import com.example.dtodemo.model.User;
import com.example.dtodemo.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    public List<UserLocationDTO> getAllUsersLocations(){
        return  userRepository.findAll().stream().map(this::convertEntityToDTO).collect(Collectors.toList());
    }
//    private  UserLocationDTO convertEntityToDTO(User user){
//        UserLocationDTO userLocationDTO = new UserLocationDTO();
//        userLocationDTO.setUserId(user.getId());
//        userLocationDTO.setEmail(user.getEmail());
//        userLocationDTO.setPlace(user.getLocation().getPlace());
//        userLocationDTO.setLongitude(user.getLocation().getLongitude());
//        userLocationDTO.setLatitude(user.getLocation().getLatitude());
//        return  userLocationDTO;
//    }
    private  UserLocationDTO convertEntityToDTO(User user){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        UserLocationDTO userLocationDTO = new UserLocationDTO();
        userLocationDTO=modelMapper.map(user,UserLocationDTO.class);
        return  userLocationDTO;
    }
}
