package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Nim;

public class Window extends JFrame {

	public Window(Nim game, JPanel north, JPanel center, JPanel south) 
	{
		setTitle("Nim");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		add(center, BorderLayout.CENTER);
		add(north, BorderLayout.NORTH);
		
		add(south, BorderLayout.SOUTH);

	}

}
