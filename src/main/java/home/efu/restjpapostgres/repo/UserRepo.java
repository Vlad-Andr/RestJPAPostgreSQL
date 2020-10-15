package home.efu.restjpapostgres.repo;

import home.efu.restjpapostgres.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findUserByUserName(String name);

  /*  @Query(value = "SELECT * FROM users WHERE age = ( SELECT MAX (age) FROM users)",nativeQuery = true)
    User findUserByAgeWhereAmountLettersMax();*/
}