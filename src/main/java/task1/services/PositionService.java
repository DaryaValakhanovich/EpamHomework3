package task1.services;

import task1.entities.Position;
import task1.entities.Salary;

import java.util.Set;

public class PositionService {
    private Set<Position> positions;

    public PositionService() {
    }

    public PositionService(Set<Position> positions) {
        this.positions = positions;
    }

    public void create(Position position) {
        positions.add(position);
    }

    public Position read(String name) {
        for (Position position : positions) {
            if (position.getName().equals(name)) {
                return position;
            }
        }
        return null;
    }

    public void update(Position position, String newName, Salary newSalary) {
        if (read(position.getName()) != null) {
            position.setName(newName);
            position.setSalary(newSalary);
        }
    }

    public void delete(Position position) {
        if (read(position.getName()) != null) {
            positions.remove(position);
        }
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }
}
