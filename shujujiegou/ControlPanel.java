package shujujiegou;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.util.List;

public class ControlPanel extends JPanel implements Runnable {
    public static int bandit;
    public static int paint;
    Random random=new Random();
    int MAX = 10000;
    int startid=0;
    public static int roadlength = 0;
    public double[] sppeduptemp=new double[]{
            0.7,2.1,1.8
    };
    String[] Styleways = new String[]{
            "马车", "人力车", "陶轮"
    };
    double[] speed = new double[]{
            5.1, 2.3, 3.4
    };
    int [][]dist=new int[26][26];
    public static int[] huaxian = new int[26];
    public static int length;
    private static JLabel osLable;
    private static JLabel tsLable;
    private static JLabel walable;
    private static JLabel oplable;
    private static JLabel sblable;
    JButton Searchbutton1,Searchbutton2, Changebutton,Clearbutton;
    JComboBox startCom = new JComboBox();
    JComboBox endCom = new JComboBox();
    JComboBox ways = new JComboBox();
    JTextArea path;
    JTextArea view;
    Graph station = new Graph();
    public static String startName = "";
    public static String endName = "";
    public static String wayName = "";
    int INT_MAX=65535;
    public static int []huaxian2 =new int [26];
    public static int length2;
    Graph graph = new Graph();
    //run是否运行，id，x,y运行到的位置，speedUp是运行速度,every用在文本区显示-->速度/every秒
    public static int run = 0;
    public static int id;
    public static int x;
    public static int y;
    public double speedUp = 1;
    public double sppedUptemp=1;
    public static int[] dx=new int[7];
    public static int[] dy=new int[7];
    public ControlPanel() {
        setPreferredSize(new Dimension(690, 660));
        setBackground(Color.white);
        setLayout(new FlowLayout(FlowLayout.LEADING, 25, 15));
        setSize(640, 100);
        oplable=initlable("",200,45);
        osLable = initlable("", 200, 45);
        tsLable = initlable("", 200, 45);
        walable = initlable("", 200, 45);
        Searchbutton1 = initButton("搜索最短路径");
        Searchbutton2=initButton("显示全部路径");
        Changebutton = initButton("进行模拟");
        Clearbutton=initButton("清除");
        startCom.addItem("选择起始任务点");
        endCom.addItem("选择目的地");
        ways.addItem("选择押镖方式");
        for (int i = 0; i < 3; i++) {
            ways.addItem(Styleways[i]);
        }
        for (int i = 0; i < 26; i++) {
            startCom.addItem(graph.mission[i].getName());
            endCom.addItem(graph.mission[i].getName());
        }
        path = new JTextArea(100,100);
        path.setFont(new Font("黑体", Font.PLAIN, 16));

        add(initlable("起始任务点", 90, 45));
        add(osLable);
        add(startCom);
        add(initlable("目的地", 90, 45));
        add(tsLable);
        add(endCom);
        add(initlable("搜索最短路径",90,45));
        add(oplable);
        add(Searchbutton1);
        add(Searchbutton2);
        add(initlable("选择押镖方式", 90, 45));
        add(walable);
        add(ways);
        add(Changebutton);
        add(Clearbutton);
        add(new JScrollPane(path));
        add(new JScrollPane(view));
//        add(path);
//        add(view);
        startCom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //起点选择发生变化后
                if (startCom.getSelectedItem().toString().equals("选择起始任务点")) {
                    startName = "";
                    return;
                }
                startName = startCom.getSelectedItem().toString();
                for(int i = 0; i<graph.mission.length; i++){
                    if(startName.equals(graph.mission[i].getName())){
                        startid=i;
                    }
                }
                path.setText(null);
            }
        });
        endCom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //终点选择发生变化后
                if (endCom.getSelectedItem().toString().equals("选择目的地")) {
                    endName = "";
                    return;
                }
                endName = endCom.getSelectedItem().toString();
                path.setText(null);
            }
        });
        ways.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ways.getSelectedItem().toString().equals("选择押镖方式")) {
                    wayName = "";
                    return;
                }
                wayName = ways.getSelectedItem().toString();
            }
        });

        Searchbutton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paint=1;
                repaint();
                Dilasitejie();
            }
        });
        Searchbutton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // repaint();
               // floyd(graph,dist);
                outPut(graph,dist);
            }
        });

        Changebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (wayName.equals("马车")) {
                    speedUp=speed[0];
                    sppedUptemp=sppeduptemp[0];
                } else if (wayName.equals("人力车")) {
                    speedUp=speed[1];
                    sppedUptemp=sppeduptemp[1];
                } else if (wayName.equals("陶轮")) {
                    speedUp=speed[2];
                    sppedUptemp=sppeduptemp[2];
                }
                    Thread t = new Thread((Runnable) Windows.getControlPanel());
                    t.start();
            }

        });
        Clearbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                path.setText(null);
            }
        });
    }
    //标签初始化
    public JLabel initlable(String s, int width, int height) {
        JLabel label = new JLabel(s, JLabel.CENTER);
        label.setBackground(Color.white);
        label.setFont(new Font("幼圆", Font.PLAIN, 25));
        return label;
    }
    //按钮初始化
    public JButton initButton(String s) {
        JButton button = new JButton(s);
        button.setSize(200,50);
        button.setLayout(null);
        button.setFont(new java.awt.Font("幼圆", Font.PLAIN, 25));
        button.setBackground(Color.white);
        return button;
    }

    //迪拉杰斯特算法
    public void Dilasitejie() {
       bandit=random.nextInt(26);
        int i = -1;
        Graph graph1 = new Graph();
        String startAttraction = startName;
        String stopAttraction = endName;
        Map<Mission, Integer> attractions = graph1.graph.shortestPath(startAttraction, stopAttraction);
        if (attractions == null) {
            JOptionPane.showMessageDialog(this, "提示", "无路径可走", JOptionPane.PLAIN_MESSAGE);
        }
        path.append("\n迪杰斯特拉算法：最短路径为：\n");
        for (Map.Entry<Mission, Integer> entry : attractions.entrySet()) {
            Mission id = entry.getKey();
            Integer value = entry.getValue();
            /*遇见山匪更换路径未能实现*/
            if (id.getNo() == bandit) {
//                path.append("\n(将会在" + id.getName() + "遇到山匪，请保护押镖的物品！) ");
                huaxian[++i] = id.getNo();
            } else {
                path.append("-->" + id.getName());
                huaxian[++i] = id.getNo();
                Mission newattraction = id;
                roadlength = value;
            }
        }
        path.append("\n路径长度为：" + roadlength);
        path.append("\n将会在"+graph.mission[bandit].getName()+"遇到山匪，请保护好押镖物品！");
        length = i + 1;
        long ms=System.currentTimeMillis();
        System.out.println("迪杰斯特拉算法时间："+ms);
    }
    /*弗洛伊德算法*/
    void floyd(Graph graph, int[][] dist) {
        int i, j, k;
        int [][]path =new int[26][26];
        String startAttraction = startName;
        String stopAttraction = endName;
        // 初始化距离矩阵，将直接连接的边的权值填入
        for (i = 0; i < 26; i++) {
            for (j = 0; j < 26; j++) {
                if (i == j) {
                    dist[i][j] = 0; // 同一顶点到自身的距离为0
                } else {
                    dist[i][j] = INT_MAX; // 其他顶点之间的距离初始化为无穷大
                }
            }
        }
        dist[0][1]=dist[1][0]=50;
        dist[0][2]=dist[2][0]=50;
        dist[0][6]=dist[6][0]=100;
        dist[0][7]=dist[7][0]=100;
        dist[0][9]=dist[9][0]=120;
        dist[0][10]=dist[10][0]=120;
        dist[0][14]=dist[14][0]=150;
        dist[1][6]=dist[6][1]=25;
        dist[2][3]=dist[3][2]=15;
        dist[2][7]=dist[7][2]=25;
        dist[3][4]=dist[4][3]=15;
        dist[3][7]=dist[7][3]=15;
        dist[3][8]=dist[8][3]=20;
        dist[4][5]=dist[5][4]=15;
        dist[4][8]=dist[8][4]=22;
        dist[5][8]=dist[8][5]=29;
        dist[6][9]=dist[9][6]=25;
        dist[6][12]=dist[12][6]=20;
        dist[7][8]=dist[8][7]=18;
        dist[7][10]=dist[10][7]=25;
        dist[8][10]=dist[10][8]=19;
        dist[8][11]=dist[11][8]=35;
        dist[9][12]=dist[12][9]=35;
        dist[9][13]=dist[13][9]=40;
        dist[9][14]=dist[9][14]=50;//
        dist[10][11]=dist[11][10]=25;
        dist[10][14]=dist[14][10]=50;
        dist[11][16]=dist[16][11]=210;
        dist[11][19]=dist[19][11]=255;
        dist[12][13]=dist[13][12]=15;
        dist[13][15]=dist[15][13]=35;//
        dist[14][15]=dist[15][14]=125;
        dist[14][16]=dist[16][14]=15;
        dist[15][16]=dist[16][15]=100;
        dist[15][17]=dist[17][15]=110;
        dist[16][17]=dist[17][16]=36;
        dist[16][19]=dist[19][16]=36;
        dist[17][18]=dist[18][17]=42;
        dist[17][19]=dist[19][17]=26;
        dist[17][20]=dist[20][17]=52;
        dist[18][20]=dist[20][18]=76;
        dist[19][20]=dist[20][19]=23;
        dist[19][21]=dist[21][19]=105;
        dist[20][21]=dist[21][20]=40;
        dist[21][22]=dist[22][21]=15;
        dist[21][23]=dist[23][21]=20;
        dist[22][23]=dist[23][22]=20;
        dist[23][24]=dist[24][23]=20;
        dist[24][25]=dist[25][24]=20;

        for(i=0;i<26;i++){
            for(j=0;j<26;j++){
                if(dist[i][j]!=INT_MAX){
                    path[i][j]=j;
                }
                else
                    path[i][j]=-1;
            }
        }
        // 使用动态规划更新距离矩阵  k=0时，表示哪两个顶点可以经过k到达彼此
        for (k = 0; k < 26 ; k++) { // k表示插入的中间顶点
            for (i = 0; i < 26 ; i++) { // i表示起始顶点
                for (j = 0; j < 26 ; j++) {  // j表示终点顶点
                    // 如果从 起始顶点i 经过 插入的中间顶点k 到达 终点顶点j 的距离更短，则更新距离矩阵
                    // i先到k，再从k到j
                    if (dist[i][k] != INT_MAX && dist[k][j] != INT_MAX && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j]=path[i][k];
                    }
                }
            }
        }
        this.path.append("\n每对顶点间的最短距离：\n");

        int cur;
        int a=0;
        for (i = 0; i < 26; i++) {
            for (j = 0; j < 26; j++) {
                if (path[i][j] == -1) {
                    this.path.append("null ");
                }
                else {
                    //System.out.printf(graph.attraction[i].getName()+"->"+graph.attraction[j].getName()+" : "+ dist[i][j]+"\n");
                    List<Integer> p= new ArrayList<>();
                    cur = i;
                    while (cur != j) {
                        p.add(cur);
                        cur = path[cur][j];
                    }
                    p.add(j);
                    if(graph.mission[i].getName().equals(startAttraction)&& graph.mission[j].getName().equals(stopAttraction)){
                        for(;a<p.size();a++) {
                            if(a==0)
                                this.path.append(graph.mission[p.get(a)].getName());
                            else
                                this.path.append("-->" + graph.mission[p.get(a)].getName());
                            huaxian2[a]=p.get(a);
                        }
                        length2=p.size();
                        this.path.append("  距离："+dist[i][j]);
                        break;
                    }
                }

            }

            //System.out.printf("\n");
        }


    }
 public void outPut(Graph graph,int [][]dist){
     int i, j, k;
     int [][]path =new int[26][26];
     String startAttraction = startName;
     String stopAttraction = endName;
     // 初始化距离矩阵，将直接连接的边的权值填入
     for (i = 0; i < 26; i++) {
         for (j = 0; j < 26; j++) {
             if (i == j) {
                 dist[i][j] = 0; // 同一顶点到自身的距离为0
             } else {
                 dist[i][j] = INT_MAX; // 其他顶点之间的距离初始化为无穷大
             }
         }
     }
     dist[0][1]=dist[1][0]=50;
     dist[0][2]=dist[2][0]=50;
     dist[0][6]=dist[6][0]=100;
     dist[0][7]=dist[7][0]=100;
     dist[0][9]=dist[9][0]=120;
     dist[0][10]=dist[10][0]=120;
     dist[0][14]=dist[14][0]=150;
     dist[1][6]=dist[6][1]=25;
     dist[2][3]=dist[3][2]=15;
     dist[2][7]=dist[7][2]=25;
     dist[3][4]=dist[4][3]=15;
     dist[3][7]=dist[7][3]=15;
     dist[3][8]=dist[8][3]=20;
     dist[4][5]=dist[5][4]=15;
     dist[4][8]=dist[8][4]=22;
     dist[5][8]=dist[8][5]=29;
     dist[6][9]=dist[9][6]=25;
     dist[6][12]=dist[12][6]=20;
     dist[7][8]=dist[8][7]=18;
     dist[7][10]=dist[10][7]=25;
     dist[8][10]=dist[10][8]=19;
     dist[8][11]=dist[11][8]=35;
     dist[9][12]=dist[12][9]=35;
     dist[9][13]=dist[13][9]=40;
     dist[9][14]=dist[9][14]=50;//
     dist[10][11]=dist[11][10]=25;
     dist[10][14]=dist[14][10]=50;
     dist[11][16]=dist[16][11]=210;
     dist[11][19]=dist[19][11]=255;
     dist[12][13]=dist[13][12]=15;
     dist[13][15]=dist[15][13]=35;//
     dist[14][15]=dist[15][14]=125;
     dist[14][16]=dist[16][14]=15;
     dist[15][16]=dist[16][15]=100;
     dist[15][17]=dist[17][15]=110;
     dist[16][17]=dist[17][16]=36;
     dist[16][19]=dist[19][16]=36;
     dist[17][18]=dist[18][17]=42;
     dist[17][19]=dist[19][17]=26;
     dist[17][20]=dist[20][17]=52;
     dist[18][20]=dist[20][18]=76;
     dist[19][20]=dist[20][19]=23;
     dist[19][21]=dist[21][19]=105;
     dist[20][21]=dist[21][20]=40;
     dist[21][22]=dist[22][21]=15;
     dist[21][23]=dist[23][21]=20;
     dist[22][23]=dist[23][22]=20;
     dist[23][24]=dist[24][23]=20;
     dist[24][25]=dist[25][24]=20;

     for(i=0;i<26;i++){
         for(j=0;j<26;j++){
             if(dist[i][j]!=INT_MAX){
                 path[i][j]=j;
             }
             else
                 path[i][j]=-1;
         }
     }
     // 使用动态规划更新距离矩阵  k=0时，表示哪两个顶点可以经过k到达彼此
     for (k = 0; k < 26 ; k++) { // k表示插入的中间顶点
         for (i = 0; i < 26 ; i++) { // i表示起始顶点
             for (j = 0; j < 26 ; j++) {  // j表示终点顶点
                 // 如果从 起始顶点i 经过 插入的中间顶点k 到达 终点顶点j 的距离更短，则更新距离矩阵
                 // i先到k，再从k到j
                 if (dist[i][k] != INT_MAX && dist[k][j] != INT_MAX && dist[i][k] + dist[k][j] < dist[i][j]) {
                     dist[i][j] = dist[i][k] + dist[k][j];
                     path[i][j]=path[i][k];
                 }
             }
         }
     }
     this.path.append("该起始任务点可达各顶点间的最短距离：\n");
     int cur;
     int a;
     for (i = 0; i < 26; i++) {
         for (j =0; j < 26; j++) {
             if (path[i][j] == -1) {
                 this.path.append("null ");
             }
             else {
                 //System.out.printf(graph.attraction[i].getName()+"->"+graph.attraction[j].getName()+" : "+ dist[i][j]+"\n");
                 List<Integer> p= new ArrayList<>();
                 cur = i;
                 while (cur != j) {
                     p.add(cur);
                     cur = path[cur][j];
                 }
                 p.add(j);
                 if(graph.mission[i].getName().equals(startAttraction)){
                     for(a=0;a<p.size();a++) {
                         if(a==0)
                             this.path.append(graph.mission[p.get(a)].getName());
                         else
                             this.path.append("-->" + graph.mission[p.get(a)].getName());
                         //huaxian2[a]=p.get(a);
                     }
                     //length2=p.size();
                     this.path.append("  距离："+dist[i][j]+"\n");
                     //break;
                }
             }

         }
         //System.out.printf("\n");
     }

 }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    //线程
    @Override
    public void run() {
        double a=sppedUptemp+speedUp;
        run=0;
        int Distance = roadlength; //剩余路线长度
        int allTime = 0;
        int x1=0,x2=0,y1=0,y2=0;
        int j=0;
        for (int i = 0; i < length; i++) {
                run=1;
                x1 = graph.mission[huaxian[0]].getLongitude();
                y1 = graph.mission[huaxian[0]].getLatitude();
                x2 = graph.mission[huaxian[length-1]].getLongitude();
                y2 = graph.mission[huaxian[length-1]].getLatitude();
            dx[0]=x1;
                dy[0]=y1;
                dx[length-1]=x2;
                dy[length-1]=y2;
            if(length==2){
                allTime=(int)(roadlength/speedUp);
                Distance-= roadlength;
                path.setText("已用时大约:" + allTime + "小时,剩余路程：" + Distance + "km\n" + "当前速度：" + speedUp + "km/h\n" + "押镖队伍已到" +
                        graph.mission[huaxian[i]].getName());
                break;
            }
            if(i!=length-1){
                allTime+= (int) (graph.mission[huaxian[i]].getNext().getDistance()/(speedUp+sppedUptemp));
                Distance= (int) (roadlength-graph.mission[huaxian[i]].getNext().getDistance());
                a+=sppedUptemp;
                    path.setText("已用时大约:" + allTime + "小时,剩余路程：" + Distance + "km\n" + "当前速度：" + a+ "km/h\n" + "押镖队伍已到" +
                            graph.mission[huaxian[i]].getName());
                    repaint();
                }
                else {
                    Distance=0;
                    path.setText("已用时大约:" + allTime + "小时,剩余路程：" + Distance + "km\n" + "当前速度：" + a+ "km/h\n" + "押镖队伍已到" +
                            graph.mission[huaxian[i]].getName());
                }
                try {
                    Thread.sleep((long) (3000 / speedUp));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        JOptionPane.showMessageDialog(this,"队伍已经到达"+endName,"提示",JOptionPane.PLAIN_MESSAGE);
    }
}
