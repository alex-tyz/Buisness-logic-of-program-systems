package org.senechka.lab1.service;

import org.senechka.lab1.exceptions.EmptyTownListException;
import org.senechka.lab1.models.Dates;
import org.senechka.lab1.models.User;
import org.senechka.lab1.models.UserTickets;
import org.senechka.lab1.repos.AdminRepository;
import org.senechka.lab1.repos.UserticktesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdminService {

    private final UserticktesRepository userticktesRepository;
    private final AdminRepository adminRepository;

    public AdminService(UserticktesRepository userticktesRepository, AdminRepository adminRepository) {
        this.userticktesRepository = userticktesRepository;
        this.adminRepository = adminRepository;
    }

    public List<UserTickets> getAllTickets(){
        if (userticktesRepository.getAllTickets().isEmpty()){
            throw new EmptyTownListException("There are no tickets today");
        }
        return userticktesRepository.getAllTickets();
    }

    public void setAdminForUser(UUID id){
        adminRepository.setAdminById(id);
    }

    public Optional<User> getCurrentUserDetails(String username){
        return adminRepository.getUserByUsername(username);
    }
}
