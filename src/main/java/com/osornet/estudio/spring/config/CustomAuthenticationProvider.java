package com.osornet.estudio.spring.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * CustomAuthenticationProvider
 */
@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider{

    @Autowired
    private UserDetailsService customUsersDetailService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        //datos del login
        String principal = authentication.getName();
        String credentials = (String)authentication.getCredentials();

        User usuario = (User)this.customUsersDetailService.loadUserByUsername(principal);
        
        if(usuario != null){
            //conprobar contraseña
            if(passwordEncoder.matches(credentials, usuario.getPassword())){
                System.out.println("Login Correcto");
                return new UsernamePasswordAuthenticationToken(principal, credentials, usuario.getAuthorities());
            }
            
        }
        
            System.out.println("Error de loging: "+principal);
            throw new BadCredentialsException("Error de Login");
        
    }
		
       
	

	public boolean supports(Class<?> authentication) {
		return true;
	}

    
}