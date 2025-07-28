import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryCustomQueryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        User user = new User();
        user.setName("Sameer");
        userRepository.save(user);

        List<User> users = userRepository.findByName("Sameer");
        assertThat(users).isNotEmpty();
        assertThat(users.get(0).getName()).isEqualTo("Sameer");
    }
}