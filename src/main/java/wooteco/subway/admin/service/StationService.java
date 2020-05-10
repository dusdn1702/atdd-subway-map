package wooteco.subway.admin.service;

import org.springframework.stereotype.Service;
import wooteco.subway.admin.domain.Station;
import wooteco.subway.admin.exception.DuplicatedStationException;
import wooteco.subway.admin.repository.StationRepository;

import java.util.Set;

@Service
public class StationService {
    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public Station save(Station station) {
        checkExistStation(station);
        return stationRepository.save(station);
    }

    private void checkExistStation(Station station) {
        if (stationRepository.existsByName(station.getName())) {
            throw new DuplicatedStationException(station.getName());
        }
    }

    public Set<Station> findAll() {
        return stationRepository.findAll();
    }

    public void deleteById(Long id) {
        stationRepository.deleteById(id);
    }
}
