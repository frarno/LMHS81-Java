/**
 *
 */

/**
 * @author user
 *
 */

import javax.swing.JFrame;

public abstract class Frame extends JFrame {

	static final long serialVersionUID = 2;
    private String title;
    private int width = 800, height = 600;
    private boolean isCentered  = true, isResizable = false;

    public abstract void addContent();


	public Frame(String title)
	{
		super();
		this.title = title;
		build();
		addContent();
	}

	public Frame(String title, int width, int height, boolean isCentered, boolean isResizable)
	{
		super();
		this.title = title;
		this.width = width;
		this.height = height;
		this.isCentered = isCentered;
		this.isResizable = isResizable;

		build();
		addContent();
	}

	private void build() {
		setTitle(title);
		setSize(width,height);
		if (isCentered) {
			setLocationRelativeTo(null);
    	}
		setResizable(isResizable);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;

	}




}
