//package uit.se121.FiPT.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import uit.se121.FiPT.entity.User;
//import uit.se121.FiPT.service.AccountService;
//
//@RestController
//@RequestMapping("/account")
//public class AccountController {
//
//    @Autowired
//    private AccountService accountService;
//
//    @CrossOrigin(origins = "http://localhost:3000")
//    @PostMapping("/register")
//    public ResponseEntity<?> registerAccount(@Validated @RequestBody User user) {
//        ResponseEntity<?> response = accountService.registerUser(user);
//        return response;
//    }
//}
