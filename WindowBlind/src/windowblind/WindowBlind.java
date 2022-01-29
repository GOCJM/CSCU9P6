package windowblind;

/**
 * A basic Java Swing application: a slider can be adjusted to open and close a "blind".
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;

public class WindowBlind extends JFrame
        implements ChangeListener, ActionListener {

    /**
     * A slider to adjust a "blind"
     */
    private JSlider slider;
    /**
     * To record the current slider/blind setting
     */
    private int sliderValue = 0;
    /**
     * For drawing on
     */
    private JPanel panel;
	private JButton openBlind;
	private JButton closeBlind;
	private JButton closeBlindProgram;

    /**
     * The main method launches the application
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WindowBlind applic = new WindowBlind();
        applic.setLocation(100,100);
        applic.setVisible(true);
    }

    /**
     * Constructor - executed at instantiation of the class
     * Sets up the application's window
     */
    public WindowBlind() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("WindowBlind");
        setSize(300,300);

        Container window = getContentPane();
        window.setLayout(new FlowLayout());     // The default is that JFrame uses BorderLayout

        panel = new JPanel() {
            // This paintComponent overrides the default one in JPanel (which does nothing).
            // paintComponent is called automatically when a screen refresh is needed.
            // The screen (Graphics parameter g) has already been cleared before paintComponent is called
            public void paintComponent(Graphics g) {
                super.paintComponent(g); // Paint the panel's background
                paintScreen(g);          // Now do our custom drawing
            } // paintComponent
        };
        panel.setPreferredSize(new Dimension(200, 200));
        panel.setBackground(Color.white);
        window.add(panel);

        slider = new JSlider(JSlider.VERTICAL,0,100,0);
        slider.setInverted(true);               // 0 will be at top, not bottom, of vertical slider
        window.add(slider);
        slider.addChangeListener(this);         // Register for slider event
        
        openBlind = new JButton("Open Blind.");
        window.add(openBlind);
        openBlind.addActionListener(this);

        closeBlind = new JButton("Close Blind.");
        window.add(closeBlind);
        closeBlind.addActionListener(this);

        closeBlindProgram = new JButton("Close Blind Program.");
        window.add(closeBlindProgram);
        closeBlindProgram.addActionListener(this);

    } // constructor

    /**
     * Re-draws the window image: a "blind" covering a "window" through which the blue sky can be seen, referring to the global variable sliderValue to determine the blind size
     * @param g
     */
    public void paintScreen(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(70, 40, 60, 100);         // The blue sky
        g.setColor(Color.lightGray);
        g.fillRect(70, 40, 60, sliderValue); // The blind, partially closed
        g.setColor(Color.black);
        g.drawRect(70, 40, 60, 100);         // The window frame
    } // paintScreen

    /**
     * When the slider is adjusted, this method is called automatically
     * @param e
     */
    public void stateChanged(ChangeEvent e) {
        sliderValue = slider.getValue();  // Fetch the slider's current setting
        repaint();                        // Force a screen refresh (paintComponent is called indirectly)
    } // stateChanged

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (openBlind.equals(source)) {
            sliderValue = 0;
        } else if (closeBlind.equals(source)) {
            sliderValue = 100;
        } else if (closeBlindProgram.equals(source)) {
            System.exit(0);
        }
        repaint();
    }
}
