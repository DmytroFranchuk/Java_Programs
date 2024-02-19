package org.example.service;

import org.example.dto.Friend;
import org.example.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FriendService {
    private final List<Friend> friendList;

    public FriendService() {
        this.friendList = new ArrayList<>(List.of(
                new Friend("Warren", "Buffett", LocalDate.parse("1930-08-30")),
                new Friend("Michael", "Saul Dell", LocalDate.parse("1965-02-23")),
                new Friend("Martha", "Stewart", LocalDate.parse("1941-08-03")),
                new Friend("Marta", "Rudolf", LocalDate.parse("1975-02-18"))
        ));
    }

    public void addFriend(Friend newFriend) {
        if (newFriend != null && isValidFriend(newFriend) && !isDuplicateFriend(newFriend)) {
            friendList.add(newFriend);
        }
    }

    private boolean isValidFriend(Friend friend) {
        return friend.getName() != null && !friend.getName().trim().isEmpty()
                && friend.getSurname() != null && !friend.getSurname().trim().isEmpty()
                && friend.getDateOfBirth() != null;
    }

    private boolean isDuplicateFriend(Friend newFriend) {
        for (Friend existingFriend : friendList) {
            if (existingFriend.getName().equalsIgnoreCase(newFriend.getName()) &&
                    existingFriend.getSurname().equalsIgnoreCase(newFriend.getSurname())) {
                return true;
            }
        }
        return false;
    }

    public List<Friend> getAllFriends() {
        return friendList;
    }

    public List<Friend> getTodayBirthdayFriends() {
        LocalDate today = LocalDate.now();
        return friendList.stream()
                .filter(friend -> friend.getDateOfBirth().getMonth() == today.getMonth()
                        && friend.getDateOfBirth().getDayOfMonth() == today.getDayOfMonth())
                .collect(Collectors.toList());
    }

    public List<Friend> findFriendsByDate(LocalDate date) {
        List<Friend> result = friendList.stream()
                .filter(friend -> friend.getDateOfBirth().equals(date))
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new NotFoundException("There are no birthdays on the specified date");
        }
        return result;
    }

    public LocalDate findDateByNameAndSurname(String name, String surname) {
        Optional<LocalDate> result = friendList.stream()
                .filter(friend -> friend.getName().equals(name) && friend.getSurname().equals(surname))
                .map(Friend::getDateOfBirth)
                .findFirst();
        if (result.isEmpty()) {
            throw new NotFoundException("Date not found for the given name and surname");
        }
        return result.get();
    }












}
