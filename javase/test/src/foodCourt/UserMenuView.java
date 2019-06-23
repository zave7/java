package foodCourt;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class UserMenuView extends JPanel {
	/**
	 * Create the panel.
	 */
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel panel = new JPanel();
	private GridBagLayout gbl_panel = new GridBagLayout();
								//db ���� 	select * from food;
//								select * from food where category_id = 1;
//								select * from food where food_name like '%�%';
//								������� ���� FoodDto���� List<FoodDto> �ȿ� �־�� ���̴�
//								�׷��� count = footList.size() �� �Ѱ����� ���´��� 
//								ȭ�鿡 �ѷ��ش� 
//								������ ���� �޴� ������ 17����� ����

//	�޴� �˻�ȭ���� ���� ����� ������ �� 2������
//	1. �˻� �Ǵ� ī�װ� ������ ���� ���� ���
//	2. �޴� �� ȭ�鿡�� �������� Ŭ������ ���� ���
	
//	�ܼ��� �������� Ŭ���̸� �̹� ī�װ� ���� Ȥ�� �˻��� ���� �޴�����Ʈ�� �̹� �������� ���̹Ƿ�
//	�޴��� �ٲ� �ʿ� ���� �ܼ��� setvisible true�� ���ָ� �ȴ�
// ī�װ� ���� Ȥ�� �˻��� ���� ���� ��쿡�� db���� �޴�����Ʈ�� ���ͼ� �ѷ���� �ϹǷ� �Ű������� �޴� list�� �޾ƿͼ� �ѷ���� �Ѵ�
	public void setMenu(int count, List<FoodDto> foodList) { // �ӽ� �׽�Ʈ�� count
		int gridx = 0;
		int gridy = 0;
		for(int i = 0; i < count; i++) {
			JButton menuButton = new MenuButton("�ѽ�" + (i+1)); // �� �ؽ�Ʈ���� list.getIndex(i).getFoodName(); �� �ð��̴�
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 9, 9);
			gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
			gbc_btnNewButton.gridx = gridx;
			gbc_btnNewButton.gridy = gridy;
			panel.add(menuButton, gbc_btnNewButton);
			gridx++;
			if(gridx > 4) {
				gridx = 0;
				gridy++;
			}
			
		}
	}
//		���� �޴��� 17�� �̾ƿ´ٰ� �ϸ�
//		0 1 2 3 4 
//		5���� ù �ٿ�
//		�����ٿ��� 
//		5 6 7 8 9 
//		5���� �;��Ѵ�
//
//		�׷��ٸ� ������ 17�� �����µ� 
//		���ΰ� 4�ΰ� ���� ������ 
//		���θ� �ٽ� 0���θ�����ְ�
//		���� 1 ������Ų��
	public UserMenuView() {
		setLayout(null);
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setBorder(null);
		panel.setLayout(gbl_panel);
		scrollPane.setBorder(null);
		
		scrollPane.setViewportView(panel);
		scrollPane.setBounds(12, 10, 988, 614);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane);
//		panel.setPreferredSize(new Dimension(998, 614));


	}

}
