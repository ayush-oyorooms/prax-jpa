package in.stvayush.booksproject.controllers;

import in.stvayush.booksproject.dtos.GroupDto;
import in.stvayush.booksproject.services.GroupsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/groups")
public class GroupsController {
    private final GroupsService groupsService;

    @PostMapping("/create")
    public GroupDto createGroup(@RequestBody GroupDto groupDto) {
        return groupsService.createGroup(groupDto);
    }

    @PutMapping("/update")
    public GroupDto addMemberToGroup(@RequestParam String groupId, @RequestParam List<String> userIds) {
        GroupDto groupDto = new GroupDto();
        try {
            groupDto = groupsService.addMemberToGroup(groupId, userIds);
        } catch (Exception e) {
            log.error("An error {} occurred while updating the group {}", e.toString(), groupId);
        }
        return groupDto;
    }
}
