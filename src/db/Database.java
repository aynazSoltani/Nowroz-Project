package db;

import java.util.ArrayList;
import db.exception.EntityNotFoundException;

public class Database {
    private static int numberOfId = 1;
    private static ArrayList<Entity> entities = new ArrayList<>();

    private Database() {}

    public static void add(Entity e) {
        e.id = numberOfId++;
        entities.add(e.copy());
    }

    public static Entity get(int id) {
        for (Entity e : entities) {
            if (e.id == id) {
                return e.copy();
            }
        }
        throw new EntityNotFoundException(id);
    }

    public static void delete(int id) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == id) {
                entities.remove(i);
                return;
            }
        }
        throw new EntityNotFoundException(id);
    }

    public static void update(Entity newEntity) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).id == newEntity.id) {
                entities.set(i, newEntity.copy());
                return;
            }
        }
        throw new EntityNotFoundException();
    }
}