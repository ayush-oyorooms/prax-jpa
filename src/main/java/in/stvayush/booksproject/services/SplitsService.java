package in.stvayush.booksproject.services;

import in.stvayush.booksproject.models.Split;
import in.stvayush.booksproject.repository.SplitsRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SplitsService {
    private final SplitsRepository splitsRepository;

    public void persistSplits(List<Split> splits) {
        splitsRepository.saveAll(splits);
    }
}
