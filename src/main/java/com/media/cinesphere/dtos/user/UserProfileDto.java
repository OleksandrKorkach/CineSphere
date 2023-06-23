package com.media.cinesphere.dtos.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.media.cinesphere.dtos.watchlist.WatchListDto;
import com.media.cinesphere.entities.User;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserProfileDto {
    private Long id;
    private String username;
    private LocalDateTime wasCreated;
    private Set<WatchListDto> watchLists;


    public static UserProfileDto fromUser(User user){
        UserProfileDto dto = new UserProfileDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setWasCreated(user.getWasCreated());
        Set<WatchListDto> watchListsDto = user.getWatchLists().stream()
                .map(WatchListDto::fromWatchList)
                .collect(Collectors.toSet());
        dto.setWatchLists(watchListsDto);
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getWasCreated() {
        return wasCreated;
    }

    public void setWasCreated(LocalDateTime wasCreated) {
        this.wasCreated = wasCreated;
    }

    public Set<WatchListDto> getWatchLists() {
        return watchLists;
    }

    public void setWatchLists(Set<WatchListDto> watchLists) {
        this.watchLists = watchLists;
    }
}
