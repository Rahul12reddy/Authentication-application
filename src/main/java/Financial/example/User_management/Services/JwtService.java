package Financial.example.User_management.Services;

import Financial.example.User_management.Entities.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${security.jwt.secret-key}")
    private String secretKey;
    @Value("${security.jwt.expiration-time}")
    private long jwtExpiration;

    public String extractUsername(String token){
        return extractClaims(token, Claims::getSubject);
    }
    public boolean isValid(String token, UserDetails userDetails){
        String username=extractUsername(token);
        return (username.equals(userDetails.getUsername()) && (!isTokenExpired(token)));
    }

    public boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date(System.currentTimeMillis()));
    }

    private Date extractExpiration(String token) {
        Date expiration = null;
        try {
            expiration = extractClaims(token, Claims::getExpiration);
            // Log expiration date to debug
            // System.out.println("Expiration Date: " + expiration);
        } catch (Exception e) {
            // Log the exception
            // e.printStackTrace();
        }
        return expiration;
        //return extractClaims(token, Claims::getExpiration);
    }
    public <T> T extractClaims(String token, Function<Claims,T> claimResolver){
        final Claims claims=extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    public Claims extractAllClaims(String token){
        try{
            return Jwts
                    .parser()
                    .verifyWith(getSignKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        }
        catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return null;
        }
    }

    public String generateToken(User user){
        String token=Jwts
                .builder()
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+jwtExpiration))
                .signWith(getSignKey())
                .compact();
        return token;
    }

    private SecretKey getSignKey() {
        byte[] key= Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(key);
    }

}
