package org.example.controller;

import jakarta.validation.Valid;
import org.example.dto.Friend;
import org.example.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/friends")
public class FriendController {
    private final FriendService friendService;

    @Autowired
    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping("/add")
    public String addNewRecord(Model model) {
        model.addAttribute("friend", new Friend("","", null));
        return "add_new_record_friend";
    }

    @PostMapping("/save")
    public String saveFriend(@ModelAttribute @Valid Friend friend, BindingResult result) {
        if (result.hasErrors()) {
            return "add_new_record_friend";
        }
        friendService.addFriend(friend);
        return "redirect:/friends/list";
    }

    @GetMapping("/list")
    public String showFriends(Model model) {
        List<Friend> friendList = friendService.getAllFriends();
        model.addAttribute("friendList", friendList);
        return "friend_list";
    }

    @PostMapping("/show")
    public String showFriendDetails(@ModelAttribute("friend") Friend friend, Model model) {
        model.addAttribute("friendDetails", friend);
        return "friend_details";
    }


}