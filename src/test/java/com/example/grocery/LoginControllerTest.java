
package com.example.grocery;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.grocery.controller.LoginController;
import com.example.grocery.domain.User;
import com.example.grocery.repository.UserRepository;

@WebMvcTest(LoginController.class)
class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserRepository repo;

    @Test
    void testLoginWithCorrectCredentials() throws Exception {

        User user = new User();
        user.setId(1);
        user.setName("testuser");
        user.setPassword("testpassword");

        when(repo.findByNameAndPassword(
                "testuser", "testpassword"))
                .thenReturn(user);

        mockMvc.perform(post("/signin")
                .param("name", "testuser")
                .param("password", "testpassword"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/dashboard.html"));
    }

    @Test
    void testLoginWithIncorrectCredentials() throws Exception {

        when(repo.findByNameAndPassword(
                "wronguser", "wrongpassword"))
                .thenReturn(null);

        mockMvc.perform(post("/signin")
                .param("name", "wronguser")
                .param("password", "wrongpassword"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/register.html"));
    }
}