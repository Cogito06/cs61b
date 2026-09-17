---
course: cs61b
date: 2026-09-17
concepts: [测试覆盖率, test coverage, 断言, assertThat, size一致性, 隐藏评分点, help GC, LinkedList.unlink]
hook: removeFirst/removeLast 漏了 size-=1，自己的测试全绿是因为没断言 size()——spec 原文还把"清空引用助 GC"列为明确评分点，不是可选好习惯。
refs:
  - proj/proj1a/src/Deque61B.java
  - https://sp24.datastructur.es/projects/proj1a/
---

## 触发
请求逐行检查自己写的 `removeFirst`/`removeLast` 逻辑和对应的 unit test，
并顺带问"给悬空节点把引用全清空"这个自己的想法有没有道理。

## 卡点 / 误解
以为自己写的单元测试全部通过就等于实现是对的。实际上
`addFirst`/`addLast` 里都有 `size += 1;`，但 `removeFirst`/`removeLast`
里完全没有对应的 `size -= 1;`——这是一个真实的逻辑漏洞（多删几次后
`size()` 会一直虚高，`isEmpty()` 永远返回 false）。测试之所以没挂，
是因为 `removeFirstTest`/`removeLastTest` 只断言了返回值，没有断言
`size()`。后来读官方 spec 原文才发现，这正是 spec 明确提醒过的坑：
"If you do not assert anything, you will pass your own tests, even if
your implementation is incorrect"。

同一份 spec 里还有一句容易被忽略的话："Must not maintain references to
removed items; garbage collection should reflect actual deque size"——
也就是说，之前顺手给摘除节点的 `front`/`back` 置 null（模仿
`java.util.LinkedList.unlink()` 的 "help GC" 做法）不只是防御性好习惯，
而是 autograder 会专门测的评分点之一。

## 关键 insight
"自己写的测试全绿" 只能验证测试**断言到的那部分**行为，两类坑会绕过
自绿的测试：
1. 状态字段本身没被断言到（这次是 `size`）——需要主动去想"这个操作
   除了返回值之外还应该改变什么内部状态，我断言了吗"。
2. spec 里写明但不直观、容易被当成"顺手最佳实践"的隐藏评分点（这次是
   GC 引用清理）——这类点只有真正去读 spec 原文才会发现，光靠代码直觉
   或者课程惯例猜不出来。

## 遗留问题
（无）
