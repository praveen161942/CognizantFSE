import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;  // 👈 Mocked even in integration

    @Test
    public void testGetUserIntegrationWithMockedService() throws Exception {
        User mockUser = new User();
        mockUser.setId(99L);
        mockUser.setName("Charlie");

        when(userService.getUserById(99L)).thenReturn(mockUser);

        mockMvc.perform(get("/users/99"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id", is(99)))
               .andExpect(jsonPath("$.name", is("Charlie")));
    }
}