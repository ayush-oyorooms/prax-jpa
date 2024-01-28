package in.stvayush.booksproject.services;

import in.stvayush.booksproject.dtos.GroupDto;
import in.stvayush.booksproject.models.Expense;
import in.stvayush.booksproject.models.Group;
import in.stvayush.booksproject.models.Member;
import in.stvayush.booksproject.repository.GroupsRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
@RequiredArgsConstructor
public class GroupsService {

    private final GroupsRepository groupsRepository;
    private final MembersService membersService;

    public GroupDto createGroup(GroupDto groupDto) {
        if (groupDto != null) {
            Group group = new Group();
            if (StringUtils.isNotEmpty(groupDto.getName())) {
                group.setName(groupDto.getName());
                List<Member> members = membersService.findMembersById(groupDto.getMembers());
                group.setMembers(members);
                groupsRepository.save(group);
                groupDto.setId(group.getId());
            }
        } else {
            log.warn("An attempt to save invalid group object {} was made", groupDto);
        }
        return groupDto;
    }

    public GroupDto addMemberToGroup(String groupId, List<String> userIds) throws Exception {
        Optional<Group> group = groupsRepository.findById(Long.parseLong(groupId));
        GroupDto groupDto = new GroupDto();
        if (group.isPresent()) {
            Group _group = group.get();
            if (!CollectionUtils.isEmpty(userIds)) {
                List<Member> members = membersService.findMembersById(userIds);
                _group.setMembers(members);
                members.forEach(member -> member.getGroups().add(_group));
                groupsRepository.save(_group);
                groupDto.setId(_group.getId());
                groupDto.setName(_group.getName());
                groupDto.setMembers(_group.getMembers().stream().map(Member::getName).toList());
                groupDto.setExpenses(_group.getExpenses().stream().map(Expense::getTitle).toList());
            } else {
                log.error("Empty userIds list was supplied for adding to a group");
            }
        } else {
            log.error("No such group with id {} exists", groupId);
            throw new IllegalAccessException("Cannot add members to a non-existing group");
        }
        return groupDto;
    }
}
