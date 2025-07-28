import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testFullFlow() {
        User user = new User();
        user.setName("David");

        userRepository.save(user);

        User fetchedUser = userService.getUserById(user.getId());

        assertThat(fetchedUser).isNotNull();
        assertThat(fetchedUser.getName()).isEqualTo("David");
    }
}