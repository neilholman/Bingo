package com.arkansascodingacademy;

public class RandomCard
{
    private Square square[][];

    public RandomCard()
    {
        square = new Square[5][5];

        Numbers numbers = new Numbers(1,15);

        for (int row = 0; row < 5; row++)
        {
            square[row][0] = new Square(numbers.draw());
        }

        numbers = new Numbers(16,30);

        for (int row = 0; row < 5; row++)
        {
            square[row][1] = new Square(numbers.draw());
        }

        numbers = new Numbers(31,45);

        for (int row = 0; row < 5; row++)
        {
            square[row][2] = new Square(numbers.draw());
        }

        numbers = new Numbers(46,60);

        for (int row = 0; row < 5; row++)
        {
            square[row][3] = new Square(numbers.draw());
        }

        numbers = new Numbers(61,75);

        for (int row = 0; row < 5; row++)
        {
            square[row][4] = new Square(numbers.draw());
        }

        //Get 5 random numbers not repeating from 1 to 15

        square[2][2] = new Square(0);
        square[2][2].cover();

    }

    private boolean bingoByColumn()
    {
        boolean bingo = false;

        for (int column = 0; column < 5; column++)
        {
            if (square[0][column].isCovered() &&
                    square[1][column].isCovered() &&
                    square[2][column].isCovered() &&
                    square[3][column].isCovered() &&
                    square[4][column].isCovered())
            {
                bingo = true;
            }
        }

        return bingo;
    }

    private boolean bingoByRow()
    {
        boolean bingo = false;

        for (int row = 0; row < 5; row++)
        {
            if (square[row][0].isCovered() &&
                square[row][1].isCovered() &&
                square[row][2].isCovered() &&
                square[row][3].isCovered() &&
                square[row][4].isCovered())
            {
                bingo = true;
            }
        }

        return bingo;
    }

    private boolean bingoByDiagonal()
    {
        boolean bingo = false;

        if ((square[0][0].isCovered() &&
             square[1][1].isCovered() &&
             square[2][2].isCovered() &&
             square[3][3].isCovered() &&
             square[4][4].isCovered()) ||
            (square[4][0].isCovered() &&
             square[3][1].isCovered() &&
             square[2][2].isCovered() &&
             square[1][3].isCovered() &&
             square[0][4].isCovered()))

        {
            bingo = true;
        }

        return bingo;
    }

    private boolean bingoByStamp()
    {
        boolean bingo = false;

        //Go through rows 0 to 3
        for (int row = 0; row < 4; row++)
        {
            //For the current row go through columns 0 to 3
            for (int column = 0; column < 4; column++)
            {
                if (square[row][column].isCovered() &&
                        square[row][column + 1].isCovered() &&
                        square[row + 1][column].isCovered() &&
                        square[row + 1][column + 1].isCovered())
                {
                    bingo = true;
                }
            }
        }

        return bingo;
    }

    public boolean bingo()
    {
        boolean bingo = false;

        if (bingoByColumn() || bingoByRow() || bingoByDiagonal() || bingoByStamp())
        {
            bingo = true;
        }

        return bingo;
    }

    public void print()
    {
        //Go through rows 0 to 4
        for (int row = 0; row < 5; row++)
        {
            //For the current row go through columns 0 to 4
            for (int column = 0; column < 5; column++)
            {
                //print out the square
                square[row][column].print();
                System.out.print(" ");
            }

            System.out.println();
        }
    }

    public void play(int number)
    {
        for (int row = 0; row < 5; row++)
        {
            for (int column = 0; column < 5; column++)
            {
                //Check for the number
                if (square[row][column].getNumber() == number)
                {
                    //If we found the number cover it
                    square[row][column].cover();
                }
            }
        }
    }

    public static void main(String[] args)
    {
        Card card = new Card();
        card.print();
    }
}
