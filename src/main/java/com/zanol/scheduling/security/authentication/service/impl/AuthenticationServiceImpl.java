package com.zanol.scheduling.security.authentication.service.impl;

//import com.zanol.scheduling.security.authentication.Authenticator;
import com.zanol.scheduling.security.authentication.model.Credentials;
import com.zanol.scheduling.security.authentication.service.AuthenticationService;
import com.zanol.scheduling.user.model.User;
import com.zanol.scheduling.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UserService userService;

    @Override
    public String generateToken(Credentials credentials) {
        if (!credentials.isFilled()) {
            throw new RuntimeException("Usuário e senha devem ser preenchidos!");
        }

        if (isValidCredentials(credentials)) {
            //return Authenticator.getInstance().genarateToken(credentials);
            return null;
        }else {
            throw new RuntimeException("Usuário e/ou senha inválido(s)!");
        }
    }

    @Override
    public Boolean isValidCredentials(Credentials credentials) {
        Optional<User> user = userService.getUserByCode(credentials.getUserCode());
/*        User user = (User) PersistEngine.getObject(
                em, User.class, "code", credentials.getUserCode());

        if (user == null)
            return false;

        return user.isValidPassword(credentials.getUserPassword());*/
        return null;
    }
}