package shujujiegou;

/*图结构*/
public class Graph {
    Mission[] mission =new Mission[26];
    MissionGraph graph;
    Graph(){
         mission[0] = new Mission(0, "会稽郡",   310,515,null);
        mission[1] = new Mission(1, "威郡",445,453, null);
       mission[2] = new Mission(2, "德庆府",  220,450,null);
       mission[3] = new Mission(3, "山庙村", 170,445, null);
        mission[4] = new Mission(4, "冰流寨", 95,440, null);
         mission[5] = new Mission(5, "邯州",45,440,  null);
        mission[6] = new Mission(6, "陈郡", 442,369, null);
         mission[7] = new Mission(7, "恭州",  245,385,null);
         mission[8] = new Mission(8, "苏松道",122,387,  null);
         mission[9] = new Mission(9, "许州", 450,305, null);
        mission[10] = new Mission(10, "京东道",225,313,  null);
        mission[11] = new Mission(11, "徽州", 122,295, null);
        mission[12] = new Mission(12, "东屏村",580,365,null);
       mission[13] = new Mission(13, "珠玑坞", 530,263, null);
         mission[14]= new Mission(14, "长石村", 305,300,null);
       mission[15] = new Mission(15, "瓦岗县", 500,190, null);
         mission[16] = new Mission(16, "泗江",310,220, null);
         mission[17] = new Mission(17, "万安州",400,170,  null);
         mission[18] = new Mission(18, "坊州", 410,100, null);
         mission[19] = new Mission(19, "象郡", 242,176,null);
        mission[20] = new Mission(20, "青州", 292,103, null);
        mission[21] = new Mission(21, "雍州",  200,95, null);
         mission[22] = new Mission(22, "隆兴府", 250,40, null);
         mission[23] = new Mission(23, "瑞羽山",187,40, null);
        mission[24] = new Mission(24, "林栖寨", 105,40, null);
        mission[25] = new Mission(25, "蜀郡",50,40,  null);
        graph = new MissionGraph();
        graph.add(mission[0]);
        graph.add(mission[1]);
        graph.add(mission[2]);
        graph.add(mission[3]);
        graph.add(mission[4]);
        graph.add(mission[5]);
        graph.add(mission[6]);
        graph.add(mission[7]);
        graph.add(mission[8]);
        graph.add(mission[9]);
        graph.add(mission[10]);
        graph.add(mission[11]);
        graph.add(mission[12]);
        graph.add(mission[13]);
        graph.add(mission[14]);
        graph.add(mission[15]);
        graph.add(mission[16]);
        graph.add(mission[17]);
        graph.add(mission[18]);
        graph.add(mission[19]);
        graph.add(mission[20]);
        graph.add(mission[21]);
        graph.add(mission[22]);
        graph.add(mission[23]);
        graph.add(mission[24]);
        graph.add(mission[25]);
        //数据插入
        graph.get(0).setNext(new GraphNode(1, 50, null));
        graph.get(0).getNext()
                .add(new GraphNode(2, 50, null))
                .add(new GraphNode(6, 100, null))
                .add(new GraphNode(7, 100, null))
                .add(new GraphNode(9, 120, null))
                .add(new GraphNode(14, 150, null));
        graph.get(1).setNext(new GraphNode(0, 50, null));
        graph.get(1).getNext()
                .add(new GraphNode(0, 50, null))
                .add(new GraphNode(6, 25, null));
        graph.get(2).setNext(new GraphNode(0, 50, null));
        graph.get(2).getNext()
                .add(new GraphNode(0, 50, null))
                .add(new GraphNode(3, 15, null))
                .add(new GraphNode(7, 25, null));
        graph.get(3).setNext(new GraphNode(0, 65, null));
        graph.get(3).getNext()
                .add(new GraphNode(2, 15, null))
                .add(new GraphNode(4, 15, null))
                .add(new GraphNode(7, 15, null))
                .add(new GraphNode(8, 20, null));
        graph.get(4).setNext(new GraphNode(0, 80, null));
        graph.get(4).getNext()
                .add(new GraphNode(3, 15, null))
                .add(new GraphNode(5, 15, null))
                .add(new GraphNode(8, 22, null));
        graph.get(5).setNext(new GraphNode(0, 95, null));
        graph.get(5).getNext()
                .add(new GraphNode(4, 15, null))
                .add(new GraphNode(8, 29, null));
        graph.get(6).setNext(new GraphNode(0, 75, null));
        graph.get(6).getNext()
                .add(new GraphNode(0, 100, null))
                .add(new GraphNode(1, 25, null))
                .add(new GraphNode(9, 25, null))
                .add(new GraphNode(12, 20, null));
        graph.get(7).setNext(new GraphNode(0, 75, null));
        graph.get(7).getNext()
                .add(new GraphNode(0, 100, null))
                .add(new GraphNode(2, 25, null))
                .add(new GraphNode(3, 15, null))
                .add(new GraphNode(8, 18, null))
                .add(new GraphNode(10, 25, null));
        graph.get(8).setNext(new GraphNode(0, 85, null));
        graph.get(8).getNext()
                .add(new GraphNode(3, 20, null))
                .add(new GraphNode(4, 22, null))
                .add(new GraphNode(5, 29, null))
                .add(new GraphNode(7, 18, null))
                .add(new GraphNode(10, 19, null))
                .add(new GraphNode(11, 35, null));
        graph.get(8).setNext(new GraphNode(0, 93, null));
        graph.get(8).getNext()
                .add(new GraphNode(3, 20, null))
                .add(new GraphNode(4, 22, null))
                .add(new GraphNode(5, 29, null))
                .add(new GraphNode(7, 18, null))
                .add(new GraphNode(10, 25, null))
                .add(new GraphNode(11, 35, null));
        graph.get(9).setNext(new GraphNode(0, 100, null));
        graph.get(9).getNext()
                .add(new GraphNode(0, 120, null))
                .add(new GraphNode(6, 25, null))
                .add(new GraphNode(12, 35, null))
                .add(new GraphNode(13, 40, null))
                .add(new GraphNode(14, 50, null));
        graph.get(10).setNext(new GraphNode(0, 100, null));
        graph.get(10).getNext()
                .add(new GraphNode(0, 120, null))
                .add(new GraphNode(7, 25, null))
                .add(new GraphNode(8, 19, null))
                .add(new GraphNode(11, 25, null))
                .add(new GraphNode(14, 50, null));
        graph.get(11).setNext(new GraphNode(0, 120, null));
        graph.get(11).getNext()
                .add(new GraphNode(8, 35, null))
                .add(new GraphNode(10, 25, null))
                .add(new GraphNode(16, 210, null))
                .add(new GraphNode(19, 225, null));
        graph.get(12).setNext(new GraphNode(0, 95, null));
        graph.get(12).getNext()
                .add(new GraphNode(6, 20, null))
                .add(new GraphNode(9, 35, null))
                .add(new GraphNode(13, 15, null));
        graph.get(13).setNext(new GraphNode(0, 110, null));
        graph.get(12).getNext()
                .add(new GraphNode(9, 40, null))
                .add(new GraphNode(12, 15, null))
                .add(new GraphNode(15, 35, null));
        graph.get(14).setNext(new GraphNode(0, 150, null));
        graph.get(14).getNext()
                .add(new GraphNode(0, 150, null))
                .add(new GraphNode(9, 50, null))
                .add(new GraphNode(10, 50, null))
                .add(new GraphNode(15, 125, null))
                .add(new GraphNode(16, 15, null));
        graph.get(15).setNext(new GraphNode(0, 145, null));
        graph.get(15).getNext()
                .add(new GraphNode(13, 35, null))
                .add(new GraphNode(14, 125, null))
                .add(new GraphNode(16, 100, null))
                .add(new GraphNode(17, 110, null));
        graph.get(16).setNext(new GraphNode(0, 165, null));
        graph.get(16).getNext()
                .add(new GraphNode(11, 210, null))
                .add(new GraphNode(14, 15, null))
                .add(new GraphNode(15, 100, null))
                .add(new GraphNode(17, 36, null))
                .add(new GraphNode(19, 36, null));
        graph.get(17).setNext(new GraphNode(0, 201, null));
        graph.get(17).getNext()
                .add(new GraphNode(16, 36, null))
                .add(new GraphNode(15, 110, null))
                .add(new GraphNode(18, 42, null))
                .add(new GraphNode(19, 26, null))
                .add(new GraphNode(20, 52, null));
        graph.get(18).setNext(new GraphNode(0, 243, null));
        graph.get(18).getNext()
                .add(new GraphNode(17, 42, null))
                .add(new GraphNode(20, 76, null));
        graph.get(19).setNext(new GraphNode(0, 201, null));
        graph.get(19).getNext()
                .add(new GraphNode(11, 225, null))
                .add(new GraphNode(16, 36, null))
                .add(new GraphNode(17, 26, null))
                .add(new GraphNode(20, 23, null))
                .add(new GraphNode(21, 105, null));
        graph.get(20).setNext(new GraphNode(0, 224, null));
        graph.get(20).getNext()
                .add(new GraphNode(21, 40, null))
                .add(new GraphNode(19, 23, null))
                .add(new GraphNode(17, 52, null))
                .add(new GraphNode(18, 76, null));
        graph.get(21).setNext(new GraphNode(0, 264, null));
        graph.get(21).getNext()
                .add(new GraphNode(22, 15, null))
                .add(new GraphNode(20, 40, null))
                .add(new GraphNode(23, 20, null))
                .add(new GraphNode(19, 105, null));
        graph.get(22).setNext(new GraphNode(0, 279, null));
        graph.get(22).getNext()
                .add(new GraphNode(23, 20, null))
                .add(new GraphNode(21, 15, null));

        graph.get(23).setNext(new GraphNode(0, 284, null));
        graph.get(23).getNext()
                .add(new GraphNode(21, 20, null))
                .add(new GraphNode(22, 20, null))
                .add(new GraphNode(24, 20, null));
        graph.get(24).setNext(new GraphNode(0, 304, null));
        graph.get(24).getNext()
                .add(new GraphNode(23, 20, null))
                .add(new GraphNode(25, 20, null));
        graph.get(25).setNext(new GraphNode(0, 324, null));
        graph.get(25).getNext()
                .add(new GraphNode(24, 20, null));
    }
}
