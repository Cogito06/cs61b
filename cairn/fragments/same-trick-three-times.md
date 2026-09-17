---
course: cs61b
cluster: 继承单元四讲怎么串起来
date: 2026-09-16
concepts: [接口契约, dynamic dispatch, Comparable, Iterator, subtype polymorphism, 继承]
hook: Comparable/Comparator 和 Iterable/Iterator 看似两套不同 API，其实是 Lec8 的 interface + dynamic method selection 被原样复用了两次——不是要分别死记三四套规则。
refs:
  - slides/[61B SP24] Lecture 8 - Inheritance 1_ Interface and Implementation Inheritance.pdf
  - slides/[61B SP24] Lecture 9 - Inheritance 2_ Extends, Casting, Higher Order Functions.pdf
  - slides/[61B SP24] Lecture 10 - Inheritance 3_ Subtype Polymorphism, Comparators, Comparable.pdf
  - slides/[61B SP24] Lecture 11 - Inheritance 4_ Iterators, Object Methods.pdf
  - https://claude.ai/artifact/1BWPTJGdG9StuKe2wkLC1p (完整知识地图，非仓库内文件，存档链接)
---

## 触发

用户说 Inheritance 这四讲（Lec 8-11）东西太多，头大，要求梳理知识结构。逐份读完四份 PPT 后发现表面上是四个不相干的话题——接口语法、extends/casting、排序比较、遍历判等——乍看要分别记住四套 API 和规则，内容量显得很爆炸。

## 卡点 / 误解

第一印象容易把这四讲当成四个平级、独立的知识块去背：interface 怎么写、extends 怎么写、Comparable 怎么写、Iterator 怎么写，各自一套语法要记。这样记的话确实信息量巨大，而且看不出为什么课程要把它们连续排在一起讲。

## 关键 insight

四讲背后其实是同一个机制被连续套用三次：**先定义一份接口契约（只规定方法签名），通用代码只认这份契约，具体类型在运行时被 dynamic method selection 自动分派到它自己的实现。**

- Lec 8 建立这个机制本身：`interface` 定义"能做什么"，`default method` 让接口也能给默认实现，dynamic method selection 是让"运行时自动选对实现"成立的底层规则。
- Lec 9 补上"实现代码也能继承"这一层（`extends`/`super`），并给出两条独立的类型规则：编译期能不能调用看 static type，重写方法实际跑谁的代码看 dynamic type。casting 是绕开这条规则的手段。
- Lec 10 把这套机制套在"怎么比较大小"上：`Comparable`（类自带的默认顺序）+ `Comparator`（外挂的任意顺序）。
- Lec 11 把同一套机制再套在"怎么遍历"（`Iterable`/`Iterator`）和"怎么判等/打印"（覆写 `Object` 的 `equals`/`toString`）上。

看清这条主线之后，要记的不是四套孤立 API，而是"一个模式 + 三个应用场景"。完整的语法细节、代码示例、每讲的易错点见 refs 里的 Artifact 可视化知识地图。

## 遗留问题

（无）
