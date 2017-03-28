###容易忽略的地方:
1. random的死循环,比如 A.random -> B ; B.random->A
2. 使用hashMap的时候,get(A.hashCode)而不是get(A) .因为get(Object ob)的原因，本来应该传递get(A.hashCode)的，但是你传递get(A)也不会报错。


#### 考点
1. 递归
    要求你对于自己写的递归函数有非常清晰的了解
    另外，造成死循环的原因就是重复调用,想清楚你的代码是不是会在重复调用的地方出了问题
2. 死循环处理
