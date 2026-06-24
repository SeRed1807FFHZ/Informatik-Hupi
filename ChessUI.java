import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ChessUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Schach - Oberfläche");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ChessBoardPanel boardPanel = new ChessBoardPanel();
            frame.setLayout(new BorderLayout());
            frame.add(boardPanel, BorderLayout.CENTER);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
