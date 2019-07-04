# Concolic StarFinder #
Concolic StarFinder (JSF) is a unit test generation tool for programs that make extensive use of dynamically allocated data structures such as lists and trees. Users need to provide a precondition, an inductive predicate in separation logic, to describe the input data structure. CSF then performs mix of *con*crete and *sym*bolic, or concolic, execution on the program to generate test cases, and use the precondition to guide its search.

## Publication
- Long H. Pham, Quang Loc Le, Quoc-Sang Phan, Jun Sun. **Concolic Testing Heap-Manipulating Programs**. FM 2019. \[[PDF](http://qsphan.github.io/papers/fm19.pdf)\]

### Questions and Issues ###
For common questions, bug reports, and feature requests, please use the [JPF Google Group](http://groups.google.com/group/java-pathfinder).

### To run all the test
Suppose you are in the root directory of jpf-costar, simply run:

```bash
$ bin/testAll.sh
```
