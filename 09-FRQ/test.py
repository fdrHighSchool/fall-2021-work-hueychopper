def solution(number):
    if number < 0:
        return 0
    else:
        m1, m2 = 3, 5
        total = 0#
        for i in range(1, number):
            for j in range(0, i):
                print(j)
                if (m1*i) == j or (m2*i) == j:
                    total -= (m2*i)
            if (m1 * i) < number: #t,t,t,t,t,f
                total += (m1 * i) #
            if (m2 * i) < number: #t,t,t,f,f
                total += (m2 * i)
            
            # print(f'current {total}')

        return total

print(solution(16))