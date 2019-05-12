package UI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;

import board.*;
import pieces.*;
import player.Player;
import UI.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static javax.swing.SwingUtilities.*;

public final class Frame extends Observable 
{
	private Color lbrown = new Color(245, 222, 179);
	private Color dbrown = new Color(159, 105, 52);
    private final JFrame gameFrame;
    private final BoardPanel boardPanel;
    private final Setup Setup;
    private Board chessBoard;
    private Move computerMove;
    private Piece click;
    private Piece piece;
    private BoardDirection boardDirection;
    private String pieceIconPath;

    private static final Dimension OUTER_FRAME_DIMENSION = new Dimension(600, 600);
    private static final Dimension BOARD_PANEL_DIMENSION = new Dimension(400, 350);
    private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10, 10);

    private static final Frame INSTANCE = new Frame();

    private Frame() {
        this.gameFrame = new JFrame("CHESS");
        final JMenuBar tableMenuBar = new JMenuBar();
        populateMenuBar(tableMenuBar);
        this.gameFrame.setJMenuBar(tableMenuBar);
        this.gameFrame.setLayout(new BorderLayout());
        this.chessBoard = Board.createStartingBoard();
        this.boardDirection = BoardDirection.NORMAL;
        this.pieceIconPath = "/chess java/";
        this.boardPanel = new BoardPanel();
        this.Setup = new Setup(this.gameFrame, true);
        this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
        this.gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
        center(this.gameFrame);
        this.gameFrame.setVisible(true);
    }

    public static Frame get() {
        return INSTANCE;
    }

    private JFrame getGameFrame() {
        return this.gameFrame;
    }

    private Board getGameBoard() {
        return this.chessBoard;
    }

    private BoardPanel getBoardPanel() {
        return this.boardPanel;
    }


    private Setup getSetup() {
        return this.Setup;
    }

    public void show() {
        Frame.get().getBoardPanel().drawBoard(Frame.get().getGameBoard());
    }

    private void populateMenuBar(final JMenuBar tableMenuBar) {
        tableMenuBar.add(Options());
    }

    private static void center(final JFrame frame) {
        final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        final int w = frame.getSize().width;
        final int h = frame.getSize().height;
        final int x = (dim.width - w) / 2;
        final int y = (dim.height - h) / 2;
        frame.setLocation(x, y);
    }

	public JMenu Options()
	{
		JMenu optionsMenu = new JMenu("Options");

        JMenuItem reset = new JMenuItem("New Game", KeyEvent.VK_P);
        reset.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                undoAllMoves();
            }


        });
        optionsMenu.add(reset);
        return optionsMenu;
	}

    private void updateGameBoard(final Board board) {
        this.chessBoard = board;
    }

    private void updateComputerMove(final Move move) {
        this.computerMove = move;
    }

    private void undoAllMoves() {
        Frame.get().getBoardPanel().drawBoard(chessBoard);
    }


    private void moveMadeUpdate(final PlayerType playerType) {
        setChanged();
        notifyObservers(playerType);
    }

    private void setupUpdate(final Setup Setup) {
        setChanged();
        notifyObservers(Setup);
    }

    

    enum PlayerType {
        HUMAN,
        COMPUTER
    }

   
    private class BoardPanel extends JPanel {

        final List<TilePanel> boardTiles;

        BoardPanel() {
            super(new GridLayout(8,8));
            this.boardTiles = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                final TilePanel tilePanel = new TilePanel(this, i);
                this.boardTiles.add(tilePanel);
                add(tilePanel);
            }
            setPreferredSize(BOARD_PANEL_DIMENSION);
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            setBackground(Color.BLACK);
            validate();
        }

        void drawBoard(final Board board) {
            removeAll();
            for (final TilePanel boardTile : boardDirection.traverse(boardTiles)) {
                boardTile.drawTile(board);
                add(boardTile);
            }
            validate();
            repaint();
        }

        void setTileDarkColor(final Board board,
                              final Color darkColor) {
            for (final TilePanel boardTile : boardTiles) {
                boardTile.setdbrown(darkColor);
            }
            drawBoard(board);
        }

        void setTileLightColor(final Board board,
                                      final Color lightColor) {
            for (final TilePanel boardTile : boardTiles) {
                boardTile.setlbrown(lightColor);
            }
            drawBoard(board);
        }

    }

    enum BoardDirection {
        NORMAL {
            @Override
            List<TilePanel> traverse(final List<TilePanel> boardTiles) {
                return boardTiles;
            }

            @Override
            BoardDirection opposite() {
                return FLIPPED;
            }
        },
        FLIPPED {
            @Override
            List<TilePanel> traverse(final List<TilePanel> boardTiles) {
            	return boardTiles;
            }

            @Override
            BoardDirection opposite() {
                return NORMAL;
            }
        };

        abstract List<TilePanel> traverse(final List<TilePanel> boardTiles);
        abstract BoardDirection opposite();

    }


    private class TilePanel extends JPanel {

        private final int square;

        TilePanel(final BoardPanel boardPanel,
                  final int square) {
            super(new GridBagLayout());
            this.square = square;
            setPreferredSize(TILE_PANEL_DIMENSION);
            assignTileColor();
            assignTilePieceIcon(chessBoard);
            highlightTileBorder(chessBoard);
            addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(final MouseEvent event) {

                    if(BoardFunctionality.isEndGame(Frame.get().getGameBoard())) {
                        return;
                    }

                    if (isRightMouseButton(event)) {
                        click = null;
                        piece = null;
                    } else if (isLeftMouseButton(event)) {
                        if (click == null) {
                            click = chessBoard.getSquare(square).getPiece();
                            piece = click;
                            if (piece == null) {
                                click = null;
                            }
                        } else {
                            final Move move = MoveFunctionality.createMove(chessBoard, click.getPosition(),
                                    square);
                            final MoveTransition transition = chessBoard.currentPlayer().makeMove(move);
                            if (transition.getMoveStatus().isDone()) {
                                chessBoard = transition.getToBoard();
                            }
                            click = null;
                            piece = null;
                        }
                    }
                    invokeLater(new Runnable() {
                        public void run() {
                            boardPanel.drawBoard(chessBoard);

                        }
                    });
                }

                @Override
                public void mouseExited(final MouseEvent e) {
                }

                @Override
                public void mouseEntered(final MouseEvent e) {
                }

                @Override
                public void mouseReleased(final MouseEvent e) {
                }

                @Override
                public void mousePressed(final MouseEvent e) {
                }
            });
            validate();
        }

        void drawTile(final Board board) {
            assignTileColor();
            assignTilePieceIcon(board);
            highlightTileBorder(board);
            highlightLegals(board);
            highlightAIMove();
            validate();
            repaint();
        }

        void setlbrown(final Color color) {
            lbrown = color;
        }

        void setdbrown(final Color color) {
            dbrown = color;
        }

        private void highlightTileBorder(final Board board) {
            if(piece != null &&
               piece.getPieceTeam() == board.currentPlayer().getTeam() &&
               piece.getPosition() == this.square) {
                setBorder(BorderFactory.createLineBorder(Color.cyan));
            } else {
                setBorder(BorderFactory.createLineBorder(Color.GRAY));
            }
        }

        private void highlightAIMove() {
            if(computerMove != null) {
                if(this.square == computerMove.getStartCoordinate()) {
                    setBackground(Color.pink);
                } else if(this.square == computerMove.getEndCoordinate()) {
                    setBackground(Color.red);
                }
            }
        }

        private void highlightLegals(Board board) {          
                for (final Move move : pieceLegalMoves(board)) {
                    if (move.getEndCoordinate() == this.square) {
                    	setBackground(Color.GREEN);
                    }
                }
        }

        private Collection<Move> pieceLegalMoves(Board board) {
            if(piece != null && piece.getPieceTeam() == board.currentPlayer().getTeam()) {
                return piece.legalMoves(board);
            }
            return Collections.emptyList();
        }

        private void assignTilePieceIcon(Board board) {
            this.removeAll();
            if(board.getSquare(this.square).getPiece() != null) {
                try{
                    final BufferedImage image = ImageIO.read(new File(pieceIconPath +
                            board.getSquare(this.square).getPiece().getPieceTeam().toString().substring(0, 1) + "" +
                            board.getSquare(this.square).getPiece().toString() +
                            ".gif"));
                    add(new JLabel(new ImageIcon(image)));
                } catch(final IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void assignTileColor() {
        	if(BoardFunctionality.rank1[square] || BoardFunctionality.rank3[square] ||
        			BoardFunctionality.rank5[square] || BoardFunctionality.rank7[square])
        			{
        				setBackground(square % 2 == 0 ? lbrown : dbrown);
        			}
        			
        			if(BoardFunctionality.rank2[square] || BoardFunctionality.rank4[square] ||
        					BoardFunctionality.rank6[square] || BoardFunctionality.rank8[square])
        			{
        				setBackground(square % 2 != 0 ? lbrown : dbrown);
        			}
        }
    }
}

