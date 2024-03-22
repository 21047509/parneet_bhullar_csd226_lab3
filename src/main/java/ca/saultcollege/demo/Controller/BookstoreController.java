package ca.saultcollege.demo.Controller;

import ca.saultcollege.demo.data.Content;
import ca.saultcollege.demo.data.Registry;
import ca.saultcollege.demo.repositories.RegistryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookstoreController {

    @GetMapping("/staffcontent")
    public ResponseEntity<String> getStaffContent(){ // map a URL to a method
        return ResponseEntity.ok("getStaffContent() : Staff");
    }


    @GetMapping("/publiccontent")
    public ResponseEntity<String> getPublicContent(){ // map a URL to a method

        String responseBody = "Welcome to our Bookstore organization";
        return ResponseEntity.ok(responseBody);
    }

//    @GetMapping("/signup")
//    public ResponseEntity<String> signup(){ // map a URL to a method
//
//        return ResponseEntity.ok("SignUp");
//    }

    @GetMapping("/about")
    public ResponseEntity<String> getAbout(){ // map a URL to a method
        return ResponseEntity.ok("At Heaven Bookstore, we're passionate about connecting readers with their next favorite book. Our curated collection spans genres," +
                " from classics to contemporary bestsellers. With a cozy atmosphere and knowledgeable staff, we're dedicated to fostering a love of reading in our community." +
                " Welcome to your literary haven!<br><br><button onclick=\\\"window.location.href='/browse-books'\\\">Browse Books</button>\n"+
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n");
    }

    @GetMapping("/project")
    public ResponseEntity<String> getProject(){ // map a URL to a method
        return ResponseEntity.ok("At Heaven Bookstore, we're always excited about upcoming projects and new launches that will delight our customers and enrich their reading experience. Stay tuned for our calendar of author events, where you can meet your favorite writers and discover new voices in literature. We're also constantly adding fresh titles to our shelves, from anticipated releases by bestselling authors to hidden gems waiting to be discovered." +
                " Keep an eye out for our curated collections and thematic displays, designed to inspire your next reading journey. Whether you're a fan of fiction, non-fiction, or something in between, there's always something new and exciting waiting for you at [Bookstore Name]. Join us as we continue to celebrate the joy of reading and explore the endless possibilities of the written word");
    }

    @GetMapping("/content")
    public ResponseEntity<String> getContent(){ // map a URL to a method
        return ResponseEntity.ok("\"At Heaven Bookstore, we offer a diverse selection of books across various genres to cater to every reader's taste. Dive into the world of fiction with our extensive collection of novels, ranging from gripping thrillers to heartwarming romance and classic literature." +
                " Explore the realms of non-fiction with insightful biographies, thought-provoking essays, and informative guides covering a wide array of topics including history, science, self-help, and more.\n" +
                "\n" +
                "Our website provides a seamless browsing experience, allowing you to discover new releases, bestsellers, and hidden literary gems from the comfort of your home. With user-friendly navigation and detailed genre categories, finding your next great read has never been easier.\n" +
                "\n" +
                "Additionally, we understand the importance of community and connection in the world of literature. That's why we offer features such as book clubs, author spotlights, and reader reviews to foster engagement and discussion among book lovers. Whether you're seeking recommendations," +
                " participating in lively debates, or simply sharing your love for a recently discovered favorite, our website is your virtual hub for all things book-related.");
    }
    @GetMapping("/publiccontent2")
    public Content getPublicContent2(){ // map a URL to a method
        return new Content("some content");
    }

    @GetMapping("/login")
    public ResponseEntity<String> getLogin(){ // map a URL to a method
        return ResponseEntity.ok("<form id=\"login-form\">\n" +
                "    <input type=\"text\" name=\"username\" id=\"username-field\" class=\"login-form-field\" placeholder=\"Username\">\n" +
                "    <input type=\"password\" name=\"password\" id=\"password-field\" class=\"login-form-field\" placeholder=\"Password\">\n" +
                "    <input type=\"submit\" value=\"Login\" id=\"login-form-submit\">\n" +
                "  </form>");
    }
    @PutMapping("/publiccontent")
    public ResponseEntity<Boolean> savePublicContent(@RequestBody @Valid Registry content) {
        Boolean result = updateRegistry(content.getRegistryKey(), content.getRegistryValue());
        return ResponseEntity.ok(result);
    }

    @PutMapping("/staffcontent")
    public ResponseEntity<Boolean> saveStaffContent(@RequestBody @Valid Registry content) {
        Boolean result = updateRegistry(content.getRegistryKey(), content.getRegistryValue());
        return ResponseEntity.ok(result);
    }





//    @PostMapping("/signup")
//    public ResponseEntity<String> createAccount(@RequestBody Account signUpFormData){
//        return ResponseEntity.ok("createAccount() : "+signUpFormData.getEmail());
//    }

    @Autowired
    RegistryRepository registryRepository;

    private Boolean updateRegistry(String registryKey, String registryValue) {
        //Find the record for the registry entry based on the supplied key
        List<Registry> registryEntries = registryRepository.findByRegistryKey(registryKey);

        Registry registryEntry = new Registry();

        if (registryEntries.size() == 0) {
            registryEntry.setRegistryKey(registryKey);
        } else {
            registryEntry = registryEntries.get(0);
        }

        registryEntry.setRegistryValue(registryValue);

        //Update the registry table with new value
        registryRepository.save(registryEntry);

        return true;
    }

    private String getRegistry(String registryKey) {
        //Find the record for the registry entry based on the supplied key
        List<Registry> registryEntries = registryRepository.findByRegistryKey(registryKey);

        Registry registryEntry = new Registry();

        if (registryEntries.size() == 0) {
            return "";
        }

        return registryEntries.get(0).getRegistryValue();
    }






}
