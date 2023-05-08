package DataBase;

import Base.*;
import File.CollectionManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;


public class SetCollection {
    public static void getDragonsFromDB() {

        try {

            ResultSet rs = MainDataBase.requestSQLWith("SELECT * FROM DRAGONS");
            while (true) {
                assert rs != null;
                if (!rs.next()) break;
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                long weight = rs.getLong("weight");
                String colorString = rs.getString("color");
                Color color = Color.valueOf(colorString);
                String typeString = rs.getString("type");
                DragonType type = DragonType.valueOf(typeString);
                Timestamp creationTimestamp = rs.getTimestamp("creationDate");
                ZonedDateTime creationDate = creationTimestamp.toInstant().atZone(ZoneId.systemDefault());
                float x = rs.getFloat("x");
                float y = rs.getFloat("y");
                double size = rs.getDouble("size");
                int eyesCount = rs.getInt("eyesCount");
                long toothCount = rs.getLong("toothCount");
                String creator = rs.getString("creator");
                CollectionManager.getDragons().add(new Dragon(id, name, new Coordinates(x, y), creationDate, age, weight, color, type,  new DragonHead(size, eyesCount,toothCount), creator));
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("Error while getting dragons from DB: " + e.getMessage());
        }
    }
}
