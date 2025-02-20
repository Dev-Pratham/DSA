import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class test {
    private JTextArea codeArea;
    private JTextArea stackArea;
    private JButton nextButton, prevButton;
    private int currentStep = 0;
    private List<String> executionSteps;

    public test() {
        executionSteps = new ArrayList<>();
        executionSteps.add("int a = 5;");
        executionSteps.add("int b = 10;");
        executionSteps.add("int sum = add(a, b);");
        executionSteps.add("print(sum);");

        JFrame frame = new JFrame("Java Code Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        codeArea = new JTextArea(10, 40);
        codeArea.setEditable(false);
        updateCodeArea();

        stackArea = new JTextArea(5, 40);
        stackArea.setEditable(false);

        nextButton = new JButton("Next");
        prevButton = new JButton("Previous");

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentStep < executionSteps.size() - 1) {
                    currentStep++;
                    updateCodeArea();
                }
            }
        });

        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentStep > 0) {
                    currentStep--;
                    updateCodeArea();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        panel.add(new JScrollPane(codeArea), BorderLayout.CENTER);
        panel.add(new JScrollPane(stackArea), BorderLayout.EAST);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void updateCodeArea() {
        StringBuilder codeDisplay = new StringBuilder();
        for (int i = 0; i < executionSteps.size(); i++) {
            if (i == currentStep) {
                codeDisplay.append("--> "); // Highlight current step
            } else {
                codeDisplay.append("    ");
            }
            codeDisplay.append(executionSteps.get(i)).append("\n");
        }
        codeArea.setText(codeDisplay.toString());
        updateStack();
    }

    private void updateStack() {
        switch (currentStep) {
            case 0 -> stackArea.setText("Stack: Empty");
            case 1 -> stackArea.setText("Stack:\na = 5");
            case 2 -> stackArea.setText("Stack:\na = 5\nb = 10");
            case 3 -> stackArea.setText("Stack:\na = 5\nb = 10\nsum = add(a, b)");
            case 4 -> stackArea.setText("Stack:\na = 5\nb = 10\nsum = 15");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(test::new);
    }
}
