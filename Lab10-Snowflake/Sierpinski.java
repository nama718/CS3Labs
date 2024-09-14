 


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SierpinskiPanel extends JPanel
{
    public SierpinskiPanel()
    {
        super.setPreferredSize(new Dimension(400, 400));
        super.setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g)
    {
        int width  = getWidth();
        int height = getHeight();

        super.paintComponent(g);
        g.setColor(Color.GREEN);
        drawSierpinski(g, width / 2, height / 2, width / 2);
    }

    public void drawSierpinski(Graphics g, int xCord, int yCord, int length) {
        if(length < 2) 
        return;
        g.drawLine(xCord, yCord, xCord - length, yCord);
        g.drawLine(xCord, yCord, xCord, yCord - length);
        g.drawLine(xCord - length, yCord, xCord, yCord - length);

        drawSierpinski(g, xCord - length/2, yCord + length/2, length/2);
        drawSierpinski(g, xCord + length/2, yCord - length/2, length/2);
        drawSierpinski(g, xCord - length/2, yCord - length/2, length/2);
    }
}

public class Sierpinski
{
    public static void main ( String[] args )
    {
        /*
         * A frame is a container for a panel
         * The panel is where the drawing will take place
         */
        JFrame frame = new JFrame("Snowflake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new SierpinskiPanel());
        frame.pack();
        frame.setVisible(true);
    }
}
