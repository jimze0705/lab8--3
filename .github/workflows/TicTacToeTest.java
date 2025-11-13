import org.junit.*;

public class TicTacToeTest {

    @Test
    public void testHorizontalWin() {
        TicTacToe game = new TicTacToe();
        game.setMove(0, 0, 'X');
        game.setMove(0, 1, 'X');
        game.setMove(0, 2, 'X');
        Assert.assertEquals("X wins", game.evaluate());
    }

    @Test
    public void testVerticalWin() {
        TicTacToe game = new TicTacToe();
        game.setMove(0, 1, 'O');
        game.setMove(1, 1, 'O');
        game.setMove(2, 1, 'O');
        Assert.assertEquals("O wins", game.evaluate());
    }

    @Test
    public void testDiagonalWin() {
        TicTacToe game = new TicTacToe();
        game.setMove(0, 0, 'X');
        game.setMove(1, 1, 'X');
        game.setMove(2, 2, 'X');
        Assert.assertEquals("X wins", game.evaluate());
    }

    @Test
    public void testDraw() {
        TicTacToe game = new TicTacToe();
        char[][] moves = {
            {'X','O','X'},
            {'X','O','O'},
            {'O','X','X'}
        };
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                game.setMove(i,j,moves[i][j]);
            }
        }
        Assert.assertEquals("Draw", game.evaluate());
    }

    @Test
    public void testOngoing() {
        TicTacToe game = new TicTacToe();
        game.setMove(0, 0, 'X');
        game.setMove(1, 1, 'O');
        Assert.assertEquals("Ongoing", game.evaluate());
    }
}
