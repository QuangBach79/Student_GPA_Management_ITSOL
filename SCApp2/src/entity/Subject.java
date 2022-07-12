package entity;

public class Subject {
    public static int BASE_ID = 100;
    public static Subject[] subjects = new Subject[100];
    public static Subject[] subjectslimit;
    private int id;
    private String name;
    private int totalUnit;
    private String type;

    public Subject(){}

    public Subject(int id, String name, int totalUnit, String type) {
        this.id = id;
        this.name = name;
        this.totalUnit = totalUnit;
        this.type = type;
    }

    public static int getBaseId() {
        return BASE_ID;
    }

    public static void setBaseId(int baseId) {
        Subject.BASE_ID = BASE_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalUnit() {
        return totalUnit;
    }

    public void setTotalUnit(int totalUnit) {
        this.totalUnit = totalUnit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
//        return "Subject{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", totalUnit=" + totalUnit +
//                ", type='" + type + '\'' +
//                '}';

        return String.format(
//                "+----------------------------------------------------------------------+\n" +
                "|%5d|%15s|%4s|%12s|", id, getName(), getTotalUnit(), getType()
        );
    }
}
