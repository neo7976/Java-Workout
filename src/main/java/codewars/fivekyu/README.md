# Жадность это хорошо
Жадность — это игра в кости, в которую играют пятью шестигранными костями. Ваша миссия, если вы решите ее принять,
состоит в том, чтобы забить бросок в соответствии с этими правилами. Вам всегда будет дан массив с пятью значениями шестигранных кубиков.
```
Three 1's => 1000 points
Three 6's =>  600 points
Three 5's =>  500 points
Three 4's =>  400 points
Three 3's =>  300 points
Three 2's =>  200 points
One   1   =>  100 points
One   5   =>   50 point
```

Один кубик может быть подсчитан только один раз в каждом броске. Например, данная «5» может учитываться только как часть тройки (составляющей 500 баллов) или как отдельные 50 баллов, но не оба в одном броске.

Пример подсчета очков
```
Throw       Score
 ---------   ------------------
5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)
```

В некоторых языках можно изменить ввод функции. Это то, что вы никогда не должны делать. Если вы мутируете ввод, вы не сможете пройти все тесты.