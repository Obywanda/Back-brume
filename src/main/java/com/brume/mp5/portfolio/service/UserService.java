package com.brume.mp5.portfolio.service;

import com.brume.mp5.portfolio.entity.User;
import com.brume.mp5.portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //Methode qui permet de cree un nouvelle user
    public void creer(User user) {
        User userDansLaBDD = this.userRepository.findByEmail(user.getEmail());
        if (userDansLaBDD == null) {
            this.userRepository.save(user);
        }
    }

    //Methode afficher une liste de users
    public List<User> rechercher(){
        return this.userRepository.findAll();
    }


    public User lire(int id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    public User lireOuCreer(User userAcreer) {
        User userDansLaBDD = this.userRepository.findByEmail(userAcreer.getEmail());
        if (userDansLaBDD == null) {
            userDansLaBDD = this.userRepository.save(userAcreer);
        }
        return userDansLaBDD;
    }
}
