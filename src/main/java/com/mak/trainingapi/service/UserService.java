package com.mak.trainingapi.service;

import com.mak.trainingapi.dto.UserRegisterDto;
import com.mak.trainingapi.dto.UserUpdateDto;
import com.mak.trainingapi.dto.UserViewDto;
import com.mak.trainingapi.mapper.UserMapper;
import com.mak.trainingapi.mapper.UserViewMapper;
import com.mak.trainingapi.model.User;
import com.mak.trainingapi.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ValidationException;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Transactional
    public UserViewDto createUser(UserRegisterDto userRegisterDto) {
        if (usernameExists(userRegisterDto.username())) {
            throw new ValidationException("User with this login already exists");
        }
        User user = UserMapper.INSTANCE.userRegisterDtoToUser(userRegisterDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return UserViewMapper.INSTANCE.userToUserView(user);
    }

    public UserViewDto getUserByUsername(String username) {
        return UserViewMapper.INSTANCE.userToUserView(userRepository.getUserByUsername(username));
    }

    // TODO update by username or id?
    @Transactional
    public UserViewDto updateUser(String username, UserUpdateDto userUpdateDto){
        User user  = userRepository.getUserByUsername(username);
        UserMapper.INSTANCE.userUpdateDtoToUser(userUpdateDto, user);
        userRepository.save(user);

        return UserViewMapper.INSTANCE.userToUserView(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User with username - %s, not found", username)));
    }

    private boolean usernameExists(String username){
        return userRepository.findByUsername(username).isPresent();
    }

    public void deleteUser(String username){
        User user  = userRepository.getUserByUsername(username);
        userRepository.delete(user);
    }


}
