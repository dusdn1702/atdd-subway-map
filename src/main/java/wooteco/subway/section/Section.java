package wooteco.subway.section;

import java.util.Objects;

import wooteco.subway.exception.IllegalInputException;
import wooteco.subway.line.LineRequest;

public class Section {
    private final long upStationId;
    private final long downStationId;
    private final int distance;
    private long lineId;

    public Section(long upStationId, long downStationId, int distance) {
        this.upStationId = upStationId;
        this.downStationId = downStationId;
        this.distance = validateDistance(distance);
    }

    public Section(long lineId, long upStationId, long downStationId, int distance) {
        this(upStationId, downStationId, distance);
        this.lineId = lineId;
    }

    public Section(long lineId, SectionRequest sectionRequest) {
        this(lineId, sectionRequest.getUpStationId(), sectionRequest.getDownStationId(), sectionRequest.getDistance());
    }

    public Section(long id, LineRequest lineRequest) {
        this(id, lineRequest.getUpStationId(), lineRequest.getDownStationId(), lineRequest.getDistance());
    }

    private int validateDistance(int distance) {
        if(distance < 0) {
            throw new IllegalInputException();
        }
        return distance;
    }

    public long getLineId() {
        return lineId;
    }

    public long getUpStationId() {
        return upStationId;
    }

    public long getDownStationId() {
        return downStationId;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Section section = (Section)o;
        return upStationId == section.upStationId && downStationId == section.downStationId
            && distance == section.distance
            && lineId == section.lineId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(upStationId, downStationId, distance, lineId);
    }
}