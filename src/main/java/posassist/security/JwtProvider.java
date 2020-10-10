package posassist.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import posassist.exceptions.BadRequestException;
import posassist.security.services.UserPrinciple;

public class JwtProvider {
	
	@Value("${posassist.jwtSecret}")
	private String jwtSecret;
	
	@Value("${posassist.jwtExpiration}")
	private int jwtExpiration;
	
	public String generateJwtToken(Authentication authentication) {

        UserPrinciple userPrincipal = (UserPrinciple) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            throw new BadRequestException("Invalid JWT signature");
        } catch (MalformedJwtException e) {
            throw new BadRequestException("Invalid JWT token");
        } catch (ExpiredJwtException e) {
            throw new BadRequestException("Expired JWT token");
        } catch (UnsupportedJwtException e) {
            throw new BadRequestException("Unsupported JWT token");
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("JWT claims string is empty");
        }
    }
}
