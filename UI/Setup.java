package UI;
import java.awt.*;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import pieces.*;
import javax.swing.*;

public class Setup extends JDialog {

    private String whitePlayer;
    private String blackPlayer;
    private JSpinner searchDepthSpinner;

    private static String play = "Play";

    public Setup(JFrame frame, boolean b)
    {
        super(frame, b);
        final JPanel myPanel = new JPanel(new GridLayout(0, 1));
        final JRadioButton whiteButton = new JRadioButton(play);
        final JRadioButton blackButton = new JRadioButton(play);
        whiteButton.setActionCommand(play);
        final ButtonGroup whiteGroup = new ButtonGroup();
        whiteGroup.add(whiteButton);
        whiteButton.setSelected(true);

        final ButtonGroup blackGroup = new ButtonGroup();
        blackGroup.add(blackButton);
        blackButton.setSelected(true);

        getContentPane().add(myPanel);
        myPanel.add(new JLabel("White"));
        myPanel.add(whiteButton);
        myPanel.add(new JLabel("Black"));
        myPanel.add(blackButton);

        myPanel.add(new JLabel("Search"));
        this.searchDepthSpinner = addLabeledSpinner(myPanel, "Search Depth", new SpinnerNumberModel(6, 0, Integer.MAX_VALUE, 1));

        final JButton cancelButton = new JButton("Cancel");
        final JButton okButton = new JButton("OK");

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Setup.this.setVisible(false);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cancel");
                Setup.this.setVisible(false);
            }

        });

        myPanel.add(cancelButton);
        myPanel.add(okButton);

        setLocationRelativeTo(frame);
        pack();
        setVisible(false);
    }

    void promptUser() {
        setVisible(true);
        repaint();
    }

    String getWhitePlayer() {
        return whitePlayer;
    }

    String getBlackPlayer() {
        return blackPlayer;
    }

    private static JSpinner addLabeledSpinner(final Container c,
                                              final String label,
                                              final SpinnerModel model) {
        final JLabel l = new JLabel(label);
        c.add(l);
        final JSpinner spinner = new JSpinner(model);
        l.setLabelFor(spinner);
        c.add(spinner);
        return spinner;
    }

    int getSearchDepth() {
        return (Integer)this.searchDepthSpinner.getValue();
    }
}

