import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ChessBoardPanel extends JPanel {
    private static final int BOARD_SIZE = 8;
    private static final int CELL_SIZE = 80;

    private final JLabel[][] squares = new JLabel[BOARD_SIZE][BOARD_SIZE];

    public ChessBoardPanel() {
        setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        setPreferredSize(new Dimension(BOARD_SIZE * CELL_SIZE, BOARD_SIZE * CELL_SIZE));

        for (int r = 0; r < BOARD_SIZE; r++) {
            for (int c = 0; c < BOARD_SIZE; c++) {
                JLabel label = new JLabel();
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setVerticalAlignment(SwingConstants.CENTER);

                boolean dark = (r + c) % 2 == 1;
                label.setBackground(dark ? new Color(118, 150, 86) : new Color(238, 238, 210));
                label.setOpaque(true);
                label.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));

                squares[r][c] = label;
                add(label);
            }
        }

        initPieces();
    }

    /**
     * Initiale Figurenstellung.
     * Erwartete Bildnamen (im Klassenpfad/Assets-Ordner):
     * assets/wP.png, assets/wN.png, assets/wB.png, assets/wR.png, assets/wQ.png,
     * assets/wK.png
     * assets/bP.png, assets/bN.png, assets/bB.png, assets/bR.png, assets/bQ.png,
     * assets/bK.png
     */
    private void initPieces() {
        // Zeilen r=0 entspricht Reihe 8 (Black back rank)
        // Zeilen r=7 entspricht Reihe 1 (White back rank)

        // Black
        setPiece(0, 0, "bR");
        setPiece(0, 1, "bN");
        setPiece(0, 2, "bB");
        setPiece(0, 3, "bQ");
        setPiece(0, 4, "bK");
        setPiece(0, 5, "bB");
        setPiece(0, 6, "bN");
        setPiece(0, 7, "bR");

        for (int c = 0; c < 8; c++)
            setPiece(1, c, "bP");

        // White
        for (int c = 0; c < 8; c++)
            setPiece(6, c, "wP");

        setPiece(7, 0, "wR");
        setPiece(7, 1, "wN");
        setPiece(7, 2, "wB");
        setPiece(7, 3, "wQ");
        setPiece(7, 4, "wK");
        setPiece(7, 5, "wB");
        setPiece(7, 6, "wN");
        setPiece(7, 7, "wR");
    }

    private void setPiece(int r, int c, String pieceCode) {
        JLabel label = squares[r][c];
        String fileName = "assets/" + pieceCode + ".png";

        URL url = ChessBoardPanel.class.getClassLoader().getResource(fileName);
        if (url == null) {
            // Kein Bild vorhanden -> Feld leer (keine Exception, damit UI trotzdem läuft)
            label.setIcon(null);
            return;
        }

        ImageIcon icon = new ImageIcon(url);
        // Optional: Bild auf Zellgröße skalieren
        Image scaled = icon.getImage().getScaledInstance(CELL_SIZE - 10, CELL_SIZE - 10, Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(scaled));
    }
}
