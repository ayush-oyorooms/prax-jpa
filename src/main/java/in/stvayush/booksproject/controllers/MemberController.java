package in.stvayush.booksproject.controllers;

import in.stvayush.booksproject.dtos.MemberDto;
import in.stvayush.booksproject.services.MembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MembersService membersService;

    @PostMapping("/add")
    public MemberDto addMember(@RequestBody MemberDto memberDto) {
        return membersService.addMember(memberDto);
    }
}
