package ExamPrep.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    public List<Pet> data;
    public int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (capacity > 0) {
            data.add(pet);
            capacity--;
        }
    }

    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                data.remove(pet);
                capacity++;
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        return data
                .stream()
                .filter(p -> p.getName().equals(name) && p.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:").append("\n");
        for (Pet e : data) {
            sb.append(e.getName()).append(" ").append(e.getOwner()).append("\n");
        }
        return sb.toString();
    }

}
