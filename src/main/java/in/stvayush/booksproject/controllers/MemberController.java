package in.stvayush.booksproject.controllers;

import in.stvayush.booksproject.constants.Endpoints;
import in.stvayush.booksproject.dtos.MemberDto;
import in.stvayush.booksproject.services.MembersService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.MEMBER)
@RequiredArgsConstructor
public class MemberController {
    private final MembersService membersService;

    @PostMapping(value = Endpoints.CREATE)
    public MemberDto createMember(@RequestBody MemberDto memberDto) {
        return membersService.createMember(memberDto);
    }

    @GetMapping(value = Endpoints.LIST)
    public List<MemberDto> retrieveMemberInfo(@RequestParam List<String> memberIds) {
        return membersService.findMemberById(memberIds);
    }
}
