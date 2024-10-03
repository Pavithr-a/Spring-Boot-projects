package com.project.ecommerceproject.service;

import com.project.ecommerceproject.DAO.LocalUserDAO;
import com.project.ecommerceproject.api.entity.LoginBody;
import com.project.ecommerceproject.api.entity.RegistrationBody;
import com.project.ecommerceproject.entity.LocalUser;
import com.project.ecommerceproject.exception.UserAlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private LocalUserDAO localUserDAO;
    private EncryptionService encryptionService;
    private JWTService jwtService;
    public UserService(LocalUserDAO localUserDAO, EncryptionService encryptionService,JWTService jwtService) {
        this.localUserDAO = localUserDAO;
        this.encryptionService = encryptionService;
        this.jwtService=jwtService;
    }

    public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if(localUserDAO.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
        && localUserDAO.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        LocalUser user=new LocalUser();
        user.setEmail(registrationBody.getEmail());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setUsername(registrationBody.getUsername());
        user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword())); //to creat hashed pw

       return localUserDAO.save(user);

    }

    public String loginUser(LoginBody loginBody){
        Optional<LocalUser> opUser=localUserDAO.findByEmailIgnoreCase(loginBody.getUsername());
        if(opUser.isPresent()){
            LocalUser user= opUser.get();
            if(encryptionService.verifyPassword(loginBody.getPassword(),user.getPassword())){
                return jwtService.generateJWT(user);
            }
        }
        return null;
    }

}
