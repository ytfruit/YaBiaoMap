package shujujiegou;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import static shujujiegou.ControlPanel.*;

public class MapPanel extends JPanel {
    private static int block_width = 20;
    private static final int BST_BLOCK_WIDTH = 20;
    private static final int MAX_BLOCK_WIDTH = 20;
    private static final int MIN_BLOCK_WIDTH = 20;
    private int width;
    private int height;
    private static final Point BST_Basepoint = new Point();
    private static HashMap<Integer, Color> colors = new HashMap<>();
    private static boolean isshowing = false;
    private static boolean isviewport = false;
    private static ArrayList<Graph> path;
    ImageIcon icon;
    private static int process = 0;
    private Point realpoint;
    Graph graph = new Graph();
    //run是否运行，id，x,y运行到的位置，speedUp是运行速度,every用在文本区显示-->速度/every秒
//    public static int run=0;
//    public static int id;
//    public static int x;
//    public static int y;
//    public static int speedUp=1;
//    public static int every=1;

    public MapPanel(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }
      //背景图
        @Override
        public void paintComponent (Graphics g){
            super.paintComponent(g);
            icon = new ImageIcon("D:\\qqfiles\\shujujiegou\\shujujiegou\\bgback.jpg");
            g.drawImage(icon.getImage(), 0, 0, getSize().width, getSize().height, this);
        }
        @Override
        public void paint (Graphics g){
            super.paint(g);
            /*高亮显示所有点（弃用）
        for (int j=0;j<26;j++){
            g.setFont(new Font("黑体",Font.CENTER_BASELINE,16));
            g.setColor(new Color(255,255,255));
            g.fillOval(graph.attraction[j].getLongitude(),graph.attraction[j].getLatitude(),20,20);
            if(j==25){
                break;
            }
            g.drawLine(graph.attraction[j].getLongitude()+5,graph.attraction[j].getLatitude()+5,graph.attraction[j+1].getLongitude()+5,graph.attraction[j+1].getLatitude()+5);
        }
*/

            /* 迪杰斯特拉显示最短路径*/
            for (int i = 0; i < ControlPanel.length; i++) {
                g.setFont(new Font("黑体", Font.CENTER_BASELINE, 16));
                g.setColor(new Color(255, 255, 255));
                g.fillOval(graph.mission[huaxian[i]].getLongitude(), graph.mission[huaxian[i]].getLatitude(), 20, 20);
                g.setColor(Color.BLACK);
                g.drawLine(graph.mission[huaxian[i]].getLongitude() + 5, graph.mission[huaxian[i]].getLatitude() - 3, graph.mission[huaxian[i]].getLongitude() + 20, graph.mission[huaxian[i]].getLatitude() - 20);
                g.drawString(graph.mission[huaxian[i]].getName(), graph.mission[huaxian[i]].getLongitude() + 15, graph.mission[huaxian[i]].getLatitude() - 20);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.WHITE);
                g2.setStroke(new BasicStroke(3.0f));
                if (i == ControlPanel.length - 1) {
                    g.setColor(Color.BLUE);
                    g.fillOval(graph.mission[huaxian[i]].getLongitude(), graph.mission[huaxian[i]].getLatitude(), 20,20);
                    break;
                }
                g2.drawLine(graph.mission[huaxian[i]].getLongitude() + 3, graph.mission[huaxian[i]].getLatitude() + 3, graph.mission[huaxian[i + 1]].getLongitude() + 3, graph.mission[huaxian[i + 1]].getLatitude() + 3);
                if(i==0){
                    g.setColor(Color.red);
                    g.fillOval(graph.mission[huaxian[i]].getLongitude(), graph.mission[huaxian[i]].getLatitude(), 20, 20);
                    g.setColor(Color.white);
                }

                g.setColor(Color.WHITE);
                repaint();
            }
            /*弗洛伊德画图未实现*/
            for (int i = 0; i < ControlPanel.length2; i++) {
                g.setFont(new Font("黑体", Font.CENTER_BASELINE, 16));
                g.setColor(new Color(255, 255, 255));
                g.fillOval(graph.mission[huaxian2[i]].getLongitude(), graph.mission[huaxian2[i]].getLatitude(), 20, 20);
                g.setColor(Color.BLACK);
                g.drawLine(graph.mission[huaxian2[i]].getLongitude() + 5, graph.mission[huaxian2[i]].getLatitude() - 3, graph.mission[huaxian2[i]].getLongitude() + 20, graph.mission[huaxian2[i]].getLatitude() - 20);
                g.drawString(graph.mission[huaxian2[i]].getName(), graph.mission[huaxian2[i]].getLongitude() + 15, graph.mission[huaxian2[i]].getLatitude() - 20);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.WHITE);
                g2.setStroke(new BasicStroke(3.0f));
                if (i == ControlPanel.length2 - 1) {
                    g.setColor(Color.BLACK);
                    g.fillOval(graph.mission[huaxian[i]].getLongitude(), graph.mission[huaxian[i]].getLatitude(), 20,20);
                    break;
                }
                g2.drawLine(graph.mission[huaxian2[i]].getLongitude() + 3, graph.mission[huaxian2[i]].getLatitude() + 3, graph.mission[huaxian2[i + 1]].getLongitude() + 3, graph.mission[huaxian2[i + 1]].getLatitude() + 3);
                if(i==0){
                    g.setColor(Color.YELLOW);
                    g.fillOval(graph.mission[huaxian[i]].getLongitude(), graph.mission[huaxian[i]].getLatitude(), 20, 20);
                    g.setColor(Color.white);
                }
                g.setColor(Color.WHITE);
                repaint();
            }
            if(paint==1){
                g.setColor(Color.BLACK);
                g.fillOval(graph.mission[bandit].getLongitude(),graph.mission[bandit].getLatitude(),20,20);
            }

            repaint();
        }

    }