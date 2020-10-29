package com.kodilla.ecommerce.controller;
import com.kodilla.ecommerce.dto.GroupDto;
import com.kodilla.ecommerce.domain.GroupNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/group")
public class GroupController {

    @GetMapping
    public List<GroupDto> getGroups() {
        GroupDto groupDto1 = new GroupDto(3,"example1", "desc1", null);
        GroupDto groupDto2 = new GroupDto(4,"example2", "desc2", null);
        List<GroupDto> groupDtoArrayList = new ArrayList<>();
        groupDtoArrayList.add(groupDto1);
        groupDtoArrayList.add(groupDto2);
        return groupDtoArrayList;
    }

    @GetMapping("{groupId}")
    public GroupDto getGroup(@PathVariable Long groupId) throws GroupNotFoundException {
        if (groupId == 3) {
            return new GroupDto(3, "example", "desc1", null);
        } else {
            return new GroupDto(0, "test", "test", null);
        }
    }

    @PostMapping
    public void createGroup(@RequestBody GroupDto groupDto) {
    }

    @PutMapping
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return new GroupDto(6, "updated DTO","desc1", null);
    }
}
