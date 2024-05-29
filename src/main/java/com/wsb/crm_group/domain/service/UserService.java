package com.wsb.crm_group.domain.service;

import com.wsb.crm_group.domain.dao.UserRepository;
import com.wsb.crm_group.model.user.ChangePasswordRequest;
import com.wsb.crm_group.model.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        if (!passwordEncoder.matches(request.currentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }

        if (!request.newPassword().equals(request.confirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        user.setPassword(passwordEncoder.encode(request.newPassword()));

        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
}
