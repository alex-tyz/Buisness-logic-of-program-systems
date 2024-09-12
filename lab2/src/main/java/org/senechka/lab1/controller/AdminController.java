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
import java.util.UUID;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

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

    @PostMapping("/viewUserInformation")
    public User getUserInformation(@ModelAttribute String username){
       return adminService.getCurrentUserDetails(username);
    }
}
