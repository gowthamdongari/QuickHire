package com.example.quickhirebackend.services;
import com.example.quickhirebackend.dao.MatchRepository;
import com.example.quickhirebackend.model.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    // Create or Update a Match record
    public Matches saveMatch(Matches match) {
        return matchRepository.save(match);
    }

    // Retrieve all Match records
    public List<Matches> findAllMatches() {
        return matchRepository.findAll();
    }

    // Retrieve a Match by its ID
    public Optional<Matches> findMatchById(Integer id) {
        return matchRepository.findById(id);
    }

    // Update a Match record
    public Matches updateMatch(Integer id, Matches matchDetails) {
        return matchRepository.findById(id)
                .map(match -> {
                    match.setMatchPercentage(matchDetails.getMatchPercentage());
                    match.setProfessionalId(matchDetails.getProfessionalId());
                    match.setJobId(matchDetails.getJobId());
                    match.setStaffId(matchDetails.getStaffId());
                    return matchRepository.save(match);
                })
                .orElseThrow(() -> new IllegalStateException("Match with ID " + id + " does not exist"));
    }

    // Delete a Match record
    public void deleteMatch(Integer id) {
        matchRepository.deleteById(id);
    }
}
