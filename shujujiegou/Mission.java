package shujujiegou;

public class Mission {
    private int no;
    private String name;
    private String position;
    private int longitude;//横坐标
    private int latitude;//纵坐标
    private GraphNode next;

    public Mission(int no, String name, int longitude, int latitude, GraphNode next) {
        this.no = no;
        this.name = name;
        this.position = position;
        this.longitude = longitude;
        this.latitude = latitude;
        this.next = next;
    }
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public GraphNode getNext() {
        return next;
    }

    public void setNext(GraphNode next) {
        this.next = next;
    }
}