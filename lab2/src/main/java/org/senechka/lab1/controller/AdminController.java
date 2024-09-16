package org.senechka.lab1.controller;

import org.senechka.lab1.models.Dates;
import org.senechka.lab1.models.User;
import org.senechka.lab1.models.UserTickets;
import org.senechka.lab1.security.jwt.UserService;
import org.senechka.lab1.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;
    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAllTicket")
    public List<UserTickets> getAllUserTickets(){
        return adminService.getAllTickets();
    }
    //хз как по умному
    @PostMapping("/setAdmin")
    public void setAdminForUser(@ModelAttribute(value = "id") UUID id){
        adminService.setAdminForUser(id);
        userService.getAdmin();
    }
    //@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/viewUserInformation")
    public Optional<User> getUserInformation(@ModelAttribute(value = "username") String username){
        System.out.println(adminService.getCurrentUserDetails(username));
       return adminService.getCurrentUserDetails(username);
    }

    @GetMapping("/xyu")
    public void xyu(){
        System.out.println("P E N I S");
    }
}
