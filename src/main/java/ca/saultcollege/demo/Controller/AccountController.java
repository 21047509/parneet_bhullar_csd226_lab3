package ca.saultcollege.demo.Controller;

import ca.saultcollege.demo.data.*;
import ca.saultcollege.demo.repositories.AccountRepository;
import ca.saultcollege.demo.repositories.RegistryRepository;
import ca.saultcollege.demo.security.JwtTokenUtil;
import ca.saultcollege.demo.security.RefreshTokenUtil;
import ch.qos.logback.core.model.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")


public class AccountController {
    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtTokenUtil jwtUtil;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    RefreshTokenUtil refreshTokenUtil;












    //    @PostMapping("/auth")
//    @PostMapping(value = "/auth/login_old")
//    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
//        try {
//            Authentication authentication = authManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            request.getEmail(), request.getPassword())
//            );
//
//            Account account = new Account();
//            account.setId(1);
//            account.setEmail(authentication.getPrincipal().toString());
//
//            String accessToken = jwtUtil.generateAccessToken(account);
//
//            AuthResponse response = new AuthResponse(account.getEmail(), accessToken);
//
//            return ResponseEntity.ok().body(response);
//        } catch (Exception ex) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }


    //    @PostMapping("/signup")
//    public ResponseEntity<String> createAccount(@RequestBody Account signUpFormData){
//        return ResponseEntity.ok("createAccount() : "+signUpFormData.getEmail());
//    }
    @GetMapping("/signin")
    public ResponseEntity<String> getSignin() { // map a URL to a method
        String s = "<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "" +
                "<head>" +
                "  <meta charset=\"UTF-8\">" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "  <title>Login</title>" +
                "  <link rel=\"stylesheet\" href=\"login-page.css\">" +
                "<style>" +
                "  html {" +
                "    height: 100%;" +
                "  }" +
                "" +
                "  body {" +
                "    height: 100%;" +
                "    margin: 0;" +
                "    font-family: Arial, Helvetica, sans-serif;" +
                "    display: grid;" +
                "    justify-items: center;" +
                "    align-items: center;" +
                "    background-color: #3a3a3a;" +
                "  }" +
                "" +
                "  #main-holder {" +
                "    width: 50%;" +
                "    height: 70%;" +
                "    display: grid;" +
                "    justify-items: center;" +
                "    align-items: center;" +
                "    background-color: white;" +
                "    border-radius: 7px;" +
                "    box-shadow: 0px 0px 5px 2px black;" +
                "  }" +
                "" +
                "  #login-error-msg-holder {" +
                "    width: 100%;" +
                "    height: 100%;" +
                "    display: grid;" +
                "    justify-items: center;" +
                "    align-items: center;" +
                "  }" +
                "" +
                "  #login-error-msg {" +
                "    width: 23%;" +
                "    text-align: center;" +
                "    margin: 0;" +
                "    padding: 5px;" +
                "    font-size: 12px;" +
                "    font-weight: bold;" +
                "    color: #8a0000;" +
                "    border: 1px solid #8a0000;" +
                "    background-color: #e58f8f;" +
                "    opacity: 0;" +
                "  }" +
                "" +
                "  #error-msg-second-line {" +
                "    display: block;" +
                "  }" +
                "" +
                "  #login-form {" +
                "    align-self: flex-start;" +
                "    display: grid;" +
                "    justify-items: center;" +
                "    align-items: center;" +
                "  }" +
                "" +
                "  .login-form-field::placeholder {" +
                "    color: #3a3a3a;" +
                "  }" +
                "" +
                "  .login-form-field {" +
                "    border: none;" +
                "    border-bottom: 1px solid #3a3a3a;" +
                "    margin-bottom: 10px;" +
                "    border-radius: 3px;" +
                "    outline: none;" +
                "    padding: 0px 0px 5px 5px;" +
                "  }" +
                "" +
                "  #login-form-submit {" +
                "    width: 100%;" +
                "    padding: 7px;" +
                "    border: none;" +
                "    border-radius: 5px;" +
                "    color: white;" +
                "    font-weight: bold;" +
                "    background-color: #3a3a3a;" +
                "    cursor: pointer;" +
                "    outline: none;" +
                "  }" +
                "</style>" +
                "</head>" +
                "" +
                "<body>" +
                "<main id=\"main-holder\">" +
                "  <h1 id=\"login-header\">Login</h1>" +
                "" +
                "  <div id=\"login-error-msg-holder\">" +
                "  </div>" +
                "" +
                "  <form id=\"login-form\" hx-post=\"/auth/login\" hx-target=\"this\">" +
                "    <input type=\"text\" name=\"username\" id=\"username-field\" class=\"login-form-field\" placeholder=\"Username\">" +
                "    <input type=\"password\" name=\"password\" id=\"password-field\" class=\"login-form-field\" placeholder=\"Password\">" +
                "    <input type=\"submit\" value=\"Login\" id=\"login-form-submit\">" +
                "  </form>" +
                "" +
                "</main>" +
                "</body>" +
                "" +
                "</html>";
        return ResponseEntity.ok(s);
    }

    @GetMapping("/signin55")
    public ResponseEntity<String> getSignin55() { // map a URL to a method
        String s = "<form hx-post=\"/signin\" hx-target=\"this\" hx-swap=\"outerHTML\">" +
                "    <div>xx" +
                "        <label>First Name</label>" +
                "        <input type=\"text\" name=\"firstname\" value=\"Joe\">" +
                "    </div>" +
                "    <div class=\"form-group\">" +
                "        <label>Last Name</label>" +
                "        <input type=\"text\" name=\"lastname\" value=\"Blow\">" +
                "    </div>" +
                "    <div class=\"form-group\">" +
                "        <label>Email Address</label>" +
                "        <input type=\"email\" name=\"email\" value=\"joe@blow.com\">" +
                "    </div>" +
                "    <div class=\"form-group\">" +
                "        <label>Password</label>" +
                "        <input type=\"password\" name=\"password\" value=\"xxxxx\">" +
                "    </div>" +
                "    <div class=\"form-group\">" +
                "        <label>Confirm Password</label>" +
                "        <input type=\"password\" name=\"confirmPassword\" value=\"xxxxx\">" +
                "    </div>" +
                "    <button class=\"btn\">Submit</button>" +
                "    <button class=\"btn\" hx-get=\"/signin\">Cancel</button>" +
                "</form>";
        return ResponseEntity.ok(s);
    }

    @PostMapping("/signup")
    public ResponseEntity<String> createAccount(@RequestBody Account signUpFormData) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode(signUpFormData.getPassword());

        signUpFormData.setPassword(password);

        Account savedAccount = accountRepository.save(signUpFormData);

        return ResponseEntity.ok("createAccount(): " + signUpFormData.getEmail());
    }

//    @GetMapping("/signup")
//    public ResponseEntity<String> getSignup() { // map a URL to a method
//        String s = "<form hx-post=\"/signin\" hx-target=\"this\" hx-swap=\"outerHTML\">" +
//                "    <div>" +
//                "        <label>First Name</label>" +
//                "        <input type=\"text\" name=\"firstname\" value=\"Joe\">" +
//                "    </div>" +
//                "    <div class=\"form-group\">" +
//                "        <label>Last Name</label>" +
//                "        <input type=\"text\" name=\"lastname\" value=\"Blow\">" +
//                "    </div>" +
//                "    <div class=\"form-group\">" +
//                "        <label>Email Address</label>" +
//                "        <input type=\"email\" name=\"email\" value=\"joe@blow.com\">" +
//                "    </div>" +
//                "    <div class=\"form-group\">" +
//                "        <label>Password</label>" +
//                "        <input type=\"password\" name=\"password\" value=\"xxxxx\">" +
//                "    </div>" +
//                "    <div class=\"form-group\">" +
//                "        <label>Confirm Password</label>" +
//                "        <input type=\"password\" name=\"confirmPassword\" value=\"xxxxx\">" +
//                "    </div>" +
//                "    <button class=\"btn\">Submit</button>" +
//                "    <button class=\"btn\" hx-get=\"/signin\">Cancel</button>" +
//                "</form>";
//        return ResponseEntity.ok(s);
//    }

    @GetMapping("/home")
    public ResponseEntity<String> getHome() {
        String homeContent = "<h1>Welcome to Our Bookstore</h1>"
                + "<p>Explore our wide selection of books</p>"
                + "<a href=\"/catalog\" class=\"btn\">Browse Catalog</a>";
        return ResponseEntity.ok(homeContent);
    }


    // just here for reference: call it with http://localhost:8080/signup2?email=f.c@g.c
    @GetMapping("/signup2")
    @ResponseBody
    public String createAccount2(@RequestParam String email) {
        return "email: " + email;
    }


    @Autowired
    RegistryRepository registryRepository;
//
//    private Boolean updateRegistry(String registryKey, String registryValue) {
//        //Find the record for the registry entry based on the supplied key
//        List<Registry> registryEntries = registryRepository.findByRegistryKey(registryKey);
//
//        Registry registryEntry = new Registry();
//
//        if (registryEntries.size() == 0) {
//            registryEntry.setRegistryKey(registryKey);
//        } else {
//            registryEntry = registryEntries.get(0);
//        }
//
//        registryEntry.setRegistryValue(registryValue);
//
//        //Update the registry table with new value
//        registryRepository.save(registryEntry);
//
//        return true;
//    }

    @PostMapping(path="/auth/login")
    public ResponseEntity<?> login(@ModelAttribute Account acc, Model model) {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            acc.getEmail(), acc.getPassword())
            );

            Account account = (Account) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(account);
            RefreshToken refreshToken = refreshTokenUtil.createRefreshToken(account.getId());

            AuthResponse response = new AuthResponse(account.getEmail(), accessToken,refreshToken.getToken());

            return ResponseEntity.ok().body(response + "<script>alert('setting var \\\"accessToken\\\"');var accessToken='" + accessToken + "';</script>");
        } catch( Exception ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    @GetMapping("/protectedPage")
    public ResponseEntity<String> getProtectedPage(org.springframework.ui.Model model){ // map a URL to a method
        String s="" +
                "<h1>Protected page</h1>";
        return ResponseEntity.ok(s);
    }
    @GetMapping("/unProtectedPage")
    public ResponseEntity<String> getUnProtectedPage(@RequestHeader Map<String, String> headers) { // map a URL to a method

        ArrayList<String> h=new ArrayList<>();
        headers.forEach((key, value) -> {
            h.add(String.format("Header '%s' = %s", key, value));
        });
        String s="" +
                "<h1>Un Protected page</h1>";
        return ResponseEntity.ok(s);
    }

    @PostMapping("/auth/refreshtoken")
    public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();

        try {
            RefreshToken refreshToken = refreshTokenUtil.findByToken(requestRefreshToken);

            if (refreshToken != null) {
                if (refreshTokenUtil.verifyExpiration(refreshToken)) {
                    Account account = accountRepository.getById(refreshToken.getAccount().getId());
                    String token = jwtUtil.generateAccessToken(account);
                    return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                } else {
                    throw new Exception("RefreshTokenExpired");
                }
            }
        } catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    //hello
}


