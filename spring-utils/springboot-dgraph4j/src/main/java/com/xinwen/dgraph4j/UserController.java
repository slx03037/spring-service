package com.xinwen.dgraph4j;

import com.xinwen.dgraph4j.entity.Follows;
import com.xinwen.dgraph4j.entity.User;
import com.xinwen.dgraph4j.service.DgraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author shenlx
 * @description
 * @date 2025/2/14 17:05
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private DgraphService dgraphService;

    @PostMapping
    public String addUser(@RequestBody User user) {
        try {
            dgraphService.addUser(user);
            return "User added successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to add user: " + e.getMessage();
        }
    }

    @PostMapping("/follows")
    public String addFollows(@RequestBody Follows follows) {
        try {
            dgraphService.addFollows(follows);
            return "Follows relationship added successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to add follows relationship: " + e.getMessage();
        }
    }

    @GetMapping("/{userName}/followers")
    public String getFollowers(@PathVariable String userName) {
        try {
            return dgraphService.getFollowers(userName);
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to get followers: " + e.getMessage();
        }
    }
}
