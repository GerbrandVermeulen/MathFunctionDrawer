import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame {
	private static final long serialVersionUID = 9021589569205098646L;
	
	private final int DISPLAY_SIZE = 500;
	private GraphDisplay graph;
	private JPanel mainPanel;
	
	public Main() {
		setTitle("Function Drawer");
		setSize(DISPLAY_SIZE + 15, DISPLAY_SIZE + 38);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		setContentPane(mainPanel);
		
		graph = new GraphDisplay(DISPLAY_SIZE, 10, 10);
		mainPanel.add(graph);
		graph.setBounds(0, 0, DISPLAY_SIZE, DISPLAY_SIZE);
	}
	
	public static void main(String[] args) {
		Main curve = new Main();
		curve.setVisible(true);
	}

}
