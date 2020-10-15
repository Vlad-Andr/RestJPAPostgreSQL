package home.efu.restjpapostgres.service;

import home.efu.restjpapostgres.model.MyUserDetails;
import home.efu.restjpapostgres.model.User;
import home.efu.restjpapostgres.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceJpaPostgresImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void addNewUser(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> allUsers() {
        return userRepo.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void updateUser(Long id, User user) {
        userRepo.deleteById(id);
        userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

/*
    @Override
    public User findUserByMaxAge() {
        return userRepo.findUserByAgeWhereAmountLettersMax();
    }
*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepo.findUserByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("User not found!"));

        return user.map(MyUserDetails::new).get();
    }
}