# Bored?, Nobody to play TicTacToe?
# Dont worry play with your computer!

from random import randint

kboard = {'7': ' ', '8': ' ', '9': ' ', '4': ' ', '5': ' ', '6': ' ', '1': ' ', '2': ' ', '3': ' '}

board = []

for key in kboard.keys():
    board.append(key)

print(board)

def printboard(board):
    print(board['7'] + ' |' + board['8'] + ' |' + board['9'])
    print('- + - + -')
    print(board['4'] + ' |' + board['5'] + ' |' + board['6'])
    print('- + - + -')
    print(board['1'] + ' |' + board['2'] + ' |' + board['3'])


def TicTacToe():
    turn = 'X'
    count = 0

    for i in range(100):
        try:
            printboard(kboard)
            print()
            if turn == 'X':
                move = input('It is your turn now:')
                
                if kboard[move] == ' ':
                    kboard[move] = turn
                    count += 1
            
                else:
                    print('It is already selected!')
                    continue

            else:
                move = randint(1, 9)

                if kboard[str(move)] == ' ':
                    kboard[str(move)] = turn
                    count += 1

                else:
                    continue
            
            if count >= 5:
                if kboard['7'] == kboard['8'] == kboard['9'] != ' ':
                    printboard(kboard)
                    print('The Game is Over')
                    print(turn + ' Won the game!')
                    break

                elif kboard['4'] == kboard['5'] == kboard['6'] != ' ':
                    printboard(kboard)
                    print('The Game is Over')
                    print(turn + ' Won the game!')
                    break

                elif kboard['1'] == kboard['2'] == kboard['3'] != ' ':
                    printboard(kboard)
                    print('The Game is Over')
                    print(turn + ' Won the game!')
                    break

                elif kboard['7'] == kboard['4'] == kboard['1'] != ' ':
                    printboard(kboard)
                    print('The Game is Over')
                    print(turn + ' Won the game!')
                    break

                elif kboard['8'] == kboard['5'] == kboard['2'] != ' ':
                    printboard(kboard)
                    print('The Game is Over')
                    print(turn + ' Won the game!')
                    break

                elif kboard['9'] == kboard['6'] == kboard['3'] != ' ':
                    printboard(kboard)
                    print('The Game is Over')
                    print(turn + ' Won the game!')
                    break

                elif kboard['7'] == kboard['5'] == kboard['3'] != ' ':
                    printboard(kboard)
                    print('The Game is Over')
                    print(turn + ' Won the game!')
                    break

                elif kboard['9'] == kboard['5'] == kboard['1'] != ' ':
                    printboard(kboard)
                    print('The Game is Over')
                    print(turn + ' Won the game!')
                    break

                if count == 9:
                    printboard(kboard)
                    print('The game is Tied!')
                    break

                
            if turn == 'X':
                turn = 'O'
                continue
            
            else:
                turn = 'X'
                continue
        except KeyError as e:
            print('Please choose options only between 1 to 9')
            continue

    oncegain = input('Do you like to play once again?(y/n):')
    if oncegain == 'y':
        for key in kboard.keys():
            kboard[key] = ' '

        TicTacToe()        
            
    else:
        print('Thankyou for playing the game!')


if __name__ == '__main__':
    TicTacToe()