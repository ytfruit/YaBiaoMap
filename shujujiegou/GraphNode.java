package shujujiegou;

//无向边对应的顶点编号和有向边的长度
public class GraphNode{
    private int no;//编号
    private int distance;//距离
    private GraphNode next;//结点
    public GraphNode(){

    }
    public GraphNode(int no, int distance,GraphNode next) {
        this.no = no;
        this.distance = distance;
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public GraphNode getNext() {
        return next;
    }

    public void setNext(GraphNode next) {
        this.next = next;
    }

    public GraphNode add(GraphNode graph) {
        GraphNode temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = graph;
        return graph;
    }

    public String toString() {
        return "GraphNode{" +
                "no=" + no +
                ", distance=" + distance +
                ", next=" + next +
                '}';
    }
}
