package org.example.UI;

import javax.swing.*;
import java.awt.*;

public class RowHeader extends JPanel {
    public RowHeader(String[] labelNames)
    {
        setLayout(new GridLayout(1, labelNames.length));

        for(int i=0;i<labelNames.length;i++)
            add(createCenteredLabel(labelNames[i]));

        setPreferredSize(new Dimension(0, 50));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
        setBackground(Color.lightGray);
    }

    private JLabel createCenteredLabel(String text)
    {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }
}