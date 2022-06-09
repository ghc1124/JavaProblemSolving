// 2020110553 양시온
//Java Programming 과제 #8
//환율 계산기 프로그램
package test;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CurrencyConverterFrame extends JFrame{
	private JFrame container;
	private JLabel name = new JLabel("환율 변환",SwingConstants.RIGHT);
	private JLabel date = new JLabel ("");
	private JComboBox<String> currencyCombo;
	
	String url = "http://fx.kebhana.com/fxportal/jsp/RS/DEPLOY_EXRATE/fxrate_all.html";
	callback callback = new callback(url);
	
	

	public CurrencyConverterFrame() {
		setTitle("환율 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.setLayout(new GridLayout(3,3,5,5));
		c.add(name);	//환율 변환
		c.add(new JComboBox());	//JComboBox
		c.add(date); 	//JLabel 날짜 시간
		
		// 스레드 객체 생성 및 공유 객체 전달
		CurrencyDownloadThread cdt = new CurrencyDownloadThread(url, callback);
		
		
		c.add(new JLabel("환율 변환", SwingConstants.CENTER));	//JLabel 국가(환율)
		c.add(new JLabel("환율 변환", SwingConstants.CENTER));	//JLabel 국가(환율)
		c.add(new JTextArea());	//JTextArea(현재 환율 표시)
		c.add(new JTextField("0"));	//JTextField (숫자 입력)
		c.add(new JTextField("0"));	//JTextField (숫자 입력)
		//container.add(new JComboBox)
		
		setSize(700, 300);
		setVisible(true);
		
		cdt.start();		// 스레드 시작
		
	}

	public static void main(String[] args) {
		new CurrencyConverterFrame();

	}

}


