package rs.ac.bg.fon.silab.ru.service;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.ru.dao.GenericDAO;
import rs.ac.bg.fon.silab.ru.domain.AccessToken;
import rs.ac.bg.fon.silab.ru.domain.IDomain;
import rs.ac.bg.fon.silab.ru.domain.User;
import rs.ac.bg.fon.silab.ru.dto.UserDTO;

/**
 *
 * @author user
 */
@Service
public class UserService {
    @Autowired
    GenericDAO genericDao;

    public UserDTO login(String username, String password) throws Exception {
        String passwordHash = Hashing.sha1().hashString(password, Charsets.UTF_8).toString();
        
        Map<String, Object> params = new HashMap<>();
        params.put("username", username);
        params.put("password", passwordHash);
        
        List<IDomain> result = genericDao.findByQueryName("User.findByUsernameAndPassword", params);
        if((result != null) && (!result.isEmpty())) {
            User user = (User) result.get(0);
            String role = user.getRole();
            
            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(username);
            userDTO.setRole(role);
            
            params = new HashMap<>();
            params.put("userId", user.getId());
            
            List<IDomain> res = genericDao.findByQueryName("AccessToken.findByUser", params);
            if((res != null) && (!res.isEmpty())) {
                AccessToken token = (AccessToken) res.get(0);
                Date now = new Date();
                if(!now.before(token.getExpire())) {
                    Date tommorow = getTommorow();

                    token.setExpire(tommorow);
                    token = (AccessToken) genericDao.update(token);
                } 
                
                userDTO.setToken(token.getToken());
                return userDTO;
            }
            String token = getToken();
            Date tommorow = getTommorow();
            
            // create new token
            AccessToken accessToken = new AccessToken();
            accessToken.setToken(token);
            accessToken.setExpire(tommorow);
            accessToken.setUser(user);
            
            accessToken = (AccessToken) genericDao.insert(accessToken);
            
            userDTO.setToken(accessToken.getToken());
            return userDTO;
        } else {
            throw new Exception("Korisnik sa unetim parametrima ne postoji u sistemu.");
        }
    }
    
    public void logout(String token) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        
        List<IDomain> result = genericDao.findByQueryName("AccessToken.findByToken", params);
        if((result != null) && (!result.isEmpty())) {
            AccessToken accessToken = (AccessToken) result.get(0);
            genericDao.delete(accessToken);
        } else {
            throw new Exception("Greška prilikom učitavanja tokena.");
        }
    }
    
    public void checkUser(String token) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("token", token);
        
        List<IDomain> result = genericDao.findByQueryName("AccessToken.findByToken", params);
        if(result == null || result.isEmpty()) {
            throw new Exception("Korisnik sa datim tokenom ne postoji u sistemu.");
        }
    }
    
    private Date getTommorow() {
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DATE, 1);
        Date tommorow = new Date(cal.getTimeInMillis());

        return tommorow;
    }
    
    private String getToken() {
        Date now = new Date();
        String time = String.valueOf(now.getTime());
        
        return Hashing.sha1().hashString(time, Charsets.UTF_8).toString();
    }
}
