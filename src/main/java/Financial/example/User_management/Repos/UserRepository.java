package Financial.example.User_management.Repos;

import Financial.example.User_management.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer > {
    Optional<User> findByEmail(String email);
}
