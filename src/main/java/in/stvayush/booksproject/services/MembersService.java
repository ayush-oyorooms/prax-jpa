package in.stvayush.booksproject.services;

import in.stvayush.booksproject.dtos.MemberDto;
import in.stvayush.booksproject.dtos.SplitDto;
import in.stvayush.booksproject.models.Group;
import in.stvayush.booksproject.models.Member;
import in.stvayush.booksproject.repository.MembersRepository;
import java.util.ArrayList;
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
public class MembersService {
    private final MembersRepository membersRepository;

    public MemberDto createMember(MemberDto memberDto) {
        if (memberDto != null) {
            Member member = new Member();
            if (StringUtils.isNotEmpty(memberDto.getName())) {
                member.setName(memberDto.getName());
                membersRepository.save(member);
                memberDto.setId(member.getId());
            }
        }
        return memberDto;
    }

    public List<MemberDto> findMemberById(List<String> memberIds) {
        List<MemberDto> memberDtos = new ArrayList<>();
        List<Member> members = findMembersById(memberIds);
        if (!CollectionUtils.isEmpty(members)) {
            members.forEach(member -> {
                MemberDto memberDto = new MemberDto();
                memberDto.setId(member.getId());
                memberDto.setName(member.getName());
                memberDto.setGroups(member.getGroups().stream().map(Group::getName).toList());
                member.getOwedSplits().forEach(owedSplit -> {
                    SplitDto splitDto = SplitDto.builder()
                        .splitId(owedSplit.getId())
                        .expenseId(owedSplit.getExpense().getId())
                        .amount(owedSplit.getAmount())
                        .build();
                    memberDto.getOwedSplits().add(splitDto);
                });
                member.getPaidSplits().forEach(paidSplit -> {
                    SplitDto splitDto = SplitDto.builder()
                        .splitId(paidSplit.getId())
                        .expenseId(paidSplit.getExpense().getId())
                        .amount(paidSplit.getAmount())
                        .build();
                    memberDto.getPaidSplits().add(splitDto);
                });
                memberDtos.add(memberDto);
            });
        }
        return memberDtos;
    }

    public List<Member> findMembersById(List<String> userIds) {
        List<Member> members = new ArrayList<>();
        if (!CollectionUtils.isEmpty(userIds)) {
            userIds.forEach(userId ->
                membersRepository.findById(Long.parseLong(userId)).ifPresent(members::add)
            );
        } else {
            log.error("Empty list of userIds {} supplied for finding in db", userIds);
        }
        return members;
    }

    public Optional<Member> findMemberById(String userId) {
        return membersRepository.findById(Long.parseLong(userId));
    }

    public void updateMember() {
    }

}
