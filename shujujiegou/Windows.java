package shujujiegou;
/*
我们限定该区域是无向网。
我们提供该区域的地图，某镖队要护送票号，镖队从任务点A到任务点B，山匪随机出现，有可能我们需要确定一条从A到B的最短的押镖路径，再根据最短路径选择出行方式，使得花费的时间最短。
我们为镖队提供三种出行方式，我们需要得到从A到B不同出行方式对应的时间。
*/
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class Windows extends JFrame{
    private static int window_height=800;
    private static int window_width=640;
    private static int window_x = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getWidth() - window_width) / 2);
    private static int window_y = (int) ((Toolkit.getDefaultToolkit().getScreenSize().getHeight() -window_height) / 2);
    private static MapPanel mapPanel = new MapPanel(640,540);
    private static ControlPanel controlPanel = new ControlPanel();
    public Windows(){
        setBounds(window_x,window_y,window_width,window_height);
        setTitle("押镖地图");
//  窗口调整大小弃用      setResizable(false);
        setLayout(new FlowLayout(FlowLayout.CENTER,5,40));
        getContentPane().add(mapPanel);
        add(controlPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        JFrame mGFrame = new Windows();
    }
    public static ControlPanel getControlPanel(){
        return controlPanel;
    }
    public static MapPanel getMapPanel(){
        return mapPanel;
    }

}