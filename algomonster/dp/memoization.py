import abc


# Top-down with Memoization
def fib(n, memo):
    if n in memo:  # check in memo, if found, retrieve and return right away
        return memo[n]

    if n == 0 or n == 1:
        return n

    res = fib(n - 1, memo) + fib(n - 2, memo)

    memo[n] = res  # save in memo before returning
    return res


# Bottom up with Tabulation
# No recursion, and thus no system stack overflow although not a huge concern for normal coding interviews.
def fib_b(n):
    dp = [0, 1]
    for i in range(2, n + 1):
        #  the recurrence relation. 
        dp.append(dp[i - 1] + dp[i - 2])

    return dp[-1]


# 0, 1, 1, 2, 3, 5, 8
n = 6
abcd = fib(n, {})
print(f'fib({n})',  abcd)


for i in range(0, 5):
    print(f'{i} ', 2*i);