package rs.ac.bg.fon.silab.ru.dto;

/**
 *
 * @author user
 */
public class UserDTO {
    private String username;
    private String role;
    private String token;

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
    
}
