package shujujiegou;
/*
�����޶�����������������
�����ṩ������ĵ�ͼ��ĳ�ڶ�Ҫ����Ʊ�ţ��ڶӴ������A�������B��ɽ��������֣��п���������Ҫȷ��һ����A��B����̵�Ѻ��·�����ٸ������·��ѡ����з�ʽ��ʹ�û��ѵ�ʱ����̡�
����Ϊ�ڶ��ṩ���ֳ��з�ʽ��������Ҫ�õ���A��B��ͬ���з�ʽ��Ӧ��ʱ�䡣
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
        setTitle("Ѻ�ڵ�ͼ");
//  ���ڵ�����С����      setResizable(false);
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