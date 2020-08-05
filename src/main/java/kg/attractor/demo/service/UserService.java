package kg.attractor.demo.service;

import kg.attractor.demo.form.UserForm;
import kg.attractor.demo.model.User;
import kg.attractor.demo.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.security.Principal;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder encoder;


    public void addUser(UserForm userForm){

        userRepo.save(User.builder()
        .password(encoder.encode(userForm.getPassword()))
        .email(userForm.getEmail())
        .name(userForm.getName())
        .build());
    }

    public void checkUserPresence(Model model, Principal principal){
        if(principal != null){
            if (userRepo.existsByEmail(principal.getName())){
                model.addAttribute("user", true);
            }
        }
    }
}
