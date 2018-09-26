package rs.ac.bg.fon.silab.ru.controller;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.ru.Response;
import rs.ac.bg.fon.silab.ru.dto.UserDTO;
import rs.ac.bg.fon.silab.ru.service.UserService;

/**
 *
 * @author user
 */
@RestController
public class LoginController {
    @Autowired
    UserService userService;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Response login(@RequestHeader("username") String username, @RequestHeader("password") String password) {
        Response response;
        try {
            UserDTO user = userService.login(username, password);
            response = new Response("success", user);
        } catch(Exception ex) {
            response = new Response("failure", null, ex.getMessage());
        }

        return response;
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.DELETE)
    public Response logout(@RequestHeader("X-Auth-Token") String token) {
        Response response;
        try {
            userService.logout(token);
            response = new Response("success", null);
        } catch(Exception ex) {
            response = new Response("failure", null, ex.getMessage());
        }

        return response;
    }
    
    @RequestMapping(value = "/checkUser", method = RequestMethod.GET)
    public Response checkUser(@RequestHeader("X-Auth-Token") String token) {
        Response response;
        try {
            userService.checkUser(token);
            response = new Response("success", null, "Navedeni token postoji u sistemu");
        } catch(Exception ex) {
            response = new Response("failure", null, ex.getMessage());
        }

        return response;
    }
    
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public void method() {
        
        String adminPasswordHash = Hashing.sha1().hashString("admin", Charsets.UTF_8).toString();
        System.out.println("======================= PASSWORD ================");
        System.out.println("Admin ======== " + adminPasswordHash);
        System.out.println("======================= PASSWORD ================");
        
        String markoPasswordHash = Hashing.sha1().hashString("marko", Charsets.UTF_8).toString();
        System.out.println("======================= PASSWORD ================");
        System.out.println("Marko ======== " + markoPasswordHash);
        System.out.println("======================= PASSWORD ================");
        
        String userPasswordHash = Hashing.sha1().hashString("user", Charsets.UTF_8).toString();
        System.out.println("======================= PASSWORD ================");
        System.out.println("User ======== " + userPasswordHash);
        System.out.println("======================= PASSWORD ================");
        
    }
    
     /*String passwordHash = Hashing.sha1().hashString("password", Charsets.UTF_8).toString();
        System.out.println("======================= PASSWORD ================");
        System.out.println("======== " + passwordHash);
        System.out.println("======================= PASSWORD ================");
        
        System.out.println("======================= TOKEN ================");
        System.out.println("======== " + token);
        System.out.println("======================= TOKEN ================");
        
        return new Response("success", null);*/
}
