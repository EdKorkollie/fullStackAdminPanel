package Controller;

import Service.ProductService;
import Service.TransactionService;
import Service.UserService;
import model.Role;
import model.Transaction;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDateTime;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/api/user/registration")
    private ResponseEntity<?> register(@RequestBody User user) {
        //username should be unique, so we check if username exist or not. if username already exist well return conflict status.
        if(userService.findByUsername(user.getUsername()) != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        //default role
        user.setRole(Role.USER);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/api/user/login")
    public ResponseEntity<?> getUser(Principal principal) {

        if(principal == null || principal.getName() == null) {
            //logout will also be use here so we should return ok http status
            return ResponseEntity.ok(principal);
        }
        return new ResponseEntity<>(userService.findByUsername(principal.getName()), HttpStatus.OK);
    }

    @PostMapping("/api/user/purchase")
    public ResponseEntity<?> purchaseProduct(@RequestBody Transaction transaction) {
        transaction.setPurchaseDate(LocalDateTime.now());
        return new ResponseEntity<>(transactionService.saveTransaction(transaction), HttpStatus.CREATED);
    }

    @GetMapping("/api/user/products")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productService.findAllProducts(), HttpStatus.OK);
    }
}
