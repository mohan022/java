/*
 * package com.es.services;
 * 
 * import java.util.List;
 * 
 * import javax.transaction.Transactional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Component;
 * 
 * import com.excelsoft.enties.User; import com.excelsoft.repo.UserRepo;
 * 
 * @Component public class UserService {
 * 
 * @Autowired UserRepo userRepo;
 * 
 * @Transactional public User registerNewUser(User user) { return
 * userRepo.save(user);
 * 
 * }
 * 
 * public User searchByUserName(String username) { List<User> user =
 * userRepo.findAll(); if (user.size() > 0) { return user.get(0); } else {
 * return null; }
 * 
 * }
 * 
 * }
 */
