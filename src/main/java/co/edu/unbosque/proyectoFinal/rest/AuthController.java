package co.edu.unbosque.proyectoFinal.rest;

import co.edu.unbosque.proyectoFinal.entities.Usuario;
import co.edu.unbosque.proyectoFinal.repository.UsuarioRepository;
import co.edu.unbosque.proyectoFinal.security.jwt.JwtTokenUtil;
import co.edu.unbosque.proyectoFinal.security.payload.JwtResponse;
import co.edu.unbosque.proyectoFinal.security.payload.LoginRequest;
import co.edu.unbosque.proyectoFinal.security.payload.MessageResponse;
import co.edu.unbosque.proyectoFinal.security.payload.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authManager;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;
    private final JwtTokenUtil jwtTokenUtil;

    public AuthController(AuthenticationManager authManager, UsuarioRepository usuarioRepository, PasswordEncoder encoder, JwtTokenUtil jwtTokenUtil) {
        this.authManager = authManager;
        this.usuarioRepository = usuarioRepository;
        this.encoder = encoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest){

        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtTokenUtil.generateJwtToken(authentication);
            return ResponseEntity.ok(new JwtResponse(jwt));
        }catch (Exception e){
            return ResponseEntity.ok(new JwtResponse("Credenciales incorrectas"));
        }

        // UserDetails userDetails = (UserDetails) authentication.getPrincipal();


    }
    @PostMapping("/register")
    public ResponseEntity<MessageResponse> register(@RequestBody RegisterRequest signUpRequest) {

        // Check 1: username
        if (usuarioRepository.existsByCorreo(signUpRequest.getCorreo())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        // Check 2: email
        if (usuarioRepository.existsByCorreo(signUpRequest.getCorreo())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        Usuario user = new Usuario(null,signUpRequest.getId_rol(),signUpRequest.getNombre(),signUpRequest.getCorreo(), encoder.encode(signUpRequest.getContrasena()),signUpRequest.getTelefono(),signUpRequest.getDireccion(),true);


        usuarioRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
